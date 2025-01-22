package com.example.demo.customer.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;

@Getter
@Entity
//@Table(name = "cust")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@Column(name = "username", length = 50, nullable = false)
	private String name;
	
//	@Column(columnDefinition = "clob")
	private String phone;
	
//	@OneToOne
//	@JoinColumn(name = "address_id")
//	Address address;
	
//	@OneToMany(mappedBy = "address")
//	List<Address> address;
	
	@Transient
	private String addr;
	
	@Transient
	private String grade;

	public Customer() {}
	
	public Customer(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
