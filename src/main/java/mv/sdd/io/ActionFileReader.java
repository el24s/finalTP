package mv.sdd.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static mv.sdd.io.ActionParser.parseLigne;

// Lecture du fichier d'actions fonctionne
public class ActionFileReader {
    public static List<Action> readActions(String filePath) throws IOException {
        List<Action> actions = new ArrayList<>();

        // DONE : Ajouter le code qui permet de lire et parser un fichier d'actions
        try {
            BufferedReader buffR = new BufferedReader(new FileReader(filePath));
            String ligne;
            while((ligne = buffR.readLine()) != null) {
                actions.add(parseLigne(ligne));
                System.out.println(ligne);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return actions;
    }
}
