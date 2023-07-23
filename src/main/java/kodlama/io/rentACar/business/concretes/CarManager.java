package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.car.CreateCarRequest;
import kodlama.io.rentACar.business.requests.car.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.car.GetAllCarResponse;
import kodlama.io.rentACar.business.responses.car.GetByIdCarResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.CarRepository;
import kodlama.io.rentACar.entities.Car;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CarManager implements CarService {
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllCarResponse> getAll() {
		List<Car> cars = this.carRepository.findAll();
		List<GetAllCarResponse> carResponse = cars.stream()
				.map(car -> this.modelMapperService.forResponse().map(cars, GetAllCarResponse.class))
				.collect(Collectors.toList());

		return carResponse;
	}
	

	@Override
	public GetByIdCarResponse getById(int id) {
		Car car = this.carRepository.findById(id).orElseThrow();		
		GetByIdCarResponse response= this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);
		return response;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		Car car= this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carRepository.save(car);
		
	}

	@Override
	public void delete(int id) {
		this.carRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carRepository.save(car);
		
	}

}
