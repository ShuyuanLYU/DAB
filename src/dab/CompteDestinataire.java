package dab;

public class CompteDestinataire {

    private String iban;
    private String bic;

    public CompteDestinataire(String iban, String bic) {
    	this.iban = iban;
    	this.bic = bic;
    }

    public String afficheCompte() {
        return "Iban : " + iban + "  BIC : " + bic;
    }

}