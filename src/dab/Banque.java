package dab;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banque {

	private String nomBanque;

	private String codeBanque;

	public List<Banque> autresBanques = new ArrayList<Banque>();

	private List<Client> listClient = new ArrayList<Client>();

	private List<CarteClient> ListCarteClient = new ArrayList<CarteClient>();

	private List<Compte> ListCompte = new ArrayList<Compte>();

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

	public ComptesVirement recupereComptesVirement(Client compteClient) {
		return compteClient.recupereComptesVirement();
	}

	public boolean effectueVirement(Compte compteEmission, Compte compteDestinataire, double somme, Date date,
			String message) {
		return compteEmission.verifierVirementPossible(somme, date);
	}

	public List<Compte> recupereComptesConsultation(String noCarte) {
		//System.out.println("[Banque] - recupereComptesConsultation LANCER -> " + noCarte); // trace
		for (int i = 0; i < ListCarteClient.size(); i++) { // parcourir tout les CarteClient
			CarteClient tmp = ListCarteClient.get(i);
			if (tmp.verifierNumeroCarte(noCarte)) {
				Client client_trouve = tmp.recupereClient(); // si on le trouve
				return client_trouve.recupereComptes(); // on revoie la liste des comptes
			}
		}
		return new ArrayList<Compte>(); // sinon, on revoie une liste vide
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
		System.out.println("size of ListClient: " + listClient.size());
		for (int i = 0; i < listClient.size(); i++) {
			Client tmp = listClient.get(i);
			System.out.println(tmp.toString());
		}
	}

	// pour init Banque
	public void ajouteClient(Client c) {
		if (listClient == null)
			listClient = new ArrayList<Client>();
		listClient.add(c);
	}

	// pour init Banque
	public void ajouteCarteClient(CarteClient cc) {
		if (ListCarteClient == null)
			ListCarteClient = new ArrayList<CarteClient>();
		ListCarteClient.add(cc);
	}

}
