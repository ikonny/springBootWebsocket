package cn.hkfdt.xiaot.mybatis.mapper.ltschina;


import cn.hkfdt.xiaot.mybatis.model.ltschina.TRecord;
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
}