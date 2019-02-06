package dab;

import java.util.Date;

public class E9VirementEffectue extends Etat {
	
	private void E9affichage() {
		System.out.println(" +---------------------+");
		System.out.println(" | Virement effectué ! |");
		System.out.println(" +---------------------+");
	}
	public void traitement(Distrib distrib) throws Exception {

		Compte comptePersoChoisi = (Compte) distrib.listeInfoVirement[0];
		Object compteDestinataireChoisi = distrib.listeInfoVirement[1];
		float somme = (float) distrib.listeInfoVirement[2];
		Date date = (Date) distrib.listeInfoVirement[3];
		String message = (String) distrib.listeInfoVirement[4];
		
		distrib.banqueDeRattachement.effectueVirement(comptePersoChoisi, compteDestinataireChoisi, somme, date,
				message);
		E9affichage();

		distrib.changeEtat(new E1AttenteOperation());

	}

}
