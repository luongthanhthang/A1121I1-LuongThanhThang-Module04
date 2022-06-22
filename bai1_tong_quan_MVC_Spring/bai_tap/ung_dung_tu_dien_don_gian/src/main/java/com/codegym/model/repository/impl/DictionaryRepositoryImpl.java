package com.codegym.model.repository.impl;

import com.codegym.model.entity.EnglishLanguage;
import com.codegym.model.entity.VietnamLanguage;
import com.codegym.model.repository.IDictionaryRepository;

import java.util.HashMap;
import java.util.Map;

public class DictionaryRepositoryImpl implements IDictionaryRepository {
    @Override
    public Map<EnglishLanguage, VietnamLanguage> getDictionary() {
        Map<EnglishLanguage, VietnamLanguage> dictionaryList =  new HashMap<>();
        dictionaryList.put(new EnglishLanguage("one"), new VietnamLanguage("mot"));
        dictionaryList.put(new EnglishLanguage("two"), new VietnamLanguage("hai"));
        dictionaryList.put(new EnglishLanguage("three"), new VietnamLanguage("ba"));
        dictionaryList.put(new EnglishLanguage("four"), new VietnamLanguage("bon"));
        dictionaryList.put(new EnglishLanguage("five"), new VietnamLanguage("nam"));
        dictionaryList.put(new EnglishLanguage("six"), new VietnamLanguage("sau"));
        dictionaryList.put(new EnglishLanguage("seven"), new VietnamLanguage("bay"));
        dictionaryList.put(new EnglishLanguage("eight"), new VietnamLanguage("tam"));
        dictionaryList.put(new EnglishLanguage("nine"), new VietnamLanguage("chin"));
        dictionaryList.put(new EnglishLanguage("ten"), new VietnamLanguage("muoi"));
        return dictionaryList;
    }
}
