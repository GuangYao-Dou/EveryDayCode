package com.dgy.pojo;

public interface TabSellerMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(TabSeller record);

    int insertSelective(TabSeller record);

    TabSeller selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(TabSeller record);

    int updateByPrimaryKey(TabSeller record);
}