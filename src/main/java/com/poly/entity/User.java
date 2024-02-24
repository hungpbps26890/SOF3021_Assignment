package com.poly.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@Column(columnDefinition = "varchar(100)")
	@NotEmpty(message = "{NotEmpty.user.username}")
	private String username;

	@NotEmpty(message = "{NotEmpty.user.password}")
	private String password;

	@Column(name = "first_name", columnDefinition = "nvarchar(15)")
	@NotEmpty(message = "{NotEmpty.user.firstName}")
	private String firstName;

	@Column(name = "last_name", columnDefinition = "nvarchar(50)")
	@NotEmpty(message = "{NotEmpty.user.lastName}")
	private String lastName;

	@Column(name = "phone_number", columnDefinition = "varchar(50)")
	@NotEmpty(message = "{NotEmpty.user.phoneNumber}")
	private String phoneNumber;

	@Column(columnDefinition = "varchar(150)")
	@NotEmpty(message = "{NotEmpty.user.email}")
	@Email(message = "{Email.user.email}")
	private String email;

	@NotNull(message = "{NotNull.user.admin}")
	private Boolean admin = false;

	@NotNull(message = "{NotNull.user.active}")
	private Boolean active = true;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<UserAddress> userAddresses;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Order> orders;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private ShoppingCart cart;

}
