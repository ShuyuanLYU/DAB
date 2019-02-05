package dab;

import java.util.Date;

public class E8AttenteVerificationVirement extends Etat {
	
	public void traitement(Distrib distrib) throws Exception {
		
		Compte comptePersoChoisi = (Compte) distrib.listeInfoVirement[0];
		Object compteDestinataireChoisi = distrib.listeInfoVirement[1];
		float somme = (float) distrib.listeInfoVirement[2];
		Date date = (Date) distrib.listeInfoVirement[3];
		String message = (String) distrib.listeInfoVirement[4];
		if (distrib.banqueDeRattachement.effectueVirement(comptePersoChoisi, compteDestinataireChoisi, somme, date, message))
			System.out.println("Virement effectué !");
		else
			System.out.println("Erreur lors du virement.");
		
		distrib.changeEtat(new E1AttenteOperation());
	}
}
