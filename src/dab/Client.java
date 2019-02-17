package dab;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class Client {

    private String nomClient;
    private ArrayList<Compte> listeComptes;
    private ArrayList<CompteDestinataire> listeComptesDestinataires;


    public Client(String nomClient, ArrayList<Compte> listeComptes, ArrayList<CompteDestinataire> compteDestinataires) {
        this.nomClient = nomClient;
        this.listeComptes = listeComptes;
        this.listeComptesDestinataires = compteDestinataires;
    }

    public ArrayList<Compte> recupereComptes() {
        if (listeComptes == null)
            listeComptes = new ArrayList<>();

        return listeComptes;
    }

    public Object[] recupereComptesVirement() {
        if (listeComptes == null)
            listeComptes = new ArrayList<>();

        if (listeComptesDestinataires == null)
            listeComptesDestinataires = new ArrayList<>();


        return new Object[]{listeComptes.stream().filter(c -> c.getSolde() > 0).collect(Collectors.toList()), listeComptesDestinataires};
    }
}
