package com.codegym.model.repository;

import java.util.ArrayList;
import java.util.List;

public class PageSizeRepoImpl implements IPageSizeRepo{
    static List<Integer > intList = new ArrayList<>();
    static {
        intList.add(5);
        intList.add(10);
        intList.add(25);
        intList.add(50);
        intList.add(100);
    }
    @Override
    public List<Integer> pageSizeList() {
        return intList;
    }
}
