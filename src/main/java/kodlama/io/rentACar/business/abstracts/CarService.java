package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.car.CreateCarRequest;
import kodlama.io.rentACar.business.requests.car.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.car.GetAllCarResponse;
import kodlama.io.rentACar.business.responses.car.GetByIdCarResponse;
@Service
public interface CarService {
	List<GetAllCarResponse> getAll();
	GetByIdCarResponse getById(int id);
	void add(CreateCarRequest createCarRequest);
	void delete(int id);
	void update(UpdateCarRequest updateCarRequest);

}
