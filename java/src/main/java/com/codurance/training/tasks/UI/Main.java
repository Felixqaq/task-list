package com.codurance.training.tasks.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.codurance.training.tasks.Adapter.TaskController;
import com.codurance.training.tasks.Entity.TaskList;

public class Main implements Runnable{
    private static final String QUIT = "quit";

    private final BufferedReader in;
    private final PrintWriter out;
    private TaskController taskController = new TaskController();

    public Main(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        new Main(in, out).run();
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            taskController.execute(command);
        }
    }
}