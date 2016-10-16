package com.sabre.api.sacs.domain.leadpricecalendar;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class LeadPriceCalendarResponse {

    @JsonProperty("OriginLocation")
    private String originLocation;
    
    @JsonProperty("DestinationLocation")
    private String destinationLocation;
    
    @JsonProperty("FareInfo")
    private List<FareInfoResponse> fareInfo;
    
    @JsonProperty("Links")
    private List<Link> links;

    public String getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(String originLocation) {
        this.originLocation = originLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public List<FareInfoResponse> getFareInfo() {
        return fareInfo;
    }

    public void setFareInfo(List<FareInfoResponse> fareInfo) {
        this.fareInfo = fareInfo;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
