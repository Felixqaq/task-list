package com.codurance.training.tasks.UseCase;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;

public class ShowUseCase{

    public static void show() {
        for (Project project : taskList.getProjects()) {
            out.println(project.getName());
            for (Task task : project.getTasks()) {
                out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }

}