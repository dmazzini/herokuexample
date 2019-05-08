package ar.uba.service;

import ar.uba.domain.Category;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Collection<Category> findAllByHidden(boolean hidden);
}
