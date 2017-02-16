package cn.hkfdt.xiaot.mybatis.mapper.ltschina;

import cn.hkfdt.xiaot.mybatis.model.ltschina.School;
import cn.hkfdt.xiaot.mybatis.model.ltschina.SchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SchoolMapper {
    int countByExample(SchoolExample example);

    int deleteByExample(SchoolExample example);

    int deleteByPrimaryKey(String schoolKey);

    int insert(School record);

    int insertSelective(School record);

    List<School> selectByExampleWithRowbounds(SchoolExample example, RowBounds rowBounds);

    List<School> selectByExample(SchoolExample example);

    School selectByPrimaryKey(String schoolKey);

    int updateByExampleSelective(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByExample(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);
}