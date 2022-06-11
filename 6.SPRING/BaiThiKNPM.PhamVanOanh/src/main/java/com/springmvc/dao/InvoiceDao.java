package com.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.Invoice;

@Repository
public class InvoiceDao {
	@Autowired
	private SessionFactory sessionFactory;

	public int countTotalRecords() {    // đếm số dòng dữ liệu trong bảng Hóa đơn, phục vụ cho việc phân trang
		Session session = sessionFactory.getCurrentSession();
		final String sql="select count(*) totalRecords from hoadon";
		return (int) session.createNativeQuery(sql)
							.addScalar("totalRecords",IntegerType.INSTANCE)
							.getSingleResult();
	}
	
	public List<Invoice> getAll(int offset, int rowcount) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * FROM hoadon LIMIT :offset, :rowcount", Invoice.class)
				  .setParameter("offset", offset)
				  .setParameter("rowcount", rowcount)
			      .getResultList();
	}

	public void save(Invoice invoice) { // Thêm 1 hóa đơn mới
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(invoice);
	}
	
	public Invoice get(int id) {    // lấy ra một hóa đơn bất kỳ theo Id
		Session session = sessionFactory.getCurrentSession();
		return session.get(Invoice.class, id);
		
	}
	public void delete(int id) {   // delete hóa đơn theo id
		Session session = sessionFactory.getCurrentSession();
		session.createNativeQuery("delete from hoadon where SoHoaDon=:id").setParameter("id", id).executeUpdate();
	}
}
