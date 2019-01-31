package dab;

import java.util.ArrayList;
import java.util.List;

public class ComptesVirement {
	private List<Compte> ListCompte = new ArrayList<Compte>();

	private List<CompteDestinataire> ListCompteDestinataire = new ArrayList<CompteDestinataire>();

	public ComptesVirement(List<Compte> ListCompte, List<CompteDestinataire> ListCompteDestinataire) {
		this.ListCompte = ListCompte;
		this.ListCompteDestinataire = ListCompteDestinataire;
	}
	
	public List<Compte> getListCompte(){
		return ListCompte;
	}
	
	public List<CompteDestinataire> getListCompteDestinataire(){
		return ListCompteDestinataire;
	}
}
