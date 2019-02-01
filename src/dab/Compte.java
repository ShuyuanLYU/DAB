package dab;

import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compte {

	private float Solde;
	private String numeroCompte;
	private float plafondRetrait;
	private List<Client> client = new ArrayList<>();
	private List<OperationBancaire> listOB = new ArrayList<>();

	public String getNumeroCompte() {
		return numeroCompte;
	}
	
	public Compte(float Solde, String numeroCompte, float plafondRetrait) {
		this.Solde = Solde;
		this.numeroCompte = numeroCompte;
		this.plafondRetrait = plafondRetrait;
    }

	public String afficheCompte() {
		return "Numéro compte : " + numeroCompte + "\n" + "Solde : " + Solde + "\n";
	}

	public String afficheDetailsCompte() {
		return "Numéro compte : " + numeroCompte + "\n" + "Solde : " + Solde + "\n" +
				"Plafond de retrait : " + plafondRetrait;
	}

	public Compte recupereCompte() {
		return this;
	}

	public String afficheCompteVirement() {
		return "Numéro compte : " + numeroCompte + "\n" + "Solde : " + Solde;
	}

	public boolean verifierVirementPossible(double somme, Date date) {
		return Solde >= somme;
	}
}
