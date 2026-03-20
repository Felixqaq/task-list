package com.codurance.training.tasks.UI;

import java.io.PrintWriter;

import com.codurance.training.tasks.Adapter.IConsole;

public class Console implements IConsole {
    private PrintWriter out;

    public Console(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void print(String message) {
        out.print(message);
    }
    
}
