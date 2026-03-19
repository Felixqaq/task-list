package com.codurance.training.tasks.UseCase;

public class AddProjectUseCase{

    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            taskList.addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            if (!taskList.addTask(projectTask[0], projectTask[1])){
                out.printf("Could not find a project with the name \"%s\".", projectTask[0]);
                out.println();
            }
        }
    }
    
}