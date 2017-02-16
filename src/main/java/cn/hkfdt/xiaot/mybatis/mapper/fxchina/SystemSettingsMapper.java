package cn.hkfdt.xiaot.mybatis.mapper.fxchina;

import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettings;
import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettingsExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface SystemSettingsMapper {
    int countByExample(SystemSettingsExample example);

    int deleteByExample(SystemSettingsExample example);

    int deleteByPrimaryKey(@Param("type") String type, @Param("keyCode") String keyCode);

    int insert(SystemSettings record);

    int insertSelective(SystemSettings record);

    List<SystemSettings> selectByExampleWithRowbounds(SystemSettingsExample example, RowBounds rowBounds);

    List<SystemSettings> selectByExample(SystemSettingsExample example);

    SystemSettings selectByPrimaryKey(@Param("type") String type, @Param("keyCode") String keyCode);

    int updateByExampleSelective(@Param("record") SystemSettings record, @Param("example") SystemSettingsExample example);

    int updateByExample(@Param("record") SystemSettings record, @Param("example") SystemSettingsExample example);

    int updateByPrimaryKeySelective(SystemSettings record);

    int updateByPrimaryKey(SystemSettings record);
}