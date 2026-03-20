package com.codurance.training.tasks.Entity;

import java.util.ArrayList;

public final class TaskList {

    private final ArrayList<Project> projects = new ArrayList<>();

    private long lastId = 0;

    public TaskList() {
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void addProject(String name) {
        projects.add(new Project(name, new ArrayList<>()));
    }

    public boolean addTask(String projectName, String description) {
        for (Project project : projects) {
            if (project.getName().equals(projectName)) {
                project.getTasks().add(new Task(nextId(), description, false));
                return true;
            }
        }
        return false;
    }

    public boolean check(int id) {
        return setDone(id, true);
    }

    public boolean uncheck(int id) {
        return setDone(id, false);
    }

    private boolean setDone(int id, boolean done) {
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return true;
                }
            }
        }
        return false;
    }

    private long nextId() {
        return ++lastId;
    }
}
