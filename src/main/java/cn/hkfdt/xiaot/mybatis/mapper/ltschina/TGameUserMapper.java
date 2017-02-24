package cn.hkfdt.xiaot.mybatis.mapper.ltschina;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TGameUser;
import cn.hkfdt.xiaot.mybatis.model.ltschina.TGameUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TGameUserMapper {
    int countByExample(TGameUserExample example);

    int deleteByExample(TGameUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TGameUser record);

    int insertSelective(TGameUser record);

    List<TGameUser> selectByExampleWithRowbounds(TGameUserExample example, RowBounds rowBounds);

    List<TGameUser> selectByExample(TGameUserExample example);

    TGameUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TGameUser record, @Param("example") TGameUserExample example);

    int updateByExample(@Param("record") TGameUser record, @Param("example") TGameUserExample example);

    int updateByPrimaryKeySelective(TGameUser record);

    int updateByPrimaryKey(TGameUser record);
}