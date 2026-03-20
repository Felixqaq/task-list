package com.codurance.training.tasks.UseCase;

public class HelpUseCase {
    public String help() {
        return String.format(
            "Commands:\n" +
            "  show\n" +
            "  add project <project name>\n" +
            "  add task <project name> <task description>\n" +
            "  check <task ID>\n" +
            "  uncheck <task ID>\n"
        );
    }
    
}
