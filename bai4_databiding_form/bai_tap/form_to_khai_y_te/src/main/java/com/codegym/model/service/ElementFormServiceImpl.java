package com.codegym.model.service;

import com.codegym.model.entity.Person;
import com.codegym.model.repository.ElementFormRepoImpl;
import com.codegym.model.repository.IElementFormRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementFormServiceImpl implements IElementFormService {
    IElementFormRepo elementFormRepo = new ElementFormRepoImpl();

    @Override
    public List<String> genderList() {
        return elementFormRepo.genderList();
    }

    @Override
    public List<String> nationalityList() {
        return elementFormRepo.nationalityList();
    }

    @Override
    public List<String> travelInfoList() {
        return elementFormRepo.travelInfoList();
    }

    @Override
    public Map<String, String> checkData(Person person) {
        Map<String, String> mapError = new HashMap<>();
        if (person.getName().equals("")) {
            mapError.put("name", "Bạn chưa nhập mục này");
        }
        if (person.getYearOfBirth().equals("")) {
            mapError.put("birthday", "Bạn chưa nhập mục này");
        }
        if (person.getIdCard().equals("")) {
            mapError.put("idCard", "Bạn chưa nhập mục này");
        }
        if (person.getTravel() == null) {
            mapError.put("travelInfo", "Bạn chưa nhập mục này");
        }
        if (person.getTravelId().equals("")) {
            mapError.put("numberVehicle", "Bạn chưa nhập mục này");
        }
        if (person.getSeats().equals("")) {
            mapError.put("numberSeat", "Bạn chưa nhập mục này");
        }
        if (person.getStartDate().equals("")) {
            mapError.put("dateStart", "Bạn chưa nhập mục này");
        }
        if (person.getEndDate().equals("")) {
            mapError.put("dateEnd", "Bạn chưa nhập mục này");
        }
        if (person.getAttention().equals("")) {
            mapError.put("extraInfo", "Bạn chưa nhập mục này");
        }
        return mapError;
    }
}