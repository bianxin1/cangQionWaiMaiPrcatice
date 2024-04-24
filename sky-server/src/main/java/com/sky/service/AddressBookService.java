package com.sky.service;

import com.sky.entity.AddressBook;

import java.util.List;

public interface AddressBookService {
    /**
     * 新增收货地址
     * @param addressBook
     */
    void save(AddressBook addressBook);

    /**
     * 查询所有收货地址
     *
     * @return
     */
     List<AddressBook> list();

    /**
     * 查询默认地址
     * @return
     */
    AddressBook findByUserId();

    /**
     * 设置默认地址
     * @param addressBook
     */
    void setDefault(AddressBook addressBook);

    /**
     * 更改地址
     * @param addressBook
     */
    void update(AddressBook addressBook);

    /**
     *
     * @param id
     * @return
     */
    AddressBook getById(Long id);

    /**
     * 删除地址
     * @param id
     */
    void deleteById(Long id);
}
