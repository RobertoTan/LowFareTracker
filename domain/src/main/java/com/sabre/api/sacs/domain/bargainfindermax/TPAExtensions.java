
package com.sabre.api.sacs.domain.bargainfindermax;

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
    "IntelliSellTransaction"
})
public class TPAExtensions {

    @JsonProperty("IntelliSellTransaction")
    private com.sabre.api.sacs.domain.bargainfindermax.IntelliSellTransaction IntelliSellTransaction;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The IntelliSellTransaction
     */
    @JsonProperty("IntelliSellTransaction")
    public com.sabre.api.sacs.domain.bargainfindermax.IntelliSellTransaction getIntelliSellTransaction() {
        return IntelliSellTransaction;
    }

    /**
     * 
     * @param IntelliSellTransaction
     *     The IntelliSellTransaction
     */
    @JsonProperty("IntelliSellTransaction")
    public void setIntelliSellTransaction(com.sabre.api.sacs.domain.bargainfindermax.IntelliSellTransaction IntelliSellTransaction) {
        this.IntelliSellTransaction = IntelliSellTransaction;
    }

    public TPAExtensions withIntelliSellTransaction(com.sabre.api.sacs.domain.bargainfindermax.IntelliSellTransaction IntelliSellTransaction) {
        this.IntelliSellTransaction = IntelliSellTransaction;
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

    public TPAExtensions withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
