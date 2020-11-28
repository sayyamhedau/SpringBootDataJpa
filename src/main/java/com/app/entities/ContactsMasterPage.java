package com.app.entities;

import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

@Data
public class ContactsMasterPage {
	private int pageNo = 0;
	private int pageSize = 7;
	private Direction byDirection = Direction.DESC;
	private String sortby = "id";
}
