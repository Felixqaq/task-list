package com.codurance.training.tasks.UseCase;

public class HelpUseCase {

    public static void help() {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
        return 
    }
    
}
