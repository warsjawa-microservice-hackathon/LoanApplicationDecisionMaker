package com.ofg.twitter.controller

class ReportingRequest {

    String loanId
    String job
    Long amount
    String fraudStatus
    String decision


    @Override
    public String toString() {
        return "ReportingRequest{" +
                "loanId='" + loanId + '\'' +
                ", job='" + job + '\'' +
                ", amount=" + amount +
                ", fraudStatus='" + fraudStatus + '\'' +
                ", decision='" + decision + '\'' +
                '}';
    }
}
