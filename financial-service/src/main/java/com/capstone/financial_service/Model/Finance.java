package com.capstone.financial_service.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "finances")
public class Finance {
    @Id
    private String id;
    private String projectId;
    private double budget;
    private double expenses;
    private String status;
    public Finance() {
    }
    public Finance(String id, String projectId, double budget, double expenses, String status) {
        this.id = id;
        this.projectId = projectId;
        this.budget = budget;
        this.expenses = expenses;
        this.status = status;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProjectId() {
        return projectId;
    }
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public double getExpenses() {
        return expenses;
    }
    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    
    // Constructors, Getters, and Setters
}
