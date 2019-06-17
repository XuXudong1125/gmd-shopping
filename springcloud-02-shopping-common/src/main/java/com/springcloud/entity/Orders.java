package com.springcloud.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Orders表对应的实体类，用于封装一行订单信息
 * @author 徐旭东
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements java.io.Serializable {

	private static final long serialVersionUID = -3857392721920542241L;

	/**
	 * 订单编号
	 */
	private Integer orderId;

	/**
	 * 当前订单对应的用户信息
	 */
	private Users user;

	/**
	 * 收货人姓名：如果省略默认为用户表中的用户姓名
	 */
	private String receiverName;

	/**
	 * 收货人联系电话：如果省略默认为用户表中的用户联系电话
	 */
	private String receiverTel;

	/**
	 * 收货人地址：如果省略默认为用户表中的用户地址
	 */
	private String receiverAddr;

	/**
	 * 订单时间：默认为当前时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderTime;

	/**
	 * 订单总数
	 */
	private Double orderTotal;

	/**
	 * 订单状态
	 */
	private Integer orderStatus;
	
	
	/**
	 * 订单起始时间：查询条件
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDateMin;
	
	/**
	 * 订单终止时间：查询条件
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDateMax;
	
	
	/**
	 * 订单起始年月：查询条件
	 */
	private String startMonth;
	
	
	/**
	 * 订单终止年月：查询条件
	 */
	private String endMonth;
	
	/**
	 * 统计结果的年月
	 */
	private String orderMonth;
	
	/**
	 * 统计结果的销售额
	 */
	private Double orderPrice;
	
}