package dab;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.Locale;
import java.util.Scanner;

public class E7AfficheComptesPersosEtDestinataires extends Etat {

    private void afficheListeComptesPersosVirement(ArrayList<Compte> listeComptes) {
        if (listeComptes.size() > 0) {
            int indice = 1;
            System.out.println("-------------------------------------------");
            System.out.println("      ----Liste Comptes �metteurs----   ");

            for (Compte comptePerso : listeComptes) {
                System.out.print(" " + indice++ + ". ");
                System.out.println(comptePerso.afficheCompteVirement());
            }
            System.out.println("      -------------------------------   ");
        } else
            System.out.println("Aucun compte n'a été trouvé."); // Ne devrait jamais se produire
    }

    private int getChoixCompte(int tailleListe) {
        System.out.print("Tapez votre choix : ");
        Scanner input = new Scanner(System.in);
        int choix = input.nextInt();

        while (choix < 1 || choix > tailleListe) {
            System.out.print("Tapez votre choix entre " + 1 + " et " + tailleListe + " svp : ");
            choix = input.nextInt();
        }

        return choix;
    }

    private void afficheListeComptesDestinatairesVirement(ArrayList<Compte> listeComptesPersos,
                                                          ArrayList<CompteDestinataire> listeComptesDestinataires) {
        if (listeComptesPersos.size() > 0 || listeComptesDestinataires.size() > 0) {
            int indice = 1;

            System.out.println("      ----Liste Comptes Destinataires----   ");

            for (Compte compte : listeComptesPersos) {
                System.out.print(" " + indice++ + ". ");
                System.out.println(compte.afficheCompteVirement());
            }

            for (CompteDestinataire compte : listeComptesDestinataires) {
                System.out.print(" " + indice++ + ". ");
                System.out.println(compte.afficheCompte());
            }

            System.out.println("      -------------------------------   ");
            System.out.println("-------------------------------------------");
        } else
            System.out.println("Aucun compte n'a été trouvé."); // Ne devrait jamais se produire
    }

    public void traitement(Distrib distrib) throws Exception {
        afficheListeComptesPersosVirement(distrib.listeComptes);

        int indiceComptePersoChoisi = getChoixCompte(distrib.listeComptes.size()) - 1;
        Compte comptePersoChoisi = distrib.listeComptes.get(indiceComptePersoChoisi);

        ArrayList<Compte> listeComptesPersosMoinsChoix = new ArrayList<>(distrib.listeComptes);
        listeComptesPersosMoinsChoix.remove(indiceComptePersoChoisi);
        afficheListeComptesDestinatairesVirement(listeComptesPersosMoinsChoix, distrib.listeComptesDestinataires);

        ArrayList<Object> listeCompteDestinataireAChoisir = new ArrayList<>(listeComptesPersosMoinsChoix);
        listeCompteDestinataireAChoisir.addAll(distrib.listeComptesDestinataires);

        Object compteDestinataireChoisi = listeCompteDestinataireAChoisir
                .get(getChoixCompte(distrib.listeComptesDestinataires.size() + listeComptesPersosMoinsChoix.size()) - 1);
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);

        Scanner input = new Scanner(System.in);

        float somme = 0;
        Date date = new Date();

        try {
            System.out.print("Somme : ");
            somme = Float.parseFloat(input.next());
            System.out.print("Date : ");
            date = format.parse(input.next());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.print("Message : ");

        String message = input.next();

        distrib.listeInfoVirement[0] = comptePersoChoisi;
        distrib.listeInfoVirement[1] = compteDestinataireChoisi;
        distrib.listeInfoVirement[2] = somme;
        distrib.listeInfoVirement[3] = date;
        distrib.listeInfoVirement[4] = message;

        distrib.changeEtat(new E8AttenteVerificationVirement());
    }
}
