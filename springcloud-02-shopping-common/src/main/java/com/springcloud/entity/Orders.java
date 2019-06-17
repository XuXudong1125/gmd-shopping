package com.springcloud.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Orders���Ӧ��ʵ���࣬���ڷ�װһ�ж�����Ϣ
 * @author ����
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements java.io.Serializable {

	private static final long serialVersionUID = -3857392721920542241L;

	/**
	 * �������
	 */
	private Integer orderId;

	/**
	 * ��ǰ������Ӧ���û���Ϣ
	 */
	private Users user;

	/**
	 * �ջ������������ʡ��Ĭ��Ϊ�û����е��û�����
	 */
	private String receiverName;

	/**
	 * �ջ�����ϵ�绰�����ʡ��Ĭ��Ϊ�û����е��û���ϵ�绰
	 */
	private String receiverTel;

	/**
	 * �ջ��˵�ַ�����ʡ��Ĭ��Ϊ�û����е��û���ַ
	 */
	private String receiverAddr;

	/**
	 * ����ʱ�䣺Ĭ��Ϊ��ǰʱ��
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderTime;

	/**
	 * ��������
	 */
	private Double orderTotal;

	/**
	 * ����״̬
	 */
	private Integer orderStatus;
	
	
	/**
	 * ������ʼʱ�䣺��ѯ����
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDateMin;
	
	/**
	 * ������ֹʱ�䣺��ѯ����
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDateMax;
	
	
	/**
	 * ������ʼ���£���ѯ����
	 */
	private String startMonth;
	
	
	/**
	 * ������ֹ���£���ѯ����
	 */
	private String endMonth;
	
	/**
	 * ͳ�ƽ��������
	 */
	private String orderMonth;
	
	/**
	 * ͳ�ƽ�������۶�
	 */
	private Double orderPrice;
	
}