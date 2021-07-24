package com.universal.rest.webservices.filtered;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

//Static Filtering
//@JsonIgnoreProperties(value= {"data1", "data2"})  //Alternate way to achieve filtering 
//The above code will eliminate data1 and data2 from the Json response

@JsonFilter("SomeBeanFilter") // Annotation for dynamic filtering
public class SomeBean {

	private String data1;
	private String data2;

	@JsonIgnore // This annotation will eliminate the field which follows from Json Response
	private String data3;

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public String getData3() {
		return data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
	}

	public SomeBean(String data1, String data2, String data3) {
		super();
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
	}

}
