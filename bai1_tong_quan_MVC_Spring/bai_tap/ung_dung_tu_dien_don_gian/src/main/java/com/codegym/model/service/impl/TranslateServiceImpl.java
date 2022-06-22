package com.codegym.model.service.impl;

import com.codegym.model.entity.EnglishLanguage;
import com.codegym.model.entity.VietnamLanguage;
import com.codegym.model.repository.IDictionaryRepository;
import com.codegym.model.repository.impl.DictionaryRepositoryImpl;
import com.codegym.model.service.ITranslateService;
import java.util.Map;

public class TranslateServiceImpl implements ITranslateService {
    IDictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();


    @Override
    public Map<EnglishLanguage, VietnamLanguage> getDictionary() {
        return dictionaryRepository.getDictionary();
    }
}
