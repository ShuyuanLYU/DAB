package dab;

public class CarteClient {

    private String numeroCarte;
    private Client client;
    
    public CarteClient(String numeroCarte, Client client) {
    	this.numeroCarte = numeroCarte;
    	this.client = client;
    }
    
    public String getNumeroCarte() {
    	return numeroCarte;
    }

    public boolean verifierNumeroCarte(String numeroCarte) {
        return this.numeroCarte.equals(numeroCarte);
    }

    public Client recupereClient() {
        return client;
    }
    // pour test
    public String toString() {
    	return "NoCarte : " + numeroCarte + " client : " + client.getNomClient();
    }
}