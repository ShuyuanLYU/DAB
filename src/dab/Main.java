package dab;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    	
    	// initialisation compte/client/carteclient/banque/distrib...

		List<Compte> listeComptesBob = initComptes();
		List<Client> listeClientsCA = initClientsCA(listeComptesBob);
		List<CarteClient> listeCartesClients = initCartesClient(listeClientsCA);

		Banque lcl = new Banque("Crédit lyonnais", "LCL");
		
		Distrib d = new Distrib(initBanque(listeClientsCA, listeCartesClients));
		
		//lance distrib
		d.lanceDistributeur();
    }

    private static List<Compte> initComptes() {
		Compte compte_Bob_1 = new Compte(100, "CA1234567");
		Compte compte_Bob_2 = new Compte(200, "CA7654321");

		List<Compte> listeComptesBob = new ArrayList<>();
		listeComptesBob.add(compte_Bob_1);
		listeComptesBob.add(compte_Bob_2);

		return listeComptesBob;
	}

	private static List<Client> initClientsCA(List<Compte> listeComptesBob) {
    	List<Client> listeClients= new ArrayList<>();

		listeClients.add(new Client("12345_Bob", listeComptesBob, null));
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