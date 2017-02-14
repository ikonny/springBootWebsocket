package cn.hkfdt.xiaot.mybatis.mapper.ltschina;


import cn.hkfdt.xiaot.mybatis.model.ltschina.ForceAnalysis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ForceAnalysisExtendsMapper extends ForceAnalysisMapper {

	@Select("select * from xiaot_force_analysis WHERE fdtId = #{para.fdtId} and type = #{para.type}")
	ForceAnalysis selectByFdtId(@Param("para") ForceAnalysis record);
	/**
	 * 获取某个市场的大师排行榜
	 * @param type
	 * @return
	 * author:xumin 
	 * 2016-12-19 下午2:07:40
	 */
	@Select("select * from xiaot_force_analysis WHERE type = #{para.type} ORDER BY accumulatedIncome DESC,fdtScore DESC LIMIT 0,50")
	List<ForceAnalysis> getXiaotMasterList(@Param("type") int type);
}