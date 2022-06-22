package com.codegym.model.service;

import com.codegym.model.entity.EnglishLanguage;
import com.codegym.model.entity.VietnamLanguage;

import java.util.Map;

public interface ITranslateService {
    Map<EnglishLanguage, VietnamLanguage> getDictionary();
}
