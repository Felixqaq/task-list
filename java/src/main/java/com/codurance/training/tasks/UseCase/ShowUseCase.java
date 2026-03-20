package com.codurance.training.tasks.UseCase;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.Entity.TaskList;

public class ShowUseCase{
    private TaskList taskList;
    
    public ShowUseCase(TaskList taskList) {
        this.taskList = taskList;
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        for (Project project : taskList.getProjects()) {
            sb.append(project.getName()).append("\n");
            for (Task task : project.getTasks()) {
                sb.append(String.format("    [%c] %d: %s\n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription()));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}