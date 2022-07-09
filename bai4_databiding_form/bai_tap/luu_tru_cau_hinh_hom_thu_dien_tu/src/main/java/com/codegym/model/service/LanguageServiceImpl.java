package com.codegym.model.service;

import com.codegym.model.repository.ILanguageRepo;
import com.codegym.model.repository.LanguageRepoImpl;

import java.util.ArrayList;
import java.util.List;

public class LanguageServiceImpl implements ILanguageService {
    ILanguageRepo languageRepo = new LanguageRepoImpl();

    @Override
    public List<String> languageList() {
        return languageRepo.languageList();
    }
}
