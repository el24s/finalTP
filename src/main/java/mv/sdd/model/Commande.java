package mv.sdd.model;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Commande {
    private int id;
    private static int nbCmd = 0;
    private final Client client;
    private EtatCommande etat = EtatCommande.EN_ATTENTE;
    private int tempsRestant; // en minutes simulées

    // TODO : ajouter l'attribut plats et son getter avec le bon type et le choix de la SdD adéquat
    private Map<MenuPlat, Plat> plats = new HashMap<>();

    // TODO : Ajout du ou des constructeur(s) nécessaires ou compléter au besoin
    public Commande(Client client, MenuPlat plat) {
        id = ++nbCmd;
        this.client = client;
        // À compléter
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public EtatCommande getEtat() {
        return etat;
    }

    public int getTempsRestant() {
        return tempsRestant;
    }

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

    // TODO : Ajoutez la méthode ajouterPlat
    public void ajouterPlat(Map<MenuPlat, String> plat) {
        if(plat.isEmpty()) {
           return;
        }
        plats.put(plat.get(0), plat.get(1));
    }

    // TODO : Ajoutez la méthode demarrerPreparation
    public void demarrerPreparation() {

    }

    // TODO : Ajoutez la méthode decrementerTempsRestant
    public int decrementerTempsRestant() {
        return tempsRestant = 0;
    }

    // TODO : Ajoutez la méthode estTermineeParTemps
    public boolean estTermineeParTemps() {
        return false;
    }

    // TODO : Ajoutez la méthode calculerTempsPreparationTotal
    public void calculerTempsPreparationTotal() {

    }

    // TODO : Ajoutez la méthode calculerMontant
    public void calculerMontant() {

    }
}
