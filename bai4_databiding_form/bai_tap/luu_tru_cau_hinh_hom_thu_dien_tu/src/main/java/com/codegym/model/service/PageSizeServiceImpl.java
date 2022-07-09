package com.codegym.model.service;

import com.codegym.model.repository.IPageSizeRepo;
import com.codegym.model.repository.PageSizeRepoImpl;

import java.util.ArrayList;
import java.util.List;

public class PageSizeServiceImpl implements IPageSizeService {
    IPageSizeRepo pageSizeRepo = new PageSizeRepoImpl();
    @Override
    public List<Integer> pageSizeList() {
        return pageSizeRepo.pageSizeList();
    }
}
