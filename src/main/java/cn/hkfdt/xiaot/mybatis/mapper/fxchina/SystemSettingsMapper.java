package cn.hkfdt.xiaot.mybatis.mapper.fxchina;

import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettings;
import cn.hkfdt.xiaot.mybatis.model.fxchina.SystemSettingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemSettingsMapper {
    int countByExample(SystemSettingsExample example);

    int deleteByExample(SystemSettingsExample example);

    int deleteByPrimaryKey(@Param("type") String type, @Param("keyCode") String keyCode);

    int insert(SystemSettings record);

    int insertSelective(SystemSettings record);

    List<SystemSettings> selectByExample(SystemSettingsExample example);

    SystemSettings selectByPrimaryKey(@Param("type") String type, @Param("keyCode") String keyCode);

    int updateByExampleSelective(@Param("record") SystemSettings record, @Param("example") SystemSettingsExample example);

    int updateByExample(@Param("record") SystemSettings record, @Param("example") SystemSettingsExample example);

    int updateByPrimaryKeySelective(SystemSettings record);

    int updateByPrimaryKey(SystemSettings record);
}