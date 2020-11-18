package com.ssm.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the purchase_product database table.
 * 
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="purchase_product")
@NamedQuery(name="PurchaseProduct.findAll", query="SELECT p FROM PurchaseProduct p")
public class PurchaseProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private Long id;

	@Column(name="created_at")
	@CreationTimestamp
	private Timestamp createdAt;

	private int total;

	@Column(name="updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

//	//bi-directional many-to-one association to Purchase
//	@ManyToOne
//	private Purchase purchase;
	@Column(name="purchase_id")
	private Long purchaseId;
}