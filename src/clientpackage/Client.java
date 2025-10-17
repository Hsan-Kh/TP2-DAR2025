package clientpackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import formatoperation.Operation;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6000)) {

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            Scanner sc = new Scanner(System.in);

            System.out.print("Entrez le premier nombre : ");
            double a = sc.nextDouble();

            System.out.print("Entrez l'opérateur (+, -, *, /) : ");
            String opStr = sc.next();

            if (opStr.length() != 1 || "+-*/".indexOf(opStr.charAt(0)) == -1) {
                System.out.println("Opérateur invalide !");
                sc.close();
                return;
            }
            char op = opStr.charAt(0);

            System.out.print("Entrez le deuxième nombre : ");
            double b = sc.nextDouble();

            Operation operation = new Operation(a, b, op);
            out.writeObject(operation);

            Object result = in.readObject();
            System.out.println("Résultat reçu du serveur : " + result);

            sc.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
