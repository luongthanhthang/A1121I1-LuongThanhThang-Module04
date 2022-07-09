package com.codegym.model.service;

import com.codegym.model.entity.Person;

import java.util.List;
import java.util.Map;

public interface IElementFormService {
    List<String> genderList ();
    List<String> nationalityList ();
    List<String> travelInfoList ();
    Map<String, String> checkData(Person person);
}
