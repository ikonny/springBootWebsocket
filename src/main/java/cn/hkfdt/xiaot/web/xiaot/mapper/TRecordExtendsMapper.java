package cn.hkfdt.xiaot.web.xiaot.mapper;


import cn.hkfdt.xiaot.mybatis.mapper.TRecordMapper;
import cn.hkfdt.xiaot.mybatis.model.TRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TRecordExtendsMapper extends TRecordMapper {

	@Select("select * from xiaot_record WHERE fdtId = #{para.fdtId} and type = #{para.market}" +
			" ORDER BY createTime DESC LIMIT #{para.offset},#{para.count}")
	List<TRecord> getXiaotRecord(@Param("para")Map<String, Object> mapPara);

	@Select("select COUNT(1) from xiaot_record WHERE fdtId = #{para.fdtId} and type = #{para.market}")
	int getXiaotRecordTotal(@Param("para")Map<String, Object> mapPara);
}