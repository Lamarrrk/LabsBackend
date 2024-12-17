package org.example.labsbackend.controllers;

import org.example.labsbackend.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final Map<Long, Category> categories = new HashMap<>();

    @PostMapping
    public String createCategory(@RequestBody Category category) {
        categories.put(category.getId(), category);
        return "Category created successfully!";
    }

    @GetMapping
    public Collection<Category> getAllCategories() {
        return categories.values();
    }

    @DeleteMapping("/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        categories.remove(categoryId);
        return "Category deleted successfully!";
    }
}


