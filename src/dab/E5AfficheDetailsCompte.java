package dab;

public class E5AfficheDetailsCompte extends Etat {

    private void afficheDetailsCompte(Distrib distrib) {
        System.out.println("------- Détails du compte ----------");
        System.out.println(distrib.listeComptes.get(distrib.indiceChoixCompte).afficheDetailsCompte());
        System.out.println("-------------------------------------");
    }

    public void traitement(Distrib distrib) throws Exception {
        afficheDetailsCompte(distrib);

        distrib.changeEtat(new E1AttenteOperation());
    }
}
