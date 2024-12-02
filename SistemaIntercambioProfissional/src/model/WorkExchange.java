package model;

public class WorkExchange extends ExchangeProgram {
    public WorkExchange(String programName, String destinationCountry, int duration, CostCalculationStrategy costStrategy) {
        super(programName, destinationCountry, duration, costStrategy);
    }
}
