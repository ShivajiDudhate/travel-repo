package com.travel.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class Journey {
	
	@Id
	@GeneratedValue
	@Column(name ="Journey_id")
	private Integer id;
	
	@Column(name ="Customer_Id")
	private Integer customerId;
	
	@Column(name ="Journey_Start_Time")
	@CreationTimestamp
	private LocalDate startTime;
	
	@Column(name ="Journey_Route_name")
	private String routeName;
	
	@Column(name ="Journey_Price")
	private BigDecimal jurneyPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public BigDecimal getJurneyPrice() {
		return jurneyPrice;
	}

	public void setJurneyPrice(BigDecimal jurneyPrice) {
		this.jurneyPrice = jurneyPrice;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Journey [id=" + id + ", customerId=" + customerId + ", startTime=" + startTime + ", routeName="
				+ routeName + ", jurneyPrice=" + jurneyPrice + "]";
	}

	
}