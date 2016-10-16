
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
    "BaggageInformation"
})
public class BaggageInformationList {

    @JsonProperty("BaggageInformation")
    private List<com.sabre.api.sacs.domain.bargainfindermax_gen.BaggageInformation> BaggageInformation = new ArrayList<com.sabre.api.sacs.domain.bargainfindermax_gen.BaggageInformation>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The BaggageInformation
     */
    @JsonProperty("BaggageInformation")
    public List<com.sabre.api.sacs.domain.bargainfindermax_gen.BaggageInformation> getBaggageInformation() {
        return BaggageInformation;
    }

    /**
     * 
     * @param BaggageInformation
     *     The BaggageInformation
     */
    @JsonProperty("BaggageInformation")
    public void setBaggageInformation(List<com.sabre.api.sacs.domain.bargainfindermax_gen.BaggageInformation> BaggageInformation) {
        this.BaggageInformation = BaggageInformation;
    }

    public BaggageInformationList withBaggageInformation(List<com.sabre.api.sacs.domain.bargainfindermax_gen.BaggageInformation> BaggageInformation) {
        this.BaggageInformation = BaggageInformation;
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

    public BaggageInformationList withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
