package com.sky.mapper;

import com.sky.entity.AddressBook;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressBookMapper {
    /**
     * 新增收货地址
     * @param addressBook
     */
    @Insert("insert into address_book(user_id, consignee, sex, phone, province_code, province_name, city_code, city_name, district_code, district_name, detail, label, is_default) values " +
            "(#{userId},#{consignee},#{sex},#{phone},#{provinceCode},#{provinceName},#{cityCode},#{cityName},#{districtCode},#{districtName},#{detail},#{label},#{isDefault})")
    void insert(AddressBook addressBook);
    List<AddressBook> list(AddressBook addressBook);

    /**
     * 查询默认地址
     * @param addressBook
     */
    @Select("select * from address_book where user_id=#{userId} and is_default = 1")
    void getDefaltAddress(AddressBook addressBook);
    @Update("update address_book set is_default = #{isDefault} and user_id =#{userId}")
    void updateIsDefaultByUserId(AddressBook addressBook);

    void update(AddressBook addressBook);
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from address_book where id = #{id}")
    AddressBook getById(Long id);

    /**
     * 删除地址
     * @param id
     */
    @Delete("delete from address_book where id=#{id}")
    void deleteById(Long id);
}
