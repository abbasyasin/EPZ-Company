package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import java.io.Serializable;
import java.time.LocalDate;

public class InvestmentStrategy implements Serializable {
    private String strategyName;
    private String strategyDescription;
    private String category;
    private LocalDate implementationDate;
    private String priority;
    private String highPriority;

    public InvestmentStrategy(String strategyName, String strategyDescription, String category, LocalDate implementationDate, String priority, String highPriority) {
        this.strategyName = strategyName;
        this.strategyDescription = strategyDescription;
        this.category = category;
        this.implementationDate = implementationDate;
        this.priority = priority;
        this.highPriority = highPriority;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public String getStrategyDescription() {
        return strategyDescription;
    }

    public void setStrategyDescription(String strategyDescription) {
        this.strategyDescription = strategyDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getImplementationDate() {
        return implementationDate;
    }

    public void setImplementationDate(LocalDate implementationDate) {
        this.implementationDate = implementationDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getHighPriority() {
        return highPriority;
    }

    public void setHighPriority(String highPriority) {
        this.highPriority = highPriority;
    }
}
