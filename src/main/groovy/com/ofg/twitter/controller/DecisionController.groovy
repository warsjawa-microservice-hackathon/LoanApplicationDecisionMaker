package com.ofg.twitter.controller

import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import com.ofg.microservice.Collaborators
import com.ofg.twitter.controller.place.extractor.PropagationWorker
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.validation.constraints.NotNull
import java.util.concurrent.Callable

import static org.springframework.web.bind.annotation.RequestMethod.PUT

@Slf4j
@RestController
@RequestMapping('api/loanApplication')
@Api(value = "loanApplication", description = "Collects places from tweets and propagates them to Collerators")
class DecisionController {

    @Autowired private ServiceRestClient serviceRestClient

    @RequestMapping(
            value = '{loanApplicationId}',
            method = PUT,
            consumes = 'application/json',
            produces = 'application/json')
    @ApiOperation(value = "loan decision",
            notes = "loan decision")
    /*Callable<Void>*/ String makeDecision(
            @PathVariable("loanApplicationId") @NotNull String loanApplicationId,
            @RequestBody @NotNull DecisionRequest decisionRequest) {

        MarketingRequest marketingRequest = new MarketingRequest()
        Person p = new Person()
        p.setFirstName(decisionRequest.firstName)
        p.setLastName(decisionRequest.lastName)
        marketingRequest.setPerson(p)
        marketingRequest.setDecision("OK")

        serviceRestClient.forService("marketing")
                .put()
                .onUrl("/api/marketing/$loanApplicationId")
                .body(marketingRequest)
                .anObject()
                .ofType(String)

        return "zupa"
    }

}