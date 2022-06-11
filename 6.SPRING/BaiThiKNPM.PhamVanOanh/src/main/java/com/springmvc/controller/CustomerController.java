package com.springmvc.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.common.Application;
import com.springmvc.entity.Invoice;
import com.springmvc.service.InvoiceService;

@Controller
@RequestMapping("hoadon")
public class CustomerController {
	@Autowired
	private InvoiceService invoiceService;
	@GetMapping
	public String index(ModelMap modelMap, 
			@RequestParam(name = "page",defaultValue = "1") int page,
			@RequestParam(name = "text",defaultValue = "") String text) {
		int totalRecords= invoiceService.countTotalRecords();
		System.out.println(totalRecords);
		int totalPages=(int)Math.ceil((float) totalRecords / Application.RECORDS_PER_PAGE);
		page=page<1?1:page;
		page=page>totalPages?totalPages:page;
		int offset=(page-1)*Application.RECORDS_PER_PAGE;
		
		
		// pagination and search current page
		List<Invoice> invoices= invoiceService.getAll(offset, Application.RECORDS_PER_PAGE);
		invoices.forEach(System.out::println);
		if(!text.trim().isEmpty()) {
			invoices=invoices.stream().filter(invoice->{
				return invoice.getNguoiLap().toLowerCase().contains(text);	
			}).collect(Collectors.toList());
		}
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("totalPages",totalPages);
		modelMap.addAttribute("invoices",invoices);
		return Application.INVOICE_INDEX_PAGE;
	}
	@GetMapping("/add")
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("invoice", new Invoice());
		return Application.INVOICE_FORM_PAGE;
	}
	@GetMapping("/update")
	public String update(ModelMap modelMap,
			@RequestParam("id") int id) {
		Invoice invoice=invoiceService.get(id);
		modelMap.addAttribute("invoice", invoice);
		return Application.INVOICE_FORM_PAGE;
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Invoice invoice) { // get customer

		invoiceService.save(invoice);
		// redirect == ${contextPath}
		return Application.INVOICE_REDIRECT;
	}
	@GetMapping("/delete")
	public String delete(ModelMap modelMap,
			@RequestParam("id") int id) {
		invoiceService.delete(id);
		return Application.INVOICE_REDIRECT;
	}
}
