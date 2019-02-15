package dab;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banque {

	private String nomBanque;
	private String codeBanque;
	private List<Client> listeClients;
	private List<CarteClient> listeCartesClients;
	private List<Compte> listeCompte;

	public Banque(String nomBanque, String codeBanque) {
		this.nomBanque = nomBanque;
		this.codeBanque = codeBanque;
		listeClients = new ArrayList<>();
		listeCartesClients = new ArrayList<>();
		listeCompte = new ArrayList<>();
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

	public void effectuerVirement(Compte compteEmission, Object compteDestinataire, float somme, Date date,
			String message) {
		compteEmission.setSolde(-somme);
		compteEmission.ajouteOperationBancaire(new OperationBancaire(NatureOperation.debit, -somme, date, message));

		if (compteDestinataire instanceof Compte) {

			((Compte) compteDestinataire).setSolde(somme);
			((Compte) compteDestinataire)
					.ajouteOperationBancaire(new OperationBancaire(NatureOperation.credit, somme, date, message));
		}
	}

	public boolean verifierVirement(Compte compteEmission, float somme) {
		return compteEmission.verifierVirementPossible(somme);
	}

	public List<Compte> recupereComptesConsultation(String numeroCarteInseree) {
		for (CarteClient carteClient : listeCartesClients) {
			if (carteClient.verifierNumeroCarte(numeroCarteInseree)) {
				Client clientTrouve = carteClient.recupereClient();
				return clientTrouve.recupereComptes();
			}
		}
		return new ArrayList<>();
	}

	public void ajouteClient(Client c) {
		if (listeClients == null)
			listeClients = new ArrayList<>();

		listeClients.add(c);
	}

	public void ajouteCarteClient(CarteClient cc) {
		if (listeCartesClients == null)
			listeCartesClients = new ArrayList<>();

		listeCartesClients.add(cc);
	}
}
