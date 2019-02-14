package dab;

import java.util.Scanner;

public class E1AttenteOperation extends Etat {

    public void afficheMenu() {
        System.out.println(" +-------------MENU-----------------+");
        System.out.println(" | 1. Consultation.                 |");
        System.out.println(" | 2. Virement.                     |");
        System.out.println(" | 3. Retirer votre carte.(Quitter) |");
        System.out.println(" +----------------------------------+");
    }

    public static int getChoixMenu(int min, int max) {
        System.out.print("Tapez votre choix : ");
        Scanner input = new Scanner(System.in);
        int choix = input.nextInt();

        while (choix < min || choix > max) {
            System.out.print("Tapez votre choix entre " + min + " et " + max + " svp : ");
            choix = input.nextInt();
        }

        return choix;
    }

    public void traitement(Distrib distrib) throws Exception {
        afficheMenu();
        int choix = getChoixMenu(1, 3);

        switch (choix) {
            case 1:
                distrib.changeEtat(new E3AttenteRecuperationComptesConsultation());
                break;
            case 2:
				distrib.changeEtat(new E6AttenteRecuperationComptesVirement());
                break;
            case 3:
                distrib.changeEtat(new E2EtatFinal());
                break;
            default:
                this.traitement(distrib);
                break;
        }
    }
}
