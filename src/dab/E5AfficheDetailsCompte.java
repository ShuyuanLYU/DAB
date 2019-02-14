package dab;

public class E5AfficheDetailsCompte extends Etat {

    private void afficheDetailsCompte(Compte compte) {
        System.out.println("---------- Détails du compte -------------");
        System.out.println(compte.afficheDetailsCompte());
        System.out.println("------------------------------------------");
    }

    public void traitement(Distrib distrib) throws Exception {
        Compte compte = distrib.listeComptes.get(distrib.indiceChoixCompte);
        afficheDetailsCompte(compte);

        distrib.changeEtat(new E1AttenteOperation());
    }
}
