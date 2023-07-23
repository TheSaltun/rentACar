package kodlama.io.rentACar.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cars")
public class Car {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="plate")
	private String plate;
	
	@Column(name="modelYear")
	private int modelYear;
	
	@Column(name="state")
	private int state;
	
	@Column(name="dailyPrice")
	private int dailyPrice;
	
	
	@ManyToOne
	@JoinColumn(name="model_id")
	private Model model;

}
