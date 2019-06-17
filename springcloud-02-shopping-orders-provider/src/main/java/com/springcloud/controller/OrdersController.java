package com.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

/**
 * ����ģ����Ʋ�
 * 
 * @author ����
 *
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	/**
	 * ��ѯ��������������Ϣ
	 * 
	 * @param orders     ��ѯ����
	 * @param pageNumber ҳ��
	 * @return
	 */
	@RequestMapping(value = "/selectOrders")
	public ResultValue selectOrders(Orders orders, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();

		try {
			// ��ѯ������������Ʒ��Ϣ
			PageInfo<Orders> pageInfo = this.ordersService.selectOrders(orders, pageNumber);
			// �ӷ�ҳ��Ϣ�л����Ʒ��Ϣ
			List<Orders> list = pageInfo.getList();
			// �����ѯ��������������Ʒ��Ϣ
			if (list != null && list.size() > 0) {

				rv.setCode(0);

				Map<String, Object> map = new HashMap<>();
				// ����Ʒ��Ϣ��ָ���ļ�����Map������
				map.put("ordersList", list);

				PageUtils pageUtils = new PageUtils(pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				// ����ҳ��Ϣ��ָ�������ִ���Map������
				map.put("pageUtils", pageUtils);

				rv.setDataMap(map);
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("û���ҵ�������������Ʒ��Ϣ");

		return rv;
	}

	/**
	 * �޸�ָ����ŵ���Ʒ��Ϣ
	 * 
	 * @param goods �޸ĵ���Ʒ��Ϣ
	 * @return
	 */
	@RequestMapping(value = "/updateOrdersStatus")
	public ResultValue updateOrdersStatus(Orders orders) {

		ResultValue rv = new ResultValue();

		try {
			Integer OrdersStatus = this.ordersService.updateOrdersStatus(orders);
			if (OrdersStatus > 0) {
				rv.setCode(0);
				rv.setMessage("����״̬�޸ĳɹ�");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("����״̬�޸�ʧ��");
		return rv;
	}

	/**
	 * ��ѯָ��ʱ�䷶Χ�����۶�
	 * 
	 * @param order ��ѯ����
	 * @return
	 */
	@RequestMapping(value = "/selectGroup")
	public ResultValue selectGroup(Orders orders, @RequestParam("startMonth") String startMonth,
			@RequestParam("endMonth") String endMonth) {
		ResultValue rv = new ResultValue();

		try {
			List<Orders> list = this.ordersService.selectGroup(orders);

			// �����ѯ������ʱ����������Ʒ���۶�
			if (list != null && list.size() > 0) {

				rv.setCode(0);
				List<String> x = new ArrayList<>();
				List<Double> y = new ArrayList<>();
				
				for (Orders  o : list) {
					x.add(o.getOrderMonth());
					y.add(o.getOrderPrice());
				}
				Map<String, Object> map = new HashMap<>();
			
				// ������ʱ����Ϣ��ָ�������ִ���Map������
				map.put("x", x);
				map.put("y", y);

				rv.setDataMap(map);
				rv.setMessage("�ɹ��ҵ�������������Ʒ���۶����");
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("û���ҵ�������������Ʒ���۶��");

		return rv;
	}

}
