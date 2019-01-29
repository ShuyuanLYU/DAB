package dab;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;
import java.util.List;

public class Distrib {
    private int nbBillets10;
    private int nbBillets20;
    private int nbBillets50;
    private int nbBillets100;

    public Banque BanqueDeRattachement;

    private Carte carteInseree;
    
    public Distrib() {
    }

    public void insererCarte(String noCarte, String code, int nbEssaisRestants) {
    }

    public boolean saisirCode(int codeSaisi) {
        throw new NotImplementedException();
    }

    public void choisirOperation(int noOp) {
    }

    private void consultation(Client compteClient) {
    }

    private void afficheListeComptes(List<Compte> listeComptes) {
    }

    private void choisirCompte(Compte compte) {
    }

    private void afficheCompte(Compte compte) {
    }

    private void gererCompte(Compte compte) {
    }

    private void afficheListeOperationsDeGestion(Compte compte) {
    }

    private List<Compte> choixVirement(Client compteClient, List<Compte> comptesDestinataires) {
        throw new NotImplementedException();
    }

    private void afficheListeComptesVirement(List<Compte> comptesPerso, List<Compte> comptesDestinataires) {
    }

    private boolean selectionneInformationsVirement(Compte compteEmission, Compte compteDestinataire, double somme, Date date, String message) {
        throw new NotImplementedException();
    }

}
