package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.utils.Page;

import java.util.List;

public interface CategoryMapper {

    /**
     * 分页查询
     * @return
     */
    List<Category> list(Page page);

    /**
     * 获取种类总个数
     * pagenum当前页数 pagesize页数个数
     * @return
     */
    int total();

    /**
     * 增加类别
     * @param category
     */
    void add(Category category);

    /**
     * 根据id删除
     * @param id
     */
    void delete(int id);

    /**
     * 根据id查询一条分类数据
     * @param id
     */
    Category get(int id);

    /**
     * 根据查询出来的数据执行更新操作
     * @param category
     */
    void update(Category category);
}
