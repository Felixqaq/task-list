package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.LinkedList;

public final class TaskList {

    private final LinkedList<Project> projects = new LinkedList<>();

    private long lastId = 0;

    public TaskList() {
    }

    public LinkedList<Project> getProjects() {
        return projects;
    }

    public boolean addProject(String name) {
        projects.add(new Project(name, new ArrayList<>()));
        return true;
    }

    public boolean addTask(String project, String description) {
        for (Project p : projects) {
            if (p.getName().equals(project)) {
                p.getTasks().add(new Task(nextId(), description, false));
                return true;
            }
        }
        return false;
    }

    public boolean check(String idString) {
        return setDone(idString, true);
    }

    public boolean uncheck(String idString) {
        return setDone(idString, false);
    }

    private boolean setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
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
