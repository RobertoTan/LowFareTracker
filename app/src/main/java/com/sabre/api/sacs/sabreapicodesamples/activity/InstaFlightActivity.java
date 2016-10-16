package com.sabre.api.sacs.sabreapicodesamples.activity;

import com.sabre.api.sacs.configuration.SacsConfiguration;
import com.sabre.api.sacs.domain.BaseDomainResponse;
import com.sabre.api.sacs.domain.instaflight_gen.InstaFlightResponse;
import com.sabre.api.sacs.domain.leadpricecalendar.LeadPriceCalendarRequest;
import com.sabre.api.sacs.domain.leadpricecalendar.LeadPriceCalendarResponse;
import com.sabre.api.sacs.domain.leadpricecalendar.Link;
import com.sabre.api.sacs.rest.GenericRestGetCall;
import com.sabre.api.sacs.workflow.Activity;
import com.sabre.api.sacs.workflow.SharedContext;

import java.util.List;


/**
 * Activity to use in workflow. It runs the InstaFlight call.
 * It uses the result of the previous call - LeadPriceCalendar - to
 * create the request parameters.
 */
public class InstaFlightActivity implements Activity {

    private SacsConfiguration config = SacsConfiguration.getInstance();
    
    private BargainFinderMaxActivity next = new BargainFinderMaxActivity();
    
    GenericRestGetCall<LeadPriceCalendarRequest, InstaFlightResponse> call = new GenericRestGetCall<>();
    
    @Override
    public Activity run(SharedContext context) {
        
        BaseDomainResponse<LeadPriceCalendarResponse> lpc = (BaseDomainResponse<LeadPriceCalendarResponse>) context.getResult("LeadPriceCalendar");
        if (lpc.getStatus() != 200) {
            return null;
        }
        List<Link> links = lpc.getResult().getFareInfo().get(0).getLinks();
        for (Link link: links) {
            if ("shop".equals(link.getRel())) {
                call.setUrl(link.getHref());
                break;
            }
        }
        BaseDomainResponse<InstaFlightResponse> instaFlight = call.doCall(InstaFlightResponse.class, context);
        context.putResult("InstaFlight", instaFlight);
        return next;
    }

}

    