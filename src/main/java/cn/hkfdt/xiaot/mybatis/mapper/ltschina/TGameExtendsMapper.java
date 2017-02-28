package cn.hkfdt.xiaot.mybatis.mapper.ltschina;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TGame;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by crimson on 17/2/27.
 */
public interface TGameExtendsMapper {
    @Select("select * from xiaot_game where gameId = #{gameId}")
    TGame selectGameByGameId(@Param("gameId") String gameId);
}
