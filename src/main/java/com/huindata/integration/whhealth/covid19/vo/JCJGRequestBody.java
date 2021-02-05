package com.huindata.integration.whhealth.covid19.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JCJGRequestBody implements RequestBody{
    @JsonProperty("YLJGDM")
    private String YLJGDM;

    @JsonProperty("SGTXM")
    private String SGTXM;

    @JsonProperty("BBLX")
    private String BBLX;

    @JsonProperty("YLJGMC")
    private String YLJGMC;

    @JsonProperty("CYJGDM")
    private String CYJGDM;

    @JsonProperty("CYJGMC")
    private String CYJGMC;

    @JsonProperty("CYRQ")
    private String CYRQ;

    @JsonProperty("PID")
    private String PID;

    @JsonProperty("YWHDLX")
    private String YWHDLX;

    @JsonProperty("JZLSH")
    private String JZLSH;

    @JsonProperty("KH")
    private String KH;

    @JsonProperty("KLX")
    private String KLX;

    @JsonProperty("ZJLX")
    private String ZJLX;

    @JsonProperty("ZJHM")
    private String ZJHM;

    @JsonProperty("XM")
    private String XM;

    @JsonProperty("CSRQ")
    private String CSRQ;

    @JsonProperty("XB")
    private String XB;

    @JsonProperty("LXRXM")
    private String LXRXM;

    @JsonProperty("LXRZJHM")
    private String LXRZJHM;

    @JsonProperty("LXRZJLX")
    private String LXRZJLX;

    @JsonProperty("GXDM")
    private String GXDM;

    @JsonProperty("LXRLXDH")
    private String LXRLXDH;

    @JsonProperty("JCRQ")
    private String JCRQ;

    @JsonProperty("JCRESDM")
    private String JCRESDM;

    @JsonProperty("JCRESMC")
    private String JCRESMC;

    @JsonProperty("JCFF")
    private String JCFF;

    @JsonProperty("JCZBMC")
    private String JCZBMC = "";

    @JsonProperty("CT_ORF")
    private String CT_ORF = "";

    @JsonProperty("CT_N")
    private String CT_N = "";

    @JsonProperty("CT_E")
    private String CT_E = "";

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

    public String getCYRQ() {
        return CYRQ;
    }

    public void setCYRQ(String CYRQ) {
        this.CYRQ = CYRQ;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getYWHDLX() {
        return YWHDLX;
    }

    public void setYWHDLX(String YWHDLX) {
        this.YWHDLX = YWHDLX;
    }

    public String getJZLSH() {
        return JZLSH;
    }

    public void setJZLSH(String JZLSH) {
        this.JZLSH = JZLSH;
    }

    public String getKH() {
        return KH;
    }

    public void setKH(String KH) {
        this.KH = KH;
    }

    public String getKLX() {
        return KLX;
    }

    public void setKLX(String KLX) {
        this.KLX = KLX;
    }

    public String getZJLX() {
        return ZJLX;
    }

    public void setZJLX(String ZJLX) {
        this.ZJLX = ZJLX;
    }

    public String getZJHM() {
        return ZJHM;
    }

    public void setZJHM(String ZJHM) {
        this.ZJHM = ZJHM;
    }

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
    }

    public String getCSRQ() {
        return CSRQ;
    }

    public void setCSRQ(String CSRQ) {
        this.CSRQ = CSRQ;
    }

    public String getXB() {
        return XB;
    }

    public void setXB(String XB) {
        this.XB = XB;
    }

    public String getLXRXM() {
        return LXRXM;
    }

    public void setLXRXM(String LXRXM) {
        this.LXRXM = LXRXM;
    }

    public String getLXRZJHM() {
        return LXRZJHM;
    }

    public void setLXRZJHM(String LXRZJHM) {
        this.LXRZJHM = LXRZJHM;
    }

    public String getLXRZJLX() {
        return LXRZJLX;
    }

    public void setLXRZJLX(String LXRZJLX) {
        this.LXRZJLX = LXRZJLX;
    }

    public String getGXDM() {
        return GXDM;
    }

    public void setGXDM(String GXDM) {
        this.GXDM = GXDM;
    }

    public String getLXRLXDH() {
        return LXRLXDH;
    }

    public void setLXRLXDH(String LXRLXDH) {
        this.LXRLXDH = LXRLXDH;
    }

    public String getJCRQ() {
        return JCRQ;
    }

    public void setJCRQ(String JCRQ) {
        this.JCRQ = JCRQ;
    }

    public String getJCRESDM() {
        return JCRESDM;
    }

    public void setJCRESDM(String JCRESDM) {
        this.JCRESDM = JCRESDM;
    }

    public String getJCRESMC() {
        return JCRESMC;
    }

    public void setJCRESMC(String JCRESMC) {
        this.JCRESMC = JCRESMC;
    }

    public String getJCFF() {
        return JCFF;
    }

    public void setJCFF(String JCFF) {
        this.JCFF = JCFF;
    }

    public String getJCZBMC() {
        return JCZBMC;
    }

    public void setJCZBMC(String JCZBMC) {
        this.JCZBMC = JCZBMC;
    }

    public String getCT_ORF() {
        return CT_ORF;
    }

    public void setCT_ORF(String CT_ORF) {
        this.CT_ORF = CT_ORF;
    }

    public String getCT_N() {
        return CT_N;
    }

    public void setCT_N(String CT_N) {
        this.CT_N = CT_N;
    }

    public String getCT_E() {
        return CT_E;
    }

    public void setCT_E(String CT_E) {
        this.CT_E = CT_E;
    }
}
