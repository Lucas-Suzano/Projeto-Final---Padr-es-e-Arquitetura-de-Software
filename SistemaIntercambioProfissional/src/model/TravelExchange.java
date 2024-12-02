package model;

public class TravelExchange extends ExchangeProgram {
    public TravelExchange(String programName, String destinationCountry, int duration, CostCalculationStrategy costStrategy) {
        super(programName, destinationCountry, duration, costStrategy);
    }
}
