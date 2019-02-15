package dab;

import java.util.Date;

public class E8AttenteVerificationVirement extends Etat {

    private void afficheVerificationEchoue() {
        System.out.println("+---------------------+");
        System.out.println("|Vérification échouée !|");
        System.out.println("| Veuillez recommencer |");
        System.out.println("+---------------------+");
    }

    private void afficheVirementEffectue() {
        System.out.println(" +---------------------+");
        System.out.println(" | Virement effectué ! |");
        System.out.println(" +---------------------+");
    }

    public void traitement(Distrib distrib) {
        Compte comptePersoChoisi = (Compte) distrib.listeInfoVirement[0];
        Object compteDestinataireChoisi = distrib.listeInfoVirement[1];
        float somme = (float) distrib.listeInfoVirement[2];
        Date date = (Date) distrib.listeInfoVirement[3];
        String message = (String) distrib.listeInfoVirement[4];

        try {
            if (distrib.banqueDeRattachement.verifierVirement(comptePersoChoisi, somme)) {

                distrib.banqueDeRattachement.effectuerVirement(comptePersoChoisi, compteDestinataireChoisi, somme, date,
                        message);
                afficheVirementEffectue();

                distrib.changeEtat(new E1AttenteOperation());
            }
            else {
                afficheVerificationEchoue();
                distrib.changeEtat(new E7AfficheComptesPersosEtDestinataires());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
