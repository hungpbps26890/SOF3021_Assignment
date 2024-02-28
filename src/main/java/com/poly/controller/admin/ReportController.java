package com.poly.controller.admin;

import java.net.http.HttpRequest;
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
import com.poly.model.CreateDate;
import com.poly.service.CategoryService;
import com.poly.service.OrderService;
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
	OrderService orderService;
	@Autowired
	SessionService session;
	
	Pageable pageable = PageRequest.of(0, 10);
	
	@RequestMapping("/admin/report/index")
	public String index(Model model) {
		
		List<String> days = orderService.findDays();
		List<String> months = orderService.findMonths();
		List<String> years = orderService.findYears();
		
		model.addAttribute("days", days);
		model.addAttribute("months", months);
		model.addAttribute("years", years);
		
		return "admin/report-management";
	}
	
	@RequestMapping("/admin/report")
	public String get(Model model, @ModelAttribute("createDate") CreateDate cd) {
		model.addAttribute("pages", reportService.findAll(pageable));
		model.addAttribute("printExcel", false);
		return "forward:/admin/report/index";
	}

	@PostMapping("/admin/report/search")
	public String search(Model model, HttpServletRequest request,
			@ModelAttribute("createDate") CreateDate createDate) {
		
		String day = createDate.getDay();
		String month = createDate.getMonth();
		String year = createDate.getYear();
		StringBuilder date = new StringBuilder();
		date.append(day).append(" ").append(month).append(" ").append(year);
		
		if (day.equals("0") && month.equals("0") && year.equals("0"))
			model.addAttribute("pages", reportService.findAll(pageable));
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
		
		Page<Report> pages = (Page<Report>) model.getAttribute("pages");
		
		ExcelService.exportReportExcel(date.toString(), pages.getContent());
		
		session.setAttribute("day", day);
		session.setAttribute("month", month);
		session.setAttribute("year", year);
		
		
		model.addAttribute("printExcel", true);
		return "forward:/admin/report/index";
	}
	
	@GetMapping("/admin/report/page")
	public String page(Model model, @ModelAttribute("createDate") CreateDate createDate,
			@RequestParam("p") Optional<Integer> p) {
		String day = session.getAttribute("day");
		String month = session.getAttribute("month");
		String year = session.getAttribute("year");
		pageable = PageRequest.of(p.orElse(0), 10);
		
		if (day == null && month == null && year == null)
			model.addAttribute("pages", reportService.findAll(pageable));
		else if (day.equals("0") && month.equals("0") && year.equals("0"))
			model.addAttribute("pages", reportService.findAll(pageable));
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
	
}
