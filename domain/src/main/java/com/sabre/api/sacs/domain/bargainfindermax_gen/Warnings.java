
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
    "Warning"
})
public class Warnings {

    @JsonProperty("Warning")
    private List<com.sabre.api.sacs.domain.bargainfindermax_gen.Warning> Warning = new ArrayList<com.sabre.api.sacs.domain.bargainfindermax_gen.Warning>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Warning
     */
    @JsonProperty("Warning")
    public List<com.sabre.api.sacs.domain.bargainfindermax_gen.Warning> getWarning() {
        return Warning;
    }

    /**
     * 
     * @param Warning
     *     The Warning
     */
    @JsonProperty("Warning")
    public void setWarning(List<com.sabre.api.sacs.domain.bargainfindermax_gen.Warning> Warning) {
        this.Warning = Warning;
    }

    public Warnings withWarning(List<com.sabre.api.sacs.domain.bargainfindermax_gen.Warning> Warning) {
        this.Warning = Warning;
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

    public Warnings withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
