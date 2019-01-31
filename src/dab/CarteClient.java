package dab;

public class CarteClient {

    private String noCarte;
    private Client client;
    
    public CarteClient(String NoCarte, Client client) {
    	this.noCarte = NoCarte;
    	this.client = client;
    }
    
    public String getNoCarte() {
    	// System.out.println("[CarteClient] - getNoCarte -> " + noCarte);
    	return noCarte;
    }

    public boolean verifierNumeroCarte(String noCarte) {
        return noCarte.equals(noCarte);
    }

    public Client recupereClient() {
    	// System.out.println("CarteClient - recupereClient -> " + client.getNomClient());
        return client;
    }
    // pour test
    public String toString() {
    	return "NoCarte : " + noCarte + " client : " + client.getNomClient();
    }
}