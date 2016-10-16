
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
    "BaseFare",
    "FareConstruction",
    "EquivFare",
    "Taxes",
    "TotalFare"
})
public class ItinTotalFare {

    @JsonProperty("BaseFare")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.BaseFare BaseFare;
    @JsonProperty("FareConstruction")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.FareConstruction FareConstruction;
    @JsonProperty("EquivFare")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.EquivFare EquivFare;
    @JsonProperty("Taxes")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.Taxes Taxes;
    @JsonProperty("TotalFare")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.TotalFare TotalFare;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The BaseFare
     */
    @JsonProperty("BaseFare")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.BaseFare getBaseFare() {
        return BaseFare;
    }

    /**
     * 
     * @param BaseFare
     *     The BaseFare
     */
    @JsonProperty("BaseFare")
    public void setBaseFare(com.sabre.api.sacs.domain.bargainfindermax_gen.BaseFare BaseFare) {
        this.BaseFare = BaseFare;
    }

    public ItinTotalFare withBaseFare(com.sabre.api.sacs.domain.bargainfindermax_gen.BaseFare BaseFare) {
        this.BaseFare = BaseFare;
        return this;
    }

    /**
     * 
     * @return
     *     The FareConstruction
     */
    @JsonProperty("FareConstruction")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.FareConstruction getFareConstruction() {
        return FareConstruction;
    }

    /**
     * 
     * @param FareConstruction
     *     The FareConstruction
     */
    @JsonProperty("FareConstruction")
    public void setFareConstruction(com.sabre.api.sacs.domain.bargainfindermax_gen.FareConstruction FareConstruction) {
        this.FareConstruction = FareConstruction;
    }

    public ItinTotalFare withFareConstruction(com.sabre.api.sacs.domain.bargainfindermax_gen.FareConstruction FareConstruction) {
        this.FareConstruction = FareConstruction;
        return this;
    }

    /**
     * 
     * @return
     *     The EquivFare
     */
    @JsonProperty("EquivFare")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.EquivFare getEquivFare() {
        return EquivFare;
    }

    /**
     * 
     * @param EquivFare
     *     The EquivFare
     */
    @JsonProperty("EquivFare")
    public void setEquivFare(com.sabre.api.sacs.domain.bargainfindermax_gen.EquivFare EquivFare) {
        this.EquivFare = EquivFare;
    }

    public ItinTotalFare withEquivFare(com.sabre.api.sacs.domain.bargainfindermax_gen.EquivFare EquivFare) {
        this.EquivFare = EquivFare;
        return this;
    }

    /**
     * 
     * @return
     *     The Taxes
     */
    @JsonProperty("Taxes")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.Taxes getTaxes() {
        return Taxes;
    }

    /**
     * 
     * @param Taxes
     *     The Taxes
     */
    @JsonProperty("Taxes")
    public void setTaxes(com.sabre.api.sacs.domain.bargainfindermax_gen.Taxes Taxes) {
        this.Taxes = Taxes;
    }

    public ItinTotalFare withTaxes(com.sabre.api.sacs.domain.bargainfindermax_gen.Taxes Taxes) {
        this.Taxes = Taxes;
        return this;
    }

    /**
     * 
     * @return
     *     The TotalFare
     */
    @JsonProperty("TotalFare")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.TotalFare getTotalFare() {
        return TotalFare;
    }

    /**
     * 
     * @param TotalFare
     *     The TotalFare
     */
    @JsonProperty("TotalFare")
    public void setTotalFare(com.sabre.api.sacs.domain.bargainfindermax_gen.TotalFare TotalFare) {
        this.TotalFare = TotalFare;
    }

    public ItinTotalFare withTotalFare(com.sabre.api.sacs.domain.bargainfindermax_gen.TotalFare TotalFare) {
        this.TotalFare = TotalFare;
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

    public ItinTotalFare withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
