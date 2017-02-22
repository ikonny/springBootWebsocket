package cn.hkfdt.xiaot.mybatis.mapper.ltschina;


import cn.hkfdt.xiaot.mybatis.model.ltschina.TQuestions;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface TQuestionsExtendsMapper extends TQuestionsMapper {
	/**
	 * 根据外部接口的题目获取联合主键
	 * @param para
	 * @return
	 * author:xumin 
	 * 2016-12-16 上午11:35:45
	 */
	@Select("select * from xiaot_questions WHERE exchangeCode=#{para.exchangeCode}" +
			" and shortSymbol = #{para.shortSymbol} and tradeDay = #{para.tradeDay} and initType =1")
	TQuestions getByUnionKey(@Param("para") TQuestions para);
	/**
	 * 获取还没有获取行情数据的题目
	 * @return
	 * author:xumin 
	 * 2016-12-19 下午6:29:41
	 */
	@Select("select * from xiaot_questions WHERE type = #{type} and initType =0")
	List<TQuestions> initTQuestions(@Param("type") int type);
}