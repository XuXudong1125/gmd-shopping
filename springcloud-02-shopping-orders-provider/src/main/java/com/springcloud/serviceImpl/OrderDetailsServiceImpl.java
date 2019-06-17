package com.springcloud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.dao.OrderDetailsMapper;
import com.springcloud.entity.OrderDetails;
import com.springcloud.service.OrderDetailsService;

/**
 * ����ģ��ģ�Ͳ��ʵ���࣬����ʵ�ֶ�����ϸģ��ķ���
 * 
 * @author ����
 *
 */

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsMapper orderDetailsMapper;

	@Override
	public PageInfo<OrderDetails> selectByOrderId(Integer orderId, Integer pageNumber) {

		// ����ÿҳ����Ϣ
		PageHelper.startPage(pageNumber + 1,5);
		// ��ѯ������������Ʒ��Ϣ
		List<OrderDetails> list = this.orderDetailsMapper.selectByOrderId(orderId);
		// ���ط�ҳ��Ϣ
		return new PageInfo<>(list);
	}

	
}
