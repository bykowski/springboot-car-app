package pl.bykowski.springbootcarapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bykowski.springbootcarapp.model.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
}
