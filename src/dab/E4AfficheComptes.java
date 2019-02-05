package dab;

import java.util.List;

public class E4AfficheComptes extends Etat {
	
	private void afficheListeComptes(List<Compte> listeComptes) {
		System.out.println("----- Liste des comptes -----");

		int indice = 1;

		for (Compte compte : listeComptes) {
			System.out.println("       -Compte " + indice++ + "-");
			System.out.println(compte.afficheCompte());
		}
		System.out.println("-------- Fin de liste ---------");

	}
	
	private void afficheMenuDetailsCompte(List<Compte> listeComptes) {
		int indice = 1;

		for (Compte compte : listeComptes) {
			System.out.println(" " + indice++ + ". Voir détails de : " + compte.getNumeroCompte());
		}

		System.out.println(" " + indice + ". Retour au menu");
		System.out.println("-----------------------");
	}

	
	public void traitement(Distrib distrib) throws Exception {
		afficheListeComptes(distrib.listeComptes);
		afficheMenuDetailsCompte(distrib.listeComptes);
		distrib.changeEtat(new E2EtatFinal());
	}
}
