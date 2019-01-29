package dab;

import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compte {

	private float Solde;
	private String noCompte;
	private float plafondRetrait;
	private List<Client> client = new ArrayList<Client>();
	private List<OperationBancaire> listOB = new ArrayList<OperationBancaire>();
	
	public Compte(float Solde, String noCompte, float plafondRetrait) {
		this.Solde = Solde;
		this.noCompte = noCompte;
		this.plafondRetrait = plafondRetrait;
    }

	public String afficheCompte() {
		return "noCompte : " + noCompte + "\n" + "Solde : " + Solde + "\n" + "plafondRetrait : " + "\n";
	}

	public Compte recupereCompte() {
		return this;
	}

	public String afficheCompteVirement() {
		return null;
	}

	public boolean verifierVirementPossible(double somme, Date date) {
		return true;
	}

}
