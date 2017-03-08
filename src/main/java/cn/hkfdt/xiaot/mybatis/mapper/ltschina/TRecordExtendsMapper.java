package cn.hkfdt.xiaot.mybatis.mapper.ltschina;


import cn.hkfdt.xiaot.mybatis.model.ltschina.TRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;
public interface TRecordExtendsMapper extends TRecordMapper {

	@Select("select * from xiaot_record WHERE fdtId = #{para.fdtId} and type = #{para.market}" +
			" ORDER BY createTime DESC LIMIT #{para.offset},#{para.count}")
	List<TRecord> getXiaotRecord(@Param("para") Map<String, Object> mapPara);

	@Select("select * from xiaot_record WHERE uniqueId = #{uniqueId}")
	TRecord getXiaotRecordByUnid(@Param("uniqueId") String uniqueId);

	@Select("select COUNT(1) from xiaot_record WHERE fdtId = #{para.fdtId} and type = #{para.market}")
	int getXiaotRecordTotal(@Param("para") Map<String, Object> mapPara);

	@Insert("replace into xiaot_record (symbol, fdtId," +
			"      tradeTime, returnRate, volatility, " +
			"      type, createTime, actions, " +
			"      score, questionKey, VERSION, reqBody, uniqueId, `status`" +
			"      )" +
			"    values (#{record.symbol}, #{record.fdtId}, " +
			"      #{record.tradeTime}, #{record.returnRate}, #{record.volatility}, " +
			"      #{record.type}, #{record.createTime}, #{record.actions}, " +
			"      #{record.score}, #{record.questionKey}, #{record.VERSION}, #{record.reqBody}, #{record.uniqueId}, #{record.status}" +
			"      )")
	void replaceXiaotRecord(@Param("record") TRecord record);

	@Select("select * from xiaot_record where createTime < #{time} and `status` = 0")
	List<TRecord> getTimeOutRecord(@Param("time") Long time);

	@Update("update xiaot_record set `status` = 1, score = #{para.score}, volatility = #{para.volatility}, " +
			"createTime = #{para.createTime}, scoreResult = #{para.scoreResult} where recordId = #{para.id}")
	void updateScore(@Param("para") Map<String, Object> mapPara);

}