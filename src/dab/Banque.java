package dab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banque {

    private String nomBanque;

    private String codeBanque;

    public List<Banque> autresBanques = new ArrayList<Banque> ();

    private List<Client> listClient = new ArrayList<Client> ();

    private List<CarteClient> ListCarteClient = new ArrayList<CarteClient> ();

    private List<Compte> ListCompte = new ArrayList<Compte> ();

    public boolean estUnClient(String noCarte) {
    	return noCarte.startsWith(codeBanque);
    }

    private List<Compte> recupereComptes(String noCarte) {
    	return null;
    }

    public List<Compte> recupereComptesVirement(Client compteClient) {
    	return null;
    }

    public boolean effectueVirement(Compte compteEmission, Compte compteDestinataire, double somme, Date date, String message) {
    	return true;
    }

    public List<Compte> recupereComptesConsultation(String noCarte) {
    	return null;
    }

    private void recupereComptesDestinataire() {
    }

    public Banque(String nomBanque, String codeBanque) {
    	this.nomBanque = nomBanque;
    	this.codeBanque = codeBanque;
    }

}

