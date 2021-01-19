package com.shanxijuzhi.juzhi.mapper;

import com.shanxijuzhi.juzhi.model.TestDataInfo;

public interface TestDataInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestDataInfo record);

    int insertSelective(TestDataInfo record);

    TestDataInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestDataInfo record);

    int updateByPrimaryKey(TestDataInfo record);
}