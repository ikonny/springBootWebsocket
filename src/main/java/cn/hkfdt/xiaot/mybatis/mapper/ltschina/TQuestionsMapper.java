package cn.hkfdt.xiaot.mybatis.mapper.ltschina;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestions;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TQuestionsMapper {
    int countByExample(TQuestionsExample example);

    int deleteByExample(TQuestionsExample example);

    int deleteByPrimaryKey(Integer questionId);

    int insert(TQuestions record);

    int insertSelective(TQuestions record);

    List<TQuestions> selectByExampleWithBLOBsWithRowbounds(TQuestionsExample example, RowBounds rowBounds);

    List<TQuestions> selectByExampleWithBLOBs(TQuestionsExample example);

    List<TQuestions> selectByExampleWithRowbounds(TQuestionsExample example, RowBounds rowBounds);

    List<TQuestions> selectByExample(TQuestionsExample example);

    TQuestions selectByPrimaryKey(Integer questionId);

    int updateByExampleSelective(@Param("record") TQuestions record, @Param("example") TQuestionsExample example);

    int updateByExampleWithBLOBs(@Param("record") TQuestions record, @Param("example") TQuestionsExample example);

    int updateByExample(@Param("record") TQuestions record, @Param("example") TQuestionsExample example);

    int updateByPrimaryKeySelective(TQuestions record);

    int updateByPrimaryKeyWithBLOBs(TQuestions record);

    int updateByPrimaryKey(TQuestions record);
}