package model;

public class ComplexCostStrategy implements CostCalculationStrategy {
    private final double baseCostPerWeek = 350; // Valor fixo por semana
    private final double adjustmentFactor = 1.2; // Fator de ajuste para complexidade

    @Override
    public double calculateCost(int duration) {
        return (baseCostPerWeek * duration) * adjustmentFactor;
    }
}
