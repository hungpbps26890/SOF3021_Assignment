package com.poly.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poly.dao.ReportDAO;
import com.poly.entity.Report;
import com.poly.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	ReportDAO reportDAO;
	
	@Override
	public Page<Report> findByCreateDate(LocalDate localDate, boolean paymentStatus, Pageable pageable) {
		return reportDAO.findByCreateDate(localDate, paymentStatus, pageable);
	}
	
	@Override
	public Page<Report> findAll(boolean paymentStatus, Pageable pageable) {
		return reportDAO.findAll(paymentStatus, pageable);
	}

	@Override
	public Page<Report> findByDay(String day, boolean paymentStatus, Pageable pageable) {
		return reportDAO.findByDay(day, paymentStatus, pageable);
	}

	@Override
	public Page<Report> findByMonth(String month, boolean paymentStatus, Pageable pageable) {
		return reportDAO.findByMonth(month, paymentStatus, pageable);
	}

	@Override
	public Page<Report> findByYear(String year, boolean paymentStatus, Pageable pageable) {
		return reportDAO.findByYear(year, paymentStatus, pageable);
	}

	@Override
	public Page<Report> findByMonthAndYear(String month, String year, boolean paymentStatus, Pageable pageable) {
		return reportDAO.findByMonthAndYear(month, year, paymentStatus, pageable);
	}

	@Override
	public Page<Report> findByDayAndMonthAndYear(String day, String month, String year, boolean paymentStatus, Pageable pageable) {
		return reportDAO.findByDayAndMonthAndYear(day, month, year, paymentStatus, pageable);
	}
	
	@Override
	public Page<Report> findByDrink(boolean paymentStatus, Pageable pageable) {
		return reportDAO.findByDrink(paymentStatus, pageable);
	}
	
	@Override
	public Page<Report> findByDrink(LocalDate fromDate, LocalDate toDate, boolean paymentStatus, Pageable pageable) {
		return reportDAO.findByDrink(fromDate, toDate, paymentStatus, pageable);
	}

}
