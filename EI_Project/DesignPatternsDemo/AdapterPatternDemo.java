// Adapter Pattern Example - Plug Adapter
interface TwoPinPlug {
    void connectTwoPin();
}

class OldDevice implements TwoPinPlug {
    public void connectTwoPin() {
        System.out.println("Old device connected with 2-pin plug.");
    }
}

interface ThreePinSocket {
    void connectThreePin();
}

class PlugAdapter implements ThreePinSocket {
    private TwoPinPlug device;
    public PlugAdapter(TwoPinPlug device) { this.device = device; }
    public void connectThreePin() {
        System.out.println("Using adapter...");
        device.connectTwoPin();
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        OldDevice device = new OldDevice();
        ThreePinSocket socket = new PlugAdapter(device);

        socket.connectThreePin();
    }
}
