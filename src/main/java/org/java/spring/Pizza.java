package org.java.spring;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Il nome è obbligatorio")
	@Length(min = 3, max = 255, message = "Il nome deve essere più lungo di 3 caratteri e massimo 255")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message = "La descrizione è obbligatorio")
	@Column(columnDefinition = "TEXT", nullable = false)
	private String description;
	
	@Column(columnDefinition = "TEXT")
	private String photo;
	
	@NotNull(message = "Il prezzo è obbligatorio")
	@Positive(message = "Il prezzo deve essere superiore a zero")
	@Column(nullable = false)
	private float price;
	
	
	public Pizza() {}
	
	public Pizza(String name, String description, String photo, float price) {
		setName(name);
		setDescription(description);
		setPhoto(photo);
		setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
