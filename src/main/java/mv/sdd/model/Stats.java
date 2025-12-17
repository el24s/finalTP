package mv.sdd.model;

import mv.sdd.utils.Constantes;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Stats {
    private Horloge horloge;
    private int totalClients = 0;
    private int nbServis = 0;
    private int nbFaches = 0;
    private double chiffreAffaires = 0;
    // remplacer Object par le bon type et initilaliser l'attribut avec la bonne valeur
    //  et ajuster les getters et les setters DONE
    private HashMap<MenuPlat, Integer> ventesParPlat = new HashMap<>();

    // au besoin ajuster le constructeur et/ou ajouter d'autres
    public Stats(Horloge horloge, HashMap<MenuPlat, Integer> ventesParPlat) {
        this.horloge = horloge;
        this.ventesParPlat = ventesParPlat;
        // compléter le code manquant DONE
    }

    public HashMap<MenuPlat, Integer> getVentesParPlat() {
        return ventesParPlat;
    }

    public void setVentesParPlat(HashMap<MenuPlat, Integer> ventesParPlat) {
        this.ventesParPlat = ventesParPlat;
    }

    public void incrementerTotalClients() {
        totalClients++;
    }

    public void incrementerNbServis() {
        nbServis++;
    }

    public void incrementerNbFaches() {
        nbFaches++;
    }

    public void incrementerChiffreAffaires(double montant) {
        this.chiffreAffaires += montant;
    }

    public static String statsPlatLine(MenuPlat codePlat, int quantite) {
        return "\n" + "\t\t" + codePlat + " : " + quantite;
    }

    // ajouter incrementerVentesParPlat(MenuPlat codePlat) et autres méthodes au besoin DONE
    public void incrementerVentesParPlat(MenuPlat codePlat) {
        ventesParPlat.put(codePlat, ventesParPlat.get(codePlat) + 1) ;
    }

    public String toString() {
        String chaine = String.format(
                Constantes.STATS_GENERAL,
                horloge.getTempsSimule(),
                totalClients,
                nbServis,
                nbFaches,
                chiffreAffaires
        );

        // ajouter le code pour concaténer avec statsPlatLines les lignes des quantités vendus par plat (à l'aide de ventesParPlat),
        // sachant que la méthode statsPlatLine sert à formater une ligne et retourne une chaine DONE
        for (Map.Entry<MenuPlat, Integer> entry : ventesParPlat.entrySet()) {
            MenuPlat plat = entry.getKey();
            Integer quantite = entry.getValue();
        }
        return chaine;
    }
}
