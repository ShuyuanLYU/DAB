package dab;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // initialisation compte/client/carteclient/banque/distrib...

        ArrayList<Compte> listeComptesBob = initComptes();
        ArrayList<CompteDestinataire> listeComptesDestBob = initComptesDestinataires();
        ArrayList<Client> listeClientsCA = initClientsCA(listeComptesBob, listeComptesDestBob);
        ArrayList<CarteClient> listeCartesClients = initCartesClient(listeClientsCA);

        Banque LCL = new Banque("Crédit lyonnais", "LCL");

		/* Initialise distrib avec le numéro de la carte car
		   l'authentification est déjà effectuée et la carte est déjà insérée */
        Distrib distrib = new Distrib(initBanque(listeClientsCA, listeCartesClients), "0123456789");

        // Lance l'interface du distributeur
        try {
            distrib.etat.traitement(distrib);
        } catch (Exception e) {
            System.out.println("Problème du ditributeur...");
            e.printStackTrace();
        }
    }

    private static ArrayList<Compte> initComptes() {
        Compte compte_Bob_0 = new Compte(0, "CA1234567", 100, -100);
        Compte compte_Bob_1 = new Compte(100, "CA1234567", 100, -100);
        Compte compte_Bob_2 = new Compte(200, "CA7654321", 200, 0);

        ArrayList<Compte> listeComptesBob = new ArrayList<>();
        listeComptesBob.add(compte_Bob_0);
        listeComptesBob.add(compte_Bob_1);
        listeComptesBob.add(compte_Bob_2);


        return listeComptesBob;
    }

    private static ArrayList<CompteDestinataire> initComptesDestinataires() {
        CompteDestinataire compteDest_Bob_1 = new CompteDestinataire("723687146876219", "PPSTQTRQ");
        CompteDestinataire compteDest_Bob_2 = new CompteDestinataire("1874693285710237", "MQKTQRPK");

        ArrayList<CompteDestinataire> listeComptesDestBob = new ArrayList<>();
        listeComptesDestBob.add(compteDest_Bob_1);
        listeComptesDestBob.add(compteDest_Bob_2);

        return listeComptesDestBob;
    }

    private static ArrayList<Client> initClientsCA(ArrayList<Compte> listeComptesBob, ArrayList<CompteDestinataire> listeComptesDestBob) {
        ArrayList<Client> listeClients = new ArrayList<>();

        listeClients.add(new Client("12345_Bob", listeComptesBob, listeComptesDestBob));
        listeClients.add(new Client("11111_Leo", null, null));
        listeClients.add(new Client("22222_David", null, null));

        return listeClients;
    }

    private static ArrayList<CarteClient> initCartesClient(ArrayList<Client> listeClients) {
        ArrayList<CarteClient> listeCartesClients = new ArrayList<>();

        for (Client client : listeClients)
            listeCartesClients.add(new CarteClient("0123456789", client));

        return listeCartesClients;
    }

    private static Banque initBanque(ArrayList<Client> listeClients, ArrayList<CarteClient> listeCarteClients) {
        Banque banque = new Banque("Crédit Agricole", "CA");

        for (Client client : listeClients)
            banque.ajouteClient(client);

        for (CarteClient carteClient : listeCarteClients)
            banque.ajouteCarteClient(carteClient);

        return banque;
    }
}