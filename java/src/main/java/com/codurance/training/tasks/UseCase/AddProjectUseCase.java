package com.codurance.training.tasks.UseCase;

import com.codurance.training.tasks.Entity.TaskList;

public class AddProjectUseCase{
    private TaskList taskList;
    
    public AddProjectUseCase(TaskList taskList) {
        this.taskList = taskList;
    }

    public String add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            taskList.addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            if (!taskList.addTask(projectTask[0], projectTask[1])){
                return String.format("Could not find a project with the name \"%s\".\n", projectTask[0]);
            }
        }
        return "";
    }
}