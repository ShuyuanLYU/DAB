package dab;

import java.util.List;

public class E6AttenteRecuperationComptesVirement extends Etat {
	
    public void traitement(Distrib distrib) throws Exception {

    	Object[] listeComptes = distrib.banqueDeRattachement.recupereComptesVirement(distrib.numeroCarteInseree);
    	
    	distrib.listeComptes = (List<Compte>) listeComptes[0];
    	distrib.listeComptesDestinataires = (List<CompteDestinataire>) listeComptes[1];
    	
    	distrib.changeEtat(new E7AfficheComptesPersosEtDestinataires());
    }
}
