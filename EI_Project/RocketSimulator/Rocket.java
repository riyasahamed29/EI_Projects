// Basic class to hold rocket data
public class Rocket {
    int stage;
    int fuel; 
    double altitude;
    double speed;
    RocketStatus status;

    public Rocket() {
        this.stage = 1;
        this.fuel = 100;
        this.altitude = 0;
        this.speed = 0;
        this.status = RocketStatus.PRE_LAUNCH;
    }
}
