package com.spring.rest.model;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue
	private UUID orderId;
	
	@Column(nullable = false)
	private String orderType;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private double deliveryChrgs;
	
	@Column(nullable = false)
	private long phone;
	
	@Column(nullable = false)
	private long altPhone;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	@JsonIgnoreProperties({"orders","hibernateLazyInitializer", "handler"})
	private Address address;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties({"orders","hibernateLazyInitializer", "handler"})
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn( name = "product_id" )
	@JsonIgnoreProperties({"orders","hibernateLazyInitializer", "handler"})
	private Product product;
}
