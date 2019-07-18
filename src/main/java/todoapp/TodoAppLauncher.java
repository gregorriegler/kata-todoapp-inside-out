package todoapp;

import todoapp.system.InMemoryTaskRepository;

public class TodoAppLauncher {
    public static void main(String[] args) {
        new TodoApp(new FrontController(new InMemoryTaskRepository())).start();
    }
}