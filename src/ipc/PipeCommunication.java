package ipc;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeCommunication {
    private final PipedOutputStream output;
    private final PipedInputStream input;

    public PipeCommunication() throws IOException {
        this.output = new PipedOutputStream();
        this.input = new PipedInputStream(output); // Connect the streams
    }

    // Send message via pipe
    public void send(String message) throws IOException {
        output.write(message.getBytes());
        output.flush();
    }

    // Receive message via pipe
    public String receive() throws IOException {
        byte[] buffer = new byte[1024];
        int length = input.read(buffer);
        if (length == -1) return null;
        return new String(buffer, 0, length);
    }

    // Close streams when done
    public void close() {
        try {
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}