package dab;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class E7AfficheComptesPersosEtComptesDestnatairesEtSaisir extends Etat {
	
	private void afficheListeComptesPersosVirement(Distrib distrib) {
		if (distrib.listeComptes.size() > 0) {
			int indice = 1;
			System.out.println("-------------------------------------------");
			System.out.println("      ----Liste Comptes �metteurs----   ");

			for (Compte comptePerso : distrib.listeComptes) {
				System.out.print(" " + indice++ + ". ");
				System.out.println(comptePerso.afficheCompteVirement());
			}

			System.out.println("      -------------------------------   ");
		} else
			System.out.println("Aucun compte n'a été trouvé."); // Ne devrait jamais se produire
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
	
	private void afficheListeComptesDestinatairesVirement(List<Compte> listeComptesPersos,
			List<CompteDestinataire> listeComptesDestinataires) {
		if (listeComptesPersos.size() > 0 || listeComptesDestinataires.size() > 0) {
			int indice = 1;
			
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
			System.out.println("-------------------------------------------");
		} else
			System.out.println("Aucun compte n'a été trouvé."); // Ne devrait jamais se produire
	}
	
	public void traitement(Distrib distrib) throws Exception {
		afficheListeComptesPersosVirement(distrib);
		
		int indiceComptePersoChoisi = getChoixCompte(distrib.listeComptes.size()) - 1;
		Compte comptePersoChoisi = distrib.listeComptes.get(indiceComptePersoChoisi);
		
		List<Compte> listeComptesPersosMoinsChoix = new ArrayList<>(distrib.listeComptes);
		listeComptesPersosMoinsChoix.remove(indiceComptePersoChoisi);
		afficheListeComptesDestinatairesVirement(listeComptesPersosMoinsChoix, distrib.listeComptesDestinataires);
		
		ArrayList<Object> listeCompteDestinataireAChoisir = new ArrayList<>(listeComptesPersosMoinsChoix);
		for (CompteDestinataire compte : distrib.listeComptesDestinataires)
			listeCompteDestinataireAChoisir.add(compte);
		Object compteDestinataireChoisi = listeCompteDestinataireAChoisir
				.get(getChoixCompte(distrib.listeComptesDestinataires.size() + listeComptesPersosMoinsChoix.size()) - 1);

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
		
		
		distrib.listeInfoVirement[0] = comptePersoChoisi;
		distrib.listeInfoVirement[1] = compteDestinataireChoisi;
		distrib.listeInfoVirement[2] = somme;
		distrib.listeInfoVirement[3] = date;
		distrib.listeInfoVirement[4] = message;
		/*
		System.out.println("---------- TRACE ----------");
		System.out.println("1. Compte perso : " + distrib.listeInfoVirement[0].getClass());
		System.out.println(((Compte)distrib.listeInfoVirement[0]).afficheCompte());
		System.out.println("2. Compte destinataire : " + distrib.listeInfoVirement[1].getClass());
		if(distrib.listeInfoVirement[1] instanceof Compte)
			System.out.println(((Compte) distrib.listeInfoVirement[1]).afficheCompte());
		else if(distrib.listeInfoVirement[1] instanceof CompteDestinataire)
			System.out.println(((CompteDestinataire) distrib.listeInfoVirement[1]).afficheCompte());
		System.out.println("3. Somme : " + distrib.listeInfoVirement[2].getClass() + "\n" + distrib.listeInfoVirement[2]);
		System.out.println("4. Date : " + distrib.listeInfoVirement[3].getClass() + "\n" + distrib.listeInfoVirement[3].toString());
		System.out.println("5. Message : " + distrib.listeInfoVirement[4].getClass() + "\n" + distrib.listeInfoVirement[4]);
		System.out.println("----------- END -----------");
		*/
		distrib.changeEtat(new E8AttenteVerificationVirement());
		
	}
}
