package com.codurance.training.tasks.UseCase;

public class ErrorUseCase {
    public String error(String command) {
        return String.format("I don't know what the command \"%s\" is.\n", command);
    }

}
