package cn.hkfdt.xiaot.mybatis.mapper;

import cn.hkfdt.xiaot.mybatis.model.TQuestions;
import cn.hkfdt.xiaot.mybatis.model.TQuestionsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TQuestionsMapper {
    int countByExample(TQuestionsExample example);

    int deleteByExample(TQuestionsExample example);

    int deleteByPrimaryKey(Integer questionId);

    int insert(TQuestions record);

    int insertSelective(TQuestions record);

    List<TQuestions> selectByExampleWithBLOBs(TQuestionsExample example);

    List<TQuestions> selectByExample(TQuestionsExample example);

    TQuestions selectByPrimaryKey(Integer questionId);

    int updateByExampleSelective(@Param("record") TQuestions record, @Param("example") TQuestionsExample example);

    int updateByExampleWithBLOBs(@Param("record") TQuestions record, @Param("example") TQuestionsExample example);

    int updateByExample(@Param("record") TQuestions record, @Param("example") TQuestionsExample example);

    int updateByPrimaryKeySelective(TQuestions record);

    int updateByPrimaryKeyWithBLOBs(TQuestions record);

    int updateByPrimaryKey(TQuestions record);
}