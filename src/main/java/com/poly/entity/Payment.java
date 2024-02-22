package com.poly.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Payment implements Serializable{
	private String status;
	private String message;
	private String URL;
}
