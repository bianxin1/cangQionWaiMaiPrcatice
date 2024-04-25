package com.sky.controller.admin;

import com.sky.dto.OrdersCancelDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.dto.OrdersRejectionDTO;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OredeService;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("adminOrderController")
@RequestMapping("/admin/order")
@Api(tags = "订单相关接口")
@Slf4j
public class OrderController {
    @Resource
    private OredeService oredeService;

    /**
     * 查询订单
     *
     * @param ordersPageQueryDTO
     * @return
     */
    @GetMapping("conditionSearch")
    @ApiOperation("查询订单")
    public Result<PageResult> conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO) {
        log.info("查询订单：{}", ordersPageQueryDTO);
        PageResult pageResult = oredeService.conditionSearch(ordersPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 展示订单数量
     *
     * @return
     */
    @GetMapping("/statistics")
    @ApiOperation("展示各个状态订单数量")
    public Result<OrderStatisticsVO> statistics() {
        OrderStatisticsVO orderStatisticsVO = oredeService.statistics();
        return Result.success(orderStatisticsVO);
    }

    /**
     * 查询订单详情
     *
     * @param id
     * @return
     */
    @GetMapping("/details/{id}")
    @ApiOperation("查询订单详情")
    public Result<OrderVO> details(@PathVariable Long id) {
        OrderVO orderVO = oredeService.details(id);
        return Result.success(orderVO);
    }

    /**
     * 接单
     *
     * @param orders
     * @return
     */
    @PutMapping("/confirm")
    @ApiOperation("接单")
    public Result confirm(@RequestBody Orders orders) {
        oredeService.confirm(orders);
        return Result.success();
    }

    /**
     * 拒单
     * @param ordersRejectionDTO
     * @return
     */
    @PutMapping("/rejection")
    @ApiOperation("拒单")
    public Result rejection(@RequestBody OrdersRejectionDTO ordersRejectionDTO) {
        oredeService.rejection(ordersRejectionDTO);
        return Result.success();
    }

    /**
     * 取消订单
     * @param ordersCancelDTO
     * @return
     */
    @PutMapping("/cancel")
    @ApiOperation("取消订单")
    public Result cancel(@RequestBody OrdersCancelDTO ordersCancelDTO){
        oredeService.cancelByadmin(ordersCancelDTO);
        return Result.success();
    }
    /**
     * 派送订单
     *
     * @return
     */
    @PutMapping("/delivery/{id}")
    @ApiOperation("派送订单")
    public Result delivery(@PathVariable("id") Long id) {
        oredeService.delivery(id);
        return Result.success();
    }
    /**
     * 完成订单
     *
     * @return
     */
    @PutMapping("/complete/{id}")
    @ApiOperation("完成订单")
    public Result complete(@PathVariable("id") Long id) {
        oredeService.complete(id);
        return Result.success();
    }
}
