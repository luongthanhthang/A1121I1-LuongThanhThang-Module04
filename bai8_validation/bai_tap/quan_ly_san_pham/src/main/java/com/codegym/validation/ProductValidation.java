package com.codegym.validation;

import com.codegym.entity.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class ProductValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        if (product.getStartDate() == null) {
            errors.rejectValue("startTime", "StarTimeNotNull");
        }

        if (product.getEndDate() == null) {
            errors.rejectValue("endTime", "EndTimeNotNull");
        } else {
            LocalDate startTime = product.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endTime = product.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(startTime, endTime).getDays() < 0) {
                errors.rejectValue("endTime", "DateComparison");
            }
        }
    }
}

