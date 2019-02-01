package dab;

import java.util.ArrayList;
import java.util.List;

public class ComptesVirement {
	private List<Compte> listeComptes = new ArrayList<>();

	private List<CompteDestinataire> listeComptesDestinataires = new ArrayList<CompteDestinataire>();

	public ComptesVirement(List<Compte> listeComptes, List<CompteDestinataire> listeComptesDestinataires) {
		this.listeComptes = listeComptes;
		this.listeComptesDestinataires = listeComptesDestinataires;
	}
	
	public List<Compte> getlisteComptes(){
		return listeComptes;
	}
	
	public List<CompteDestinataire> getlisteComptesDestinataires(){
		return listeComptesDestinataires;
	}
}
