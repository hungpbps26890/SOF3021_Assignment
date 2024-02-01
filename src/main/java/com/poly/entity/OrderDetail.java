package com.poly.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order_details", uniqueConstraints = { @UniqueConstraint(columnNames = { "drink_id", "order_id" }) })
public class OrderDetail implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "{NotNull.orderDetail.quantity}")
	@Positive(message = "{Positive.orderDetail.quantity}")
	private Integer quantity;
	
	@NotNull(message = "{NotNull.orderDetail.price}")
	@Positive(message = "{Positive.orderDetail.price}")
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "drink_id")
	Drink drink;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	Order order;

}
