package com.sky.controller.user;

import com.sky.context.BaseContext;
import com.sky.entity.AddressBook;
import com.sky.result.Result;
import com.sky.service.AddressBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user/addressBook")
@Slf4j
@Api(tags = "用户收货地址相关接口")
public class AddressBookController {
    @Resource
    private AddressBookService addressBookService;

    /**
     * 新增收货地址
     * @param addressBook
     * @return
     */
    @PostMapping
    @ApiOperation("新增收货地址")
    public Result save(@RequestBody AddressBook addressBook){
        log.info("添加收货地址：{}",addressBook);
        addressBookService.save(addressBook);
        return Result.success();
    }

    /**
     * 查询所有收货地址
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("查询用户收货地址")
    public Result<List<AddressBook>> list(){
        List<AddressBook> list = addressBookService.list();
        return Result.success(list);
    }

    /**
     * 查询默认地址
     * @return
     */
    @GetMapping("/default")
    @ApiOperation("查询默认之地")
    public Result<AddressBook> findDefaultAddress(){
        AddressBook addressBook = addressBookService.findByUserId();
        return Result.success(addressBook);
    }
    @PutMapping ("/default")
    @ApiOperation("设置默认地址")
    public Result setDefaultAddress(@RequestBody AddressBook addressBook){
        log.info("设置默认地址：{}",addressBook);
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBookService.setDefault(addressBook);
        return Result.success();
    }
    /**
     * 根据id修改地址
     *
     * @param addressBook
     * @return
     */
    @PutMapping
    @ApiOperation("根据id修改地址")
    public Result update(@RequestBody AddressBook addressBook) {
        addressBookService.update(addressBook);
        return Result.success();
    }
    @GetMapping("/{id}")
    @ApiOperation("根据id查询地址")
    public Result<AddressBook> getById(@PathVariable Long id) {
        AddressBook addressBook = addressBookService.getById(id);
        return Result.success(addressBook);
    }
    /**
     * 根据id删除地址
     *
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("根据id删除地址")
    public Result deleteById(Long id) {
        addressBookService.deleteById(id);
        return Result.success();
    }
}
