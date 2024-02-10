package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.ReportDAO;
import com.poly.entity.Report;
import com.poly.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	ReportDAO reportDAO;
	
	@Override
	public List<Report> findByCreateDate() {
		return reportDAO.findByCreateDate();
	}

	@Override
	public List<Report> findByDay(String day) {
		return reportDAO.findByDay(day);
	}

	@Override
	public List<Report> findByMonth(String month) {
		return reportDAO.findByMonth(month);
	}

	@Override
	public List<Report> findByYear(String year) {
		return reportDAO.findByYear(year);
	}

	@Override
	public List<Report> findByMonthAndYear(String month, String year) {
		return reportDAO.findByMonthAndYear(month, year);
	}

	@Override
	public List<Report> findByDayAndMonthAndYear(String day, String month, String year) {
		return reportDAO.findByDayAndMonthAndYear(day, month, year);
	}

}
