package dab;

import java.util.ArrayList;


public class Compte {

    private float solde;
    private String numeroCompte;
    private float plafondRetrait;
    private float soldeMinimum;
    private ArrayList<Client> clients;
    private ArrayList<OperationBancaire> listeOB;

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public Compte(float solde, String numeroCompte, float plafondRetrait, float soldeMinimum) {
        this.solde = solde;
        this.numeroCompte = numeroCompte;
        this.plafondRetrait = plafondRetrait;
        this.soldeMinimum = soldeMinimum;
        clients = new ArrayList<>();
        listeOB = new ArrayList<>();
    }

    public String afficheCompte() {
        return "  Numéro compte : " + numeroCompte + "\n" + "  Solde : " + solde;
    }

    public String afficheDetailsCompte() {
        return "  Numéro compte : " + numeroCompte + "\n" + "  Solde : " + solde + "\n" + "  Plafond de retrait : "
                + plafondRetrait + "\n" + "  Solde minimum : " + soldeMinimum + "\n" + afficheListeOB();
    }

    public String afficheCompteVirement() {
        return "Numéro compte : " + numeroCompte + "  Solde : " + solde;
    }

    public boolean verifierVirementPossible(float somme) {
        return solde >= somme;
    }

    public void setSolde(float somme) {
        solde += somme;
    }

    public float getSolde() {
        return solde;
    }

    public void ajouteOperationBancaire(OperationBancaire nouvelleOB) {
        listeOB.add(nouvelleOB);
    }

    public String afficheListeOB() {
        StringBuilder contenu = new StringBuilder("   - - - Liste Opérations Bancaires - - -\n");

        if (listeOB.size() > 0)
            for (int i = 0; i < listeOB.size(); i++)
                contenu.append("                -").append(i + 1).append("-\n").append(listeOB.get(i).afficheOB());
        else
            contenu.append(" Il n'y a d'opérations bancaires enregistrées.\n");
        contenu.append("   - - - - - - - - - - - - - - - - - - - -");

        return contenu.toString();
    }

}
