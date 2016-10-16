
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
    "PTC_FareBreakdown"
})
public class PTCFareBreakdowns {

    @JsonProperty("PTC_FareBreakdown")
    private List<com.sabre.api.sacs.domain.bargainfindermax_gen.PTCFareBreakdown> PTCFareBreakdown = new ArrayList<com.sabre.api.sacs.domain.bargainfindermax_gen.PTCFareBreakdown>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The PTCFareBreakdown
     */
    @JsonProperty("PTC_FareBreakdown")
    public List<com.sabre.api.sacs.domain.bargainfindermax_gen.PTCFareBreakdown> getPTCFareBreakdown() {
        return PTCFareBreakdown;
    }

    /**
     * 
     * @param PTCFareBreakdown
     *     The PTC_FareBreakdown
     */
    @JsonProperty("PTC_FareBreakdown")
    public void setPTCFareBreakdown(List<com.sabre.api.sacs.domain.bargainfindermax_gen.PTCFareBreakdown> PTCFareBreakdown) {
        this.PTCFareBreakdown = PTCFareBreakdown;
    }

    public PTCFareBreakdowns withPTCFareBreakdown(List<com.sabre.api.sacs.domain.bargainfindermax_gen.PTCFareBreakdown> PTCFareBreakdown) {
        this.PTCFareBreakdown = PTCFareBreakdown;
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

    public PTCFareBreakdowns withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
