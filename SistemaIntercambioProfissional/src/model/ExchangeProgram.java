package model;

public abstract class ExchangeProgram {
    private final String name;
    private final String destinationCountry;
    private final int duration; // in weeks
    private final CostCalculationStrategy costStrategy;

    public ExchangeProgram(String name, String destinationCountry, int duration, CostCalculationStrategy costStrategy) {
        this.name = name;
        this.destinationCountry = destinationCountry;
        this.duration = duration;
        this.costStrategy = costStrategy;
    }

    public double calculateCost() {
        return costStrategy.calculateCost(duration);
    }

    @Override
    public String toString() {
        return String.format("Program: %s, Destination: %s, Duration: %d weeks", name, destinationCountry, duration);
    }

    public int getDuration() {
        return duration;
    }
}
