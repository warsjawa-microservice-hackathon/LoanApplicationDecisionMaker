package com.ofg.twitter.controller

class MarketingRequest {
    Person person
    String decision

    Person getPerson() {
        return person
    }

    void setPerson(Person person) {
        this.person = person
    }

    String getDecision() {
        return decision
    }

    void setDecision(String decision) {
        this.decision = decision
    }
}
