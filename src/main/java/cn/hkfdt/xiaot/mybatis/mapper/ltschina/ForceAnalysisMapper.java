package cn.hkfdt.xiaot.mybatis.mapper.ltschina;

import cn.hkfdt.xiaot.mybatis.model.ltschina.ForceAnalysis;
import cn.hkfdt.xiaot.mybatis.model.ltschina.ForceAnalysisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ForceAnalysisMapper {
    int countByExample(ForceAnalysisExample example);

    int deleteByExample(ForceAnalysisExample example);

    int deleteByPrimaryKey(Integer forceId);

    int insert(ForceAnalysis record);

    int insertSelective(ForceAnalysis record);

    List<ForceAnalysis> selectByExampleWithRowbounds(ForceAnalysisExample example, RowBounds rowBounds);

    List<ForceAnalysis> selectByExample(ForceAnalysisExample example);

    ForceAnalysis selectByPrimaryKey(Integer forceId);

    int updateByExampleSelective(@Param("record") ForceAnalysis record, @Param("example") ForceAnalysisExample example);

    int updateByExample(@Param("record") ForceAnalysis record, @Param("example") ForceAnalysisExample example);

    int updateByPrimaryKeySelective(ForceAnalysis record);

    int updateByPrimaryKey(ForceAnalysis record);
}