package com.poly.service;

import java.util.List;

import com.poly.entity.Report;

public interface ReportService {
	List<Report> findByCreateDate();
	List<Report> findByDay(String day);
	List<Report> findByMonth(String month);
	List<Report> findByYear(String year);
	List<Report> findByMonthAndYear(String month, String year);
	List<Report> findByDayAndMonthAndYear(String day, String month, String year);
}
