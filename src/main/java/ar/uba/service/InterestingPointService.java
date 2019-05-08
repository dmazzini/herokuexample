package ar.uba.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ar.uba.domain.InterestingPoint;
import ar.uba.domain.InterestingPointFilterSpec;

@Service
public class InterestingPointService {
	@Autowired
	private InterestingPointRepository repository;
	
	public Collection<InterestingPoint> getAllInterestingPoints() {
		return getAllFilteredBy(InterestingPointFilterSpec.EMPTY);
	}
	
	public Collection<InterestingPoint> getAllFilteredBy(InterestingPointFilterSpec filterSpec) {
		return repository.findAll(getSpec(filterSpec));
	}
	
	public InterestingPoint save(InterestingPoint interestingPoint) {
		return repository.save(interestingPoint);
	}
	
	public InterestingPoint update(InterestingPoint interestingPoint) {
		Optional<InterestingPoint> point = repository.findById(interestingPoint.getId());
		if (point.isPresent()) {
			return repository.save(interestingPoint);
		}
		
		throw new RuntimeException("cannot find interesting point with id");
	}
	
	private Specification<InterestingPoint> getSpec(InterestingPointFilterSpec filterSpec) {
		return InterestingPointPredicates.isHidden(filterSpec.isHidden())
				.and(InterestingPointPredicates.inCategories(filterSpec.getCategories()))
				.and(InterestingPointPredicates.name(filterSpec.getName()));
	}
}
