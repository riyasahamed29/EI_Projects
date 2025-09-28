// Observer Pattern Example - Weather Station
import java.util.*;

interface WeatherObserver {
    void update(int temperature);
}

class PhoneDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Phone Display: Temperature updated to " + temperature + "°C");
    }
}

class TVDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("TV Display: Temperature updated to " + temperature + "°C");
    }
}

class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(WeatherObserver obs) { observers.add(obs); }

    public void setTemperature(int temp) {
        this.temperature = temp;
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver obs : observers) {
            obs.update(temperature);
        }
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.addObserver(new PhoneDisplay());
        station.addObserver(new TVDisplay());

        station.setTemperature(25);
        station.setTemperature(30);
    }
}
