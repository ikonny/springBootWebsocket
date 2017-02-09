package cn.hkfdt.xiaot.mybatis.mapper;

import cn.hkfdt.xiaot.mybatis.model.ForceAnalysis;
import cn.hkfdt.xiaot.mybatis.model.ForceAnalysisExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ForceAnalysisMapper {
    int countByExample(ForceAnalysisExample example);

    int deleteByExample(ForceAnalysisExample example);

    int deleteByPrimaryKey(Integer forceId);

    int insert(ForceAnalysis record);

    int insertSelective(ForceAnalysis record);

    List<ForceAnalysis> selectByExample(ForceAnalysisExample example);

    ForceAnalysis selectByPrimaryKey(Integer forceId);

    int updateByExampleSelective(@Param("record") ForceAnalysis record, @Param("example") ForceAnalysisExample example);

    int updateByExample(@Param("record") ForceAnalysis record, @Param("example") ForceAnalysisExample example);

    int updateByPrimaryKeySelective(ForceAnalysis record);

    int updateByPrimaryKey(ForceAnalysis record);
}