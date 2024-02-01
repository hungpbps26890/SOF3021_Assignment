package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.PaymentMethodDAO;

@Service
public class PaymentMethodServiceIpml implements PaymentMethodService {
	@Autowired
	PaymentMethodDAO paymentMethodDAO;
}
