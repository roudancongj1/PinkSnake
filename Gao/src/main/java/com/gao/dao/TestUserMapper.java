package com.gao.dao;

import com.gao.pojo.TestUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TestUserMapper {
    @Select("select * from \"testUser\"")
    List<TestUser> queryAll();

    int insertOne(TestUser testUser);
}
