
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
    "RequestorID"
})
public class Source {

    @JsonProperty("RequestorID")
    private com.sabre.api.sacs.domain.bargainfindermax.RequestorID RequestorID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The RequestorID
     */
    @JsonProperty("RequestorID")
    public com.sabre.api.sacs.domain.bargainfindermax.RequestorID getRequestorID() {
        return RequestorID;
    }

    /**
     * 
     * @param RequestorID
     *     The RequestorID
     */
    @JsonProperty("RequestorID")
    public void setRequestorID(com.sabre.api.sacs.domain.bargainfindermax.RequestorID RequestorID) {
        this.RequestorID = RequestorID;
    }

    public Source withRequestorID(com.sabre.api.sacs.domain.bargainfindermax.RequestorID RequestorID) {
        this.RequestorID = RequestorID;
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

    public Source withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
