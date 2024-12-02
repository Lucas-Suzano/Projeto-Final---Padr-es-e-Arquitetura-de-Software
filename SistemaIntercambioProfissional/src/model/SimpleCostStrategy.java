package model;

public class SimpleCostStrategy implements CostCalculationStrategy {
    private final double baseCostPerWeek = 300; // Valor fixo por semana

    @Override
    public double calculateCost(int duration) {
        return baseCostPerWeek * duration;
    }
}
