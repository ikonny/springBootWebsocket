package cn.hkfdt.xiaot.mybatis.mapper.ltschina;

import cn.hkfdt.xiaot.mybatis.model.ltschina.Auth;
import cn.hkfdt.xiaot.mybatis.model.ltschina.AuthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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