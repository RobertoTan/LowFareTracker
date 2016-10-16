
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
    "PassengerTypeQuantity",
    "FareBasisCodes",
    "PassengerFare",
    "Endorsements",
    "TPA_Extensions"
})
public class PTCFareBreakdown {

    @JsonProperty("PassengerTypeQuantity")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.PassengerTypeQuantity PassengerTypeQuantity;
    @JsonProperty("FareBasisCodes")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.FareBasisCodes FareBasisCodes;
    @JsonProperty("PassengerFare")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.PassengerFare PassengerFare;
    @JsonProperty("Endorsements")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.Endorsements Endorsements;
    @JsonProperty("TPA_Extensions")
    private TPAExtensions__ TPAExtensions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The PassengerTypeQuantity
     */
    @JsonProperty("PassengerTypeQuantity")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.PassengerTypeQuantity getPassengerTypeQuantity() {
        return PassengerTypeQuantity;
    }

    /**
     * 
     * @param PassengerTypeQuantity
     *     The PassengerTypeQuantity
     */
    @JsonProperty("PassengerTypeQuantity")
    public void setPassengerTypeQuantity(com.sabre.api.sacs.domain.bargainfindermax_gen.PassengerTypeQuantity PassengerTypeQuantity) {
        this.PassengerTypeQuantity = PassengerTypeQuantity;
    }

    public PTCFareBreakdown withPassengerTypeQuantity(com.sabre.api.sacs.domain.bargainfindermax_gen.PassengerTypeQuantity PassengerTypeQuantity) {
        this.PassengerTypeQuantity = PassengerTypeQuantity;
        return this;
    }

    /**
     * 
     * @return
     *     The FareBasisCodes
     */
    @JsonProperty("FareBasisCodes")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.FareBasisCodes getFareBasisCodes() {
        return FareBasisCodes;
    }

    /**
     * 
     * @param FareBasisCodes
     *     The FareBasisCodes
     */
    @JsonProperty("FareBasisCodes")
    public void setFareBasisCodes(com.sabre.api.sacs.domain.bargainfindermax_gen.FareBasisCodes FareBasisCodes) {
        this.FareBasisCodes = FareBasisCodes;
    }

    public PTCFareBreakdown withFareBasisCodes(com.sabre.api.sacs.domain.bargainfindermax_gen.FareBasisCodes FareBasisCodes) {
        this.FareBasisCodes = FareBasisCodes;
        return this;
    }

    /**
     * 
     * @return
     *     The PassengerFare
     */
    @JsonProperty("PassengerFare")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.PassengerFare getPassengerFare() {
        return PassengerFare;
    }

    /**
     * 
     * @param PassengerFare
     *     The PassengerFare
     */
    @JsonProperty("PassengerFare")
    public void setPassengerFare(com.sabre.api.sacs.domain.bargainfindermax_gen.PassengerFare PassengerFare) {
        this.PassengerFare = PassengerFare;
    }

    public PTCFareBreakdown withPassengerFare(com.sabre.api.sacs.domain.bargainfindermax_gen.PassengerFare PassengerFare) {
        this.PassengerFare = PassengerFare;
        return this;
    }

    /**
     * 
     * @return
     *     The Endorsements
     */
    @JsonProperty("Endorsements")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.Endorsements getEndorsements() {
        return Endorsements;
    }

    /**
     * 
     * @param Endorsements
     *     The Endorsements
     */
    @JsonProperty("Endorsements")
    public void setEndorsements(com.sabre.api.sacs.domain.bargainfindermax_gen.Endorsements Endorsements) {
        this.Endorsements = Endorsements;
    }

    public PTCFareBreakdown withEndorsements(com.sabre.api.sacs.domain.bargainfindermax_gen.Endorsements Endorsements) {
        this.Endorsements = Endorsements;
        return this;
    }

    /**
     * 
     * @return
     *     The TPAExtensions
     */
    @JsonProperty("TPA_Extensions")
    public TPAExtensions__ getTPAExtensions() {
        return TPAExtensions;
    }

    /**
     * 
     * @param TPAExtensions
     *     The TPA_Extensions
     */
    @JsonProperty("TPA_Extensions")
    public void setTPAExtensions(TPAExtensions__ TPAExtensions) {
        this.TPAExtensions = TPAExtensions;
    }

    public PTCFareBreakdown withTPAExtensions(TPAExtensions__ TPAExtensions) {
        this.TPAExtensions = TPAExtensions;
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

    public PTCFareBreakdown withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
