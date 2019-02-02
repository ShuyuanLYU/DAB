package dab;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Distrib {
	private int nbBillets10;
	private int nbBillets20;
	private int nbBillets50;
	private int nbBillets100;

	public Banque banqueDeRattachement;

	private String numeroCarteInseree; // je pense on dois ignore cette classe ptetre

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

		if (listeComptes.size() > 0)
			afficheListeComptes(listeComptes);
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

		afficheMenuDetailsCompte(listeComptes);
		int choix = getChoixDetailsCompte(listeComptes);
		traiteChoixDetailsCompte(listeComptes, choix);
	}

	private int getChoixDetailsCompte(List<Compte> listeComptes) {
		System.out.print("Tapez votre choix : ");
		Scanner input = new Scanner(System.in);
		int choix = input.nextInt();

		while (choix < 1 || choix > listeComptes.size() + 1) {
			System.out.print("Tapez votre choix entre " + 1 + " et " + (listeComptes.size() + 1) + " svp : ");
			choix = input.nextInt();
		}
		return choix;
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

	private void afficheCompte(Compte compte) {
		System.out.println(compte.afficheCompte());
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

		List<Compte> listeComptesPerso = (List<Compte>) listeComptes[0];
		List<CompteDestinataire> listeComptesDestinataires = (List<CompteDestinataire>) listeComptes[1];
		afficheListeComptesVirement(listeComptesPerso, listeComptesDestinataires);

		// System.out.println("Choix a espace choix b : ");
		// int[] indiceChoixComptes = obtenirIndiceComptesVirement();
		obtenirInfoVirement(listeComptesPerso, listeComptesDestinataires);
	}

	private int[] obtenirIndiceComptesVirement() {
		// System.out.println("Tapez deux numéros de compte séparés par des espaces (1-" + (listeComptesPerso.size() + 1) + ")  (" + (listeComptesPerso.size() + 2) + "-" + (listeComptesPerso.size() + listeComptesDestinataires.size() + 2));
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String stringArray[] = inputString.split(" ");
		int num[] = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			num[i] = Integer.parseInt(stringArray[i]);
			// System.out.println(num[i]);
		}
		return num;
	}
	
	
	
	private Object[] obtenirInfoVirement(List<Compte> listeComptesPerso, List<CompteDestinataire> listeComptesDestinataires) {
		Object info[] = new Object[5];
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Tapez deux numéros de compte séparés par des espaces (1-" + listeComptesPerso.size() + ")  (" + (listeComptesPerso.size() + 1) + "-" + (listeComptesPerso.size() + listeComptesDestinataires.size() + 2) + ") : ");
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
		for(int i = 0; i < 5; i ++) {
			System.out.println(" -> " + i + " => "+ info[i]);
		}
		// info[0] = listeComptesPerso.get(num[0]);
		// info[1] = listeComptesPerso.get(num[1]);
		//System.out.println(num[0] + " - " + num[1]);
		
		//System.out.println("Tapez deux numéros de compte séparés par des espaces : ");
		//Scanner input = new Scanner(System.in);
		//inputString = input.nextLine();
		return null;
		
	}

	private void afficheListeComptesVirement(List<Compte> listeComptesPerso, List<CompteDestinataire> listeComptesDestinataires) {
		if (listeComptesPerso != null && listeComptesDestinataires != null) {
			int indice = 1;
			System.out.println("-------------------------------------------");
			System.out.println("      ----Liste Comptes �metteurs----   ");
			for (Compte comptePerso : listeComptesPerso) {
				System.out.print(" " + indice++ + ". ");
				System.out.println(comptePerso.afficheCompteVirement());
			}

			System.out.println("      -------------------------------   ");
			System.out.println("      --Liste Comptes destinataires--   ");
			for (Compte comptePerso : listeComptesPerso) {
				System.out.print(" " + indice++ + ". ");
				System.out.println(comptePerso.afficheCompteVirement());
			}
			for (CompteDestinataire compteDestinataire : listeComptesDestinataires) {
				System.out.print(" " + indice++ + ". ");
				System.out.println(compteDestinataire.afficheCompte());
			}
			System.out.println("      -------------------------------   ");
			System.out.println(" " + indice + ". Retour au menu");
			System.out.println("-------------------------------------------");
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
	}

	public void afficheInit() {
		System.out.println("Bienvenue au distribteur de " + banqueDeRattachement.getNomBanque());
		System.out.println("Vous avez déjà passé l'Authentification d'identité");
		System.out.println("Nous supposons donc que c'est la carte de Bob qui a été insérée.");
	}

	public void afficheMenu() {
		System.out.println("   +-------------MENU----------------+");
		System.out.println("   | 1. Consultation.                |");
		System.out.println("   | 2. Virement.                    |");
		System.out.println("   | 3. Retirer votre carte.(Quitter)|");
		System.out.println("   +---------------------------------+");
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

		System.out.println("Au revoir !");
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
		default:
			System.out.println("Erreur...");
			break;
		}
	}
}
