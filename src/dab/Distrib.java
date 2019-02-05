package dab;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Distrib {
	private int nbBillets10;
	private int nbBillets20;
	private int nbBillets50;
	private int nbBillets100;

	public Banque banqueDeRattachement;

	public String numeroCarteInseree; // je pense on dois ignore cette classe ptetre
	public Etat etat;
	
	public List<Compte> listeComptes;
	public int indiceChoixCompte;
	
	public List<CompteDestinataire> listeComptesDestinataires;
	public Object[] listeInfoVirement;
	
	public void insererCarte(String noCarte, String code, int nbEssaisRestants) {
	}

	public boolean saisirCode(int codeSaisi) {
		return true;
	}

	public void choisirOperation(int noOp) {
	}

	private void choixConsultation() {
		System.out.println("Consultation lancée, \nLe numéro de la carte insérée est " + numeroCarteInseree + ".");

		List<Compte> listeComptes = banqueDeRattachement.recupereComptesConsultation(numeroCarteInseree);

		if (listeComptes.size() > 0) {
			afficheListeComptes(listeComptes);
			afficheMenuDetailsCompte(listeComptes);
			selectionneCompte(listeComptes);
			//traiteChoixDetailsCompte(listeComptes, choix);
		}

		else
			System.out.println("Aucun compte n'a été trouvé."); // Ne devrait jamais se produire
	}

	private void afficheListeComptes(List<Compte> listeComptes) {
		System.out.println("----- Liste des comptes -----");

		int indice = 1;

		for (Compte compte : listeComptes) {
			System.out.println("       -Compte " + indice++ + "-");
			System.out.println(compte.afficheCompte());
		}
		System.out.println("-------- Fin de liste ---------");

	}

	private void selectionneCompte(List<Compte> listeComptes) {
		System.out.print("Tapez votre choix : ");
		Scanner input = new Scanner(System.in);
		int choix = input.nextInt();

		while (choix < 1 || choix > listeComptes.size() + 1) {
			System.out.print("Tapez votre choix entre " + 1 + " et " + (listeComptes.size() + 1) + " svp : ");
			choix = input.nextInt();
		}
		if (choix <= listeComptes.size()) {
			System.out.println("------- Détails du compte ----------");
			System.out.println(listeComptes.get(choix - 1).afficheDetailsCompte());
			System.out.println("-------------------------------------");
		}
	}

	private void traiteChoixDetailsCompte(List<Compte> listeComptes, int choix) {
		if (choix <= listeComptes.size()) {
			System.out.println("------- Détails du compte ----------");
			System.out.println(listeComptes.get(choix - 1).afficheDetailsCompte());
			System.out.println("-------------------------------------");
		}
	}

	private void afficheMenuDetailsCompte(List<Compte> listeComptes) {
		int indice = 1;

		for (Compte compte : listeComptes) {
			System.out.println(" " + indice++ + ". Voir détails de : " + compte.getNumeroCompte());
		}

		System.out.println(" " + indice + ". Retour au menu");
		System.out.println("-----------------------");
	}

	private void choisirCompte(Compte compte) {
		// TO DO
	}

	private void gererCompte(Compte compte) {
		// TO DO
	}

	private void afficheListeOperationsDeGestion(Compte compte) {
		// TO DO
	}

	private void choixVirement() {
		System.out.println("Virement lancé, \nLe numéro de la carte insérée est " + numeroCarteInseree + ".");

		Object[] listeComptes = banqueDeRattachement.recupereComptesVirement(numeroCarteInseree);

		List<Compte> listeComptesPersos = (List<Compte>) listeComptes[0];
		List<CompteDestinataire> listeComptesDestinataires = (List<CompteDestinataire>) listeComptes[1];

		afficheListeComptesPersosVirement(listeComptesPersos);
		int indiceComptePersoChoisi = getChoixCompte(listeComptesPersos.size()) - 1;
		Compte comptePersoChoisi = listeComptesPersos.get(indiceComptePersoChoisi);

		List<Compte> listeComptesPersosMoinsChoix = new ArrayList<>(listeComptesPersos);
		listeComptesPersosMoinsChoix.remove(indiceComptePersoChoisi);

		afficheListeComptesDestinatairesVirement(listeComptesPersosMoinsChoix, listeComptesDestinataires);

		ArrayList<Object> listeCompteDestinataireAChoisir = new ArrayList<>(listeComptesPersosMoinsChoix);
		for (CompteDestinataire compte : listeComptesDestinataires)
			listeCompteDestinataireAChoisir.add(compte);
		Object compteDestinataireChoisi = listeCompteDestinataireAChoisir
				.get(getChoixCompte(listeComptesDestinataires.size() + listeComptesPersosMoinsChoix.size()) - 1);

		// TODO mettre dans une méthode
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);

		Scanner input = new Scanner(System.in);
		float somme = 0;
		Date date = new Date();
		try {
			System.out.print("Somme : ");
			somme = Float.parseFloat(input.next());
			System.out.print("Date : ");
			date = format.parse(input.next());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Message : ");
		String message = input.next();

		if (banqueDeRattachement.effectueVirement(comptePersoChoisi, compteDestinataireChoisi, somme, date, message))
			System.out.println("Virement effectué !");
		else
			System.out.println("Erreur lors du virement.");
	}

	private int getChoixCompte(int tailleListe) {
		System.out.print("Tapez votre choix : ");
		Scanner input = new Scanner(System.in);
		int choix = input.nextInt();

		while (choix < 1 || choix > tailleListe) {
			System.out.print("Tapez votre choix entre " + 1 + " et " + tailleListe + " svp : ");
			choix = input.nextInt();
		}

		return choix;
	}

	private int[] obtenirIndiceComptesVirement() {
		// System.out.println("Tapez deux numéros de compte séparés par des espaces (1-"
		// + (listeComptesPerso.size() + 1) + ") (" + (listeComptesPerso.size() + 2) +
		// "-" + (listeComptesPerso.size() + listeComptesDestinataires.size() + 2));
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String stringArray[] = inputString.split(" ");
		int num[] = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			num[i] = Integer.parseInt(stringArray[i]);
		}
		return num;
	}

	private Object[] obtenirInfoVirement(List<Compte> listeComptesPerso,
			List<CompteDestinataire> listeComptesDestinataires) {
		Object info[] = new Object[5];

		Scanner input = new Scanner(System.in);

		System.out.println("Tapez deux numéros de compte séparés par des espaces (1-" + listeComptesPerso.size()
				+ ")  (" + (listeComptesPerso.size() + 1) + "-"
				+ (listeComptesPerso.size() + listeComptesDestinataires.size() + 2) + ") : ");
		System.out.println("indice compte perso | indice compte dest | somme | msg");
		String inputString = input.nextLine();
		String stringArray[] = inputString.split(" ");
		int num[] = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			// num[i] = Integer.parseInt(stringArray[i]);
			switch (i) {
			case 0:
				info[0] = Integer.parseInt(stringArray[i]);
				break;
			case 1:
				info[1] = Integer.parseInt(stringArray[i]);
				break;
			case 2:
				info[2] = stringArray[i];
				break;
			case 3:
				info[4] = stringArray[i];
				break;
			default:
				System.out.println("Erreur...");
				break;
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(" -> " + i + " => " + info[i]);
		}
		// info[0] = listeComptesPerso.get(num[0]);
		// info[1] = listeComptesPerso.get(num[1]);
		// System.out.println(num[0] + " - " + num[1]);

		// System.out.println("Tapez deux numéros de compte séparés par des espaces :
		// ");
		// Scanner input = new Scanner(System.in);
		// inputString = input.nextLine();
		return null;

	}

	private void afficheListeComptesPersosVirement(List<Compte> listeComptesPerso) {
		if (listeComptesPerso.size() > 0) {
			int indice = 1;
			System.out.println("-------------------------------------------");
			System.out.println("      ----Liste Comptes �metteurs----   ");

			for (Compte comptePerso : listeComptesPerso) {
				System.out.print(" " + indice++ + ". ");
				System.out.println(comptePerso.afficheCompteVirement());
			}

			System.out.println("      -------------------------------   ");
		} else
			System.out.println("Aucun compte n'a été trouvé."); // Ne devrait jamais se produire
	}

	private void afficheListeComptesDestinatairesVirement(List<Compte> listeComptesPersos,
			List<CompteDestinataire> listeComptesDestinataires) {
		if (listeComptesPersos.size() > 0 || listeComptesDestinataires.size() > 0) {
			int indice = 1;
			System.out.println("-------------------------------------------");
			System.out.println("      ----Liste Comptes Destinataires----   ");

			for (Compte compte : listeComptesPersos) {
				System.out.print(" " + indice++ + ". ");
				System.out.println(compte.afficheCompteVirement());
			}

			for (CompteDestinataire compte : listeComptesDestinataires) {
				System.out.print(" " + indice++ + ". ");
				System.out.println(compte.afficheCompte());
			}

			System.out.println("      -------------------------------   ");
		} else
			System.out.println("Aucun compte n'a été trouvé."); // Ne devrait jamais se produire
	}

	private boolean selectionneInformationsVirement(Compte compteEmission, Compte compteDestinataire, double somme,
			Date date, String message) {
		return true;
	}

	// ---- méthodes créées manuellement
	public Distrib(Banque banqueDeRattachement, String numeroCarteInseree) {
		this.banqueDeRattachement = banqueDeRattachement;
		this.numeroCarteInseree = numeroCarteInseree;
		etat = new E1AttenteOperation();
		listeInfoVirement = new Object[5]; 
	}
	
	public void afficheInit() {
		System.out.println("Bienvenue au distribteur de " + banqueDeRattachement.getNomBanque());
		System.out.println("Vous avez déjà passé l'Authentification d'identité");
		System.out.println("Nous supposons donc que c'est la carte de Bob qui a été insérée.");
	}
	
	
	public void afficheMenu() {
		System.out.println(" +-------------MENU----------------+");
		System.out.println(" | 1. Consultation.                |");
		System.out.println(" | 2. Virement.                    |");
		System.out.println(" | 3. Retirer votre carte.(Quitter)|");
		System.out.println(" +---------------------------------+");
	}
	

	public static int getChoixMenu(int min, int max) {
		System.out.print("Tapez votre choix : ");
		Scanner input = new Scanner(System.in);
		int choix = input.nextInt();

		while (choix < min || choix > max) {
			System.out.print("Tapez votre choix entre " + min + " et " + max + " svp : ");
			choix = input.nextInt();
		}

		return choix;
	}

	public void lanceDistributeur() {
		afficheInit();

		int choix;

		do {
			afficheMenu();
			choix = getChoixMenu(1, 3);

			// System.out.println("Votre choix est : " + choix);

			traiteChoixMenu(choix);
		} while (choix < 3);
	}

	public void traiteChoixMenu(int choix) {
		switch (choix) {
		case 1:
			System.out.println("Traitement consultation...");

			choixConsultation();
			break;
		case 2:
			System.out.println("Traitement Virement...");

			choixVirement();
			break;
		case 3:
			System.out.println("Au revoir !");
			break;
		default:
			System.out.println("Erreur...");
			break;
		}
	}
	
	public void changeEtat(Etat nouvelEtat) throws Exception {
		this.etat = nouvelEtat;
		etat.traitement(this);
	}
}
