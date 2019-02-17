package dab;


import java.util.ArrayList;
import java.util.Scanner;

public class E4AfficheComptes extends Etat {

    private void afficheListeComptes(ArrayList<Compte> listeComptes) {
        int indice = 1;

        System.out.println("- - - - Liste des comptes - - - -");

        for (Compte compte : listeComptes) {
            System.out.println("         -Compte " + indice++ + "-");
            System.out.println(compte.afficheCompte());
        }

        System.out.println("- - - - - Fin de liste - - - - -");
    }

    private void afficheMenuDetailsCompte(ArrayList<Compte> listeComptes) {
        int indice = 1;

        for (Compte compte : listeComptes) {
            System.out.println(" " + indice++ + ". Voir détails de : " + compte.getNumeroCompte());
        }

        System.out.println(" " + indice++ + ". Retour au menu");
        System.out.println(" " + indice + ". Quitter");
        System.out.println("--------------------------------");
    }

    private int selectionneCompte(ArrayList<Compte> listeComptes) {
        System.out.print("Tapez votre choix : ");

        Scanner input = new Scanner(System.in);
        int choix = input.nextInt();

        while (choix < 1 || choix > listeComptes.size() + 2) {
            System.out.print("Tapez votre choix entre " + 1 + " et " + (listeComptes.size() + 2) + " svp : ");
            choix = input.nextInt();
        }

        return choix;
    }


    public void traitement(Distrib distrib) throws Exception {
        afficheListeComptes(distrib.listeComptes);
        afficheMenuDetailsCompte(distrib.listeComptes);

        int choix = selectionneCompte(distrib.listeComptes);

        if (choix == distrib.listeComptes.size() + 1)
            distrib.changeEtat(new E1AttenteOperation());
        else if (choix == distrib.listeComptes.size() + 2)
            distrib.changeEtat(new E2EtatFinal());
        else {
            distrib.indiceChoixCompte = choix - 1;
            distrib.changeEtat(new E5AfficheDetailsCompte());
        }
    }
}
