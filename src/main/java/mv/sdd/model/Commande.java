package mv.sdd.model;

import java.util.HashMap;
import java.util.Map;

public class Commande {
    private int id;
    private static int nbCmd = 0;
    private final Client client;
    private EtatCommande etat = EtatCommande.EN_ATTENTE;
    private int tempsRestant; // en minutes simulées
    // ajouter l'attribut catalogue et son getter avec le bon type et le choix de la SdD adéquat DONE
    private Map<MenuPlat, Plat> catalogue = new HashMap<>();

    // TODO : Ajout du ou des constructeur(s) nécessaires ou compléter au besoin
    public Commande(Client client, MenuPlat plat, Map<MenuPlat, Plat> catalogue) {
        id = ++nbCmd;
        this.client = client;
        this.catalogue = catalogue;
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

    public Map<MenuPlat, Plat> getCatalogue() {
        return catalogue;
    }

    // Ajoutez la méthode ajouterPlat DONE
    public void ajouterPlat(Plat plat) {
        if(plat == null) {
           return;
        }
        catalogue.put(plat.getCode(), plat);
    }

    // Ajoutez la méthode demarrerPreparation
    public void demarrerPreparation() {
        etat = EtatCommande.EN_PREPARATION;
        tempsRestant = calculerTempsPreparationTotal();

    }

    // Ajoutez la méthode decrementerTempsRestant DONE
    public void decrementerTempsRestant() {
        tempsRestant -= 1;
    }

    // Ajoutez la méthode estTermineeParTemps DONE
    public boolean estTermineeParTemps() {
        if (tempsRestant == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Ajoutez la méthode calculerTempsPreparationTotal DONE
    public int calculerTempsPreparationTotal() {
        int tempsTotal = 0;
        for (Plat plat : catalogue.values()) {
            tempsTotal += plat.getTempsPreparation();
        }
        return tempsTotal;
    }

    // Ajoutez la méthode calculerMontant DONE
    public double calculerMontant() {
        double montantTotal = 0;

        for (Plat plat : catalogue.values()) {
            montantTotal += plat.getPrix();
        }
        return montantTotal;
    }
}
