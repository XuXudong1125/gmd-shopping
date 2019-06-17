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
 * 订单模块控制层
 * 
 * @author 徐旭东
 *
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	/**
	 * 查询满足条件订单信息
	 * 
	 * @param orders     查询条件
	 * @param pageNumber 页数
	 * @return
	 */
	@RequestMapping(value = "/selectOrders")
	public ResultValue selectOrders(Orders orders, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();

		try {
			// 查询满足条件的商品信息
			PageInfo<Orders> pageInfo = this.ordersService.selectOrders(orders, pageNumber);
			// 从分页信息中获得商品信息
			List<Orders> list = pageInfo.getList();
			// 如果查询到满足条件的商品信息
			if (list != null && list.size() > 0) {

				rv.setCode(0);

				Map<String, Object> map = new HashMap<>();
				// 将商品信息以指定的键存入Map集合中
				map.put("ordersList", list);

				PageUtils pageUtils = new PageUtils(pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				// 将分页信息以指定的名字存入Map集合中
				map.put("pageUtils", pageUtils);

				rv.setDataMap(map);
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("没有找到满足条件的商品信息");

		return rv;
	}

	/**
	 * 修改指定编号的商品信息
	 * 
	 * @param goods 修改的商品信息
	 * @return
	 */
	@RequestMapping(value = "/updateOrdersStatus")
	public ResultValue updateOrdersStatus(Orders orders) {

		ResultValue rv = new ResultValue();

		try {
			Integer OrdersStatus = this.ordersService.updateOrdersStatus(orders);
			if (OrdersStatus > 0) {
				rv.setCode(0);
				rv.setMessage("订单状态修改成功");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("订单状态修改失败");
		return rv;
	}

	/**
	 * 查询指定时间范围的销售额
	 * 
	 * @param order 查询条件
	 * @return
	 */
	@RequestMapping(value = "/selectGroup")
	public ResultValue selectGroup(Orders orders, @RequestParam("startMonth") String startMonth,
			@RequestParam("endMonth") String endMonth) {
		ResultValue rv = new ResultValue();

		try {
			List<Orders> list = this.ordersService.selectGroup(orders);

			// 如果查询到满足时间条件的商品销售额
			if (list != null && list.size() > 0) {

				rv.setCode(0);
				List<String> x = new ArrayList<>();
				List<Double> y = new ArrayList<>();
				
				for (Orders  o : list) {
					x.add(o.getOrderMonth());
					y.add(o.getOrderPrice());
				}
				Map<String, Object> map = new HashMap<>();
			
				// 将满足时间信息以指定的名字存入Map集合中
				map.put("x", x);
				map.put("y", y);

				rv.setDataMap(map);
				rv.setMessage("成功找到满足条件的商品销售额！！！");
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("没有找到满足条件的商品销售额！！");

		return rv;
	}

}
