package ipc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {
    private final BlockingQueue<String> queue;

    public MessageQueue() {
        this.queue = new LinkedBlockingQueue<>();
    }

    // Put a message into the queue
    public void send(String message) throws InterruptedException {
        queue.put(message);
    }

    // Retrieve and remove a message from the queue
    public String receive() throws InterruptedException {
        return queue.take();
    }

    // Optional: check current queue size
    public int getQueueSize() {
        return queue.size();
    }
}