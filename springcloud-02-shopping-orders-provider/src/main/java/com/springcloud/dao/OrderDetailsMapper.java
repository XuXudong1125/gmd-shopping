package com.springcloud.dao;

import com.springcloud.entity.OrderDetails;
import java.util.List;

public interface OrderDetailsMapper {
    int deleteByPrimaryKey(Integer orderDetailId);

    int insert(OrderDetails record);

    OrderDetails selectByPrimaryKey(Integer orderDetailId);

    List<OrderDetails> selectAll();

    int updateByPrimaryKey(OrderDetails record);
    
    /**
     *查询 指定编号的订单明细
     * 
     * @param orderId	指定订单编号
     * @return	成功返回java.util.List类型的是例 	失败返回null
     */
    public abstract List<OrderDetails> selectByOrderId(Integer orderId);
}