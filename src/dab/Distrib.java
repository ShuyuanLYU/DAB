package dab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Distrib {
	private int nbBillets10;
	private int nbBillets20;
	private int nbBillets50;
	private int nbBillets100;

	public Banque BanqueDeRattachement;

	private Carte carteInseree; // je pense on dois ignore cette classe ptetre

	public Distrib(Banque BanqueDeRattachement) {
		this.BanqueDeRattachement = BanqueDeRattachement;
	}

	public void insererCarte(String noCarte, String code, int nbEssaisRestants) {
	}

	public boolean saisirCode(int codeSaisi) {
		return true;
	}

	public void choisirOperation(int noOp) {
	}

	// private void consultation(Client compteClient) { <----version origine
	private void consultation(Carte carteInseree_auth) {
		System.out.println(
				"Consultation lance, \nVotre Numéro de la Carte Insérée est " + carteInseree_auth.getNoCarte() + ".");
		List<Compte> list_compte_consultation = BanqueDeRattachement
				.recupereComptesConsultation(carteInseree_auth.getNoCarte());
		if (list_compte_consultation.size() > 0)
			afficheListeComptes(list_compte_consultation);
		else
			System.out.println("Désolé, compte non trouvé");
		// j'ai pas fini je pense...
	}

	private void afficheListeComptes(List<Compte> listeComptes) {
		System.out.println("----- List Compte -----");
		int indice = 1;
		for (Compte p : listeComptes) {
			System.out.println("       -" + indice + "-");
			System.out.println(p.afficheCompte() + "\n");
			indice++;
		}
		System.out.println("--------- End ---------");
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

	private List<Compte> choixVirement(Client compteClient, List<Compte> comptesDestinataires) {
		return null;
	}

	private void afficheListeComptesVirement(List<Compte> comptesPerso, List<Compte> comptesDestinataires) {
		// TO DO
	}

	private boolean selectionneInformationsVirement(Compte compteEmission, Compte compteDestinataire, double somme,
			Date date, String message) {
		return true;
	}

	// ---------------------------------------------- méthodes créées manuelles
	public Distrib(Banque BanqueDeRattachement, Carte carteInseree) {
		this.BanqueDeRattachement = BanqueDeRattachement;
		this.carteInseree = carteInseree;
	}

	public void afficher_init() {
		System.out.println("Bienvenu à Distribteur de " + BanqueDeRattachement.getNomBanque());
		System.out.println("Vous avez déjà passé l'Authentification d'identité");
		// System.out.println("Le numéro de la carte insérée est : " + carteInseree.getNoCarte());
	}

	public void menu() {
		System.out.println("-------MENU-------");
		System.out.println("1. Consultation");
		System.out.println("2. Virement");
		System.out.println("3. Retirer votre carte(Quitter)");
		System.out.println("------------------");
	}

	public static int getInt(int min, int max) {
		System.out.print("Tape votre choix : ");
		Scanner input = new Scanner(System.in);
		int choix = input.nextInt();
		while (choix < min || choix > max) {
			System.out.print("Tape votre choix entre " + min + " et " + max + " svp : ");
			choix = input.nextInt();
		}
		return choix;
	}

	public void lanceDistributeur() {
		afficher_init();
		menu();
		int choix = getInt(1, 3);
		while (choix < 3) {
			System.out.println("Votre choix est : " + choix);
			traiterChoix(choix);
			choix = getInt(1, 3);
		}
		System.out.println("Au revoir ! ");
	}
	
	public void traiterChoix(int choix) {
		switch(choix) {
		case 1:
			System.out.println("Traitement Consultation...");
			System.out.println("On suppose que l'on a inséré la carte de Bob");
			consultation(initCarteClientBob());
			break;
		case 2:
			System.out.println("Traitement Virement...(non réalisé)");
			break;
		default : 
			System.out.println("Erreur...");
		}
	}
	
	// init une CarteClient de Bob(je suis pas sur comment insérer une carte)
	private Carte initCarteClientBob() {
		
		Carte carte_phisique_Bob = new Carte("CA1234567", "password");
		/*
		Compte compte_Bob_1 = new Compte(100, "CA1234567");
		Compte compte_Bob_2 = new Compte(200, "CA7654321");
		List<Compte> listCompteBob = new ArrayList<Compte>();
		listCompteBob.add(compte_Bob_1);
		listCompteBob.add(compte_Bob_2);
		
		Client Bob = new Client("12345_Bob", listCompteBob, null);
		CarteClient carte_Bob = new CarteClient("CA1234567", Bob);
		*/
		return carte_phisique_Bob;
		
	}

}
