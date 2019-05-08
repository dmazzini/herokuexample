package ar.uba.service;

import ar.uba.domain.InterestingPoint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestingPointRepository extends JpaRepository<InterestingPoint, Integer>, JpaSpecificationExecutor<InterestingPoint> {
}
