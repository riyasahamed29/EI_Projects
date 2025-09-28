// Command interface
public interface Command {
    void execute();
}

// StartChecksCommand.java
class StartChecksCommand implements Command {
    private RocketSimulator sim;
    public StartChecksCommand(RocketSimulator sim) { this.sim = sim; }
    public void execute() { sim.startChecks(); }
}

// LaunchCommand.java
class LaunchCommand implements Command {
    private RocketSimulator sim;
    public LaunchCommand(RocketSimulator sim) { this.sim = sim; }
    public void execute() { sim.launch(); }
}

// FastForwardCommand.java
class FastForwardCommand implements Command {
    private RocketSimulator sim;
    private int sec;
    public FastForwardCommand(RocketSimulator sim, int sec) { 
        this.sim = sim; 
        this.sec = sec;
    }
    public void execute() { sim.fastForward(sec); }
}
