// Singleton - only one simulator at a time
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RocketSimulator {
    private static RocketSimulator instance;
    private Rocket rocket;
    private List<Observer> observers;
    private FileWriter logger;

    private RocketSimulator() {
        rocket = new Rocket();
        observers = new ArrayList<>();
        try {
            logger = new FileWriter("simulation.log", true); // append log
        } catch (IOException e) {
            System.out.println("Logger not available.");
        }
    }

    public static RocketSimulator getInstance() {
        if (instance == null) {
            instance = new RocketSimulator();
        }
        return instance;
    }

    public void addObserver(Observer o) { observers.add(o); }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(rocket);
        }
        logToFile("Stage: " + rocket.stage + " | Fuel: " + rocket.fuel +
                " | Alt: " + rocket.altitude + " km | Speed: " + rocket.speed + " km/h | Status: " + rocket.status);
    }

    private void logToFile(String msg) {
        try {
            logger.write(msg + "\n");
            logger.flush();
        } catch (IOException e) {
            System.out.println("Error writing log.");
        }
    }

    // Start checks
    public void startChecks() {
        if (rocket.status == RocketStatus.PRE_LAUNCH) {
            System.out.println("All systems are 'Go' for launch.");
        } else {
            System.out.println("Checks already done.");
        }
    }

    // Launch
    public void launch() {
        if (rocket.status == RocketStatus.PRE_LAUNCH) {
            rocket.status = RocketStatus.IN_FLIGHT;
            System.out.println("Rocket Launched!");
            simulateFlight(5);
        } else {
            System.out.println("Rocket cannot be launched now.");
        }
    }

    // Fast forward
    public void fastForward(int sec) {
        if (rocket.status == RocketStatus.IN_FLIGHT) {
            simulateFlight(sec);
        } else {
            System.out.println("Fast forward not possible in this state.");
        }
    }

    private void simulateFlight(int sec) {
        for (int i = 0; i < sec; i++) {
            if (rocket.fuel <= 0) {
                rocket.status = RocketStatus.FAILED;
                System.out.println("Mission Failed: Fuel empty.");
                notifyObservers();
                return;
            }

            rocket.fuel -= 5;
            rocket.altitude += 15;
            rocket.speed += 1200;

            // Stage separation
            if (rocket.stage == 1 && rocket.altitude >= 50) {
                rocket.stage = 2;
                System.out.println("Stage 1 separated. Entering Stage 2.");
            }

            // Orbit achieved
            if (rocket.altitude >= 120 && rocket.fuel > 0) {
                rocket.status = RocketStatus.ORBIT;
                System.out.println("Orbit achieved! Mission Successful.");
                notifyObservers();
                return;
            }

            notifyObservers();
        }
    }
}
