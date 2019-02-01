package dab;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	private String nomClient;
	private List<Compte> listeComptes;
	private List<CompteDestinataire> listeComptesDestinataires;

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
			listeComptes = new ArrayList<>();

		return listeComptes;
	}

	public ComptesVirement recupereComptesVirement() {
		if(listeComptes == null)
			listeComptes = new ArrayList<>();

		if(listeComptesDestinataires == null)
			listeComptesDestinataires = new ArrayList<>();

		return new ComptesVirement(listeComptes, listeComptesDestinataires);
	}

	// ---- pour test
	public String toString() {
		return "Client " + nomClient;
		// + " possède " + ListCompte.size() + "ListCompte.";
	}

}
