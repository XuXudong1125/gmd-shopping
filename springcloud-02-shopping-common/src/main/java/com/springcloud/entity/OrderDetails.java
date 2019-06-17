package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order_details���Ӧ��ʵ���࣬���ڷ�װһ�ж�����ϸ��Ϣ
 * @author ����
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails implements java.io.Serializable {
   
	private static final long serialVersionUID = -5575089304535953058L;

	/**
	 * ������ϸ���
	 */
	private Integer orderDetailId;

	/**
	 * �������
	 */
    private Integer orderId;

    /**
	 * ��Ʒ���
	 */
    private Integer goodsId;

    /**
	 * ��Ʒ����
	 */
    private String goodsName;

    /**
	 * ��Ʒ�ɽ���
	 */
    private Double goodsFinalPrice;

    /**
	 * ��Ʒ�ɽ�����
	 */
    private Integer goodsFinalNum;
}