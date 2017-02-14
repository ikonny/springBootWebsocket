package cn.hkfdt.xiaot.mybatis.model.ltschina;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuthExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("USERID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("USERID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            addCriterion("SALT is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            addCriterion("SALT is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(String value) {
            addCriterion("SALT =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(String value) {
            addCriterion("SALT <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addCriterion("SALT >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addCriterion("SALT >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addCriterion("SALT <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addCriterion("SALT <=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLike(String value) {
            addCriterion("SALT like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addCriterion("SALT not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(List<String> values) {
            addCriterion("SALT in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addCriterion("SALT not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addCriterion("SALT between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addCriterion("SALT not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("CREATED is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("CREATED is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("CREATED =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("CREATED <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("CREATED >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("CREATED <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("CREATED <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("CREATED in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("CREATED not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("CREATED between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("CREATED not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("USERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("USERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Byte value) {
            addCriterion("USERTYPE =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Byte value) {
            addCriterion("USERTYPE <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Byte value) {
            addCriterion("USERTYPE >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("USERTYPE >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Byte value) {
            addCriterion("USERTYPE <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Byte value) {
            addCriterion("USERTYPE <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Byte> values) {
            addCriterion("USERTYPE in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Byte> values) {
            addCriterion("USERTYPE not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Byte value1, Byte value2) {
            addCriterion("USERTYPE between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Byte value1, Byte value2) {
            addCriterion("USERTYPE not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("COUNTRY is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("COUNTRY is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("COUNTRY =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("COUNTRY <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("COUNTRY >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTRY >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("COUNTRY <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("COUNTRY <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("COUNTRY like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("COUNTRY not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("COUNTRY in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("COUNTRY not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("COUNTRY between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("COUNTRY not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNull() {
            addCriterion("LANGUAGE is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("LANGUAGE is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(String value) {
            addCriterion("LANGUAGE =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(String value) {
            addCriterion("LANGUAGE <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(String value) {
            addCriterion("LANGUAGE >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("LANGUAGE >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(String value) {
            addCriterion("LANGUAGE <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(String value) {
            addCriterion("LANGUAGE <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLike(String value) {
            addCriterion("LANGUAGE like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotLike(String value) {
            addCriterion("LANGUAGE not like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(List<String> values) {
            addCriterion("LANGUAGE in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(List<String> values) {
            addCriterion("LANGUAGE not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(String value1, String value2) {
            addCriterion("LANGUAGE between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(String value1, String value2) {
            addCriterion("LANGUAGE not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andUserlevelIsNull() {
            addCriterion("USERLEVEL is null");
            return (Criteria) this;
        }

        public Criteria andUserlevelIsNotNull() {
            addCriterion("USERLEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andUserlevelEqualTo(Byte value) {
            addCriterion("USERLEVEL =", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelNotEqualTo(Byte value) {
            addCriterion("USERLEVEL <>", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelGreaterThan(Byte value) {
            addCriterion("USERLEVEL >", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("USERLEVEL >=", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelLessThan(Byte value) {
            addCriterion("USERLEVEL <", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelLessThanOrEqualTo(Byte value) {
            addCriterion("USERLEVEL <=", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelIn(List<Byte> values) {
            addCriterion("USERLEVEL in", values, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelNotIn(List<Byte> values) {
            addCriterion("USERLEVEL not in", values, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelBetween(Byte value1, Byte value2) {
            addCriterion("USERLEVEL between", value1, value2, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelNotBetween(Byte value1, Byte value2) {
            addCriterion("USERLEVEL not between", value1, value2, "userlevel");
            return (Criteria) this;
        }

        public Criteria andIsterminatedIsNull() {
            addCriterion("ISTERMINATED is null");
            return (Criteria) this;
        }

        public Criteria andIsterminatedIsNotNull() {
            addCriterion("ISTERMINATED is not null");
            return (Criteria) this;
        }

        public Criteria andIsterminatedEqualTo(Byte value) {
            addCriterion("ISTERMINATED =", value, "isterminated");
            return (Criteria) this;
        }

        public Criteria andIsterminatedNotEqualTo(Byte value) {
            addCriterion("ISTERMINATED <>", value, "isterminated");
            return (Criteria) this;
        }

        public Criteria andIsterminatedGreaterThan(Byte value) {
            addCriterion("ISTERMINATED >", value, "isterminated");
            return (Criteria) this;
        }

        public Criteria andIsterminatedGreaterThanOrEqualTo(Byte value) {
            addCriterion("ISTERMINATED >=", value, "isterminated");
            return (Criteria) this;
        }

        public Criteria andIsterminatedLessThan(Byte value) {
            addCriterion("ISTERMINATED <", value, "isterminated");
            return (Criteria) this;
        }

        public Criteria andIsterminatedLessThanOrEqualTo(Byte value) {
            addCriterion("ISTERMINATED <=", value, "isterminated");
            return (Criteria) this;
        }

        public Criteria andIsterminatedIn(List<Byte> values) {
            addCriterion("ISTERMINATED in", values, "isterminated");
            return (Criteria) this;
        }

        public Criteria andIsterminatedNotIn(List<Byte> values) {
            addCriterion("ISTERMINATED not in", values, "isterminated");
            return (Criteria) this;
        }

        public Criteria andIsterminatedBetween(Byte value1, Byte value2) {
            addCriterion("ISTERMINATED between", value1, value2, "isterminated");
            return (Criteria) this;
        }

        public Criteria andIsterminatedNotBetween(Byte value1, Byte value2) {
            addCriterion("ISTERMINATED not between", value1, value2, "isterminated");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("SCHOOL is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("SCHOOL is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("SCHOOL =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("SCHOOL <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("SCHOOL >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("SCHOOL >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("SCHOOL <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("SCHOOL <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("SCHOOL like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("SCHOOL not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("SCHOOL in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("SCHOOL not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("SCHOOL between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("SCHOOL not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andServiceIsNull() {
            addCriterion("SERVICE is null");
            return (Criteria) this;
        }

        public Criteria andServiceIsNotNull() {
            addCriterion("SERVICE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEqualTo(String value) {
            addCriterion("SERVICE =", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotEqualTo(String value) {
            addCriterion("SERVICE <>", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceGreaterThan(String value) {
            addCriterion("SERVICE >", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE >=", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLessThan(String value) {
            addCriterion("SERVICE <", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLessThanOrEqualTo(String value) {
            addCriterion("SERVICE <=", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLike(String value) {
            addCriterion("SERVICE like", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotLike(String value) {
            addCriterion("SERVICE not like", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceIn(List<String> values) {
            addCriterion("SERVICE in", values, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotIn(List<String> values) {
            addCriterion("SERVICE not in", values, "service");
            return (Criteria) this;
        }

        public Criteria andServiceBetween(String value1, String value2) {
            addCriterion("SERVICE between", value1, value2, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotBetween(String value1, String value2) {
            addCriterion("SERVICE not between", value1, value2, "service");
            return (Criteria) this;
        }

        public Criteria andFirstnameIsNull() {
            addCriterion("firstname is null");
            return (Criteria) this;
        }

        public Criteria andFirstnameIsNotNull() {
            addCriterion("firstname is not null");
            return (Criteria) this;
        }

        public Criteria andFirstnameEqualTo(String value) {
            addCriterion("firstname =", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameNotEqualTo(String value) {
            addCriterion("firstname <>", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameGreaterThan(String value) {
            addCriterion("firstname >", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameGreaterThanOrEqualTo(String value) {
            addCriterion("firstname >=", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameLessThan(String value) {
            addCriterion("firstname <", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameLessThanOrEqualTo(String value) {
            addCriterion("firstname <=", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameLike(String value) {
            addCriterion("firstname like", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameNotLike(String value) {
            addCriterion("firstname not like", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameIn(List<String> values) {
            addCriterion("firstname in", values, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameNotIn(List<String> values) {
            addCriterion("firstname not in", values, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameBetween(String value1, String value2) {
            addCriterion("firstname between", value1, value2, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameNotBetween(String value1, String value2) {
            addCriterion("firstname not between", value1, value2, "firstname");
            return (Criteria) this;
        }

        public Criteria andLastnameIsNull() {
            addCriterion("lastname is null");
            return (Criteria) this;
        }

        public Criteria andLastnameIsNotNull() {
            addCriterion("lastname is not null");
            return (Criteria) this;
        }

        public Criteria andLastnameEqualTo(String value) {
            addCriterion("lastname =", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotEqualTo(String value) {
            addCriterion("lastname <>", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameGreaterThan(String value) {
            addCriterion("lastname >", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameGreaterThanOrEqualTo(String value) {
            addCriterion("lastname >=", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameLessThan(String value) {
            addCriterion("lastname <", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameLessThanOrEqualTo(String value) {
            addCriterion("lastname <=", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameLike(String value) {
            addCriterion("lastname like", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotLike(String value) {
            addCriterion("lastname not like", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameIn(List<String> values) {
            addCriterion("lastname in", values, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotIn(List<String> values) {
            addCriterion("lastname not in", values, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameBetween(String value1, String value2) {
            addCriterion("lastname between", value1, value2, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotBetween(String value1, String value2) {
            addCriterion("lastname not between", value1, value2, "lastname");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andOrgIsNull() {
            addCriterion("org is null");
            return (Criteria) this;
        }

        public Criteria andOrgIsNotNull() {
            addCriterion("org is not null");
            return (Criteria) this;
        }

        public Criteria andOrgEqualTo(String value) {
            addCriterion("org =", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgNotEqualTo(String value) {
            addCriterion("org <>", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgGreaterThan(String value) {
            addCriterion("org >", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgGreaterThanOrEqualTo(String value) {
            addCriterion("org >=", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgLessThan(String value) {
            addCriterion("org <", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgLessThanOrEqualTo(String value) {
            addCriterion("org <=", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgLike(String value) {
            addCriterion("org like", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgNotLike(String value) {
            addCriterion("org not like", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgIn(List<String> values) {
            addCriterion("org in", values, "org");
            return (Criteria) this;
        }

        public Criteria andOrgNotIn(List<String> values) {
            addCriterion("org not in", values, "org");
            return (Criteria) this;
        }

        public Criteria andOrgBetween(String value1, String value2) {
            addCriterion("org between", value1, value2, "org");
            return (Criteria) this;
        }

        public Criteria andOrgNotBetween(String value1, String value2) {
            addCriterion("org not between", value1, value2, "org");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNull() {
            addCriterion("school_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNotNull() {
            addCriterion("school_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdEqualTo(Long value) {
            addCriterion("school_id =", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotEqualTo(Long value) {
            addCriterion("school_id <>", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThan(Long value) {
            addCriterion("school_id >", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThanOrEqualTo(Long value) {
            addCriterion("school_id >=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThan(Long value) {
            addCriterion("school_id <", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThanOrEqualTo(Long value) {
            addCriterion("school_id <=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIn(List<Long> values) {
            addCriterion("school_id in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotIn(List<Long> values) {
            addCriterion("school_id not in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdBetween(Long value1, Long value2) {
            addCriterion("school_id between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotBetween(Long value1, Long value2) {
            addCriterion("school_id not between", value1, value2, "schoolId");
            return (Criteria) this;
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

        public Criteria andSchoolRegionIsNull() {
            addCriterion("school_region is null");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionIsNotNull() {
            addCriterion("school_region is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionEqualTo(String value) {
            addCriterion("school_region =", value, "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionNotEqualTo(String value) {
            addCriterion("school_region <>", value, "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionGreaterThan(String value) {
            addCriterion("school_region >", value, "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionGreaterThanOrEqualTo(String value) {
            addCriterion("school_region >=", value, "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionLessThan(String value) {
            addCriterion("school_region <", value, "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionLessThanOrEqualTo(String value) {
            addCriterion("school_region <=", value, "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionLike(String value) {
            addCriterion("school_region like", value, "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionNotLike(String value) {
            addCriterion("school_region not like", value, "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionIn(List<String> values) {
            addCriterion("school_region in", values, "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionNotIn(List<String> values) {
            addCriterion("school_region not in", values, "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionBetween(String value1, String value2) {
            addCriterion("school_region between", value1, value2, "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionNotBetween(String value1, String value2) {
            addCriterion("school_region not between", value1, value2, "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNull() {
            addCriterion("school_name is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNotNull() {
            addCriterion("school_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEqualTo(String value) {
            addCriterion("school_name =", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotEqualTo(String value) {
            addCriterion("school_name <>", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThan(String value) {
            addCriterion("school_name >", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("school_name >=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThan(String value) {
            addCriterion("school_name <", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThanOrEqualTo(String value) {
            addCriterion("school_name <=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLike(String value) {
            addCriterion("school_name like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotLike(String value) {
            addCriterion("school_name not like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIn(List<String> values) {
            addCriterion("school_name in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotIn(List<String> values) {
            addCriterion("school_name not in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameBetween(String value1, String value2) {
            addCriterion("school_name between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotBetween(String value1, String value2) {
            addCriterion("school_name not between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andIsBlockedIsNull() {
            addCriterion("is_blocked is null");
            return (Criteria) this;
        }

        public Criteria andIsBlockedIsNotNull() {
            addCriterion("is_blocked is not null");
            return (Criteria) this;
        }

        public Criteria andIsBlockedEqualTo(String value) {
            addCriterion("is_blocked =", value, "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsBlockedNotEqualTo(String value) {
            addCriterion("is_blocked <>", value, "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsBlockedGreaterThan(String value) {
            addCriterion("is_blocked >", value, "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsBlockedGreaterThanOrEqualTo(String value) {
            addCriterion("is_blocked >=", value, "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsBlockedLessThan(String value) {
            addCriterion("is_blocked <", value, "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsBlockedLessThanOrEqualTo(String value) {
            addCriterion("is_blocked <=", value, "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsBlockedLike(String value) {
            addCriterion("is_blocked like", value, "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsBlockedNotLike(String value) {
            addCriterion("is_blocked not like", value, "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsBlockedIn(List<String> values) {
            addCriterion("is_blocked in", values, "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsBlockedNotIn(List<String> values) {
            addCriterion("is_blocked not in", values, "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsBlockedBetween(String value1, String value2) {
            addCriterion("is_blocked between", value1, value2, "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsBlockedNotBetween(String value1, String value2) {
            addCriterion("is_blocked not between", value1, value2, "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNull() {
            addCriterion("is_active is null");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNotNull() {
            addCriterion("is_active is not null");
            return (Criteria) this;
        }

        public Criteria andIsActiveEqualTo(String value) {
            addCriterion("is_active =", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotEqualTo(String value) {
            addCriterion("is_active <>", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThan(String value) {
            addCriterion("is_active >", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThanOrEqualTo(String value) {
            addCriterion("is_active >=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThan(String value) {
            addCriterion("is_active <", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThanOrEqualTo(String value) {
            addCriterion("is_active <=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLike(String value) {
            addCriterion("is_active like", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotLike(String value) {
            addCriterion("is_active not like", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveIn(List<String> values) {
            addCriterion("is_active in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotIn(List<String> values) {
            addCriterion("is_active not in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveBetween(String value1, String value2) {
            addCriterion("is_active between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotBetween(String value1, String value2) {
            addCriterion("is_active not between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingIsNull() {
            addCriterion("blackList_ranking is null");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingIsNotNull() {
            addCriterion("blackList_ranking is not null");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingEqualTo(String value) {
            addCriterion("blackList_ranking =", value, "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingNotEqualTo(String value) {
            addCriterion("blackList_ranking <>", value, "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingGreaterThan(String value) {
            addCriterion("blackList_ranking >", value, "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingGreaterThanOrEqualTo(String value) {
            addCriterion("blackList_ranking >=", value, "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingLessThan(String value) {
            addCriterion("blackList_ranking <", value, "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingLessThanOrEqualTo(String value) {
            addCriterion("blackList_ranking <=", value, "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingLike(String value) {
            addCriterion("blackList_ranking like", value, "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingNotLike(String value) {
            addCriterion("blackList_ranking not like", value, "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingIn(List<String> values) {
            addCriterion("blackList_ranking in", values, "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingNotIn(List<String> values) {
            addCriterion("blackList_ranking not in", values, "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingBetween(String value1, String value2) {
            addCriterion("blackList_ranking between", value1, value2, "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingNotBetween(String value1, String value2) {
            addCriterion("blackList_ranking not between", value1, value2, "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andImageWidthIsNull() {
            addCriterion("image_width is null");
            return (Criteria) this;
        }

        public Criteria andImageWidthIsNotNull() {
            addCriterion("image_width is not null");
            return (Criteria) this;
        }

        public Criteria andImageWidthEqualTo(String value) {
            addCriterion("image_width =", value, "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageWidthNotEqualTo(String value) {
            addCriterion("image_width <>", value, "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageWidthGreaterThan(String value) {
            addCriterion("image_width >", value, "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageWidthGreaterThanOrEqualTo(String value) {
            addCriterion("image_width >=", value, "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageWidthLessThan(String value) {
            addCriterion("image_width <", value, "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageWidthLessThanOrEqualTo(String value) {
            addCriterion("image_width <=", value, "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageWidthLike(String value) {
            addCriterion("image_width like", value, "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageWidthNotLike(String value) {
            addCriterion("image_width not like", value, "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageWidthIn(List<String> values) {
            addCriterion("image_width in", values, "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageWidthNotIn(List<String> values) {
            addCriterion("image_width not in", values, "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageWidthBetween(String value1, String value2) {
            addCriterion("image_width between", value1, value2, "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageWidthNotBetween(String value1, String value2) {
            addCriterion("image_width not between", value1, value2, "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageHeightIsNull() {
            addCriterion("image_height is null");
            return (Criteria) this;
        }

        public Criteria andImageHeightIsNotNull() {
            addCriterion("image_height is not null");
            return (Criteria) this;
        }

        public Criteria andImageHeightEqualTo(String value) {
            addCriterion("image_height =", value, "imageHeight");
            return (Criteria) this;
        }

        public Criteria andImageHeightNotEqualTo(String value) {
            addCriterion("image_height <>", value, "imageHeight");
            return (Criteria) this;
        }

        public Criteria andImageHeightGreaterThan(String value) {
            addCriterion("image_height >", value, "imageHeight");
            return (Criteria) this;
        }

        public Criteria andImageHeightGreaterThanOrEqualTo(String value) {
            addCriterion("image_height >=", value, "imageHeight");
            return (Criteria) this;
        }

        public Criteria andImageHeightLessThan(String value) {
            addCriterion("image_height <", value, "imageHeight");
            return (Criteria) this;
        }

        public Criteria andImageHeightLessThanOrEqualTo(String value) {
            addCriterion("image_height <=", value, "imageHeight");
            return (Criteria) this;
        }

        public Criteria andImageHeightLike(String value) {
            addCriterion("image_height like", value, "imageHeight");
            return (Criteria) this;
        }

        public Criteria andImageHeightNotLike(String value) {
            addCriterion("image_height not like", value, "imageHeight");
            return (Criteria) this;
        }

        public Criteria andImageHeightIn(List<String> values) {
            addCriterion("image_height in", values, "imageHeight");
            return (Criteria) this;
        }

        public Criteria andImageHeightNotIn(List<String> values) {
            addCriterion("image_height not in", values, "imageHeight");
            return (Criteria) this;
        }

        public Criteria andImageHeightBetween(String value1, String value2) {
            addCriterion("image_height between", value1, value2, "imageHeight");
            return (Criteria) this;
        }

        public Criteria andImageHeightNotBetween(String value1, String value2) {
            addCriterion("image_height not between", value1, value2, "imageHeight");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordIsNull() {
            addCriterion("forget_password is null");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordIsNotNull() {
            addCriterion("forget_password is not null");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordEqualTo(String value) {
            addCriterion("forget_password =", value, "forgetPassword");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordNotEqualTo(String value) {
            addCriterion("forget_password <>", value, "forgetPassword");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordGreaterThan(String value) {
            addCriterion("forget_password >", value, "forgetPassword");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("forget_password >=", value, "forgetPassword");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordLessThan(String value) {
            addCriterion("forget_password <", value, "forgetPassword");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordLessThanOrEqualTo(String value) {
            addCriterion("forget_password <=", value, "forgetPassword");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordLike(String value) {
            addCriterion("forget_password like", value, "forgetPassword");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordNotLike(String value) {
            addCriterion("forget_password not like", value, "forgetPassword");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordIn(List<String> values) {
            addCriterion("forget_password in", values, "forgetPassword");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordNotIn(List<String> values) {
            addCriterion("forget_password not in", values, "forgetPassword");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordBetween(String value1, String value2) {
            addCriterion("forget_password between", value1, value2, "forgetPassword");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordNotBetween(String value1, String value2) {
            addCriterion("forget_password not between", value1, value2, "forgetPassword");
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

        public Criteria andPublishTimeEqualTo(String value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(String value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(String value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(String value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(String value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLike(String value) {
            addCriterion("publish_time like", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotLike(String value) {
            addCriterion("publish_time not like", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<String> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<String> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(String value1, String value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(String value1, String value2) {
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

        public Criteria andLastUpdateTimeEqualTo(String value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(String value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(String value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(String value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLike(String value) {
            addCriterion("last_update_time like", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotLike(String value) {
            addCriterion("last_update_time not like", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<String> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<String> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(String value1, String value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andUnionidIsNull() {
            addCriterion("unionid is null");
            return (Criteria) this;
        }

        public Criteria andUnionidIsNotNull() {
            addCriterion("unionid is not null");
            return (Criteria) this;
        }

        public Criteria andUnionidEqualTo(String value) {
            addCriterion("unionid =", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotEqualTo(String value) {
            addCriterion("unionid <>", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidGreaterThan(String value) {
            addCriterion("unionid >", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidGreaterThanOrEqualTo(String value) {
            addCriterion("unionid >=", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidLessThan(String value) {
            addCriterion("unionid <", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidLessThanOrEqualTo(String value) {
            addCriterion("unionid <=", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidLike(String value) {
            addCriterion("unionid like", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotLike(String value) {
            addCriterion("unionid not like", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidIn(List<String> values) {
            addCriterion("unionid in", values, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotIn(List<String> values) {
            addCriterion("unionid not in", values, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidBetween(String value1, String value2) {
            addCriterion("unionid between", value1, value2, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotBetween(String value1, String value2) {
            addCriterion("unionid not between", value1, value2, "unionid");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeIsNull() {
            addCriterion("wechat_privilege is null");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeIsNotNull() {
            addCriterion("wechat_privilege is not null");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeEqualTo(String value) {
            addCriterion("wechat_privilege =", value, "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeNotEqualTo(String value) {
            addCriterion("wechat_privilege <>", value, "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeGreaterThan(String value) {
            addCriterion("wechat_privilege >", value, "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_privilege >=", value, "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeLessThan(String value) {
            addCriterion("wechat_privilege <", value, "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeLessThanOrEqualTo(String value) {
            addCriterion("wechat_privilege <=", value, "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeLike(String value) {
            addCriterion("wechat_privilege like", value, "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeNotLike(String value) {
            addCriterion("wechat_privilege not like", value, "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeIn(List<String> values) {
            addCriterion("wechat_privilege in", values, "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeNotIn(List<String> values) {
            addCriterion("wechat_privilege not in", values, "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeBetween(String value1, String value2) {
            addCriterion("wechat_privilege between", value1, value2, "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeNotBetween(String value1, String value2) {
            addCriterion("wechat_privilege not between", value1, value2, "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andQqVipIsNull() {
            addCriterion("qq_vip is null");
            return (Criteria) this;
        }

        public Criteria andQqVipIsNotNull() {
            addCriterion("qq_vip is not null");
            return (Criteria) this;
        }

        public Criteria andQqVipEqualTo(String value) {
            addCriterion("qq_vip =", value, "qqVip");
            return (Criteria) this;
        }

        public Criteria andQqVipNotEqualTo(String value) {
            addCriterion("qq_vip <>", value, "qqVip");
            return (Criteria) this;
        }

        public Criteria andQqVipGreaterThan(String value) {
            addCriterion("qq_vip >", value, "qqVip");
            return (Criteria) this;
        }

        public Criteria andQqVipGreaterThanOrEqualTo(String value) {
            addCriterion("qq_vip >=", value, "qqVip");
            return (Criteria) this;
        }

        public Criteria andQqVipLessThan(String value) {
            addCriterion("qq_vip <", value, "qqVip");
            return (Criteria) this;
        }

        public Criteria andQqVipLessThanOrEqualTo(String value) {
            addCriterion("qq_vip <=", value, "qqVip");
            return (Criteria) this;
        }

        public Criteria andQqVipLike(String value) {
            addCriterion("qq_vip like", value, "qqVip");
            return (Criteria) this;
        }

        public Criteria andQqVipNotLike(String value) {
            addCriterion("qq_vip not like", value, "qqVip");
            return (Criteria) this;
        }

        public Criteria andQqVipIn(List<String> values) {
            addCriterion("qq_vip in", values, "qqVip");
            return (Criteria) this;
        }

        public Criteria andQqVipNotIn(List<String> values) {
            addCriterion("qq_vip not in", values, "qqVip");
            return (Criteria) this;
        }

        public Criteria andQqVipBetween(String value1, String value2) {
            addCriterion("qq_vip between", value1, value2, "qqVip");
            return (Criteria) this;
        }

        public Criteria andQqVipNotBetween(String value1, String value2) {
            addCriterion("qq_vip not between", value1, value2, "qqVip");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryIsNull() {
            addCriterion("PHONE_COUNTRY is null");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryIsNotNull() {
            addCriterion("PHONE_COUNTRY is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryEqualTo(String value) {
            addCriterion("PHONE_COUNTRY =", value, "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryNotEqualTo(String value) {
            addCriterion("PHONE_COUNTRY <>", value, "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryGreaterThan(String value) {
            addCriterion("PHONE_COUNTRY >", value, "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_COUNTRY >=", value, "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryLessThan(String value) {
            addCriterion("PHONE_COUNTRY <", value, "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryLessThanOrEqualTo(String value) {
            addCriterion("PHONE_COUNTRY <=", value, "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryLike(String value) {
            addCriterion("PHONE_COUNTRY like", value, "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryNotLike(String value) {
            addCriterion("PHONE_COUNTRY not like", value, "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryIn(List<String> values) {
            addCriterion("PHONE_COUNTRY in", values, "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryNotIn(List<String> values) {
            addCriterion("PHONE_COUNTRY not in", values, "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryBetween(String value1, String value2) {
            addCriterion("PHONE_COUNTRY between", value1, value2, "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryNotBetween(String value1, String value2) {
            addCriterion("PHONE_COUNTRY not between", value1, value2, "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(String value) {
            addCriterion("identity =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(String value) {
            addCriterion("identity <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(String value) {
            addCriterion("identity >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("identity >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(String value) {
            addCriterion("identity <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(String value) {
            addCriterion("identity <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLike(String value) {
            addCriterion("identity like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotLike(String value) {
            addCriterion("identity not like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<String> values) {
            addCriterion("identity in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<String> values) {
            addCriterion("identity not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(String value1, String value2) {
            addCriterion("identity between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(String value1, String value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andPassChangedTimeIsNull() {
            addCriterion("PASS_CHANGED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPassChangedTimeIsNotNull() {
            addCriterion("PASS_CHANGED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPassChangedTimeEqualTo(Date value) {
            addCriterion("PASS_CHANGED_TIME =", value, "passChangedTime");
            return (Criteria) this;
        }

        public Criteria andPassChangedTimeNotEqualTo(Date value) {
            addCriterion("PASS_CHANGED_TIME <>", value, "passChangedTime");
            return (Criteria) this;
        }

        public Criteria andPassChangedTimeGreaterThan(Date value) {
            addCriterion("PASS_CHANGED_TIME >", value, "passChangedTime");
            return (Criteria) this;
        }

        public Criteria andPassChangedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PASS_CHANGED_TIME >=", value, "passChangedTime");
            return (Criteria) this;
        }

        public Criteria andPassChangedTimeLessThan(Date value) {
            addCriterion("PASS_CHANGED_TIME <", value, "passChangedTime");
            return (Criteria) this;
        }

        public Criteria andPassChangedTimeLessThanOrEqualTo(Date value) {
            addCriterion("PASS_CHANGED_TIME <=", value, "passChangedTime");
            return (Criteria) this;
        }

        public Criteria andPassChangedTimeIn(List<Date> values) {
            addCriterion("PASS_CHANGED_TIME in", values, "passChangedTime");
            return (Criteria) this;
        }

        public Criteria andPassChangedTimeNotIn(List<Date> values) {
            addCriterion("PASS_CHANGED_TIME not in", values, "passChangedTime");
            return (Criteria) this;
        }

        public Criteria andPassChangedTimeBetween(Date value1, Date value2) {
            addCriterion("PASS_CHANGED_TIME between", value1, value2, "passChangedTime");
            return (Criteria) this;
        }

        public Criteria andPassChangedTimeNotBetween(Date value1, Date value2) {
            addCriterion("PASS_CHANGED_TIME not between", value1, value2, "passChangedTime");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNull() {
            addCriterion("PERMISSION is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNotNull() {
            addCriterion("PERMISSION is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionEqualTo(String value) {
            addCriterion("PERMISSION =", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotEqualTo(String value) {
            addCriterion("PERMISSION <>", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThan(String value) {
            addCriterion("PERMISSION >", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThanOrEqualTo(String value) {
            addCriterion("PERMISSION >=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThan(String value) {
            addCriterion("PERMISSION <", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThanOrEqualTo(String value) {
            addCriterion("PERMISSION <=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLike(String value) {
            addCriterion("PERMISSION like", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotLike(String value) {
            addCriterion("PERMISSION not like", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionIn(List<String> values) {
            addCriterion("PERMISSION in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotIn(List<String> values) {
            addCriterion("PERMISSION not in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionBetween(String value1, String value2) {
            addCriterion("PERMISSION between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotBetween(String value1, String value2) {
            addCriterion("PERMISSION not between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdIsNull() {
            addCriterion("EBROKER_ID is null");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdIsNotNull() {
            addCriterion("EBROKER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdEqualTo(String value) {
            addCriterion("EBROKER_ID =", value, "ebrokerId");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdNotEqualTo(String value) {
            addCriterion("EBROKER_ID <>", value, "ebrokerId");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdGreaterThan(String value) {
            addCriterion("EBROKER_ID >", value, "ebrokerId");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdGreaterThanOrEqualTo(String value) {
            addCriterion("EBROKER_ID >=", value, "ebrokerId");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdLessThan(String value) {
            addCriterion("EBROKER_ID <", value, "ebrokerId");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdLessThanOrEqualTo(String value) {
            addCriterion("EBROKER_ID <=", value, "ebrokerId");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdLike(String value) {
            addCriterion("EBROKER_ID like", value, "ebrokerId");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdNotLike(String value) {
            addCriterion("EBROKER_ID not like", value, "ebrokerId");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdIn(List<String> values) {
            addCriterion("EBROKER_ID in", values, "ebrokerId");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdNotIn(List<String> values) {
            addCriterion("EBROKER_ID not in", values, "ebrokerId");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdBetween(String value1, String value2) {
            addCriterion("EBROKER_ID between", value1, value2, "ebrokerId");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdNotBetween(String value1, String value2) {
            addCriterion("EBROKER_ID not between", value1, value2, "ebrokerId");
            return (Criteria) this;
        }

        public Criteria andUseridLikeInsensitive(String value) {
            addCriterion("upper(USERID) like", value.toUpperCase(), "userid");
            return (Criteria) this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(EMAIL) like", value.toUpperCase(), "email");
            return (Criteria) this;
        }

        public Criteria andUsernameLikeInsensitive(String value) {
            addCriterion("upper(USERNAME) like", value.toUpperCase(), "username");
            return (Criteria) this;
        }

        public Criteria andPasswordLikeInsensitive(String value) {
            addCriterion("upper(PASSWORD) like", value.toUpperCase(), "password");
            return (Criteria) this;
        }

        public Criteria andSaltLikeInsensitive(String value) {
            addCriterion("upper(SALT) like", value.toUpperCase(), "salt");
            return (Criteria) this;
        }

        public Criteria andPhoneLikeInsensitive(String value) {
            addCriterion("upper(PHONE) like", value.toUpperCase(), "phone");
            return (Criteria) this;
        }

        public Criteria andCountryLikeInsensitive(String value) {
            addCriterion("upper(COUNTRY) like", value.toUpperCase(), "country");
            return (Criteria) this;
        }

        public Criteria andLanguageLikeInsensitive(String value) {
            addCriterion("upper(LANGUAGE) like", value.toUpperCase(), "language");
            return (Criteria) this;
        }

        public Criteria andSchoolLikeInsensitive(String value) {
            addCriterion("upper(SCHOOL) like", value.toUpperCase(), "school");
            return (Criteria) this;
        }

        public Criteria andServiceLikeInsensitive(String value) {
            addCriterion("upper(SERVICE) like", value.toUpperCase(), "service");
            return (Criteria) this;
        }

        public Criteria andFirstnameLikeInsensitive(String value) {
            addCriterion("upper(firstname) like", value.toUpperCase(), "firstname");
            return (Criteria) this;
        }

        public Criteria andLastnameLikeInsensitive(String value) {
            addCriterion("upper(lastname) like", value.toUpperCase(), "lastname");
            return (Criteria) this;
        }

        public Criteria andLocationLikeInsensitive(String value) {
            addCriterion("upper(location) like", value.toUpperCase(), "location");
            return (Criteria) this;
        }

        public Criteria andOrgLikeInsensitive(String value) {
            addCriterion("upper(org) like", value.toUpperCase(), "org");
            return (Criteria) this;
        }

        public Criteria andSexLikeInsensitive(String value) {
            addCriterion("upper(sex) like", value.toUpperCase(), "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayLikeInsensitive(String value) {
            addCriterion("upper(birthday) like", value.toUpperCase(), "birthday");
            return (Criteria) this;
        }

        public Criteria andSchoolKeyLikeInsensitive(String value) {
            addCriterion("upper(school_key) like", value.toUpperCase(), "schoolKey");
            return (Criteria) this;
        }

        public Criteria andSchoolRegionLikeInsensitive(String value) {
            addCriterion("upper(school_region) like", value.toUpperCase(), "schoolRegion");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLikeInsensitive(String value) {
            addCriterion("upper(school_name) like", value.toUpperCase(), "schoolName");
            return (Criteria) this;
        }

        public Criteria andIsBlockedLikeInsensitive(String value) {
            addCriterion("upper(is_blocked) like", value.toUpperCase(), "isBlocked");
            return (Criteria) this;
        }

        public Criteria andIsActiveLikeInsensitive(String value) {
            addCriterion("upper(is_active) like", value.toUpperCase(), "isActive");
            return (Criteria) this;
        }

        public Criteria andBlacklistRankingLikeInsensitive(String value) {
            addCriterion("upper(blackList_ranking) like", value.toUpperCase(), "blacklistRanking");
            return (Criteria) this;
        }

        public Criteria andImageWidthLikeInsensitive(String value) {
            addCriterion("upper(image_width) like", value.toUpperCase(), "imageWidth");
            return (Criteria) this;
        }

        public Criteria andImageHeightLikeInsensitive(String value) {
            addCriterion("upper(image_height) like", value.toUpperCase(), "imageHeight");
            return (Criteria) this;
        }

        public Criteria andForgetPasswordLikeInsensitive(String value) {
            addCriterion("upper(forget_password) like", value.toUpperCase(), "forgetPassword");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLikeInsensitive(String value) {
            addCriterion("upper(publish_time) like", value.toUpperCase(), "publishTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLikeInsensitive(String value) {
            addCriterion("upper(last_update_time) like", value.toUpperCase(), "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOpenidLikeInsensitive(String value) {
            addCriterion("upper(openid) like", value.toUpperCase(), "openid");
            return (Criteria) this;
        }

        public Criteria andUnionidLikeInsensitive(String value) {
            addCriterion("upper(unionid) like", value.toUpperCase(), "unionid");
            return (Criteria) this;
        }

        public Criteria andCityLikeInsensitive(String value) {
            addCriterion("upper(city) like", value.toUpperCase(), "city");
            return (Criteria) this;
        }

        public Criteria andProvinceLikeInsensitive(String value) {
            addCriterion("upper(province) like", value.toUpperCase(), "province");
            return (Criteria) this;
        }

        public Criteria andWechatPrivilegeLikeInsensitive(String value) {
            addCriterion("upper(wechat_privilege) like", value.toUpperCase(), "wechatPrivilege");
            return (Criteria) this;
        }

        public Criteria andQqVipLikeInsensitive(String value) {
            addCriterion("upper(qq_vip) like", value.toUpperCase(), "qqVip");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryLikeInsensitive(String value) {
            addCriterion("upper(PHONE_COUNTRY) like", value.toUpperCase(), "phoneCountry");
            return (Criteria) this;
        }

        public Criteria andIdentityLikeInsensitive(String value) {
            addCriterion("upper(identity) like", value.toUpperCase(), "identity");
            return (Criteria) this;
        }

        public Criteria andPermissionLikeInsensitive(String value) {
            addCriterion("upper(PERMISSION) like", value.toUpperCase(), "permission");
            return (Criteria) this;
        }

        public Criteria andEbrokerIdLikeInsensitive(String value) {
            addCriterion("upper(EBROKER_ID) like", value.toUpperCase(), "ebrokerId");
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