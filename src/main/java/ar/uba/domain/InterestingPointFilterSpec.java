package ar.uba.domain;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class InterestingPointFilterSpec {
	public static final InterestingPointFilterSpec EMPTY = new InterestingPointFilterSpec(null, null, null);
	
	private final Boolean hidden;
	private final Set<Category> categories;
	private final String name;
	
	public InterestingPointFilterSpec(Boolean hidden, Set<Category> categories, String name) {
		this.hidden = hidden;
		this.categories = categories == null ? ImmutableSet.of() : ImmutableSet.copyOf(categories);
		this.name = name;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public Boolean isHidden() {
		return hidden;
	}

	public String getName() {
		return name;
	}
}
