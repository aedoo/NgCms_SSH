package com.inspur.common.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.inspur.common.entity.PaginationBean;

/**
 * ǰ��ҳ�Ĺ�ͨ���
 * 
 * @author Administrator
 * 
 */
public abstract class PageAction extends BaseAction implements
		ServletRequestAware, ServletContextAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;

	/**
	 * ��ҳ���ݴ洢��bean
	 */
	private PaginationBean pageBean=new PaginationBean();

	/**
	 * PageBean��get/set����
	 * 
	 * @return
	 */
	public PaginationBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PaginationBean pageBean) {
		this.pageBean = pageBean;
	}

	/**
	 * ��ʾ��һҳ���ݣ�Ĭ��һҳ��ʾ�ļ�¼����Ϊ10
	 * 
	 * @return
	 * @throws Exception
	 */
	public String openList() {
		//����session�е�pageBEAN
		PaginationBean pageBean=(PaginationBean)session.getAttribute("pageBean");
		this.setPageBean(pageBean);
		
		this.getPageBean().setStartPage(1);// ��һҳ
		this.getPageBean().setStart(1);// ���ñ�ҳ�Ŀ�ʼ��¼��

		// ���м������õ�һ��������
		List<?> list = getListByPage(this.getPageBean().getStart(), this
				.getPageBean().getPageSize(),  this
				.getPageBean().getPropertyMap());
		this.getPageBean().setList(list);
		// �õ��ܼ���
		long totalCount = getTotalCount(this.getPageBean().getPropertyMap());
		this.getPageBean().setTotalCount(totalCount);
		// �õ���ҳ��
		int pageCount = getPageCount();
		this.getPageBean().setTotalPage(pageCount);
		// ���ñ�ҳ������¼��
		this.getPageBean().setLastRecordNo(getLastRecordNo());
		// ����ǰ��ҳ�Ŀ�����,��һҳ������,ǰ��ҳ������
		// this.getPageBean().setIs_prev(true);
		// ���ú�ҳ�Ŀ����ԣ�����ǵ�һҳ�����
		// this.getPageBean().setIs_next(false);
		session.setAttribute("pageBean", pageBean);
		return "list";
	}

	/**
	 * ��ҳ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String nextPage() {
		//����session�е�pageBEAN
	    pageBean=(PaginationBean)session.getAttribute("pageBean");
		this.setPageBean(pageBean);
		
		int pageCount = getPageCount();// ��ҳ��
		int startPage = this.getPageBean().getStartPage();// ��ǰҳ��

		// �������ҳ
		if (startPage + 1 <= pageCount) {
			int beforePageLastNo = this.getPageBean().getLastRecordNo();// �õ�ǰһҳ������¼��
			this.getPageBean().setStart(beforePageLastNo + 1);// ���ñ�ҳ�Ŀ�ʼ��¼��:ǰһҳ�ļ�¼��+1

			this.getPageBean().setStartPage(++startPage);
			this.getPageBean().setLastRecordNo(getLastRecordNo());// ������һҳ������¼��

			// ���м������õ�һ��������
			List<?> list = getListByPage(this.getPageBean().getStart(),
					this.getPageBean().getPageSize(), this.getPageBean().getPropertyMap());
			this.getPageBean().setList(list);
			// ����ǰ��ҳ�Ŀ�����,���ǵ�һҳ��ǰ��ҳ����
			// this.getPageBean().setIs_prev(false);
			// ���ú�ҳ�Ŀ����ԣ���������ҳ�򲻿���
			// if (startPage == pageCount) {
			// this.getPageBean().setIs_next(true);
			// }
			session.setAttribute("pageBean", pageBean);
		}
		return "list";
	}

	/**
	 * ǰ��ҳ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String prePage() {
		//����session�е�pageBEAN
		PaginationBean pageBean=(PaginationBean)session.getAttribute("pageBean");
		this.setPageBean(pageBean);

		int startPage = this.getPageBean().getStartPage();// ��ǰҳ��
		// ������ǰ��ҳ
		if (startPage != 1) {
			int beforePageStartNo = this.getPageBean().getStart();
			this.getPageBean().setStart(
					beforePageStartNo - this.getPageBean().getPageSize());// ���ñ�ҳ�Ŀ�ʼ��¼��:ǰһҳ�Ŀ�ʼ��¼��-һҳ��ʾ����ҳ��

			this.getPageBean().setStartPage(--startPage);
			this.getPageBean().setLastRecordNo(getLastRecordNo());// ����ǰһҳ������¼��

			// ���м������õ�һ��������
			List<?> list = getListByPage(this.getPageBean().getStart(),
					this.getPageBean().getPageSize(), this.getPageBean().getPropertyMap());
			this.getPageBean().setList(list);
		
			session.setAttribute("pageBean", pageBean);
		}
		return "list";
	}
	
	/**
	 * ���һҳ
	 * @return
	 */
	public String lastPage() {
		//����session�е�pageBEAN
		PaginationBean pageBean=(PaginationBean)session.getAttribute("pageBean");
		this.setPageBean(pageBean);

		//���ñ�ҳ�Ŀ�ʼ��¼�ţ������ڶ�ҳ�����һ����¼�к�+1
		this.getPageBean().setStart((pageBean.getTotalPage()-1)*pageBean.getPageSize()+1);// 
		this.getPageBean().setStartPage(pageBean.getTotalPage());//�������ҳ��ҳ���

		// ���м������õ�һ��������
		List<?> list = getListByPage(this.getPageBean().getStart(), this
				.getPageBean().getPageSize(),  this
				.getPageBean().getPropertyMap());
		this.getPageBean().setList(list);
		// �õ��ܼ���
		long totalCount = getTotalCount(this.getPageBean().getPropertyMap());
		this.getPageBean().setTotalCount(totalCount);
		// �õ���ҳ��
		int pageCount = getPageCount();
		this.getPageBean().setTotalPage(pageCount);
		// ���ñ�ҳ������¼��
		this.getPageBean().setLastRecordNo(getLastRecordNo());

		session.setAttribute("pageBean", pageBean);
		return "list";
	}

	/**
	 * ��ʾ�ڼ�ҳ������
	 * 
	 * @param page
	 * @return
	 */
	public String goPage() {
		//����session�е�pageBEAN
		PaginationBean pageBean=(PaginationBean)session.getAttribute("pageBean");
		this.setPageBean(pageBean);
		
		String page = request.getParameter("page");// �õ������ϴ��ݹ�����ת���ڼ�ҳ��ҳ��
		int pageTemp = Integer.parseInt(page);
		this.getPageBean().setStartPage(pageTemp);// ����ת���ڼ�ҳ

		// ���ñ�ҳ�Ŀ�ʼ��¼��:ǰһҳ�Ŀ�ʼ��¼��-һҳ��ʾ����ҳ��
		this.getPageBean().setStart(
				(pageTemp - 1) * this.getPageBean().getPageSize() + 1);// �õ�ǰһҳ������¼��+1
		int lastRecordNo = getLastRecordNo();// ת��ҳ�����һ����¼��
		this.getPageBean().setLastRecordNo(lastRecordNo);// ������һҳ������¼��

		// ���м������õ�һ��������
		List<?> list = getListByPage(this.getPageBean().getStart(), this.getPageBean().getPageSize(),this.getPageBean().getPropertyMap());
		this.getPageBean().setList(list);

		
		session.setAttribute("pageBean", pageBean);
		return "list";
	}

	/**
	 * ������ǰҳ������
	 * 
	 * @return
	 */
	public abstract List<?> getListByPage(int pageNo, int pageSize, Map<String, Object> propertyMap);

	/**
	 * �õ��ܼ���
	 */
	public abstract int getTotalCount(Map<String, Object> propertyMap);

	/**
	 * �õ���ҳ��
	 * 
	 * @param values
	 * @return
	 */
	public int getPageCount() {

		int totalCount = (int) this.getPageBean().getTotalCount();
		int pageSize = this.getPageBean().getPageSize();
		int pageCount = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		return pageCount;
	}

	/**
	 * �õ���ҳ������¼�к�
	 * 
	 * @return
	 */
	public int getLastRecordNo() {

		int num = this.getPageBean().getStartPage()
				* this.getPageBean().getPageSize();
		// ������һҳ����������ʾʵ���ܼ�¼��
		if (num > (int) this.getPageBean().getTotalCount()) {
			num = (int) this.getPageBean().getTotalCount();
		}
		return num;
	}

}
