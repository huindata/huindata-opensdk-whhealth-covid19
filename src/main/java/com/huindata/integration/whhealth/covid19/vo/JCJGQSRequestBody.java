package com.huindata.integration.whhealth.covid19.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JCJGQSRequestBody implements RequestBody{
    @JsonProperty("YLJGDM")
    private String YLJGDM;

    @JsonProperty("SGTXM")
    private String SGTXM;

    @JsonProperty("BBLX")
    private String BBLX;

    @JsonProperty("YLJGMC")
    private String YLJGMC;

    @JsonProperty("QSRXX")
    private String QSRXX;

    @JsonProperty("BBQSDD")
    private String BBQSDD;

    @JsonProperty("QSRQ")
    private String QSRQ;

    @JsonProperty("QSJG")
    private String QSJG;

    @JsonProperty("JQYY")
    private String JQYY;

    @JsonProperty("CYJGDM")
    private String CYJGDM;

    @JsonProperty("CYJGMC")
    private String CYJGMC;

    @JsonProperty("SDBBR")
    private String SDBBR;

    public String getYLJGDM() {
        return YLJGDM;
    }

    public void setYLJGDM(String YLJGDM) {
        this.YLJGDM = YLJGDM;
    }

    public String getSGTXM() {
        return SGTXM;
    }

    public void setSGTXM(String SGTXM) {
        this.SGTXM = SGTXM;
    }

    public String getBBLX() {
        return BBLX;
    }

    public void setBBLX(String BBLX) {
        this.BBLX = BBLX;
    }

    public String getYLJGMC() {
        return YLJGMC;
    }

    public void setYLJGMC(String YLJGMC) {
        this.YLJGMC = YLJGMC;
    }

    public String getQSRXX() {
        return QSRXX;
    }

    public void setQSRXX(String QSRXX) {
        this.QSRXX = QSRXX;
    }

    public String getBBQSDD() {
        return BBQSDD;
    }

    public void setBBQSDD(String BBQSDD) {
        this.BBQSDD = BBQSDD;
    }

    public String getQSRQ() {
        return QSRQ;
    }

    public void setQSRQ(String QSRQ) {
        this.QSRQ = QSRQ;
    }

    public String getQSJG() {
        return QSJG;
    }

    public void setQSJG(String QSJG) {
        this.QSJG = QSJG;
    }

    public String getJQYY() {
        return JQYY;
    }

    public void setJQYY(String JQYY) {
        this.JQYY = JQYY;
    }

    public String getCYJGDM() {
        return CYJGDM;
    }

    public void setCYJGDM(String CYJGDM) {
        this.CYJGDM = CYJGDM;
    }

    public String getCYJGMC() {
        return CYJGMC;
    }

    public void setCYJGMC(String CYJGMC) {
        this.CYJGMC = CYJGMC;
    }

    public String getSDBBR() {
        return SDBBR;
    }

    public void setSDBBR(String SDBBR) {
        this.SDBBR = SDBBR;
    }
}
