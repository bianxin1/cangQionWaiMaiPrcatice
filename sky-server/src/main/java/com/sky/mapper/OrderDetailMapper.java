package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    /**
     * 插入明细数据
     * @param orderDetails
     */
    void insertBatch(List<OrderDetail> orderDetails);

    /**
     * 通过订单id查询详细数据
     * @param orderId
     * @return
     */
    @Select("select * from order_detail where order_id= #{orderId}")
    List<OrderDetail> getById(Long orderId);
}
