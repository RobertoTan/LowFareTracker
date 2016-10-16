
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
    "Segment",
    "Allowance"
})
public class BaggageInformation {

    @JsonProperty("Segment")
    private List<com.sabre.api.sacs.domain.bargainfindermax_gen.Segment> Segment = new ArrayList<com.sabre.api.sacs.domain.bargainfindermax_gen.Segment>();
    @JsonProperty("Allowance")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.Allowance Allowance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Segment
     */
    @JsonProperty("Segment")
    public List<com.sabre.api.sacs.domain.bargainfindermax_gen.Segment> getSegment() {
        return Segment;
    }

    /**
     * 
     * @param Segment
     *     The Segment
     */
    @JsonProperty("Segment")
    public void setSegment(List<com.sabre.api.sacs.domain.bargainfindermax_gen.Segment> Segment) {
        this.Segment = Segment;
    }

    public BaggageInformation withSegment(List<com.sabre.api.sacs.domain.bargainfindermax_gen.Segment> Segment) {
        this.Segment = Segment;
        return this;
    }

    /**
     * 
     * @return
     *     The Allowance
     */
    @JsonProperty("Allowance")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.Allowance getAllowance() {
        return Allowance;
    }

    /**
     * 
     * @param Allowance
     *     The Allowance
     */
    @JsonProperty("Allowance")
    public void setAllowance(com.sabre.api.sacs.domain.bargainfindermax_gen.Allowance Allowance) {
        this.Allowance = Allowance;
    }

    public BaggageInformation withAllowance(com.sabre.api.sacs.domain.bargainfindermax_gen.Allowance Allowance) {
        this.Allowance = Allowance;
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

    public BaggageInformation withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
