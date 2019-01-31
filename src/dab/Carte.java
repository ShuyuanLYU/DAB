package dab;

public class Carte {

	private String noCarte;
	private String code;
	private int nbEssaisRestant;
	private final int nbEssaisTotal = 3;

	public Carte(String noCarte, String code) {
		this.noCarte = noCarte;
		this.code = code;
		nbEssaisRestant = -1;
	}

	public boolean codeOK(String codeS) {
		return code.equals(codeS);
	}

	public String getNoCarte() {
		return noCarte;
	}
	
	public void decrementerNbEssais() {
		nbEssaisRestant--;
	}
	
	public int getNbEssaisRestant() {
		return nbEssaisRestant;
	}
	
	public int initNbEssaisRestant() {
		return nbEssaisRestant = nbEssaisTotal;
	}

}