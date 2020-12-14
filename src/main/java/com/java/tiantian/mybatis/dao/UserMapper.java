package com.java.tiantian.mybatis.dao;

import com.java.tiantian.mybatis.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 天天
 * @version 1.0   接口 实现这些没忘记吧
 * @date 2020/12/14 13:34
 */

public interface UserMapper {
    /**
     * 查询所有的数据
     * @return
     */
    List<User> queryFindAll();

    /**
     * 通过id 删除数据
     * @param id
     * @return
     */
    Integer  deleteById(@Param("id") Integer id);

}
