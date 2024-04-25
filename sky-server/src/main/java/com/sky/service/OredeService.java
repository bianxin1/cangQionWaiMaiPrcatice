package com.sky.service;

import com.sky.dto.*;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;

public interface OredeService {
    /**
     * 提交订单
     *
     * @param ordersSubmitDTO
     * @return
     */
    OrderSubmitVO submit(OrdersSubmitDTO ordersSubmitDTO);

    /**
     * 订单支付
     *
     * @param ordersPaymentDTO
     * @return
     */
    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception;

    /**
     * 支付成功，修改订单状态
     *
     * @param outTradeNo
     */
    void paySuccess(String outTradeNo);

    /**
     * 分页查询
     *
     * @param page, int pageSize, Integer status
     * @return
     */
    PageResult pageQuery(int page, int pageSize, Integer status);

    /**
     * 查询订单详情
     *
     * @param id
     * @return
     */
    OrderVO details(Long id);

    /**
     * 取消订单
     *
     * @param id
     */
    void cancel(Long id);

    /**
     * 再来一单
     *
     * @param id
     */
    void repetition(Long id);

    /**
     * 查询相关订单
     *
     * @param ordersPageQueryDTO
     * @return
     */
    PageResult conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 展示订单数量
     *
     * @return
     */
    OrderStatisticsVO statistics();

    /**
     * 接单
     *
     * @param orders
     */
    void confirm(Orders orders);

    /**
     * 拒单
     *
     * @param ordersRejectionDTO
     */
    void rejection(OrdersRejectionDTO ordersRejectionDTO);

    /**
     * 后台取消订单
     * @param ordersCancelDTO
     */
    void cancelByadmin(OrdersCancelDTO ordersCancelDTO);

    /**
     * 派送
     * @param id
     */
    void delivery(Long id);

    /**
     * 完成订单
     * @param id
     */
    void complete(Long id);
}
