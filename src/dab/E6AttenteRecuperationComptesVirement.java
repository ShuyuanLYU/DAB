package dab;

import java.util.ArrayList;


public class E6AttenteRecuperationComptesVirement extends Etat {
	
    public void traitement(Distrib distrib) throws Exception {

    	Object[] listeComptes = distrib.banqueDeRattachement.recupereComptesVirement(distrib.numeroCarteInseree);
    	
    	distrib.listeComptes = (ArrayList<Compte>) listeComptes[0];
    	distrib.listeComptesDestinataires = (ArrayList<CompteDestinataire>) listeComptes[1];
    	
    	distrib.changeEtat(new E7AfficheComptesPersosEtDestinataires());
    }
}
