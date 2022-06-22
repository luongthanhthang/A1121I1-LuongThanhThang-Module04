package com.codegym.model.entity;

public class VietnamLanguage {
    private String language;

    public VietnamLanguage() {
    }

    public VietnamLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VietnamLanguage)) return false;

        VietnamLanguage that = (VietnamLanguage) o;

        return getLanguage() != null ? getLanguage().equals(that.getLanguage()) : that.getLanguage() == null;
    }

    @Override
    public int hashCode() {
        return getLanguage() != null ? getLanguage().hashCode() : 0;
    }
}
