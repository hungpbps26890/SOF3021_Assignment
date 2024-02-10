package com.poly.controller.admin;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Category;
import com.poly.entity.Report;
import com.poly.service.CategoryService;
import com.poly.service.ReportService;
import com.poly.utils.ExcelService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	boolean edit = false;

	@GetMapping("admin/report")
	public String getReportManagement(Model model,
			@Valid @ModelAttribute("report") Report report) {
		//model.addAttribute("reports", reportService.findByCreateDate());
		//model.addAttribute("reports", reportService.findByDay("2"));
		//model.addAttribute("reports", reportService.findByMonth("2"));
		model.addAttribute("reports", reportService.findByYear("2024"));
		return "admin/report-management";
	}

	@PostMapping("admin/report")
	public String postReportManagement(Model model, HttpServletRequest request,
			@RequestParam("day") String day,
			@RequestParam("month") String month,
			@RequestParam("year") String year) {
		StringBuilder date = new StringBuilder();
		date.append(day).append(" ").append(month).append(" ").append(year);
		
		if (!day.equals("0") && !month.equals("0") && !year.equals("0"))
			model.addAttribute("reports", reportService.findByDayAndMonthAndYear(day, month, year));
		else if (!month.equals("0") && !year.equals("0"))
			model.addAttribute("reports", reportService.findByMonthAndYear(month, year));
		else if (!year.equals("0"))
			model.addAttribute("reports", reportService.findByYear(year));
		else if (!month.equals("0"))
			model.addAttribute("reports", reportService.findByMonth(month));
		else if (!day.equals("0"))
			model.addAttribute("reports", reportService.findByDay(day));
		
		ExcelService.exportReportExcel(date.toString(), (List<Report>) model.getAttribute("reports"));

		return "admin/report-management";
	}
}
