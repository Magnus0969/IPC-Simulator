import ipc.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("IPC Mechanism Simulator Starting...\n");

        simulatePipeCommunication();
        simulateSharedMemory();
        simulateMessageQueue();
    }

    // 🔄 Pipe Communication Demo
    private static void simulatePipeCommunication() throws Exception {
        Logger.log("SYSTEM", "Starting Pipe Communication...");
        PipeCommunication pipe = new PipeCommunication();

        ProcessSimulator sender = new ProcessSimulator("PipeSender") {
            public void run() {
                try {
                    pipe.send("Hello via Pipe!");
                    log("Sent message.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        ProcessSimulator receiver = new ProcessSimulator("PipeReceiver") {
            public void run() {
                try {
                    String msg = pipe.receive();
                    log("Received: " + msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        sender.start();
        receiver.start();
        sender.join();
        receiver.join();
        pipe.close();
        Logger.log("SYSTEM", "Pipe Communication Ended.\n");
    }

    // 🔄 Shared Memory Demo
    private static void simulateSharedMemory() throws Exception {
        Logger.log("SYSTEM", "Starting Shared Memory Communication...");
        SharedMemory sharedMemory = new SharedMemory();

        ProcessSimulator writer = new ProcessSimulator("MemoryWriter") {
            public void run() {
                sharedMemory.write("Shared data here!");
                log("Wrote to shared memory.");
            }
        };

        ProcessSimulator reader = new ProcessSimulator("MemoryReader") {
            public void run() {
                String msg = sharedMemory.read();
                log("Read from shared memory: " + msg);
            }
        };

        writer.start();
        reader.start();
        writer.join();
        reader.join();
        Logger.log("SYSTEM", "Shared Memory Communication Ended.\n");
    }

    // 🔄 Message Queue Demo
    private static void simulateMessageQueue() throws Exception {
        Logger.log("SYSTEM", "Starting Message Queue Communication...");
        MessageQueue queue = new MessageQueue();

        ProcessSimulator producer = new ProcessSimulator("QueueProducer") {
            public void run() {
                try {
                    queue.send("Message from Producer!");
                    log("Sent message to queue.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ProcessSimulator consumer = new ProcessSimulator("QueueConsumer") {
            public void run() {
                try {
                    String msg = queue.receive();
                    log("Received from queue: " + msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        Logger.log("SYSTEM", "Message Queue Communication Ended.\n");
    }
}