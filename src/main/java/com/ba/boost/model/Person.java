package com.ba.boost.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * id,first_name,last_name,email,gender,birthday
 */

@Entity
@Table(name = "persons")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	
	@Id
	private Long id;
	@Column(name = "first_name", length = 100, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 100, nullable = false)
	private String lastName;
	@Column(name = "email", length = 150, nullable = false)
	private String email;
	@Column(name = "gender", length = 50, nullable = false)
	private String gender;
	@Column(name = "birthday", length = 50, nullable = false)
	private Date birthday;
	
	
	

}
