package com.poly.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poly.entity.Report;

public interface ReportService {
	Page<Report> findByCreateDate(LocalDate localDate, boolean paymentStatus, Pageable pageable);
	Page<Report> findAll(boolean paymentStatus, Pageable pageable);
	Page<Report> findByDay(String day, boolean paymentStatus, Pageable pageable);
	Page<Report> findByMonth(String month, boolean paymentStatus, Pageable pageable);
	Page<Report> findByYear(String year, boolean paymentStatus, Pageable pageable);
	Page<Report> findByMonthAndYear(String month, String year, boolean paymentStatus, Pageable pageable);
	Page<Report> findByDayAndMonthAndYear(String day, String month, String year, boolean paymentStatus, Pageable pageable);
	Page<Report> findByDrink(boolean paymentStatus, Pageable pageable);
	Page<Report> findByDrink(LocalDate fromDate, LocalDate toDate, boolean paymentStatus, Pageable pageable);
}
