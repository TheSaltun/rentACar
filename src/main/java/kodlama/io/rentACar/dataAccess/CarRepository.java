package kodlama.io.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
