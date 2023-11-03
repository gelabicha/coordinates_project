package ge.coordinates.coordinatesproject.repository;

import ge.coordinates.coordinatesproject.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate,Integer> {
}
