package com.hlx07.domain;

import java.util.ArrayList;

public class PageInfo {
	private int currentPageIndex;//��ǰҳ�������ֵ
	private int count;    //һҳ��Ӧ�÷ŵ�����
	private int pageCount; //�ܹ���ҳ��
	private int totalCount; //�ܹ��ļ�¼��
	private ArrayList<Student> students;
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}
	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
}
