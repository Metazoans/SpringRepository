package com.example.demo.customer.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import jakarta.transaction.Transactional;

@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Test
	@DisplayName("고객등록")
//	@Transactional
//	@Rollback
	public void insert() {
		// give
		Customer customer = new Customer("홍길동", "010-1111-2222");
		
		// when
		customerRepository.save(customer);
		addressRepository.save(Address.builder()
									  .address("대구")
//									  .customer(customer)
									  .build());
		System.out.println("id : " + customer.getId());
		
		// then
		// 단건조회 결과와 비교
		Optional<Customer> result = customerRepository.findById(1L);
		assertThat(result.get().getName()).isEqualTo("Jack");
		
		Optional<Address> address = addressRepository.findById(1L);
		System.out.println("address : " + address);
	}
	
//	@Test
	@DisplayName("고객수정")
//	@Transactional
//	@Rollback
	public void update() {
		// give
		Customer customer = new Customer("홍길동", "010-1111-2222");
		customerRepository.save(customer);
		
		// when
		Optional<Customer> result = customerRepository.findById(1L);
		result.get().setPhone("2222-3333");
		customerRepository.save(result.get());
		
		// then
		// 단건조회 결과와 비교
		assertThat(result.get().getName()).isEqualTo("홍길동");
	}
	
//	@Test
	@DisplayName("이름검색")
	public void findByName() {
		String name = "%aaa%";
		String phone = "%2%";
		List<Customer> list = customerRepository.findByNameLikeOrPhoneLikeOrderByNameDesc(name, phone);
		
		System.out.println(list);
	}
	

//	@Test
	public void findById() {
		Long id = 1L;
		String phone = "%%";
		Optional<Customer> customer = customerRepository.findById(id, phone);
		System.out.println(customer.get());
	}
}
