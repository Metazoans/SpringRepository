package com.example.demo.insa.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDTO {
	@NotNull
	private int employeeId;
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@Email
	private String email;
	private String phoneNumber;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	@NotNull
	private String jobId;
	private String jobTitle;
	private Long salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
}
