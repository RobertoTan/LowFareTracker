
package com.sabre.api.sacs.domain.bargainfindermax_gen;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ElapsedTime",
    "FlightSegment"
})
public class OriginDestinationOption {

    @JsonProperty("ElapsedTime")
    private Integer ElapsedTime;
    @JsonProperty("FlightSegment")
    private List<com.sabre.api.sacs.domain.bargainfindermax_gen.FlightSegment> FlightSegment = new ArrayList<com.sabre.api.sacs.domain.bargainfindermax_gen.FlightSegment>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The ElapsedTime
     */
    @JsonProperty("ElapsedTime")
    public Integer getElapsedTime() {
        return ElapsedTime;
    }

    /**
     * 
     * @param ElapsedTime
     *     The ElapsedTime
     */
    @JsonProperty("ElapsedTime")
    public void setElapsedTime(Integer ElapsedTime) {
        this.ElapsedTime = ElapsedTime;
    }

    public OriginDestinationOption withElapsedTime(Integer ElapsedTime) {
        this.ElapsedTime = ElapsedTime;
        return this;
    }

    /**
     * 
     * @return
     *     The FlightSegment
     */
    @JsonProperty("FlightSegment")
    public List<com.sabre.api.sacs.domain.bargainfindermax_gen.FlightSegment> getFlightSegment() {
        return FlightSegment;
    }

    /**
     * 
     * @param FlightSegment
     *     The FlightSegment
     */
    @JsonProperty("FlightSegment")
    public void setFlightSegment(List<com.sabre.api.sacs.domain.bargainfindermax_gen.FlightSegment> FlightSegment) {
        this.FlightSegment = FlightSegment;
    }

    public OriginDestinationOption withFlightSegment(List<com.sabre.api.sacs.domain.bargainfindermax_gen.FlightSegment> FlightSegment) {
        this.FlightSegment = FlightSegment;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public OriginDestinationOption withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
