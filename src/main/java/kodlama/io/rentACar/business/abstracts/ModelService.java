package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.model.CreateModelRequest;
import kodlama.io.rentACar.business.requests.model.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelResponse;
import kodlama.io.rentACar.business.responses.model.GetByIdModelResponse;
@Service
public interface ModelService {
	List<GetAllModelResponse> getAll();
	GetByIdModelResponse getById(int id);
	void add(CreateModelRequest createModelRequest);
	void delete(int id);
	void update(UpdateModelRequest updateModelRequest);

}
