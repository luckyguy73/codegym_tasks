package com.codegym.task.task14.task1408;

public class EuropeanHen extends Hen {
    @Override
    int getMonthlyEggCount() {
        return 15;
    }
    @Override
    String getDescription() {
        return super.getDescription() + String.format(" I come from %s. I lay %s eggs a month.",
                Continent.EUROPE, getMonthlyEggCount());
    }

}
