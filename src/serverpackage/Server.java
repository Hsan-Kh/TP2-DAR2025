package serverpackage;

import java.io.*;
import java.net.*;
import formatoperation.Operation;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Serveur en attente de connexion...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connecté !");

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            Operation op = (Operation) in.readObject();

            Object resultat; 

            double op1 = op.getOp1();
            double op2 = op.getOp2();
            char operateur = op.getOperateur();

            if (!(operateur == '+' || operateur == '-' || operateur == '*' || operateur == '/')) {
                resultat = "Opérateur non reconnu !";
            } else {
                switch (operateur) {
                    case '+': resultat = op1 + op2; break;
                    case '-': resultat = op1 - op2; break;
                    case '*': resultat = op1 * op2; break;
                    case '/':
                        if (op2 == 0) resultat = "Erreur : division par zéro";
                        else resultat = op1 / op2;
                        break;
                    default: resultat = "Opérateur non reconnu !";
                }
            }

            out.writeObject(resultat);
            System.out.println("Résultat envoyé : " + resultat);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
