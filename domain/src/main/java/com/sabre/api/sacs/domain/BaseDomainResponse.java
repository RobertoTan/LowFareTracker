package com.sabre.api.sacs.domain;

/**
 * Created by SG0946321 on 10/5/2015.
 */
public class BaseDomainResponse<RS> {
    private int status = 200;

    private RS result;

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }


    public RS getResult() {
        return result;
    }

    public void setResult(RS result) {
        this.result = result;
    }
}
