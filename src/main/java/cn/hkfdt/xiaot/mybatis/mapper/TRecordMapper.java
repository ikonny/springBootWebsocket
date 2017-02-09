package cn.hkfdt.xiaot.mybatis.mapper;

import cn.hkfdt.xiaot.mybatis.model.TRecord;
import cn.hkfdt.xiaot.mybatis.model.TRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TRecordMapper {
    int countByExample(TRecordExample example);

    int deleteByExample(TRecordExample example);

    int deleteByPrimaryKey(Integer recordId);

    int insert(TRecord record);

    int insertSelective(TRecord record);

    List<TRecord> selectByExampleWithBLOBs(TRecordExample example);

    List<TRecord> selectByExample(TRecordExample example);

    TRecord selectByPrimaryKey(Integer recordId);

    int updateByExampleSelective(@Param("record") TRecord record, @Param("example") TRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") TRecord record, @Param("example") TRecordExample example);

    int updateByExample(@Param("record") TRecord record, @Param("example") TRecordExample example);

    int updateByPrimaryKeySelective(TRecord record);

    int updateByPrimaryKeyWithBLOBs(TRecord record);

    int updateByPrimaryKey(TRecord record);
}