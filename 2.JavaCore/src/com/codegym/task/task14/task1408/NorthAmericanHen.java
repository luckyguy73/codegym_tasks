package com.codegym.task.task14.task1408;

public class NorthAmericanHen extends Hen {
    @Override
    int getMonthlyEggCount() {
        return 30;
    }

    @Override
    String getDescription() {
        return super.getDescription() + String.format(" I come from %s. I lay %s eggs a month.",
                Continent.NORTHAMERICA, getMonthlyEggCount());
    }
}
