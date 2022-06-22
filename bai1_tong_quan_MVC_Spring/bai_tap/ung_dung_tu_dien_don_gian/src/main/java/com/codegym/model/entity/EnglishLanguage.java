package com.codegym.model.entity;

public class EnglishLanguage {
    private String language;

    public EnglishLanguage() {
    }

    public EnglishLanguage(String language) {
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
        if (!(o instanceof EnglishLanguage)) return false;

        EnglishLanguage that = (EnglishLanguage) o;

        return getLanguage() != null ? getLanguage().equals(that.getLanguage()) : that.getLanguage() == null;
    }

    @Override
    public int hashCode() {
        return getLanguage() != null ? getLanguage().hashCode() : 0;
    }
}
