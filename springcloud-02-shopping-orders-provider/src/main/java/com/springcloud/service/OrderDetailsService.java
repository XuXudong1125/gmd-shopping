package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.OrderDetails;

/**
 * 
 * @author 徐旭东
 *
 */
public interface OrderDetailsService {

	/**
	 * 查询指定编号的订单明细的信息（分页功能）
	 * 
	 * @param orderId    订单编号
	 * @param pageNumber 页数
	 * @return 成功返回com.github.pagehelper.PageInfo<OrderDetails>类型的实例
	 */
	public abstract PageInfo<OrderDetails> selectByOrderId(Integer orderId, Integer pageNumber);
}
