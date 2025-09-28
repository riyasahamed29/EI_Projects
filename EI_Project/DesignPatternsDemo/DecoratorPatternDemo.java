// Decorator Pattern Example - Coffee Shop
interface Coffee {
    String getDescription();
    double getCost();
}

class BasicCoffee implements Coffee {
    public String getDescription() { return "Basic Coffee"; }
    public double getCost() { return 5.0; }
}

class MilkDecorator implements Coffee {
    private Coffee coffee;
    public MilkDecorator(Coffee coffee) { this.coffee = coffee; }
    public String getDescription() { return coffee.getDescription() + ", Milk"; }
    public double getCost() { return coffee.getCost() + 1.5; }
}

class SugarDecorator implements Coffee {
    private Coffee coffee;
    public SugarDecorator(Coffee coffee) { this.coffee = coffee; }
    public String getDescription() { return coffee.getDescription() + ", Sugar"; }
    public double getCost() { return coffee.getCost() + 1.0; }
}

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
    }
}
