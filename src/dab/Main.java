package dab;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    	
    	// initialisation compte/client/carteclient/banque/distrib...

		List<Compte> listeComptesBob = initComptes();
		List<CompteDestinataire> listeComptesDestBob = initComptesDestinataires();
		List<Client> listeClientsCA = initClientsCA(listeComptesBob, listeComptesDestBob);
		List<CarteClient> listeCartesClients = initCartesClient(listeClientsCA);

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

    private static List<Compte> initComptes() {
		Compte compte_Bob_1 = new Compte(100, "CA1234567", 100, -100);
		Compte compte_Bob_2 = new Compte(200, "CA7654321", 200, 0);

		List<Compte> listeComptesBob = new ArrayList<>();
		listeComptesBob.add(compte_Bob_1);
		listeComptesBob.add(compte_Bob_2);

		return listeComptesBob;
	}
    
    private static List<CompteDestinataire> initComptesDestinataires() {
    	CompteDestinataire compteDest_Bob_1 = new CompteDestinataire("723687146876219", "PPSTQTRQ");
    	CompteDestinataire compteDest_Bob_2 = new CompteDestinataire("1874693285710237", "MQKTQRPK");

		List<CompteDestinataire> listeComptesDestBob = new ArrayList<>();
		listeComptesDestBob.add(compteDest_Bob_1);
		listeComptesDestBob.add(compteDest_Bob_2);

		return listeComptesDestBob;
	}

	private static List<Client> initClientsCA(List<Compte> listeComptesBob, List<CompteDestinataire> listeComptesDestBob) {
    	List<Client> listeClients= new ArrayList<>();

		listeClients.add(new Client("12345_Bob", listeComptesBob, listeComptesDestBob));
		listeClients.add(new Client("11111_Leo", null, null));
		listeClients.add(new Client("22222_David", null, null));

		return listeClients;
	}

	private static List<CarteClient> initCartesClient(List<Client> listeClients) {
    	List<CarteClient> listeCartesClients = new ArrayList<>();

    	for(Client client : listeClients)
			listeCartesClients.add(new CarteClient("0123456789", client));

		return listeCartesClients;
	}

	private static Banque initBanque(List<Client> listeClients, List<CarteClient> listeCarteClients) {
		Banque banque = new Banque("Crédit Agricole", "CA");

		for(Client client : listeClients)
			banque.ajouteClient(client);

		for(CarteClient carteClient : listeCarteClients)
			banque.ajouteCarteClient(carteClient);

    	return banque;
	}
}