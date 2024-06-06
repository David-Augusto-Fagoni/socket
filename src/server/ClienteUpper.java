package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ClienteUpper extends javax.swing.JFrame {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int PORT = 12345;

        try (
            // Cria uma conexão com o servidor
            Socket socket = new Socket(SERVER_ADDRESS, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Connected to server.");

            // Lê a mensagem do usuário
            System.out.print("Enter message to send to server: ");
            String userInput = stdIn.readLine();

            // Envia a mensagem ao servidor
            out.println(userInput);

            // Recebe a resposta do servidor
            String serverResponse = in.readLine();
            System.out.println("Server response: " + serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}