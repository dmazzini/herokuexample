package ar.uba.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.uba.domain.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	
	public Collection<Category> getAllCategories() {
		return repository.findAll();
	}
	
	public Collection<Category> getAllCategoriesByHidden(boolean hidden) {
		return repository.findAllByHidden(hidden);
	}
	
	public Category save(Category cat) {
		return repository.save(cat);
	}
	
	public Category update(Category category) {
		Optional<Category> existingCategory = repository.findById(category.getId());
		if (existingCategory.isPresent()) {
			return repository.save(category);
		}
		
		throw new RuntimeException("cannot find category with id");
	}
}
