import ipc.Logger;

public abstract class ProcessSimulator extends Thread {
    protected String processName;

    public ProcessSimulator(String name) {
        this.processName = name;
        this.setName(name); // Set thread name
    }

    protected void log(String message) {
        Logger.log(processName, message);
    }

    // Every subclass must implement this to define its behavior
    @Override
    public abstract void run();
}