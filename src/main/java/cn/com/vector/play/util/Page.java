package cn.com.vector.play.util;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Page<T> implements Serializable {
	private static final long serialVersionUID = 9027588550147287672L;
	
	private int pageSize = 20;	//分页大小
	private int currentPageNo = 1;	//当前页
	private int totalRecord;	//总页数
	private List<T> result;		//返回对象
	
	/**
	 * 获取总页数
	 * 
	 * @return int
	 */
	public int getTotalPage() {
		int totalPage = 0;
		if (this.getTotalRecord() % this.pageSize == 0) {
			totalPage = this.getTotalRecord() / this.pageSize;
		} else {
			totalPage = this.getTotalRecord() / this.pageSize + 1;
		}
		return totalPage;
	}
	
	
	/**
	 * 获取上一页
	 * 
	 * @return int
	 */
	public int getPrevPageNo() {
		int prevPageNo = 0;
		if (this.currentPageNo == 1) {
			prevPageNo = this.currentPageNo;
		} else {
			prevPageNo = this.currentPageNo - 1;
		}
		return prevPageNo;
	}
	
	/**
	 * 获取下一页
	 * 
	 * @return
	 */
	public int getNextPageNo() {
		int nextPageNo = 0;
		if (this.currentPageNo == this.getLastPageNo()) {
			nextPageNo = this.currentPageNo;
		} else {
			nextPageNo = this.currentPageNo + 1;
		}
		return nextPageNo;
	}
	
	/**
	 * 获取最后一页
	 * 
	 * @return
	 */
	public int getLastPageNo() {
		int lastPage = 0;
		if (this.getTotalRecord() % this.pageSize == 0) {
			lastPage = this.getTotalRecord() / this.pageSize;
		} else {
			lastPage = (this.getTotalRecord() / this.pageSize) + 1;
		}
		return lastPage;
	}
}
