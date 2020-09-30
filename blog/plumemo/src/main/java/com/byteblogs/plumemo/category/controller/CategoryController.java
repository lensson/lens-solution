package com.byteblogs.plumemo.category.controller;

import com.byteblogs.common.validator.group.Insert;
import com.byteblogs.common.validator.group.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.byteblogs.common.annotation.LoginRequired;
import com.byteblogs.common.base.domain.Result;
import com.byteblogs.common.util.ThrowableUtils;
import com.byteblogs.plumemo.category.domain.vo.CategoryVO;
import com.byteblogs.plumemo.category.service.CategoryService;

/**
 * @author byteblogs
 * @since 2019-08-28
 */
@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @LoginRequired
    @PostMapping("/category/v1/add")
    public Result saveCategory(@Validated({Insert.class}) @RequestBody CategoryVO categoryVO, BindingResult result) {
        ThrowableUtils.checkParamArgument(result);
        return categoryService.saveCategory(categoryVO);
    }


    @LoginRequired
    @GetMapping("/statistics/v1/list")
    public  Result statisticsList(CategoryVO categoryVO){
        return categoryService.statisticsList(categoryVO);
    }

    @LoginRequired
    @PutMapping("/category/v1/update")
    public Result updateCategory(@Validated({Update.class}) @RequestBody CategoryVO categoryVO, BindingResult result) {
        ThrowableUtils.checkParamArgument(result);
        return categoryService.updateCategory(categoryVO);
    }

    @LoginRequired
    @GetMapping("/category-tags/v1/{id}")
    public Result getCategoryTags(@PathVariable(value = "id", required = true) Long id) {
        return categoryService.getCategoryTags(id);
    }

    @LoginRequired
    @GetMapping("/category-tags/v1/list")
    public Result getCategoryTagsList(CategoryVO categoryVO) {
        return categoryService.getCategoryTagsList(categoryVO);
    }

    @GetMapping("/category/v1/{id}")
    public Result getCategory(@PathVariable(value = "id", required = true) Long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("/category/v1/list")
    public Result getCategoryList(CategoryVO categoryVO) {
        return categoryService.getCategoryList(categoryVO);
    }

    @LoginRequired
    @DeleteMapping("/category/v1/{id}")
    public Result deleteCategory(@PathVariable(value = "id", required = true) Long id) {
        return categoryService.deleteCategory(id);
    }

}
