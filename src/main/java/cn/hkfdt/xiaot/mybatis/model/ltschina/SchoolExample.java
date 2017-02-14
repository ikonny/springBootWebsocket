package cn.hkfdt.xiaot.mybatis.model.ltschina;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SchoolExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchoolExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSchoolKeyIsNull() {
            addCriterion("school_key is null");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyIsNotNull() {
            addCriterion("school_key is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyEqualTo(String value) {
            addCriterion("school_key =", value, "schoolKey");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyNotEqualTo(String value) {
            addCriterion("school_key <>", value, "schoolKey");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyGreaterThan(String value) {
            addCriterion("school_key >", value, "schoolKey");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyGreaterThanOrEqualTo(String value) {
            addCriterion("school_key >=", value, "schoolKey");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyLessThan(String value) {
            addCriterion("school_key <", value, "schoolKey");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyLessThanOrEqualTo(String value) {
            addCriterion("school_key <=", value, "schoolKey");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyLike(String value) {
            addCriterion("school_key like", value, "schoolKey");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyNotLike(String value) {
            addCriterion("school_key not like", value, "schoolKey");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyIn(List<String> values) {
            addCriterion("school_key in", values, "schoolKey");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyNotIn(List<String> values) {
            addCriterion("school_key not in", values, "schoolKey");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyBetween(String value1, String value2) {
            addCriterion("school_key between", value1, value2, "schoolKey");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyNotBetween(String value1, String value2) {
            addCriterion("school_key not between", value1, value2, "schoolKey");
            return (Criteria) this;
        }

        public Criteria andEnNameIsNull() {
            addCriterion("en_name is null");
            return (Criteria) this;
        }

        public Criteria andEnNameIsNotNull() {
            addCriterion("en_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnNameEqualTo(String value) {
            addCriterion("en_name =", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotEqualTo(String value) {
            addCriterion("en_name <>", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameGreaterThan(String value) {
            addCriterion("en_name >", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameGreaterThanOrEqualTo(String value) {
            addCriterion("en_name >=", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLessThan(String value) {
            addCriterion("en_name <", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLessThanOrEqualTo(String value) {
            addCriterion("en_name <=", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLike(String value) {
            addCriterion("en_name like", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotLike(String value) {
            addCriterion("en_name not like", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameIn(List<String> values) {
            addCriterion("en_name in", values, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotIn(List<String> values) {
            addCriterion("en_name not in", values, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameBetween(String value1, String value2) {
            addCriterion("en_name between", value1, value2, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotBetween(String value1, String value2) {
            addCriterion("en_name not between", value1, value2, "enName");
            return (Criteria) this;
        }

        public Criteria andEnShortIsNull() {
            addCriterion("en_short is null");
            return (Criteria) this;
        }

        public Criteria andEnShortIsNotNull() {
            addCriterion("en_short is not null");
            return (Criteria) this;
        }

        public Criteria andEnShortEqualTo(String value) {
            addCriterion("en_short =", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortNotEqualTo(String value) {
            addCriterion("en_short <>", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortGreaterThan(String value) {
            addCriterion("en_short >", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortGreaterThanOrEqualTo(String value) {
            addCriterion("en_short >=", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortLessThan(String value) {
            addCriterion("en_short <", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortLessThanOrEqualTo(String value) {
            addCriterion("en_short <=", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortLike(String value) {
            addCriterion("en_short like", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortNotLike(String value) {
            addCriterion("en_short not like", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortIn(List<String> values) {
            addCriterion("en_short in", values, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortNotIn(List<String> values) {
            addCriterion("en_short not in", values, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortBetween(String value1, String value2) {
            addCriterion("en_short between", value1, value2, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortNotBetween(String value1, String value2) {
            addCriterion("en_short not between", value1, value2, "enShort");
            return (Criteria) this;
        }

        public Criteria andScNameIsNull() {
            addCriterion("sc_name is null");
            return (Criteria) this;
        }

        public Criteria andScNameIsNotNull() {
            addCriterion("sc_name is not null");
            return (Criteria) this;
        }

        public Criteria andScNameEqualTo(String value) {
            addCriterion("sc_name =", value, "scName");
            return (Criteria) this;
        }

        public Criteria andScNameNotEqualTo(String value) {
            addCriterion("sc_name <>", value, "scName");
            return (Criteria) this;
        }

        public Criteria andScNameGreaterThan(String value) {
            addCriterion("sc_name >", value, "scName");
            return (Criteria) this;
        }

        public Criteria andScNameGreaterThanOrEqualTo(String value) {
            addCriterion("sc_name >=", value, "scName");
            return (Criteria) this;
        }

        public Criteria andScNameLessThan(String value) {
            addCriterion("sc_name <", value, "scName");
            return (Criteria) this;
        }

        public Criteria andScNameLessThanOrEqualTo(String value) {
            addCriterion("sc_name <=", value, "scName");
            return (Criteria) this;
        }

        public Criteria andScNameLike(String value) {
            addCriterion("sc_name like", value, "scName");
            return (Criteria) this;
        }

        public Criteria andScNameNotLike(String value) {
            addCriterion("sc_name not like", value, "scName");
            return (Criteria) this;
        }

        public Criteria andScNameIn(List<String> values) {
            addCriterion("sc_name in", values, "scName");
            return (Criteria) this;
        }

        public Criteria andScNameNotIn(List<String> values) {
            addCriterion("sc_name not in", values, "scName");
            return (Criteria) this;
        }

        public Criteria andScNameBetween(String value1, String value2) {
            addCriterion("sc_name between", value1, value2, "scName");
            return (Criteria) this;
        }

        public Criteria andScNameNotBetween(String value1, String value2) {
            addCriterion("sc_name not between", value1, value2, "scName");
            return (Criteria) this;
        }

        public Criteria andScPinyinIsNull() {
            addCriterion("sc_pinyin is null");
            return (Criteria) this;
        }

        public Criteria andScPinyinIsNotNull() {
            addCriterion("sc_pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andScPinyinEqualTo(String value) {
            addCriterion("sc_pinyin =", value, "scPinyin");
            return (Criteria) this;
        }

        public Criteria andScPinyinNotEqualTo(String value) {
            addCriterion("sc_pinyin <>", value, "scPinyin");
            return (Criteria) this;
        }

        public Criteria andScPinyinGreaterThan(String value) {
            addCriterion("sc_pinyin >", value, "scPinyin");
            return (Criteria) this;
        }

        public Criteria andScPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("sc_pinyin >=", value, "scPinyin");
            return (Criteria) this;
        }

        public Criteria andScPinyinLessThan(String value) {
            addCriterion("sc_pinyin <", value, "scPinyin");
            return (Criteria) this;
        }

        public Criteria andScPinyinLessThanOrEqualTo(String value) {
            addCriterion("sc_pinyin <=", value, "scPinyin");
            return (Criteria) this;
        }

        public Criteria andScPinyinLike(String value) {
            addCriterion("sc_pinyin like", value, "scPinyin");
            return (Criteria) this;
        }

        public Criteria andScPinyinNotLike(String value) {
            addCriterion("sc_pinyin not like", value, "scPinyin");
            return (Criteria) this;
        }

        public Criteria andScPinyinIn(List<String> values) {
            addCriterion("sc_pinyin in", values, "scPinyin");
            return (Criteria) this;
        }

        public Criteria andScPinyinNotIn(List<String> values) {
            addCriterion("sc_pinyin not in", values, "scPinyin");
            return (Criteria) this;
        }

        public Criteria andScPinyinBetween(String value1, String value2) {
            addCriterion("sc_pinyin between", value1, value2, "scPinyin");
            return (Criteria) this;
        }

        public Criteria andScPinyinNotBetween(String value1, String value2) {
            addCriterion("sc_pinyin not between", value1, value2, "scPinyin");
            return (Criteria) this;
        }

        public Criteria andTcNameIsNull() {
            addCriterion("tc_name is null");
            return (Criteria) this;
        }

        public Criteria andTcNameIsNotNull() {
            addCriterion("tc_name is not null");
            return (Criteria) this;
        }

        public Criteria andTcNameEqualTo(String value) {
            addCriterion("tc_name =", value, "tcName");
            return (Criteria) this;
        }

        public Criteria andTcNameNotEqualTo(String value) {
            addCriterion("tc_name <>", value, "tcName");
            return (Criteria) this;
        }

        public Criteria andTcNameGreaterThan(String value) {
            addCriterion("tc_name >", value, "tcName");
            return (Criteria) this;
        }

        public Criteria andTcNameGreaterThanOrEqualTo(String value) {
            addCriterion("tc_name >=", value, "tcName");
            return (Criteria) this;
        }

        public Criteria andTcNameLessThan(String value) {
            addCriterion("tc_name <", value, "tcName");
            return (Criteria) this;
        }

        public Criteria andTcNameLessThanOrEqualTo(String value) {
            addCriterion("tc_name <=", value, "tcName");
            return (Criteria) this;
        }

        public Criteria andTcNameLike(String value) {
            addCriterion("tc_name like", value, "tcName");
            return (Criteria) this;
        }

        public Criteria andTcNameNotLike(String value) {
            addCriterion("tc_name not like", value, "tcName");
            return (Criteria) this;
        }

        public Criteria andTcNameIn(List<String> values) {
            addCriterion("tc_name in", values, "tcName");
            return (Criteria) this;
        }

        public Criteria andTcNameNotIn(List<String> values) {
            addCriterion("tc_name not in", values, "tcName");
            return (Criteria) this;
        }

        public Criteria andTcNameBetween(String value1, String value2) {
            addCriterion("tc_name between", value1, value2, "tcName");
            return (Criteria) this;
        }

        public Criteria andTcNameNotBetween(String value1, String value2) {
            addCriterion("tc_name not between", value1, value2, "tcName");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andDisplayEnIsNull() {
            addCriterion("display_en is null");
            return (Criteria) this;
        }

        public Criteria andDisplayEnIsNotNull() {
            addCriterion("display_en is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayEnEqualTo(Boolean value) {
            addCriterion("display_en =", value, "displayEn");
            return (Criteria) this;
        }

        public Criteria andDisplayEnNotEqualTo(Boolean value) {
            addCriterion("display_en <>", value, "displayEn");
            return (Criteria) this;
        }

        public Criteria andDisplayEnGreaterThan(Boolean value) {
            addCriterion("display_en >", value, "displayEn");
            return (Criteria) this;
        }

        public Criteria andDisplayEnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("display_en >=", value, "displayEn");
            return (Criteria) this;
        }

        public Criteria andDisplayEnLessThan(Boolean value) {
            addCriterion("display_en <", value, "displayEn");
            return (Criteria) this;
        }

        public Criteria andDisplayEnLessThanOrEqualTo(Boolean value) {
            addCriterion("display_en <=", value, "displayEn");
            return (Criteria) this;
        }

        public Criteria andDisplayEnIn(List<Boolean> values) {
            addCriterion("display_en in", values, "displayEn");
            return (Criteria) this;
        }

        public Criteria andDisplayEnNotIn(List<Boolean> values) {
            addCriterion("display_en not in", values, "displayEn");
            return (Criteria) this;
        }

        public Criteria andDisplayEnBetween(Boolean value1, Boolean value2) {
            addCriterion("display_en between", value1, value2, "displayEn");
            return (Criteria) this;
        }

        public Criteria andDisplayEnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("display_en not between", value1, value2, "displayEn");
            return (Criteria) this;
        }

        public Criteria andDisplayScIsNull() {
            addCriterion("display_sc is null");
            return (Criteria) this;
        }

        public Criteria andDisplayScIsNotNull() {
            addCriterion("display_sc is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayScEqualTo(Boolean value) {
            addCriterion("display_sc =", value, "displaySc");
            return (Criteria) this;
        }

        public Criteria andDisplayScNotEqualTo(Boolean value) {
            addCriterion("display_sc <>", value, "displaySc");
            return (Criteria) this;
        }

        public Criteria andDisplayScGreaterThan(Boolean value) {
            addCriterion("display_sc >", value, "displaySc");
            return (Criteria) this;
        }

        public Criteria andDisplayScGreaterThanOrEqualTo(Boolean value) {
            addCriterion("display_sc >=", value, "displaySc");
            return (Criteria) this;
        }

        public Criteria andDisplayScLessThan(Boolean value) {
            addCriterion("display_sc <", value, "displaySc");
            return (Criteria) this;
        }

        public Criteria andDisplayScLessThanOrEqualTo(Boolean value) {
            addCriterion("display_sc <=", value, "displaySc");
            return (Criteria) this;
        }

        public Criteria andDisplayScIn(List<Boolean> values) {
            addCriterion("display_sc in", values, "displaySc");
            return (Criteria) this;
        }

        public Criteria andDisplayScNotIn(List<Boolean> values) {
            addCriterion("display_sc not in", values, "displaySc");
            return (Criteria) this;
        }

        public Criteria andDisplayScBetween(Boolean value1, Boolean value2) {
            addCriterion("display_sc between", value1, value2, "displaySc");
            return (Criteria) this;
        }

        public Criteria andDisplayScNotBetween(Boolean value1, Boolean value2) {
            addCriterion("display_sc not between", value1, value2, "displaySc");
            return (Criteria) this;
        }

        public Criteria andDisplayTcIsNull() {
            addCriterion("display_tc is null");
            return (Criteria) this;
        }

        public Criteria andDisplayTcIsNotNull() {
            addCriterion("display_tc is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayTcEqualTo(Boolean value) {
            addCriterion("display_tc =", value, "displayTc");
            return (Criteria) this;
        }

        public Criteria andDisplayTcNotEqualTo(Boolean value) {
            addCriterion("display_tc <>", value, "displayTc");
            return (Criteria) this;
        }

        public Criteria andDisplayTcGreaterThan(Boolean value) {
            addCriterion("display_tc >", value, "displayTc");
            return (Criteria) this;
        }

        public Criteria andDisplayTcGreaterThanOrEqualTo(Boolean value) {
            addCriterion("display_tc >=", value, "displayTc");
            return (Criteria) this;
        }

        public Criteria andDisplayTcLessThan(Boolean value) {
            addCriterion("display_tc <", value, "displayTc");
            return (Criteria) this;
        }

        public Criteria andDisplayTcLessThanOrEqualTo(Boolean value) {
            addCriterion("display_tc <=", value, "displayTc");
            return (Criteria) this;
        }

        public Criteria andDisplayTcIn(List<Boolean> values) {
            addCriterion("display_tc in", values, "displayTc");
            return (Criteria) this;
        }

        public Criteria andDisplayTcNotIn(List<Boolean> values) {
            addCriterion("display_tc not in", values, "displayTc");
            return (Criteria) this;
        }

        public Criteria andDisplayTcBetween(Boolean value1, Boolean value2) {
            addCriterion("display_tc between", value1, value2, "displayTc");
            return (Criteria) this;
        }

        public Criteria andDisplayTcNotBetween(Boolean value1, Boolean value2) {
            addCriterion("display_tc not between", value1, value2, "displayTc");
            return (Criteria) this;
        }

        public Criteria andDomainsIsNull() {
            addCriterion("domains is null");
            return (Criteria) this;
        }

        public Criteria andDomainsIsNotNull() {
            addCriterion("domains is not null");
            return (Criteria) this;
        }

        public Criteria andDomainsEqualTo(String value) {
            addCriterion("domains =", value, "domains");
            return (Criteria) this;
        }

        public Criteria andDomainsNotEqualTo(String value) {
            addCriterion("domains <>", value, "domains");
            return (Criteria) this;
        }

        public Criteria andDomainsGreaterThan(String value) {
            addCriterion("domains >", value, "domains");
            return (Criteria) this;
        }

        public Criteria andDomainsGreaterThanOrEqualTo(String value) {
            addCriterion("domains >=", value, "domains");
            return (Criteria) this;
        }

        public Criteria andDomainsLessThan(String value) {
            addCriterion("domains <", value, "domains");
            return (Criteria) this;
        }

        public Criteria andDomainsLessThanOrEqualTo(String value) {
            addCriterion("domains <=", value, "domains");
            return (Criteria) this;
        }

        public Criteria andDomainsLike(String value) {
            addCriterion("domains like", value, "domains");
            return (Criteria) this;
        }

        public Criteria andDomainsNotLike(String value) {
            addCriterion("domains not like", value, "domains");
            return (Criteria) this;
        }

        public Criteria andDomainsIn(List<String> values) {
            addCriterion("domains in", values, "domains");
            return (Criteria) this;
        }

        public Criteria andDomainsNotIn(List<String> values) {
            addCriterion("domains not in", values, "domains");
            return (Criteria) this;
        }

        public Criteria andDomainsBetween(String value1, String value2) {
            addCriterion("domains between", value1, value2, "domains");
            return (Criteria) this;
        }

        public Criteria andDomainsNotBetween(String value1, String value2) {
            addCriterion("domains not between", value1, value2, "domains");
            return (Criteria) this;
        }

        public Criteria andFlagUrlIsNull() {
            addCriterion("flag_url is null");
            return (Criteria) this;
        }

        public Criteria andFlagUrlIsNotNull() {
            addCriterion("flag_url is not null");
            return (Criteria) this;
        }

        public Criteria andFlagUrlEqualTo(String value) {
            addCriterion("flag_url =", value, "flagUrl");
            return (Criteria) this;
        }

        public Criteria andFlagUrlNotEqualTo(String value) {
            addCriterion("flag_url <>", value, "flagUrl");
            return (Criteria) this;
        }

        public Criteria andFlagUrlGreaterThan(String value) {
            addCriterion("flag_url >", value, "flagUrl");
            return (Criteria) this;
        }

        public Criteria andFlagUrlGreaterThanOrEqualTo(String value) {
            addCriterion("flag_url >=", value, "flagUrl");
            return (Criteria) this;
        }

        public Criteria andFlagUrlLessThan(String value) {
            addCriterion("flag_url <", value, "flagUrl");
            return (Criteria) this;
        }

        public Criteria andFlagUrlLessThanOrEqualTo(String value) {
            addCriterion("flag_url <=", value, "flagUrl");
            return (Criteria) this;
        }

        public Criteria andFlagUrlLike(String value) {
            addCriterion("flag_url like", value, "flagUrl");
            return (Criteria) this;
        }

        public Criteria andFlagUrlNotLike(String value) {
            addCriterion("flag_url not like", value, "flagUrl");
            return (Criteria) this;
        }

        public Criteria andFlagUrlIn(List<String> values) {
            addCriterion("flag_url in", values, "flagUrl");
            return (Criteria) this;
        }

        public Criteria andFlagUrlNotIn(List<String> values) {
            addCriterion("flag_url not in", values, "flagUrl");
            return (Criteria) this;
        }

        public Criteria andFlagUrlBetween(String value1, String value2) {
            addCriterion("flag_url between", value1, value2, "flagUrl");
            return (Criteria) this;
        }

        public Criteria andFlagUrlNotBetween(String value1, String value2) {
            addCriterion("flag_url not between", value1, value2, "flagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlIsNull() {
            addCriterion("oss_flag_url is null");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlIsNotNull() {
            addCriterion("oss_flag_url is not null");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlEqualTo(String value) {
            addCriterion("oss_flag_url =", value, "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlNotEqualTo(String value) {
            addCriterion("oss_flag_url <>", value, "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlGreaterThan(String value) {
            addCriterion("oss_flag_url >", value, "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlGreaterThanOrEqualTo(String value) {
            addCriterion("oss_flag_url >=", value, "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlLessThan(String value) {
            addCriterion("oss_flag_url <", value, "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlLessThanOrEqualTo(String value) {
            addCriterion("oss_flag_url <=", value, "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlLike(String value) {
            addCriterion("oss_flag_url like", value, "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlNotLike(String value) {
            addCriterion("oss_flag_url not like", value, "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlIn(List<String> values) {
            addCriterion("oss_flag_url in", values, "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlNotIn(List<String> values) {
            addCriterion("oss_flag_url not in", values, "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlBetween(String value1, String value2) {
            addCriterion("oss_flag_url between", value1, value2, "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlNotBetween(String value1, String value2) {
            addCriterion("oss_flag_url not between", value1, value2, "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageIsNull() {
            addCriterion("device_language is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageIsNotNull() {
            addCriterion("device_language is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageEqualTo(String value) {
            addCriterion("device_language =", value, "deviceLanguage");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageNotEqualTo(String value) {
            addCriterion("device_language <>", value, "deviceLanguage");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageGreaterThan(String value) {
            addCriterion("device_language >", value, "deviceLanguage");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("device_language >=", value, "deviceLanguage");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageLessThan(String value) {
            addCriterion("device_language <", value, "deviceLanguage");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageLessThanOrEqualTo(String value) {
            addCriterion("device_language <=", value, "deviceLanguage");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageLike(String value) {
            addCriterion("device_language like", value, "deviceLanguage");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageNotLike(String value) {
            addCriterion("device_language not like", value, "deviceLanguage");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageIn(List<String> values) {
            addCriterion("device_language in", values, "deviceLanguage");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageNotIn(List<String> values) {
            addCriterion("device_language not in", values, "deviceLanguage");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageBetween(String value1, String value2) {
            addCriterion("device_language between", value1, value2, "deviceLanguage");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageNotBetween(String value1, String value2) {
            addCriterion("device_language not between", value1, value2, "deviceLanguage");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Boolean value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Boolean value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Boolean value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Boolean value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Boolean value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Boolean> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Boolean> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Boolean value1, Boolean value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyLikeInsensitive(String value) {
            addCriterion("upper(school_key) like", value.toUpperCase(), "schoolKey");
            return (Criteria) this;
        }

        public Criteria andEnNameLikeInsensitive(String value) {
            addCriterion("upper(en_name) like", value.toUpperCase(), "enName");
            return (Criteria) this;
        }

        public Criteria andEnShortLikeInsensitive(String value) {
            addCriterion("upper(en_short) like", value.toUpperCase(), "enShort");
            return (Criteria) this;
        }

        public Criteria andScNameLikeInsensitive(String value) {
            addCriterion("upper(sc_name) like", value.toUpperCase(), "scName");
            return (Criteria) this;
        }

        public Criteria andScPinyinLikeInsensitive(String value) {
            addCriterion("upper(sc_pinyin) like", value.toUpperCase(), "scPinyin");
            return (Criteria) this;
        }

        public Criteria andTcNameLikeInsensitive(String value) {
            addCriterion("upper(tc_name) like", value.toUpperCase(), "tcName");
            return (Criteria) this;
        }

        public Criteria andRegionLikeInsensitive(String value) {
            addCriterion("upper(region) like", value.toUpperCase(), "region");
            return (Criteria) this;
        }

        public Criteria andDomainsLikeInsensitive(String value) {
            addCriterion("upper(domains) like", value.toUpperCase(), "domains");
            return (Criteria) this;
        }

        public Criteria andFlagUrlLikeInsensitive(String value) {
            addCriterion("upper(flag_url) like", value.toUpperCase(), "flagUrl");
            return (Criteria) this;
        }

        public Criteria andOssFlagUrlLikeInsensitive(String value) {
            addCriterion("upper(oss_flag_url) like", value.toUpperCase(), "ossFlagUrl");
            return (Criteria) this;
        }

        public Criteria andGroupIdLikeInsensitive(String value) {
            addCriterion("upper(group_id) like", value.toUpperCase(), "groupId");
            return (Criteria) this;
        }

        public Criteria andDeviceLanguageLikeInsensitive(String value) {
            addCriterion("upper(device_language) like", value.toUpperCase(), "deviceLanguage");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}