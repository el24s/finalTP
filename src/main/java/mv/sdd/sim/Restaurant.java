package mv.sdd.sim;

import mv.sdd.io.Action;
import mv.sdd.io.ActionParser;
import mv.sdd.io.ActionType;
import mv.sdd.model.Client;
import mv.sdd.model.Commande;
import mv.sdd.model.MenuPlat;
import mv.sdd.model.Plat;
import mv.sdd.utils.Logger;

import java.util.*;

import static mv.sdd.model.Stats.statsPlatLine;
import static mv.sdd.utils.Formatter.resumeEtat;

public class Restaurant {
    private final Logger logger;
    private Map<Integer, Client> clients = new HashMap();
    private Map<MenuPlat, Plat> catalogue = new HashMap<>();
    private int tempsSimule;
    private Queue<Commande> file = new PriorityQueue<>();
    private List<Commande> commandesEnPrep = new ArrayList<>();
    private int nbServis = 0;
    private int nbFaches = 0;

    // Ajouter les attributs nécessaires ainsi que les getters et les setters

    // Ajouter le(s) constructeur(s)
    public Restaurant(Logger logger) {
        this.logger = logger;
    }

    // implémenter les méthodes suivantes
    // Méthode appelée depuis App pour chaque action
    public void executerAction(Action action){
        ActionType type = action.getType();
        switch(type) {
            case DEMARRER_SERVICE:
                demarrerService(action.getParam1(), action.getParam2());
                break;
            case AJOUTER_CLIENT:
                ajouterClient(action.getParam1(), action.getParam3(), action.getParam2());
                break;
            case PASSER_COMMANDE:
                passerCommande(action.getParam1(), MenuPlat.valueOf(action.getParam3()));
                break;
            case AVANCER_TEMPS:
                avancerTemps(action.getParam1());
                break;
            case AFFICHER_ETAT:
                afficherEtat();
                break;
            case AFFICHER_STATS:
                afficheStatistiques();
                break;
            case QUITTER:
                arreterService();
                break;
        }
    }

    public void demarrerService(int dureeMax, int nbCuisiniers) {
        Thread thread = new Thread();
        thread.start();
    }

    public void avancerTemps(int minutes) {
        tempsSimule += minutes;
    }

    public void arreterService(){
//        logger.close();
    }

    public void tick() {
        tempsSimule += 1;
    }
    public void afficherEtat() {
//        logger.logLine(resumeEtat(tempsSimule, nbServis, ));
//        afficher etat de tous les evenements en cours
    }
    public void afficheStatistiques() {
//        logger.logLine(statsPlatLine());
    }
    public void ajouterClient(int id, String nom, int patienceInitiale){
        if(nom == null) {
            return;
        }
        Client client = new Client(id, nom, patienceInitiale);
        clients.put(id, client);

    }
    public Commande passerCommande(int idClient, MenuPlat codePlat) {
        Client client = clients.get(idClient);

        Commande commande = client.getCommande();
        if (commande == null) {
//            commande = new Commande(client);
            client.setCommande(commande);
            file.add(commande);
        }

        Plat plat = catalogue.get(codePlat);
        commande.ajouterPlat(plat);

        return commande;
    }
    public void retirerProchaineCommande() {

    }

    // TODO : Déclarer et implémenter les méthodes suivantes
    // tick()
    // afficherEtat()
    // afficherStatistiques()
    // Client ajouterClient(int id, String nom, int patienceInitiale)
    // Commande passerCommande(int idClient, MenuPlat codePlat)
    // retirerProchaineCommande(): Commande
    // marquerCommandeTerminee(Commande commande)
    // Client creerClient(String nom, int patienceInitiale)
    // Commande creerCommandePourClient(Client client)

    // implémenter d'autres sous-méthodes qui seront appelées par les méthodes principales
    //  pour améliorer la lisibilité des méthodes en les découpant au besoin (éviter les trés longues méthodes)
    //  exemple : on peut avoir une méthode diminuerPatienceClients()
    //  qui permet de diminuer la patience des clients (appelée par tick())
}
