package com.sabre.api.sacs.sabreapicodesamples.activity;


import com.sabre.api.sacs.configuration.SacsConfiguration;
import com.sabre.api.sacs.domain.BaseDomainResponse;
import com.sabre.api.sacs.domain.leadpricecalendar.LeadPriceCalendarRequest;
import com.sabre.api.sacs.domain.leadpricecalendar.LeadPriceCalendarResponse;
import com.sabre.api.sacs.rest.GenericRestGetCall;
import com.sabre.api.sacs.workflow.Activity;
import com.sabre.api.sacs.workflow.SharedContext;

/**
 * Activity to use in workflow. It runs the LeadPriceCalendarActivity.
 */
public class LeadPriceCalendarActivity implements Activity {

    private SacsConfiguration config = com.sabre.api.sacs.configuration.SacsConfiguration.getInstance();
    
    private InstaFlightActivity next = new InstaFlightActivity();
    
    private GenericRestGetCall<LeadPriceCalendarRequest, LeadPriceCalendarResponse> call = new GenericRestGetCall<>();

    private String origin;
    private String destination;
    private String departureDate;

    public LeadPriceCalendarActivity(String origin, String destination, String departureDate) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
    }

    @Override
    public Activity run(SharedContext context) {
        context.putResult("origin", origin);
        context.putResult("destination", destination);
        context.putResult("departureDate", departureDate);
        LeadPriceCalendarRequest request = new LeadPriceCalendarRequest.Builder()
                .origin(origin)
                .destination(destination)
                .lengthOfStay(5)
                .pointOfSaleCountry("US")
                .departureDate(departureDate)
                .build();
        call.setUrl(config.getRestProperty("environment") + "/v2/shop/flights/fares");
        call.setRequest(request);
        BaseDomainResponse<LeadPriceCalendarResponse> leadPriceCalendar = call.doCall(LeadPriceCalendarResponse.class, context);
        context.putResult("LeadPriceCalendar", leadPriceCalendar);
        return next;
    }

}
