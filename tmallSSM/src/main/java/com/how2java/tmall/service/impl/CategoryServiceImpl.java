package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 后台查询所有分类数据
     *
     * @return
     */
    public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }

    /**
     * 计算总页数
     * @return
     */
    @Override
    public int total() {
        return categoryMapper.total();
    }

    /**
     * 增加类别
     * @param category
     */
    @Override
    public void add(Category category){
        categoryMapper.add(category);
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }

    /**
     * 根据id获取一条数据
     * @param id
     */
    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }

    /**
     * 更新查询出来的分类信息
     * @param c
     */
    @Override
    public void update(Category c) {
        categoryMapper.update(c);
    }


}
