package cn.hkfdt.xiaot.mybatis.mapper.ltschina;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestionsNew;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestionsNewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TQuestionsNewMapper {
    int countByExample(TQuestionsNewExample example);

    int deleteByExample(TQuestionsNewExample example);

    int deleteByPrimaryKey(Integer questionId);

    int insert(TQuestionsNew record);

    int insertSelective(TQuestionsNew record);

    List<TQuestionsNew> selectByExampleWithBLOBsWithRowbounds(TQuestionsNewExample example, RowBounds rowBounds);

    List<TQuestionsNew> selectByExampleWithBLOBs(TQuestionsNewExample example);

    List<TQuestionsNew> selectByExampleWithRowbounds(TQuestionsNewExample example, RowBounds rowBounds);

    List<TQuestionsNew> selectByExample(TQuestionsNewExample example);

    TQuestionsNew selectByPrimaryKey(Integer questionId);

    int updateByExampleSelective(@Param("record") TQuestionsNew record, @Param("example") TQuestionsNewExample example);

    int updateByExampleWithBLOBs(@Param("record") TQuestionsNew record, @Param("example") TQuestionsNewExample example);

    int updateByExample(@Param("record") TQuestionsNew record, @Param("example") TQuestionsNewExample example);

    int updateByPrimaryKeySelective(TQuestionsNew record);

    int updateByPrimaryKeyWithBLOBs(TQuestionsNew record);

    int updateByPrimaryKey(TQuestionsNew record);
}