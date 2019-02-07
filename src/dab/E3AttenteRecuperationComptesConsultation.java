package dab;

import java.util.List;

public class E3AttenteRecuperationComptesConsultation extends Etat {

	public void traitement(Distrib distrib) throws Exception {
		System.out.println("Consultation lancée, \nLe numéro de la carte insérée est " + distrib.numeroCarteInseree + ".");

		List<Compte> listeComptes = distrib.banqueDeRattachement.recupereComptesConsultation(distrib.numeroCarteInseree);
		distrib.listeComptes = listeComptes;
		
		distrib.changeEtat(new E4AfficheComptes());
	}
}
