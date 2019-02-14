package dab;

public class E3AttenteRecuperationComptesConsultation extends Etat {

	public void traitement(Distrib distrib) throws Exception {
		System.out.println("Consultation lancée, \nLe numéro de la carte insérée est " + distrib.numeroCarteInseree + ".");

		distrib.listeComptes = distrib.banqueDeRattachement.recupereComptesConsultation(distrib.numeroCarteInseree);
		
		distrib.changeEtat(new E4AfficheComptes());
	}
}
