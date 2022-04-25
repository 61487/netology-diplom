package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {

    int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        Gson gson = new Gson();
        Message message = gson.fromJson(in.readLine(), Message.class);
        if (message.getType().equals("ADD")) {
            todos.addTask(message.getTask());
        } else {
            todos.removeTask(message.getTask());
        }
        out.println(todos.getAllTasks());
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();

    }


}
