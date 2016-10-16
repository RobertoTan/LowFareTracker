package com.sabre.api.sacs.sabreapicodesamples.activity;

import com.sabre.api.sacs.configuration.SacsConfiguration;
import com.sabre.api.sacs.domain.BaseDomainResponse;
import com.sabre.api.sacs.domain.bargainfindermax.AirTravelerAvail;
import com.sabre.api.sacs.domain.bargainfindermax.BargainFinderMaxRequest;
import com.sabre.api.sacs.domain.bargainfindermax.CompanyName;
import com.sabre.api.sacs.domain.bargainfindermax.DestinationLocation;
import com.sabre.api.sacs.domain.bargainfindermax.IntelliSellTransaction;
import com.sabre.api.sacs.domain.bargainfindermax.OTAAirLowFareSearchRQ;
import com.sabre.api.sacs.domain.bargainfindermax.OriginDestinationInformation;
import com.sabre.api.sacs.domain.bargainfindermax.OriginLocation;
import com.sabre.api.sacs.domain.bargainfindermax.POS;
import com.sabre.api.sacs.domain.bargainfindermax.RequestType;
import com.sabre.api.sacs.domain.bargainfindermax.RequestorID;
import com.sabre.api.sacs.domain.bargainfindermax.Source;
import com.sabre.api.sacs.domain.bargainfindermax.TravelerInfoSummary;
import com.sabre.api.sacs.domain.bargainfindermax_gen.BfmV186Response;
import com.sabre.api.sacs.domain.bargainfindermax.PassengerTypeQuantity;
import com.sabre.api.sacs.domain.bargainfindermax.TPAExtensions;
import com.sabre.api.sacs.rest.GenericRestPostCall;
import com.sabre.api.sacs.workflow.Activity;
import com.sabre.api.sacs.workflow.SharedContext;

import java.util.ArrayList;
import java.util.List;


/**
 * Activity to use in workflow. It runs the BargainFinderMax call.
 * Last one in example flow.
 */
public class BargainFinderMaxActivity implements Activity {

    private SacsConfiguration config = com.sabre.api.sacs.configuration.SacsConfiguration.getInstance();
    
    GenericRestPostCall<BargainFinderMaxRequest, BfmV186Response> call = new GenericRestPostCall<>();

    @Override
    public Activity run(SharedContext context) {
        call.setRequest(generateRequest(context.getResult("origin").toString(),
                context.getResult("destination").toString(),
                context.getResult("departureDate").toString()+"T00:00:00"));
        call.setUrl(config.getRestProperty("environment") + "/v1.8.6/shop/flights?mode=live");
        BaseDomainResponse<BfmV186Response> response = call.doCall(BfmV186Response.class, context);
        context.putResult("BargainFinderMaxResponse", response);
        return null;
    }

    private BargainFinderMaxRequest generateRequest(String origin, String destination, String departureDate) {
        List<OriginDestinationInformation> originDestinationInfos = new ArrayList<>();
        OriginDestinationInformation odInfo = new OriginDestinationInformation()
                .withDepartureDateTime(departureDate)
                .withOriginLocation(new OriginLocation()
                        .withLocationCode(origin))
                .withDestinationLocation(new DestinationLocation()
                        .withLocationCode(destination))
                .withRPH("1");
        List<Source> sourceList = new ArrayList<>();
        Source source = new Source()
                .withRequestorID(new RequestorID()
                        .withID("REQ.ID")
                        .withType("0.AAA.X")
                        .withCompanyName(new CompanyName()
                                .withCode("TN")));
        sourceList.add(source);
        POS pos = new POS()
                .withSource(sourceList);
        originDestinationInfos.add(odInfo);

        List<PassengerTypeQuantity> passengerTypeQuantities = new ArrayList<>();
        PassengerTypeQuantity ptQuantity = new PassengerTypeQuantity()
                .withCode("ADT")
                .withQuantity(1);
        passengerTypeQuantities.add(ptQuantity);
        List<AirTravelerAvail> airTravelerAvails = new ArrayList<>();
        AirTravelerAvail atAvail = new AirTravelerAvail()
                .withPassengerTypeQuantity(passengerTypeQuantities);
        airTravelerAvails.add(atAvail);
        BargainFinderMaxRequest request = new BargainFinderMaxRequest()
                .withOTAAirLowFareSearchRQ(new OTAAirLowFareSearchRQ()
                        .withOriginDestinationInformation(originDestinationInfos)
                        .withPOS(pos)
                        .withTPAExtensions(new TPAExtensions()
                                .withIntelliSellTransaction(new IntelliSellTransaction()
                                        .withRequestType(new RequestType()
                                                .withName("50ITINS"))))
                        .withTravelerInfoSummary(new TravelerInfoSummary()
                                .withAirTravelerAvail(airTravelerAvails)));
        return request;
    }

}
