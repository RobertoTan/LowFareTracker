
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
    "SeatsRemaining",
    "Cabin",
    "Meal"
})
public class TPAExtensions___ {

    @JsonProperty("SeatsRemaining")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.SeatsRemaining SeatsRemaining;
    @JsonProperty("Cabin")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.Cabin Cabin;
    @JsonProperty("Meal")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.Meal Meal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The SeatsRemaining
     */
    @JsonProperty("SeatsRemaining")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.SeatsRemaining getSeatsRemaining() {
        return SeatsRemaining;
    }

    /**
     * 
     * @param SeatsRemaining
     *     The SeatsRemaining
     */
    @JsonProperty("SeatsRemaining")
    public void setSeatsRemaining(com.sabre.api.sacs.domain.bargainfindermax_gen.SeatsRemaining SeatsRemaining) {
        this.SeatsRemaining = SeatsRemaining;
    }

    public TPAExtensions___ withSeatsRemaining(com.sabre.api.sacs.domain.bargainfindermax_gen.SeatsRemaining SeatsRemaining) {
        this.SeatsRemaining = SeatsRemaining;
        return this;
    }

    /**
     * 
     * @return
     *     The Cabin
     */
    @JsonProperty("Cabin")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.Cabin getCabin() {
        return Cabin;
    }

    /**
     * 
     * @param Cabin
     *     The Cabin
     */
    @JsonProperty("Cabin")
    public void setCabin(com.sabre.api.sacs.domain.bargainfindermax_gen.Cabin Cabin) {
        this.Cabin = Cabin;
    }

    public TPAExtensions___ withCabin(com.sabre.api.sacs.domain.bargainfindermax_gen.Cabin Cabin) {
        this.Cabin = Cabin;
        return this;
    }

    /**
     * 
     * @return
     *     The Meal
     */
    @JsonProperty("Meal")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.Meal getMeal() {
        return Meal;
    }

    /**
     * 
     * @param Meal
     *     The Meal
     */
    @JsonProperty("Meal")
    public void setMeal(com.sabre.api.sacs.domain.bargainfindermax_gen.Meal Meal) {
        this.Meal = Meal;
    }

    public TPAExtensions___ withMeal(com.sabre.api.sacs.domain.bargainfindermax_gen.Meal Meal) {
        this.Meal = Meal;
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

    public TPAExtensions___ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
