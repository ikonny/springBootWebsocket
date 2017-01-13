package cn.hkfdt.xiaot.mybatis.mapper;

import cn.hkfdt.xiaot.mybatis.model.Auth;
import cn.hkfdt.xiaot.mybatis.model.AuthExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthMapper {
    int countByExample(AuthExample example);

    int deleteByExample(AuthExample example);

    int deleteByPrimaryKey(@Param("userid") String userid, @Param("email") String email);

    int insert(Auth record);

    int insertSelective(Auth record);

    List<Auth> selectByExampleWithBLOBs(AuthExample example);

    List<Auth> selectByExample(AuthExample example);

    Auth selectByPrimaryKey(@Param("userid") String userid, @Param("email") String email);

    int updateByExampleSelective(@Param("record") Auth record, @Param("example") AuthExample example);

    int updateByExampleWithBLOBs(@Param("record") Auth record, @Param("example") AuthExample example);

    int updateByExample(@Param("record") Auth record, @Param("example") AuthExample example);

    int updateByPrimaryKeySelective(Auth record);

    int updateByPrimaryKeyWithBLOBs(Auth record);

    int updateByPrimaryKey(Auth record);
}