package kodlama.io.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.rentACar.entities.Brand;
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
	boolean existsByName(String name);

}
