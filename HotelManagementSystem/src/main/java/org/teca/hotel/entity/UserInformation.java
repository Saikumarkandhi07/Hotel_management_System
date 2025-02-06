package org.teca.hotel.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name="User_First_Name")
	private String firstname;
	@Column(name="User_Last_Name")
	private String lastname;
	@Column(name="User_Email_Id",unique = true,nullable = false)
	private String emailid;
	@Column(name="User_Password",unique = true,nullable = false)
	private String password;
	@Column(name="Date_Of_Birth")
	private LocalDate dateofbirth;
	@Column(name="Mobile_Number",unique = true,nullable = false,length = 10)
	private String mobilenumber;
	@Column(name="User_Gender")
	private String gender;
	
}
