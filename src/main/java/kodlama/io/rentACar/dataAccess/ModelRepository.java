package kodlama.io.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

}
