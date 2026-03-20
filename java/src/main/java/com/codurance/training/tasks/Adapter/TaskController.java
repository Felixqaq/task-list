package com.codurance.training.tasks.Adapter;

import com.codurance.training.tasks.UseCase.AddProjectUseCase;
import com.codurance.training.tasks.UseCase.CheckUseCase;
import com.codurance.training.tasks.UseCase.ErrorUseCase;
import com.codurance.training.tasks.UseCase.HelpUseCase;
import com.codurance.training.tasks.UseCase.ShowUseCase;

public class TaskController{
    private AddProjectUseCase addProjectUseCase;
    private ShowUseCase showUseCase;
    private CheckUseCase checkUseCase;
    private HelpUseCase helpUseCase;
    private ErrorUseCase errorUseCase;
    private IConsole console;

    public TaskController(AddProjectUseCase addProjectUseCase, ShowUseCase showUseCase, CheckUseCase checkUseCase,
            HelpUseCase helpUseCase, ErrorUseCase errorUseCase, IConsole console) {
        this.addProjectUseCase = addProjectUseCase;
        this.showUseCase = showUseCase;
        this.checkUseCase = checkUseCase;
        this.helpUseCase = helpUseCase;
        this.errorUseCase = errorUseCase;
        this.console = console;
    }

    public void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                console.print(showUseCase.show());
                break;
            case "add":
                console.print(addProjectUseCase.add(commandRest[1]));
                break;
            case "check":
                console.print(checkUseCase.check(commandRest[1]));
                break;
            case "uncheck":
                console.print(checkUseCase.uncheck(commandRest[1]));
                break;
            case "help":
                console.print(helpUseCase.help());
                break;
            default:
                console.print(errorUseCase.error(command));
                break;
        }
    }
}