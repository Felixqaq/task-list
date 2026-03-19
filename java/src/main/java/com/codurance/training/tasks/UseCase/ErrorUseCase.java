package com.codurance.training.tasks.UseCase;

public class ErrorUseCase {
    public static void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }

}
