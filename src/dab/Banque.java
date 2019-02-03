package dab;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banque {

	private String nomBanque;
	private String codeBanque;

	public List<Banque> autresBanques = new ArrayList<>();

	private List<Client> listeClients = new ArrayList<>();
	private List<CarteClient> listeCartesClients = new ArrayList<>();
	private List<Compte> ListCompte = new ArrayList<>();

	public Banque(String nomBanque, String codeBanque) {
		this.nomBanque = nomBanque;
		this.codeBanque = codeBanque;
	}

	public boolean estUnClient(String noCarte) {
		return noCarte.startsWith(codeBanque);
	}

	private List<Compte> recupereComptes(String noCarte) {
		return null;
	}

	public Object[] recupereComptesVirement(String numeroCarteInseree) {
		for (CarteClient carteClient : listeCartesClients) {
			if (carteClient.verifierNumeroCarte(numeroCarteInseree)) {
				Client clientTrouve = carteClient.recupereClient();
				return clientTrouve.recupereComptesVirement();
			}
		}
		return new Object[2];
	}

	public boolean effectueVirement(Compte compteEmission, Object compteDestinataire, float somme, Date date,
			String message) {
		if(compteEmission.verifierVirementPossible(somme)) {
			
			compteEmission.setSolde(-somme);
			compteEmission.ajouteOperationBancaire(new OperationBancaire(NatureOperation.débit, -somme, date));
			if(compteDestinataire instanceof Compte) {
				((Compte) compteDestinataire).setSolde(somme);
				((Compte) compteDestinataire).ajouteOperationBancaire(new OperationBancaire(NatureOperation.crédit, somme, date));
			}		
			return true;
		}
		else
			return false;
	}

	public List<Compte> recupereComptesConsultation(String numeroCarteInseree) {
		for (CarteClient carteClient : listeCartesClients) {
			if (carteClient.verifierNumeroCarte(numeroCarteInseree)) {
				Client clientTrouve = carteClient.recupereClient(); // si on le trouve
				return clientTrouve.recupereComptes(); // on revoie la liste des comptes
			}
		}
		return new ArrayList<>(); // sinon, on revoie une liste vide
	}

	private void recupereComptesDestinataire() {
		// TO DO
	}

	// ---------------------------------------------- méthodes créées manuelles
	public String getNomBanque() {
		return nomBanque;
	}

	// pour test
	public void afficheListClient() {
		System.out.println("size of ListClient: " + listeClients.size());

		for (Client tmp : listeClients) {
			System.out.println(tmp.toString());
		}
	}

	// pour init Banque
	public void ajouteClient(Client c) {
		if (listeClients == null)
			listeClients = new ArrayList<Client>();

		listeClients.add(c);
	}

	// pour init Banque
	public void ajouteCarteClient(CarteClient cc) {
		if (listeCartesClients == null)
			listeCartesClients = new ArrayList<CarteClient>();

		listeCartesClients.add(cc);
	}

}
