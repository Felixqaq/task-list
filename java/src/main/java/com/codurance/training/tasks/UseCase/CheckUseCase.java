package com.codurance.training.tasks.UseCase;

import com.codurance.training.tasks.Entity.TaskList;

public class CheckUseCase {
    private TaskList taskList;
    public CheckUseCase(TaskList taskList) {
        this.taskList = taskList;
    }

    public String check(String idString) {
        int id = Integer.parseInt(idString);
        if(!taskList.check(id)){
            return String.format("Could not find a task with an ID of %d.\n", idString);
        }
        return "";
    }

    public String uncheck(String idString) {
        int id = Integer.parseInt(idString);
        if(!taskList.uncheck(id)){
            return String.format("Could not find a task with an ID of %d.\n", idString);
        }
        return "";
    }
    
}
