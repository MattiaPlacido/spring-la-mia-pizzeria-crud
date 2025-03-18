package org.lessons.java.spring_la_mia_pizzeria_crud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pizzas")
public class Pizza {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "The name must no be null, empty or blank.")
	private String name;

	@Lob
	@NotBlank(message = "The description must no be null, empty or blank.")
	private String description;

	private String photoUrl;

	@NotNull
	@DecimalMin(value = "0.1", message = "Price must be greater than 0")
	private Double price;

	// Getters and setters
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String value) {
		this.photoUrl = value;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double value) {
		this.price = value;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}

	@Override
	public String toString() {
		return String.format("%s : %s, %f $ ", name, description, price);
	}

}
