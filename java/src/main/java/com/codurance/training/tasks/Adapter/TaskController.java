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

    public TaskController(AddProjectUseCase addProjectUseCase, ShowUseCase showUseCase, CheckUseCase checkUseCase,
            HelpUseCase helpUseCase, ErrorUseCase errorUseCase) {
        this.addProjectUseCase = addProjectUseCase;
        this.showUseCase = showUseCase;
        this.checkUseCase = checkUseCase;
        this.helpUseCase = helpUseCase;
        this.errorUseCase = errorUseCase;
    }

    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        String respose = "";
        switch (command) {
            case "show":
                respose = showUseCase.show();
                break;
            case "add":
                respose = addProjectUseCase.add(commandRest[1]);
                break;
            case "check":
                respose = checkUseCase.check(commandRest[1]);
                break;
            case "uncheck":
                respose = checkUseCase.uncheck(commandRest[1]);
                break;
            case "help":
                respose = helpUseCase.help();
                break;
            default:
                respose = errorUseCase.error(command);
                break;
        }
        return respose;
    }
}