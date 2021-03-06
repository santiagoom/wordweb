package com.learn.word.web;

import java.util.List;

public class Page<T> {

	private int pageNo;

	private List<T> list;

	private int pageSize = 10 ;

	private int totalItemNumber;

	public Page(int pageNo) {
		super();
		this.pageNo = pageNo;
	}

	public int getPageNo() {
		if(pageNo < 0){
			pageNo = 1;
		}
		
		if(pageNo > getTotalPageNumber()){
			pageNo  = getTotalPageNumber();
		}
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalPageNumber(){
		int totalPageNumber =  totalItemNumber/pageSize;
		if(totalItemNumber % pageSize != 0){
			totalPageNumber++;
		}
		
		return totalPageNumber;
	}
	
	public boolean isHasNext(){
		if(getPageNo() < getTotalPageNumber()){
			return true;
		}
		
		return false;
	}
	
	public boolean isHasPrev(){
		if(getPageNo() > 1){
			return true;
		}
		
		return false;
	}
	
	public int getNextPage(){
		if(isHasNext()){
			return getPageNo() + 1;
		}
		
		return getPageNo();
	}
	
	public int getPrevPage(){
		if(isHasPrev()){
			return getPageNo() - 1;
		}
		
		return getPageNo();
	}
	
	public int getTotalItemNumber() {
		return totalItemNumber;
	}

	public void setTotalItemNumber(int totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}

	
}
