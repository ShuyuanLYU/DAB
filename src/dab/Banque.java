package dab;

public class Banque {
    private String nomBanque;

    private String getNomBanque() {
        // Automatically generated method. Please do not modify this code.
        return this.nomBanque;
    }

    private void setNomBanque(String value) {
        // Automatically generated method. Please do not modify this code.
        this.nomBanque = value;
    }

    private String codeBanque;

    private String getCodeBanque() {
        // Automatically generated method. Please do not modify this code.
        return this.codeBanque;
    }

    private void setCodeBanque(String value) {
        // Automatically generated method. Please do not modify this code.
        this.codeBanque = value;
    }

    public List<CarteClient> carteClient = new ArrayList<CarteClient> ();

    public List<Banque> autresBanques = new ArrayList<Banque> ();

    public boolean estUnClient(String noCarte) {
    }

}

