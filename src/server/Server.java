package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running...");
            System.out.println("Waiting for client connection...");

            // Espera por uma conexão do cliente
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Criação de streams de entrada e saída
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Recebe a mensagem do cliente
            String message = in.readLine().toUpperCase();
            System.out.println("Received from client: " + message);

            // Envia uma resposta ao cliente
            out.println("Message received by server: " + message);

            // Fecha os recursos
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}