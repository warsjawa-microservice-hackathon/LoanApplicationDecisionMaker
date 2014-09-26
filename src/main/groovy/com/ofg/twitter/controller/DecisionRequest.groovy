package com.ofg.twitter.controller

class DecisionRequest {

    private String firstName
    private String lastName
    private String job
    private Long amount
    private String fraudStatus

    String getFirstName() {
        return firstName
    }

    void setFirstName(String firstName) {
        this.firstName = firstName
    }

    String getLastName() {
        return lastName
    }

    void setLastName(String lastName) {
        this.lastName = lastName
    }

    String getJob() {
        return job
    }

    void setJob(String job) {
        this.job = job
    }

    Long getAmount() {
        return amount
    }

    void setAmount(Long amount) {
        this.amount = amount
    }

    String getFraudStatus() {
        return fraudStatus
    }

    void setFraudStatus(String fraudStatus) {
        this.fraudStatus = fraudStatus
    }
}
