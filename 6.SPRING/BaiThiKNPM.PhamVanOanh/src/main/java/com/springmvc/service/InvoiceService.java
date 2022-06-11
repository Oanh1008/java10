package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.InvoiceDao;
import com.springmvc.entity.Invoice;

@Service
public class InvoiceService {
	@Autowired
	private InvoiceDao invoiceDao;
	

	@Transactional
	public List<Invoice> getAll(int offset,int rowcount) {
		return invoiceDao.getAll(offset,rowcount);
	}


	@Transactional
	public int countTotalRecords() {
		return invoiceDao.countTotalRecords();
	}


	@Transactional
	public void save(Invoice invoice) {
		invoiceDao.save(invoice);
		
	}


	@Transactional
	public Invoice get(int id) {
		// TODO Auto-generated method stub
		return invoiceDao.get(id);
	}


	@Transactional
	public void delete(int id) {
		invoiceDao.delete(id);
		
	}
}
