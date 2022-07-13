package com.codegym.formatter;

import com.codegym.entity.Province;
import com.codegym.service.IProvinceService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Province> {

    private IProvinceService provinceService;

    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String id, Locale locale) throws ParseException {
        Optional<Province> province = provinceService.findById(Integer.parseInt(id));
        return province.orElse(null);
    }

    @Override
    public String print(Province object, Locale locale) {
        return null;
    }
}
