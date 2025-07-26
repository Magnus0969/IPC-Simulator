package ipc;

public class SharedMemory {
    private String data;
    private boolean available = false;

    // Writer: write to shared memory
    public synchronized void write(String message) {
        while (available) {
            try {
                wait(); // Wait until data is read
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        this.data = message;
        this.available = true;
        notifyAll(); // Notify readers
    }

    // Reader: read from shared memory
    public synchronized String read() {
        while (!available) {
            try {
                wait(); // Wait until data is written
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        available = false;
        notifyAll(); // Notify writers
        return data;
    }
}