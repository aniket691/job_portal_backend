package com.app.dto;

import java.time.LocalDate;

public class SubscriptionDTO {

    private Long subscriptionId;
    private String subscriptionType;
    private LocalDate subscriptionStartDate;
    private LocalDate subscriptionEndDate;

    // Constructors
    public SubscriptionDTO() {}

    public SubscriptionDTO(Long subscriptionId, String subscriptionType, LocalDate subscriptionStartDate, LocalDate subscriptionEndDate) {
        this.subscriptionId = subscriptionId;
        this.subscriptionType = subscriptionType;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionEndDate = subscriptionEndDate;
    }

    // Getters and Setters
    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public LocalDate getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public LocalDate getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(LocalDate subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }
}
