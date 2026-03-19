package com.codurance.training.tasks.Adapter;

import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.UseCase.AddProjectUseCase;
import com.codurance.training.tasks.UseCase.CheckUseCase;
import com.codurance.training.tasks.UseCase.ErrorUseCase;
import com.codurance.training.tasks.UseCase.HelpUseCase;
import com.codurance.training.tasks.UseCase.ShowUseCase;

public class TaskController{
    public void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        TaskList taskList = new TaskList();
        switch (command) {
            case "show":
                ShowUseCase.show();
                break;
            case "add":
                AddProjectUseCase.add(commandRest[1]);
                break;
            case "check":
                CheckUseCase.check(commandRest[1]);
                break;
            case "uncheck":
                CheckUseCase.uncheck(commandRest[1]);
                break;
            case "help":
                HelpUseCase.help();
                break;
            default:
                ErrorUseCase.error(command);
                break;
        }
    }
}