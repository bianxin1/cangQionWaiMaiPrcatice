package com.sky.service;

import com.sky.vo.BusinessDataVO;
import com.sky.vo.DishOverViewVO;
import com.sky.vo.OrderOverViewVO;
import com.sky.vo.SetmealOverViewVO;

import java.time.LocalDateTime;

public interface WorkspaceService {
    /**
     * 今日数据统计
     * @param begin
     * @param end
     * @return
     */
    BusinessDataVO getBusinessData(LocalDateTime begin, LocalDateTime end);

    /**
     * 套餐管理
     * @return
     */
    SetmealOverViewVO overviewSetmeals();

    /**
     * 查询顶顶那
     * @return
     */
    OrderOverViewVO getOrderOverView();

    /**
     * 菜品
     * @return
     */
    DishOverViewVO getDishOverView();
}
