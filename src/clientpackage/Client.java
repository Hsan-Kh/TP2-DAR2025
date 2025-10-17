package clientpackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Je suis un client pas encore connecté...");

            Socket socket = new Socket("localhost", 4730);
            System.out.println("Je suis un client connecté au serveur.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Entrez une opération (ex : 15 + 5) : ");
            String operation = scanner.nextLine();

            out.println(operation);
            System.out.println("Opération envoyée : " + operation);

            String resultat = in.readLine();
            System.out.println("Résultat reçu du serveur : " + resultat);

            in.close();
            out.close();
            socket.close();
            scanner.close();
            System.out.println("Client déconnecté.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
