package ar.uba.service;

import java.util.Set;

import org.springframework.data.jpa.domain.Specification;

import ar.uba.domain.Category;
import ar.uba.domain.InterestingPoint;

public class InterestingPointPredicates {
	static Specification<InterestingPoint> inCategories(Set<Category> categories) {
		return categories.isEmpty() ? (root, query, builder) -> builder.and() :
				(root, query, builder) -> root.get("category").in(categories);
	}
	
	static Specification<InterestingPoint> isHidden(Boolean hidden) {
		return hidden == null ? (root, query, builder) -> builder.and() :
				(root, query, builder) -> builder.equal(root.get("hidden"), hidden);
	}
	
	static Specification<InterestingPoint> name(String name) {
		return name == null ? (root, query, builder) -> builder.and() :
				(root, query, builder) -> builder.like(root.get("hidden"), "%" + name.toLowerCase() + "%");
	}
}
