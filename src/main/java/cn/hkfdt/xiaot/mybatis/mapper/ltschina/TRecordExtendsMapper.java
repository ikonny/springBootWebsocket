package cn.hkfdt.xiaot.mybatis.mapper.ltschina;


import cn.hkfdt.xiaot.mybatis.model.ltschina.TRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
public interface TRecordExtendsMapper extends TRecordMapper {

	@Select("select * from xiaot_record WHERE fdtId = #{para.fdtId} and type = #{para.market}" +
			" ORDER BY createTime DESC LIMIT #{para.offset},#{para.count}")
	List<TRecord> getXiaotRecord(@Param("para") Map<String, Object> mapPara);

	@Select("select COUNT(1) from xiaot_record WHERE fdtId = #{para.fdtId} and type = #{para.market}")
	int getXiaotRecordTotal(@Param("para") Map<String, Object> mapPara);

	@Insert("replace into xiaot_record (symbol, fdtId," +
			"      tradeTime, returnRate, volatility, " +
			"      type, createTime, actions, " +
			"      score, questionKey, VERSION" +
			"      )" +
			"    values (#{record.symbol}, #{record.fdtId}, " +
			"      #{record.tradeTime}, #{record.returnRate}, #{record.volatility}, " +
			"      #{record.type}, #{record.createTime}, #{record.actions}, " +
			"      #{record.score}, #{record.questionKey}, #{record.VERSION}" +
			"      )")
	void replaceXiaotRecord(@Param("record") TRecord record);

}