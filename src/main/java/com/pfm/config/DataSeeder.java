package com.pfm.config;

import com.pfm.entity.Category;
import com.pfm.entity.CategoryType;
import com.pfm.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            List<Category> defaultCategories = List.of(
                    createCat("Salary", CategoryType.INCOME),
                    createCat("Food", CategoryType.EXPENSE),
                    createCat("Move", CategoryType.EXPENSE),
                    createCat("Entertainment", CategoryType.EXPENSE)
            );
            categoryRepository.saveAll(defaultCategories);
        }
    }

    private Category createCat(String name, CategoryType type) {
        Category c = new Category();
        c.setName(name);
        c.setType(type);
        return c;
    }
}
