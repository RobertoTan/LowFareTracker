
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
    "Tax",
    "TotalTax"
})
public class Taxes_ {

    @JsonProperty("Tax")
    private List<Tax_> Tax = new ArrayList<Tax_>();
    @JsonProperty("TotalTax")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.TotalTax TotalTax;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Tax
     */
    @JsonProperty("Tax")
    public List<Tax_> getTax() {
        return Tax;
    }

    /**
     * 
     * @param Tax
     *     The Tax
     */
    @JsonProperty("Tax")
    public void setTax(List<Tax_> Tax) {
        this.Tax = Tax;
    }

    public Taxes_ withTax(List<Tax_> Tax) {
        this.Tax = Tax;
        return this;
    }

    /**
     * 
     * @return
     *     The TotalTax
     */
    @JsonProperty("TotalTax")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.TotalTax getTotalTax() {
        return TotalTax;
    }

    /**
     * 
     * @param TotalTax
     *     The TotalTax
     */
    @JsonProperty("TotalTax")
    public void setTotalTax(com.sabre.api.sacs.domain.bargainfindermax_gen.TotalTax TotalTax) {
        this.TotalTax = TotalTax;
    }

    public Taxes_ withTotalTax(com.sabre.api.sacs.domain.bargainfindermax_gen.TotalTax TotalTax) {
        this.TotalTax = TotalTax;
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

    public Taxes_ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
