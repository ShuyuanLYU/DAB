package dab;

public class CompteDestinataire {

    private String Iban;
    private String BIC;

    public CompteDestinataire(String Iban, String BIC) {
    	this.Iban = Iban;
    	this.BIC = BIC;
    }
    
    public CompteDestinataire recupereCompte() {
    	return this;
    }

    public String afficheCompte() {
        return "Iban : " + Iban + "\n" + "BIC : " + BIC;
    }



}