# 🖧 IPC Mechanism Simulator

A Java-based simulation of classic **Inter-Process Communication (IPC)** mechanisms — **Pipes**, **Shared Memory**, and **Message Queues**. This project demonstrates how processes communicate in an OS-like environment using Java multithreading and synchronization.

---

## 🔧 Features

- Simulates 3 IPC mechanisms:
  - 🧵 **Pipe Communication**
  - 🧠 **Shared Memory**
  - 📬 **Message Queue**
- Thread-safe communication between processes
- Modular and extensible design
- Real-time event logging
- Educational and demonstrative use case

---

## 📁 Project Structure

```
IPC-Simulator/
├── src/
│   └── ipc/
│       ├── Logger.java              // Logs inter-process events
│       ├── MessageQueue.java        // Message queue simulation
│       ├── PipeCommunication.java   // Pipe-based communication
│       ├── SharedMemory.java        // Shared memory simulation
│       ├── ProcessSimulator.java    // Simulates concurrent processes
│       └── Main.java                // Entry point to run simulation
├── README.md
```

---

## 🚀 Getting Started

### ✅ Requirements

- Java 8 or higher
- Java IDE (IntelliJ / Eclipse / VS Code) or terminal

### ▶️ Run the Project

1. **Clone the repository**

```bash
git clone https://github.com/Magnus0969/IPC-Simulator.git
cd IPC-Simulator
```

2. **Compile the Java files**

```bash
javac -d out src/ipc/*.java
```

3. **Run the simulation**

```bash
java -cp out ipc.Main
```

---

## 🧠 IPC Mechanisms Simulated

| Mechanism         | Description                                                                 |
|------------------|-----------------------------------------------------------------------------|
| **Pipes**         | Uses `PipedInputStream` and `PipedOutputStream` to simulate stream-based IPC. |
| **Shared Memory** | Simulates shared access to a memory block via synchronized `Map`.           |
| **Message Queue** | Implements FIFO-based communication using `BlockingQueue`.                 |

Each method is encapsulated in its own class and orchestrated via `ProcessSimulator`.

---

## 💻 Sample Output

<pre>
<span style="color:#ff007f">[Logger]</span> Process A wrote to Pipe: Hello
<span style="color:#ff007f">[Logger]</span> Process B read from Pipe: Hello
<span style="color:#ff007f">[Logger]</span> Process A wrote to Shared Memory: [key: 1, value: Data]
<span style="color:#ff007f">[Logger]</span> Process B read from Shared Memory: Data
<span style="color:#ff007f">[Logger]</span> Process A sent message: Ping
<span style="color:#ff007f">[Logger]</span> Process B received message: Ping
</pre>

---

## 🎓 Use Cases

- 📘 Operating System assignments and labs  
- 🔄 Understanding IPC and concurrency in Java  
- 🛠️ System design & process synchronization demos  

---

## 🛠️ Future Enhancements

- 🖥 JavaFX/Swing-based visual dashboard  
- 📄 JSON-configurable process and communication patterns  
- 📡 Add semaphores, sockets, and advanced IPC  
- 🕒 Logging to file + timestamps  

---

## 👨‍💻 Author

**Karthik B Magadi**  
GitHub: [@Magnus0969](https://github.com/Magnus0969)

---

## 📜 License

This project is licensed under the [MIT License](LICENSE)

---

⭐ **Star this repo if you found it helpful!**
