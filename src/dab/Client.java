package dab;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	private String nomClient;
	private List<Compte> listeComptes = new ArrayList<Compte>();
	private List<CompteDestinataire> listeComptesDestinataires = new ArrayList<CompteDestinataire>();

	public String getNomClient() {
		return nomClient;
	}
	
	public Client(String nomClient, List<Compte> listeComptes, List<CompteDestinataire> compteDestinataires) {
		this.nomClient = nomClient;
		this.listeComptes = listeComptes;
		this.listeComptesDestinataires = compteDestinataires;
	}
	
	public List<Compte> recupereComptes() {
		if(listeComptes == null)
			listeComptes = new ArrayList<Compte>();
		return listeComptes;
	}

	public ComptesVirement recupereComptesVirement() {
		if(listeComptes == null)
			listeComptes = new ArrayList<Compte>();
		if(listeComptesDestinataires == null)
			listeComptesDestinataires = new ArrayList<CompteDestinataire>();
		return new ComptesVirement(listeComptes, listeComptesDestinataires);
	}

	// ---- pour test
	public String toString() {
		return "Client " + nomClient;
		// + " possède " + ListCompte.size() + "ListCompte.";
	}

}
