package com.codurance.training.tasks.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.codurance.training.tasks.Adapter.IConsole;
import com.codurance.training.tasks.Adapter.TaskController;
import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.UseCase.AddProjectUseCase;
import com.codurance.training.tasks.UseCase.CheckUseCase;
import com.codurance.training.tasks.UseCase.ErrorUseCase;
import com.codurance.training.tasks.UseCase.HelpUseCase;
import com.codurance.training.tasks.UseCase.ShowUseCase;

public class Main implements Runnable{
    private static final String QUIT = "quit";

    private final BufferedReader in;
    private final PrintWriter out;
    
    private TaskList taskList = new TaskList();
    private AddProjectUseCase addProjectUseCase = new AddProjectUseCase(taskList);
    private ShowUseCase showUseCase = new ShowUseCase(taskList);
    private CheckUseCase checkUseCase = new CheckUseCase(taskList);
    private HelpUseCase helpUseCase = new HelpUseCase();
    private ErrorUseCase errorUseCase = new ErrorUseCase();
    private IConsole console;

    private TaskController taskController;
    
    public Main(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
        this.console = new Console(out);
        this.taskController = new TaskController(addProjectUseCase, showUseCase, checkUseCase, helpUseCase, errorUseCase, console);
    
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