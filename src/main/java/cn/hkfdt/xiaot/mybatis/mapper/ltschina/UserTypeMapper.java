package cn.hkfdt.xiaot.mybatis.mapper.ltschina;

import cn.hkfdt.xiaot.mybatis.model.ltschina.UserType;
import cn.hkfdt.xiaot.mybatis.model.ltschina.UserTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface UserTypeMapper {
    int countByExample(UserTypeExample example);

    int deleteByExample(UserTypeExample example);

    int deleteByPrimaryKey(@Param("userId") String userId, @Param("typeId") String typeId);

    int insert(UserType record);

    int insertSelective(UserType record);

    List<UserType> selectByExample(UserTypeExample example);

    UserType selectByPrimaryKey(@Param("userId") String userId, @Param("typeId") String typeId);

    int updateByExampleSelective(@Param("record") UserType record, @Param("example") UserTypeExample example);

    int updateByExample(@Param("record") UserType record, @Param("example") UserTypeExample example);

    int updateByPrimaryKeySelective(UserType record);

    int updateByPrimaryKey(UserType record);
}