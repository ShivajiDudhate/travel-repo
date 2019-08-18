package com.travel.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Route {
	
@Id
@GeneratedValue
@Column(name ="Route_Id")
private Integer Id;

@Column(name ="Route_Name", unique = true)
private String name;

@Column(name ="satrt_Point")
private String satrtPoint;

@Column(name ="end_Point")
private String endPoint;

public Integer getId() {
	return Id;
}

public void setId(Integer id) {
	Id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSatrtPoint() {
	return satrtPoint;
}

public void setSatrtPoint(String satrtPoint) {
	this.satrtPoint = satrtPoint;
}

public String getEndPoint() {
	return endPoint;
}

public void setEndPoint(String endPoint) {
	this.endPoint = endPoint;
}

@Override
public String toString() {
	return "Route [Id=" + Id + ", name=" + name + ", satrtPoint=" + satrtPoint + ", endPoint=" + endPoint
			+ "]";
}

}
