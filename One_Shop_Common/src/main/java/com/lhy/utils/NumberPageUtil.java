package com.lhy.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NumberPageUtil implements Serializable {
	
	private Integer current;	//OK
	
	private Integer first;		//OK
	
	private Integer last;		//OK
	
	private Integer count;		//OK
	
	private Integer prev;		//OK
	
	private Integer next;		//OK
	
	private Integer pageSize;	//OK
	
	private Integer btnNum;	//OK
	
	private List<Integer> btnList = new ArrayList<Integer>();
	
	private List data;
	
	private List typeList;
	
	private List brandList;
	
	public NumberPageUtil(Integer current, Integer count, Integer pageSize, Integer btnNum) {
		System.out.println(current+"---"+count+"----"+pageSize+"----"+btnNum);
		this.current  = current;
		this.count = count;
		this.pageSize = pageSize;
		this.btnNum = btnNum;
		this.init();
		this.initBtn();
	}
	
	public NumberPageUtil() {
		
	}

	private void initBtn() {
		//当页数比按钮个数小的时候
		if(this.last<=this.btnNum) {
			for(int i=1;i<=this.last;i++) {
				this.btnList.add(i);
			}
			return;
		}
		
		//当页数大于按钮个数的时候
		//1.处理中间段
		Integer start = 1+this.btnNum/2;
		Integer stop = this.last-this.btnNum/2;
		if(this.current>=start && this.current<=stop) {
			for(int i=this.current-this.btnNum/2;i<=this.current+this.btnNum/2;i++) {
				this.btnList.add(i);
			}
			return;
		}
		
		//2.有可能在轴前
		if(this.current<start) {
			for(int i=1;i<=this.btnNum;i++) {
				this.btnList.add(i);
			}
			return;
		}
		
		//3.有可能在轴后
		if(this.current>stop) {
			for(int i=this.last-this.btnNum+1;i<=this.last;i++) {
				this.btnList.add(i);
			}
			return;
		}
	}

	private void init() {
		this.first = 1;
		this.last = count%pageSize == 0 ? count/pageSize : count/pageSize + 1;
		this.prev = this.current == 1 ? 1: this.current-1;
		this.next = this.current == this.last ? this.last:this.current + 1;
	}

	public Integer getCurrent() {
		return current;
	}

	public Integer getFirst() {
		return first;
	}

	public Integer getLast() {
		return last;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getPrev() {
		return prev;
	}

	public Integer getNext() {
		return next;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getBtnNum() {
		return btnNum;
	}

	public List<Integer> getBtnList() {
		return btnList;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public List getTypeList() {
		return typeList;
	}

	public void setTypeList(List typeList) {
		this.typeList = typeList;
	}

	public List getBrandList() {
		return brandList;
	}

	public void setBrandList(List brandList) {
		this.brandList = brandList;
	}
	
}
