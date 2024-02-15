package com.poly.controller.admin;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Category;
import com.poly.entity.Report;
import com.poly.service.CategoryService;
import com.poly.service.ReportService;
import com.poly.utils.ExcelService;
import com.poly.utils.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class ReportController {
	
	@Autowired
	ReportService reportService;
	@Autowired
	SessionService session;
	
	Pageable pageable = PageRequest.of(0, 1);
	
	@RequestMapping("admin/report/index")
	public String index() {
		return "admin/report-management";
	}
	
	@RequestMapping("admin/report")
	public String get(Model model) {
		model.addAttribute("pages", reportService.findByCreateDate(pageable));
		return "admin/report-management";
	}

	@PostMapping("admin/report/search")
	public String search(Model model, HttpServletRequest request,
			@RequestParam("day") String day,
			@RequestParam("month") String month,
			@RequestParam("year") String year) {
		StringBuilder date = new StringBuilder();
		date.append(day).append(" ").append(month).append(" ").append(year);
		
		if (!day.equals("0") && !month.equals("0") && !year.equals("0"))
			model.addAttribute("pages", reportService.findByDayAndMonthAndYear(day, month, year, pageable));
		else if (!month.equals("0") && !year.equals("0"))
			model.addAttribute("pages", reportService.findByMonthAndYear(month, year, pageable));
		else if (!year.equals("0"))
			model.addAttribute("pages", reportService.findByYear(year, pageable));
		else if (!month.equals("0"))
			model.addAttribute("pages", reportService.findByMonth(month, pageable));
		else if (!day.equals("0"))
			model.addAttribute("pages", reportService.findByDay(day, pageable));
		
		ExcelService.exportReportExcel(date.toString(), (List<Report>) model.getAttribute("reports"));
		
		session.setAttribute("day", day);
		session.setAttribute("month", month);
		session.setAttribute("year", year);
		return "forward:/admin/report/index";
	}
	
	@GetMapping("admin/report/page")
	public String page(Model model,
			@RequestParam("p") Optional<Integer> p) {
		String day = session.getAttribute("day");
		String month = session.getAttribute("month");
		String year = session.getAttribute("year");
		pageable = PageRequest.of(p.orElse(0), 1);
		
		if (day == null && month == null && year == null)
			model.addAttribute("pages", reportService.findByCreateDate(pageable));
		else {
			if (!day.equals("0") && !month.equals("0") && !year.equals("0"))
				model.addAttribute("pages", reportService.findByDayAndMonthAndYear(day, month, year, pageable));
			else if (!month.equals("0") && !year.equals("0"))
				model.addAttribute("pages", reportService.findByMonthAndYear(month, year, pageable));
			else if (!year.equals("0"))
				model.addAttribute("pages", reportService.findByYear(year, pageable));
			else if (!month.equals("0"))
				model.addAttribute("pages", reportService.findByMonth(month, pageable));
			else if (!day.equals("0"))
				model.addAttribute("pages", reportService.findByDay(day, pageable));
		}
		
		return "forward:/admin/report/index";
	}
	
	@PostMapping("admin/report/print")
	public String printExcel(Model model, HttpServletRequest request) {
		List<Report> reports = null;
		pageable = PageRequest.of(0, 1);
		String day = session.getAttribute("day");
		String month = session.getAttribute("month");
		String year = session.getAttribute("year");
		StringBuilder date = new StringBuilder();
		date.append(day).append(" ").append(month).append(" ").append(year);
		
		if (day == null && month == null && year == null) {
			reports = reportService.findByCreateDate(pageable).getContent();
			date = new StringBuilder();
			Date d = new Date();
			date.append(d.getDate()).append(d.getMonth()).append(d.getYear());
		} else {
			if (!day.equals("0") && !month.equals("0") && !year.equals("0"))
				reports = reportService.findByDayAndMonthAndYear(day, month, year, pageable).getContent();
			else if (!month.equals("0") && !year.equals("0"))
				reports = reportService.findByMonthAndYear(month, year, pageable).getContent();
			else if (!year.equals("0"))
				reports = reportService.findByYear(year, pageable).getContent();
			else if (!month.equals("0"))
				reports = reportService.findByMonth(month, pageable).getContent();
			else if (!day.equals("0"))
				reports = reportService.findByDay(day, pageable).getContent();
		}
			
		
		ExcelService.exportReportExcel(date.toString(), reportService.findByCreateDate(pageable).getContent());
		return "forward:/admin/report";
	}
}
