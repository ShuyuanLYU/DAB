package dab;

import java.text.SimpleDateFormat;
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

	public String afficheOB() {
		SimpleDateFormat dt = new SimpleDateFormat("dd-mm-yyyy");
		return "  Nature Operation : " + nature + "\n" + "  Montant : " + montant + "\n" + "  Date Operation : "
				+ dt.format(dateOperation) + "\n";
	}

}
