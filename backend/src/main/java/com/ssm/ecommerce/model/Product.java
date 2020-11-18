package com.ssm.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String name;
	private String description;

	private Double price;

	@Column(name="quantity_available")
	private int quantityAvailable;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private Category category;

	//bi-directional many-to-one association to Unit
	@ManyToOne
	private Unit unit;

	@Column(name="image_url")
	private String imageUrl;
//	@OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
//	@JoinColumn(name="product_id")
//	private List<ProductImage> productImages;

}