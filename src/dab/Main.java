package dab;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    	
    	// init compte/client/carteclient/banque/distrib...
    	Compte compte_Bob_1 = new Compte(100, "CA1234567");
		Compte compte_Bob_2 = new Compte(200, "CA7654321");
		List<Compte> listCompteBob = new ArrayList<Compte>();
		listCompteBob.add(compte_Bob_1);
		listCompteBob.add(compte_Bob_2);
		
		Client Bob = new Client("12345_Bob", listCompteBob, null);
		Client Léo = new Client("11111_Leo", null, null);
		Client Davide = new Client("22222_Davide", null, null);
		
		CarteClient carte_Bob = new CarteClient("CA1234567", Bob);
		CarteClient carte_Leo = new CarteClient("CA1111111", Léo);
		CarteClient carte_Davide = new CarteClient("CA2222222", Davide);
		
		Banque CA = new Banque("Crédit Agricole", "CA");
		CA.ajouteClient(Bob);
		CA.ajouteClient(Léo);
		CA.ajouteClient(Davide);
		CA.ajouteCarteClient(carte_Bob);
		CA.ajouteCarteClient(carte_Leo);
		CA.ajouteCarteClient(carte_Davide);
		
		Banque LCL = new Banque("Crédit lyonnais", "LCL");
		
		Distrib d = new Distrib(CA);
		
		//lance distrib
		d.lanceDistributeur();

    }
}