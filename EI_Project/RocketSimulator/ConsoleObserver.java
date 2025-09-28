// Observer implementation that prints updates to console
public class ConsoleObserver implements Observer {
    @Override
    public void update(Rocket rocket) {
        System.out.println("[Update] Stage: " + rocket.stage +
                " | Fuel: " + rocket.fuel + "%" +
                " | Altitude: " + rocket.altitude + " km" +
                " | Speed: " + rocket.speed + " km/h" +
                " | Status: " + rocket.status);
    }
}
