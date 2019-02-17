package dab;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OperationBancaire {

    private NatureOperation nature;
    private float montant;
    private Date dateOperation;
    private String message;

    public OperationBancaire(NatureOperation nature, float montant, Date dateOperation, String message) {
        this.nature = nature;
        this.montant = montant;
        this.dateOperation = dateOperation;
        this.message = message;
    }

    public String afficheOB() {
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        return "  Nature Operation : " + nature + "\n" + "  Montant : " + montant + "\n" + "  Date Operation : "
                + dt.format(dateOperation) + "\n" + "  Message : " + message + "\n";
    }

}
