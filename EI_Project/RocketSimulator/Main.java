// Entry point of the program
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RocketSimulator sim = RocketSimulator.getInstance();
        sim.addObserver(new ConsoleObserver());

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Rocket Launch Simulator ===");
        System.out.println("Commands: start_checks | launch | fast_forward X | exit");

        while (true) {
            System.out.print("> ");
            String input = sc.nextLine();
            String[] parts = input.split(" ");

            Command cmd = null;
            switch (parts[0]) {
                case "start_checks":
                    cmd = new StartChecksCommand(sim);
                    break;
                case "launch":
                    cmd = new LaunchCommand(sim);
                    break;
                case "fast_forward":
                    if (parts.length > 1) {
                        int sec = Integer.parseInt(parts[1]);
                        cmd = new FastForwardCommand(sim, sec);
                    } else {
                        System.out.println("Usage: fast_forward X");
                    }
                    break;
                case "exit":
                    System.out.println("Simulation ended.");
                    sc.close();
                    return;
                default:
                    System.out.println("Unknown command.");
            }
            if (cmd != null) cmd.execute();
        }
    }
}
