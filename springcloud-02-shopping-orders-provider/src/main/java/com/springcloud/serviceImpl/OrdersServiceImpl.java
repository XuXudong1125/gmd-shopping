package com.springcloud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.dao.OrdersMapper;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;
/**
 * ����ģ��ģ�Ͳ��ʵ���࣬ʵ�ֶ���ģ��ķ���
 * 
 * @author ����
 */

@Service
public class OrdersServiceImpl<OrderMapper> implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;

	@Override
	public PageInfo<Orders> selectOrders(Orders orders, Integer pageNumber) {
		if (orders.getUser() != null) {
			// ��Ʒ�������˼�%
			orders.getUser().setUserName("%" + orders.getUser().getUserName() + "%");
		}
		
		// ����ÿҳ����Ϣ
		PageHelper.startPage(pageNumber + 1, PageUtils.PAGE_ROW_COUNT);
		// ��ѯ������������Ʒ��Ϣ
		List<Orders> list = this.ordersMapper.selectOrders(orders);
		// ���ط�ҳ��Ϣ
		return new PageInfo<>(list);
	}

	@Transactional
	@Override
	public Integer updateOrdersStatus(Orders orders) {
		
		return this.ordersMapper.updateOrdersStatus(orders);
	}

	
	@Override
	public List<Orders> selectGroup(Orders orders) {
		return this.ordersMapper.selectGroup(orders);
	}

}
