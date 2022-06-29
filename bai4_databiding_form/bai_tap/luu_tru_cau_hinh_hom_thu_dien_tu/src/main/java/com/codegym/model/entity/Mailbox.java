package com.codegym.model.entity;

import java.util.List;

public class Mailbox {
    private String languages;
    private Integer pageSizes;
    private boolean spamsFilter;
    private String signature;

    public Mailbox() {
    }

    public Mailbox(String languages, Integer pageSizes, boolean spamsFilter, String signature) {
        this.languages = languages;
        this.pageSizes = pageSizes;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Integer getPageSizes() {
        return pageSizes;
    }

    public void setPageSizes(Integer pageSizes) {
        this.pageSizes = pageSizes;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Mailbox{" +
                "languages='" + languages + '\'' +
                ", pageSizes=" + pageSizes +
                ", spamsFilter=" + spamsFilter +
                ", signature='" + signature + '\'' +
                '}';
    }
}
