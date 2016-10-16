package com.sabre.api.sacs.domain.bargainfindermax;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sabre.api.sacs.domain.instaflight_gen.PricedItinerary;

import java.util.List;

public class PricedItineraries {

    @JsonProperty("PricedItinerary")
    private List<PricedItinerary> pricedItinerary;
}
