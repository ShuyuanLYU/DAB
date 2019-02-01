package dab;

import java.util.Date;

public class OperationBancaire {

	private NatureOperation nature;
	private float montant;
	private Date dateOperation;
	
	public OperationBancaire(NatureOperation nature, float montant, Date dateOperation) {
		this.nature = nature;
		this.montant = montant;
		this.dateOperation = dateOperation;
    }

	public void ajouteOperation(String nature, double montant, Date date) {
	}

	public String afficheOB() {
		return "Nature Operation : " + nature + "\n" + "Montant : " + montant + "\n" + "Date Operation : "
				+ dateOperation.toString() + "\n";
	}

}
