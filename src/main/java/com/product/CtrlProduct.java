package com.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CtrlProduct {
private List<Category> categories;
    
    public CtrlProduct() {
        categories = new ArrayList<>();
        categories.add(new Category(1, "Lentes", "Lts", 1));
        categories.add(new Category(2, "Relojes", "Rljs", 1));
    }
    
    @GetMapping("/category")
    public List<Category> getCategories() {
        List<Category> activeCategories = new ArrayList<>();
        for (Category c : categories) {
            if (c.getStatus() == 1) {
                activeCategories.add(c);
            }
        }
        return activeCategories;
    }
}
