package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.utils.Page;

import java.util.List;

public interface CategoryService {
    List<Category> list(Page page);
    int total();
    void add(Category category);
    void delete(int id);
    Category get(int id);
    void update(Category c);
}
