package com.codurance.training.tasks.UseCase;

public class CheckUseCase {

    private void check(String idString) {
        if(!taskList.check(idString)){
            out.printf("Could not find a task with an ID of %d.", idString);
            out.println();
        }
    }

    private void uncheck(String idString) {
        if(!taskList.uncheck(idString)){
            out.printf("Could not find a task with an ID of %d.", idString);
            out.println();
        }
    }
    
}
