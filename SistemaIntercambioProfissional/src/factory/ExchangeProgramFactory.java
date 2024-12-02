package factory;

import model.*;

public class ExchangeProgramFactory {
    public static ExchangeProgram createProgram(String type, String name, String country, int duration, CostCalculationStrategy costStrategy) {
        return switch (type.toLowerCase()) {
            case "work" -> new WorkExchange(name, country, duration, costStrategy);
            case "travel" -> new TravelExchange(name, country, duration, costStrategy);
            default -> throw new IllegalArgumentException("Invalid program type: " + type);
        };
    }
}
