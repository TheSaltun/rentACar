package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.model.CreateModelRequest;
import kodlama.io.rentACar.business.requests.model.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelResponse;
import kodlama.io.rentACar.business.responses.model.GetByIdModelResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.ModelRepository;
import kodlama.io.rentACar.entities.Model;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ModelManager implements ModelService{
	private ModelMapperService modelMapperService;
	private ModelRepository modelRepository;
	

	@Override
	public List<GetAllModelResponse> getAll() {
		List<Model> models = this.modelRepository.findAll();
		List<GetAllModelResponse> modelResponse = models.stream()
				.map(model -> this.modelMapperService.forResponse().map(models, GetAllModelResponse.class))
				.collect(Collectors.toList());

		return modelResponse;
	}

	@Override
	public GetByIdModelResponse getById(int id) {
		Model model = this.modelRepository.findById(id).orElseThrow();		
		GetByIdModelResponse response= this.modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
		return response;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model= this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}

	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
			Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}

}
