package org.teca.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdminInformation {

	@Id
	private int adminid;
	private String adminname;
	private String adminemailid;
	private String adminpassword;
}
