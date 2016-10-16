
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
    "OriginDestinationOption"
})
public class OriginDestinationOptions {

    @JsonProperty("OriginDestinationOption")
    private List<com.sabre.api.sacs.domain.bargainfindermax_gen.OriginDestinationOption> OriginDestinationOption = new ArrayList<com.sabre.api.sacs.domain.bargainfindermax_gen.OriginDestinationOption>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The OriginDestinationOption
     */
    @JsonProperty("OriginDestinationOption")
    public List<com.sabre.api.sacs.domain.bargainfindermax_gen.OriginDestinationOption> getOriginDestinationOption() {
        return OriginDestinationOption;
    }

    /**
     * 
     * @param OriginDestinationOption
     *     The OriginDestinationOption
     */
    @JsonProperty("OriginDestinationOption")
    public void setOriginDestinationOption(List<com.sabre.api.sacs.domain.bargainfindermax_gen.OriginDestinationOption> OriginDestinationOption) {
        this.OriginDestinationOption = OriginDestinationOption;
    }

    public OriginDestinationOptions withOriginDestinationOption(List<com.sabre.api.sacs.domain.bargainfindermax_gen.OriginDestinationOption> OriginDestinationOption) {
        this.OriginDestinationOption = OriginDestinationOption;
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

    public OriginDestinationOptions withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }


}
