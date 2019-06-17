package com.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Orders;

/**
 * 订单模型层的接口，用于定义订单模块的方法
 * 
 * @author 徐旭东
 *
 */
public interface OrdersService {

	/**
	 * 查询满足条件的订单信息（分页条件）
	 * 
	 * @param orders	查询条件
	 * @return	返回om.github.pagehelper.PageInfo<orders>的实体
	 */
	public abstract PageInfo<Orders> selectOrders(Orders orders,Integer pageNumber);
	
	
	/**
	 * 修改指定编号ORDER_ID的订单状态
	 * 
	 * @param orders	修改订单信息
	 * @return 成功返回大于0的整数，失败哦发货小于0 的整数
	 */
	public abstract Integer updateOrdersStatus(Orders orders);
	
	
	/**
	 * 查询指定日期范围内的销售额
	 * 
	 * @param orders 查询条件
	 * @return 成功返回java.util.List类型的实例 失败返回null
	 */
	public abstract List<Orders> selectGroup(Orders orders);

}
