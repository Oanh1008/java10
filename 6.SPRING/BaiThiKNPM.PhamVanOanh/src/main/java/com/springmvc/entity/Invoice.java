package com.springmvc.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;
@Entity
@Table(name = "hoadon")
public class Invoice {
	@Id
	@Column(name = "SoHoaDon")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer soHoaDon;
	
	@Column(name="NgayLap")
	private String ngayLap;
	
	@Column(name="VAT")
	private int VAT;
	
	@Column(name="NguoiLap")
	private String nguoiLap;
	
	@Column(name="TongTien")
	private Integer tongTien;

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getSoHoaDon() {
		return soHoaDon;
	}

	public void setSoHoaDon(Integer soHoaDon) {
		this.soHoaDon = soHoaDon;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	public int getVAT() {
		return VAT;
	}

	public void setVAT(int vAT) {
		VAT = vAT;
	}

	public String getNguoiLap() {
		return nguoiLap;
	}

	public void setNguoiLap(String nguoiLap) {
		this.nguoiLap = nguoiLap;
	}

	public Integer getTongTien() {
		return tongTien;
	}

	public void setTongTien(Integer tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
		return "Invoice [soHoaDon=" + soHoaDon + ", ngayLap=" + ngayLap + ", VAT=" + VAT + ", nguoiLap=" + nguoiLap
				+ ", tongTien=" + tongTien + "]";
	}

	
	
}
