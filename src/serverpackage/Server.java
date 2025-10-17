package serverpackage;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4730);
            System.out.println("Serveur démarré. En attente de connexion d’un client...");

            Socket socket = serverSocket.accept();
            System.out.println("Un client est connecté.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String operation = in.readLine();
            System.out.println("Opération reçue du client : " + operation);

            String resultat = calculer(operation);

            out.println(resultat);
            System.out.println("Résultat envoyé au client : " + resultat);

            in.close();
            out.close();
            socket.close();
            serverSocket.close();
            System.out.println("Connexion fermée. Serveur arrêté.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

private static String calculer(String operation) {
    try {
        operation = operation.trim();

        String[] elements = operation.split("\\s*([+\\-*/])\\s*");

        if (elements.length != 2) return "Format invalide. Exemple : 12 + 5";

        double op1 = Double.parseDouble(elements[0]);
        double op2 = Double.parseDouble(elements[1]);

        String operateur = "";
        if (operation.contains("+")) operateur = "+";
        else if (operation.contains("-")) operateur = "-";
        else if (operation.contains("*")) operateur = "*";
        else if (operation.contains("/")) operateur = "/";

        double resultat;
        switch (operateur) {
            case "+": resultat = op1 + op2; break;
            case "-": resultat = op1 - op2; break;
            case "*": resultat = op1 * op2; break;
            case "/":
                if (op2 == 0) return "Erreur : division par zéro";
                resultat = op1 / op2;
                break;
            default:
                return "Opérateur invalide. Utilisez +, -, * ou /";
        }

        return "Résultat : " + resultat;

    } catch (NumberFormatException e) {
        return "Erreur : opérandes non valides.";
    }
 }
}

