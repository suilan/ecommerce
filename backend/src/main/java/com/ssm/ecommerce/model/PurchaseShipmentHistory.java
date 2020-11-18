package com.ssm.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the purchase_shipment_history database table.
 * 
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="purchase_shipment_history")
@NamedQuery(name="PurchaseShipmentHistory.findAll", query="SELECT p FROM PurchaseShipmentHistory p")
public class PurchaseShipmentHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to Purchase
	@ManyToOne
	private Purchase purchase;

	//bi-directional many-to-one association to Shipment
	@ManyToOne
	private Shipment shipment;

	//bi-directional many-to-one association to ShipmentState
	@ManyToOne
	@JoinColumn(name="shipment_state_id")
	private ShipmentState shipmentState;
}