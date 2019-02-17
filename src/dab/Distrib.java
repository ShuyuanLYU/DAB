package dab;

import java.util.ArrayList;

public class Distrib {
    private int nbBillets10;
    private int nbBillets20;
    private int nbBillets50;
    private int nbBillets100;

    public Banque banqueDeRattachement;

    public String numeroCarteInseree;
    public Etat etat;

    public ArrayList<Compte> listeComptes;
    public int indiceChoixCompte;

    public ArrayList<CompteDestinataire> listeComptesDestinataires;
    public Object[] listeInfoVirement;

    public Distrib(Banque banqueDeRattachement, String numeroCarteInseree) {
        this.banqueDeRattachement = banqueDeRattachement;
        this.numeroCarteInseree = numeroCarteInseree;
        etat = new E1AttenteOperation();
        listeInfoVirement = new Object[5];
    }

    public void changeEtat(Etat nouvelEtat) throws Exception {
        this.etat = nouvelEtat;
        etat.traitement(this);
    }
}
