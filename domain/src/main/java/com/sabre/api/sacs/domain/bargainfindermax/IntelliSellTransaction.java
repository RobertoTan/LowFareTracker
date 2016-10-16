
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
    "RequestType"
})
public class IntelliSellTransaction {

    @JsonProperty("RequestType")
    private com.sabre.api.sacs.domain.bargainfindermax.RequestType RequestType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The RequestType
     */
    @JsonProperty("RequestType")
    public com.sabre.api.sacs.domain.bargainfindermax.RequestType getRequestType() {
        return RequestType;
    }

    /**
     * 
     * @param RequestType
     *     The RequestType
     */
    @JsonProperty("RequestType")
    public void setRequestType(com.sabre.api.sacs.domain.bargainfindermax.RequestType RequestType) {
        this.RequestType = RequestType;
    }

    public IntelliSellTransaction withRequestType(com.sabre.api.sacs.domain.bargainfindermax.RequestType RequestType) {
        this.RequestType = RequestType;
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

    public IntelliSellTransaction withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
