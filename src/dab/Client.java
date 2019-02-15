package dab;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	private String nomClient;
	private List<Compte> listeComptes;
	private List<CompteDestinataire> listeComptesDestinataires;

	
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

	public Object[] recupereComptesVirement() {
		if(listeComptes == null)
			listeComptes = new ArrayList<>();

		if(listeComptesDestinataires == null)
			listeComptesDestinataires = new ArrayList<>();

		return new Object[]{listeComptes, listeComptesDestinataires};
	}
}
