package com.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Orders;

/**
 * ����ģ�Ͳ�Ľӿڣ����ڶ��嶩��ģ��ķ���
 * 
 * @author ����
 *
 */
public interface OrdersService {

	/**
	 * ��ѯ���������Ķ�����Ϣ����ҳ������
	 * 
	 * @param orders	��ѯ����
	 * @return	����om.github.pagehelper.PageInfo<orders>��ʵ��
	 */
	public abstract PageInfo<Orders> selectOrders(Orders orders,Integer pageNumber);
	
	
	/**
	 * �޸�ָ�����ORDER_ID�Ķ���״̬
	 * 
	 * @param orders	�޸Ķ�����Ϣ
	 * @return �ɹ����ش���0��������ʧ��Ŷ����С��0 ������
	 */
	public abstract Integer updateOrdersStatus(Orders orders);
	
	
	/**
	 * ��ѯָ�����ڷ�Χ�ڵ����۶�
	 * 
	 * @param orders ��ѯ����
	 * @return �ɹ�����java.util.List���͵�ʵ�� ʧ�ܷ���null
	 */
	public abstract List<Orders> selectGroup(Orders orders);

}