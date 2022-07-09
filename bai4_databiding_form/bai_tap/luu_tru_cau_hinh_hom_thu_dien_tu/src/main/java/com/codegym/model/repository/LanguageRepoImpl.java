package com.codegym.model.repository;

import java.util.ArrayList;
import java.util.List;

public class LanguageRepoImpl implements ILanguageRepo{
    static List<String > stringList = new ArrayList<>();
    static {
        stringList.add("English");
        stringList.add("Vietnamese");
        stringList.add("Chinese");
        stringList.add("Japanese");
    }
    @Override
    public List<String> languageList() {
        return stringList;
    }
}
