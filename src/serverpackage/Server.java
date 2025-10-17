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
        operation = operation.trim();

        char operateur = 0;
        for (char c : operation.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operateur = c;
                break;
            }
        }

        if (operateur == 0) return "Opérateur invalide. Utilisez +, -, * ou /";

        String[] elements = operation.split("\\" + operateur);
        if (elements.length != 2) return "Format invalide. Ex : 15+5";

        try {
            double op1 = Double.parseDouble(elements[0].trim());
            double op2 = Double.parseDouble(elements[1].trim());

            double resultat;
            switch (operateur) {
                case '+': resultat = op1 + op2; break;
                case '-': resultat = op1 - op2; break;
                case '*': resultat = op1 * op2; break;
                case '/':
                    if (op2 == 0) return "Erreur : division par zéro";
                    resultat = op1 / op2;
                    break;
                default: return "Opérateur invalide. Utilisez +, -, * ou /";
            }

            return "Résultat : " + resultat;

        } catch (NumberFormatException e) {
            return "Erreur : opérandes non valides.";
        }
    }
}
