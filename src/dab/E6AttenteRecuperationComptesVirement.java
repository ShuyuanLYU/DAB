package dab;

import java.util.List;

public class E6AttenteRecuperationComptesVirement extends Etat {
	
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

	
    public void traitement(Distrib distrib) throws Exception {

    	Object[] listeComptes = distrib.banqueDeRattachement.recupereComptesVirement(distrib.numeroCarteInseree);
    	
    	distrib.listeComptes = (List<Compte>) listeComptes[0];
    	distrib.listeComptesDestinataires = (List<CompteDestinataire>) listeComptes[1];
    	
    	//afficheListeComptesPersosVirement(distrib);
    	
    	distrib.changeEtat(new E7AfficheComptesPersosEtDestinataires());
		
    	
    }
}
