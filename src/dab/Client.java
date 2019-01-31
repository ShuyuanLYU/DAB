package dab;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	private String NomClient;
	private List<Compte> ListCompte = new ArrayList<Compte>();
	private List<CompteDestinataire> ListCompteDestinataire = new ArrayList<CompteDestinataire>();

	public String getNomClient() {
		return NomClient;
	}
	
	public Client(String NomClient, List<Compte> ListCompte, List<CompteDestinataire> compteDestinataire) {
		this.NomClient = NomClient;
		this.ListCompte = ListCompte;
		this.ListCompteDestinataire = compteDestinataire;
	}
	
	public List<Compte> recupereComptes() {
		if(ListCompte == null)
			ListCompte = new ArrayList<Compte>();
		return ListCompte;
	}

	public ComptesVirement recupereComptesVirement() {
		if(ListCompte == null)
			ListCompte = new ArrayList<Compte>();
		if(ListCompteDestinataire == null)
			ListCompteDestinataire = new ArrayList<CompteDestinataire>();
		return new ComptesVirement(ListCompte, ListCompteDestinataire);
	}
	// ---- pour test
	public String toString() {
		return "Client " + NomClient;
		// + " possède " + ListCompte.size() + "ListCompte.";
	}

}
