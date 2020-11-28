package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "CONTACTS_MASTER")
public class ContactsMasterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTACT_ID")
	private Integer id;
	
	@Column(name = "CONTACT_NAME")
	private String contactName;

	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;

	@Column(name = "CONTACT_STATUS")
	private Integer contactStatus;

}
