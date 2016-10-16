
package com.sabre.api.sacs.domain.bargainfindermax_gen;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "FareCalcLine"
})
public class TPAExtensions__ {

    @JsonProperty("FareCalcLine")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.FareCalcLine FareCalcLine;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The FareCalcLine
     */
    @JsonProperty("FareCalcLine")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.FareCalcLine getFareCalcLine() {
        return FareCalcLine;
    }

    /**
     * 
     * @param FareCalcLine
     *     The FareCalcLine
     */
    @JsonProperty("FareCalcLine")
    public void setFareCalcLine(com.sabre.api.sacs.domain.bargainfindermax_gen.FareCalcLine FareCalcLine) {
        this.FareCalcLine = FareCalcLine;
    }

    public TPAExtensions__ withFareCalcLine(com.sabre.api.sacs.domain.bargainfindermax_gen.FareCalcLine FareCalcLine) {
        this.FareCalcLine = FareCalcLine;
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

    public TPAExtensions__ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
