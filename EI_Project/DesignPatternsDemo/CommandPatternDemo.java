// Command Pattern Example - Remote Control
interface Command {
    void execute();
}

class Light {
    void turnOn() { System.out.println("Light is ON"); }
    void turnOff() { System.out.println("Light is OFF"); }
}

class TurnOnCommand implements Command {
    private Light light;
    public TurnOnCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}

class TurnOffCommand implements Command {
    private Light light;
    public TurnOffCommand(Light light) { this.light = light; }
    public void execute() { light.turnOff(); }
}

class RemoteControl {
    private Command command;
    public void setCommand(Command cmd) { this.command = cmd; }
    public void pressButton() { command.execute(); }
}

public class CommandPatternDemo {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        remote.setCommand(new TurnOnCommand(light));
        remote.pressButton();

        remote.setCommand(new TurnOffCommand(light));
        remote.pressButton();
    }
}
