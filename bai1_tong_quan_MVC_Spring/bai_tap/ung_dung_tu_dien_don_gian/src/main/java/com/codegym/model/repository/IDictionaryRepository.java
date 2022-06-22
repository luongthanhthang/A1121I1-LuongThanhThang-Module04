package com.codegym.model.repository;

import com.codegym.model.entity.EnglishLanguage;
import com.codegym.model.entity.VietnamLanguage;

import java.util.Map;

public interface IDictionaryRepository {
    Map<EnglishLanguage, VietnamLanguage> getDictionary();
}
