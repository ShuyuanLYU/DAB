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
		return "No Compte : " + noCompte + "\n" + "Solde : " + Solde + "\n" + "plafondRetrait : ";
	}

	public Compte recupereCompte() {
		return this;
	}

	public String afficheCompteVirement() {
		return "No Compte : " + noCompte + "\n" + "Solde : " + Solde;
	}

	public boolean verifierVirementPossible(double somme, Date date) {
		return Solde >= somme;
	}

	//----
	public Compte(float Solde, String noCompte) {
		this.Solde = Solde;
		this.noCompte = noCompte;
		//this.plafondRetrait = plafondRetrait;
    }

}
