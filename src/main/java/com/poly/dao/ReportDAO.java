package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Report;

public interface ReportDAO extends JpaRepository<Report, Integer> {
	@Query("SELECT new Report(o.createDate, count(o), sum(o.totalPrice)) "
			+ "FROM Order o "
			+ "GROUP BY o.createDate "
			+ "ORDER BY sum(o.totalPrice) DESC")
	Page<Report> findAll(Pageable pageable);
	
	@Query("SELECT new Report(o.createDate, count(o), sum(o.totalPrice)) "
			+ "FROM Order o "
			+ "WHERE day(o.createDate) = ?1 "
			+ "GROUP BY o.createDate "
			+ "ORDER BY sum(o.totalPrice) DESC")
	Page<Report> findByDay(String day, Pageable pageable);
	
	@Query("SELECT new Report(o.createDate, count(o), sum(o.totalPrice)) "
			+ "FROM Order o "
			+ "WHERE month(o.createDate) = ?1 "
			+ "GROUP BY o.createDate "
			+ "ORDER BY sum(o.totalPrice) DESC")
	Page<Report> findByMonth(String month, Pageable pageable);
	
	@Query("SELECT new Report(year(o.createDate), count(o), sum(o.totalPrice)) "
			+ "FROM Order o "
			+ "WHERE year(o.createDate) = ?1 "
			+ "GROUP BY year(o.createDate) "
			+ "ORDER BY sum(o.totalPrice) DESC")
	Page<Report> findByYear(String year, Pageable pageable);
	
	@Query("SELECT new Report(o.createDate, count(o), sum(o.totalPrice)) "
			+ "FROM Order o "
			+ "WHERE month(o.createDate) = ?1 AND year(o.createDate) = ?2 "
			+ "GROUP BY o.createDate "
			+ "ORDER BY sum(o.totalPrice) DESC")
	Page<Report> findByMonthAndYear(String month, String year, Pageable pageable);
	
	@Query("SELECT new Report(o.createDate, count(o), sum(o.totalPrice)) "
			+ "FROM Order o "
			+ "WHERE day(o.createDate) = ?1 AND month(o.createDate) = ?2 AND year(o.createDate) = ?3 "
			+ "GROUP BY o.createDate "
			+ "ORDER BY sum(o.totalPrice) DESC")
	Page<Report> findByDayAndMonthAndYear(String day, String month, String year, Pageable pageable);
}
