package cn.hkfdt.xiaot.mybatis.mapper.ltschina;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TGame;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TGameMapper {
    int countByExample(TGameExample example);

    int deleteByExample(TGameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TGame record);

    int insertSelective(TGame record);

    List<TGame> selectByExampleWithRowbounds(TGameExample example, RowBounds rowBounds);

    List<TGame> selectByExample(TGameExample example);

    TGame selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TGame record, @Param("example") TGameExample example);

    int updateByExample(@Param("record") TGame record, @Param("example") TGameExample example);

    int updateByPrimaryKeySelective(TGame record);

    int updateByPrimaryKey(TGame record);
}