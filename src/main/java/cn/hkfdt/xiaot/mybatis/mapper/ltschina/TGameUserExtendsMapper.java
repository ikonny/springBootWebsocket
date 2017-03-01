package cn.hkfdt.xiaot.mybatis.mapper.ltschina;

import cn.hkfdt.xiaot.mybatis.model.ltschina.TGameUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by crimson on 17/3/1.
 */
public interface TGameUserExtendsMapper extends TGameUserMapper {
    @Select("select * from xiaot_game_user where gameId = #{gameId} and state = 2 order by ranking asc")
    List<TGameUser> selectGameUserByGameId(@Param("gameId") String gameId);
}
