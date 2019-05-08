package ar.uba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.uba.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

    @GetMapping("/categories")
    public String categories(Model model) {
    	model.addAttribute("categories", categoryService.getAllCategories());
    	
        return "categories";
    }   
}