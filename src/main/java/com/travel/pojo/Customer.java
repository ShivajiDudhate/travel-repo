package com.travel.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
    @GeneratedValue
	@Column (name ="Customer_Id")
	private Integer id;
	@Column(name ="customer_Name")
	private String customerName;
	
	@Column(name ="Customer_Type")
	private String customerType;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Route favRoute;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Route getFavRoute() {
		return favRoute;
	}

	public void setFavRoute(Route favRoute) {
		this.favRoute = favRoute;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerType=" + customerType
				+ ", favRoute=" + favRoute + "]";
	}
	
	
}
