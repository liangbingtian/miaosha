package com.imooc.miaosha.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * 的查询类
 * miaosha_user
 * @author liuqiangm
 *
 */
public class MiaoshaUserExample {

    protected List<String> updateFields;

    /**
     */
    protected String orderByClause;

    /**
     */
    protected boolean distinct;
	
    /**
     *
     */
    protected Integer startPos;

    /**
     *
     */
    protected Integer pageSize;

    /**
     */
    protected List<Criteria> oredCriteria;

    public MiaoshaUserExample updateIdField() {
        updateFields.add("id");
        return this;
    }

    public MiaoshaUserExample updateNicknameField() {
        updateFields.add("nickname");
        return this;
    }

    public MiaoshaUserExample updatePasswordField() {
        updateFields.add("password");
        return this;
    }

    public MiaoshaUserExample updateSaltField() {
        updateFields.add("salt");
        return this;
    }

    public MiaoshaUserExample updateHeadField() {
        updateFields.add("head");
        return this;
    }

    public MiaoshaUserExample updateRegisterDateField() {
        updateFields.add("register_date");
        return this;
    }

    public MiaoshaUserExample updateLastLoginDateField() {
        updateFields.add("last_login_date");
        return this;
    }

    public MiaoshaUserExample updateLoginCountField() {
        updateFields.add("login_count");
        return this;
    }

    public MiaoshaUserExample addPageNumAndPageSize(Integer pageNum, Integer pageSize) {
        if(pageNum != null && pageSize != null) {
            this.setStartPos((pageNum - 1) * pageSize);
            this.setPageSize(pageSize);
        }
        return this;
    }

    public MiaoshaUserExample addPageNumAndPageSize(String pageNum, String pageSize) {
        if(pageNum != null && pageSize != null) {
            int num = Integer.valueOf(pageNum);
            int size = Integer.valueOf(pageSize);
            this.setStartPos((num - 1) * size);
            this.setPageSize(size);
        }
        return this;
    }

    public MiaoshaUserExample() {
        oredCriteria = new ArrayList<Criteria>();
        updateFields = new ArrayList<String>();
    }
	
    public Integer getStartPos() {
        return startPos;
    }

    public void setStartPos(Integer startPos) {
        this.startPos = startPos;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public MiaoshaUserExample orderByIdAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`id` asc";
        }
        else {
            orderByClause += ",`id` asc";
        }
        return this;
    }

    public MiaoshaUserExample orderByIdDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`id` desc";
        }
        else {
            orderByClause += ",`id` desc";
        }
        return this;
    }
    public MiaoshaUserExample orderByNicknameAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`nickname` asc";
        }
        else {
            orderByClause += ",`nickname` asc";
        }
        return this;
    }

    public MiaoshaUserExample orderByNicknameDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`nickname` desc";
        }
        else {
            orderByClause += ",`nickname` desc";
        }
        return this;
    }
    public MiaoshaUserExample orderByPasswordAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`password` asc";
        }
        else {
            orderByClause += ",`password` asc";
        }
        return this;
    }

    public MiaoshaUserExample orderByPasswordDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`password` desc";
        }
        else {
            orderByClause += ",`password` desc";
        }
        return this;
    }
    public MiaoshaUserExample orderBySaltAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`salt` asc";
        }
        else {
            orderByClause += ",`salt` asc";
        }
        return this;
    }

    public MiaoshaUserExample orderBySaltDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`salt` desc";
        }
        else {
            orderByClause += ",`salt` desc";
        }
        return this;
    }
    public MiaoshaUserExample orderByHeadAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`head` asc";
        }
        else {
            orderByClause += ",`head` asc";
        }
        return this;
    }

    public MiaoshaUserExample orderByHeadDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`head` desc";
        }
        else {
            orderByClause += ",`head` desc";
        }
        return this;
    }
    public MiaoshaUserExample orderByRegisterDateAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`register_date` asc";
        }
        else {
            orderByClause += ",`register_date` asc";
        }
        return this;
    }

    public MiaoshaUserExample orderByRegisterDateDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`register_date` desc";
        }
        else {
            orderByClause += ",`register_date` desc";
        }
        return this;
    }
    public MiaoshaUserExample orderByLastLoginDateAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`last_login_date` asc";
        }
        else {
            orderByClause += ",`last_login_date` asc";
        }
        return this;
    }

    public MiaoshaUserExample orderByLastLoginDateDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`last_login_date` desc";
        }
        else {
            orderByClause += ",`last_login_date` desc";
        }
        return this;
    }
    public MiaoshaUserExample orderByLoginCountAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`login_count` asc";
        }
        else {
            orderByClause += ",`login_count` asc";
        }
        return this;
    }

    public MiaoshaUserExample orderByLoginCountDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`login_count` desc";
        }
        else {
            orderByClause += ",`login_count` desc";
        }
        return this;
    }

	
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
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
        if(!oredCriteria.contains(criteria)) {
            oredCriteria.add(criteria);
        }
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
        protected List<Criterion> andcriteria;

        protected List<Criterion> orcriteria;

        protected GeneratedCriteria() {
            super();
            andcriteria = new ArrayList<Criterion>();
            orcriteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return andcriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            List<Criterion> list = new ArrayList<Criterion>(andcriteria.size() + orcriteria.size());
            list.addAll(andcriteria);
            list.addAll(orcriteria);
            return list;
        }

        public List<Criterion> getAndcriteria() {
            return andcriteria;
        }

        public List<Criterion> getOrcriteria() {
            return orcriteria;
        }

        protected void addOrCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            orcriteria.add(new Criterion(condition));
        }

        protected void addOrCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            orcriteria.add(new Criterion(condition, value));
        }

        protected void addOrCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            orcriteria.add(new Criterion(condition, value1, value2));
        }

        protected void addAndCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            andcriteria.add(new Criterion(condition));
        }

        protected void addAndCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            andcriteria.add(new Criterion(condition, value));
        }

        protected void addAndCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            andcriteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addAndCriterion("`id` is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addAndCriterion("`id` is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addAndCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addAndCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addAndCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addAndCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addAndCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addAndCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addAndCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addAndCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addAndCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addAndCriterion("`id` not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addAndCriterion("`nickname` is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addAndCriterion("`nickname` is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addAndCriterion("`nickname` =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addAndCriterion("`nickname` <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addAndCriterion("`nickname` >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addAndCriterion("`nickname` >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addAndCriterion("`nickname` <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addAndCriterion("`nickname` <=", value, "nickname");
            return (Criteria) this;
        }
        public Criteria andNicknameLike(String value) {
            addAndCriterion("`nickname` like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addAndCriterion("`nickname` not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addAndCriterion("`nickname` in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addAndCriterion("`nickname` not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addAndCriterion("`nickname` between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addAndCriterion("`nickname` not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addAndCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addAndCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addAndCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addAndCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addAndCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addAndCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addAndCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addAndCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }
        public Criteria andPasswordLike(String value) {
            addAndCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addAndCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addAndCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addAndCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addAndCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addAndCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            addAndCriterion("`salt` is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            addAndCriterion("`salt` is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(String value) {
            addAndCriterion("`salt` =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(String value) {
            addAndCriterion("`salt` <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addAndCriterion("`salt` >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addAndCriterion("`salt` >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addAndCriterion("`salt` <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addAndCriterion("`salt` <=", value, "salt");
            return (Criteria) this;
        }
        public Criteria andSaltLike(String value) {
            addAndCriterion("`salt` like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addAndCriterion("`salt` not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(List<String> values) {
            addAndCriterion("`salt` in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addAndCriterion("`salt` not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addAndCriterion("`salt` between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addAndCriterion("`salt` not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andHeadIsNull() {
            addAndCriterion("`head` is null");
            return (Criteria) this;
        }

        public Criteria andHeadIsNotNull() {
            addAndCriterion("`head` is not null");
            return (Criteria) this;
        }

        public Criteria andHeadEqualTo(String value) {
            addAndCriterion("`head` =", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotEqualTo(String value) {
            addAndCriterion("`head` <>", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadGreaterThan(String value) {
            addAndCriterion("`head` >", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadGreaterThanOrEqualTo(String value) {
            addAndCriterion("`head` >=", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLessThan(String value) {
            addAndCriterion("`head` <", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLessThanOrEqualTo(String value) {
            addAndCriterion("`head` <=", value, "head");
            return (Criteria) this;
        }
        public Criteria andHeadLike(String value) {
            addAndCriterion("`head` like", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotLike(String value) {
            addAndCriterion("`head` not like", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadIn(List<String> values) {
            addAndCriterion("`head` in", values, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotIn(List<String> values) {
            addAndCriterion("`head` not in", values, "head");
            return (Criteria) this;
        }

        public Criteria andHeadBetween(String value1, String value2) {
            addAndCriterion("`head` between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotBetween(String value1, String value2) {
            addAndCriterion("`head` not between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNull() {
            addAndCriterion("`register_date` is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNotNull() {
            addAndCriterion("`register_date` is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateEqualTo(Date value) {
            addAndCriterion("`register_date` =", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotEqualTo(Date value) {
            addAndCriterion("`register_date` <>", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThan(Date value) {
            addAndCriterion("`register_date` >", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThanOrEqualTo(Date value) {
            addAndCriterion("`register_date` >=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThan(Date value) {
            addAndCriterion("`register_date` <", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThanOrEqualTo(Date value) {
            addAndCriterion("`register_date` <=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIn(List<Date> values) {
            addAndCriterion("`register_date` in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotIn(List<Date> values) {
            addAndCriterion("`register_date` not in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateBetween(Date value1, Date value2) {
            addAndCriterion("`register_date` between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotBetween(Date value1, Date value2) {
            addAndCriterion("`register_date` not between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIsNull() {
            addAndCriterion("`last_login_date` is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIsNotNull() {
            addAndCriterion("`last_login_date` is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateEqualTo(Date value) {
            addAndCriterion("`last_login_date` =", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotEqualTo(Date value) {
            addAndCriterion("`last_login_date` <>", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateGreaterThan(Date value) {
            addAndCriterion("`last_login_date` >", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateGreaterThanOrEqualTo(Date value) {
            addAndCriterion("`last_login_date` >=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateLessThan(Date value) {
            addAndCriterion("`last_login_date` <", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateLessThanOrEqualTo(Date value) {
            addAndCriterion("`last_login_date` <=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIn(List<Date> values) {
            addAndCriterion("`last_login_date` in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotIn(List<Date> values) {
            addAndCriterion("`last_login_date` not in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateBetween(Date value1, Date value2) {
            addAndCriterion("`last_login_date` between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotBetween(Date value1, Date value2) {
            addAndCriterion("`last_login_date` not between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLoginCountIsNull() {
            addAndCriterion("`login_count` is null");
            return (Criteria) this;
        }

        public Criteria andLoginCountIsNotNull() {
            addAndCriterion("`login_count` is not null");
            return (Criteria) this;
        }

        public Criteria andLoginCountEqualTo(Integer value) {
            addAndCriterion("`login_count` =", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountNotEqualTo(Integer value) {
            addAndCriterion("`login_count` <>", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountGreaterThan(Integer value) {
            addAndCriterion("`login_count` >", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountGreaterThanOrEqualTo(Integer value) {
            addAndCriterion("`login_count` >=", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountLessThan(Integer value) {
            addAndCriterion("`login_count` <", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountLessThanOrEqualTo(Integer value) {
            addAndCriterion("`login_count` <=", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountIn(List<Integer> values) {
            addAndCriterion("`login_count` in", values, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountNotIn(List<Integer> values) {
            addAndCriterion("`login_count` not in", values, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountBetween(Integer value1, Integer value2) {
            addAndCriterion("`login_count` between", value1, value2, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountNotBetween(Integer value1, Integer value2) {
            addAndCriterion("`login_count` not between", value1, value2, "loginCount");
            return (Criteria) this;
        }

        public Criteria orIdIsNull() {
            addOrCriterion("`id` is null");
            return (Criteria) this;
        }

        public Criteria orIdIsNotNull() {
            addOrCriterion("`id` is not null");
            return (Criteria) this;
        }

        public Criteria orIdEqualTo(Long value) {
            addOrCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdNotEqualTo(Long value) {
            addOrCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdGreaterThan(Long value) {
            addOrCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdGreaterThanOrEqualTo(Long value) {
            addOrCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdLessThan(Long value) {
            addOrCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdLessThanOrEqualTo(Long value) {
            addOrCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdIn(List<Long> values) {
            addOrCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria orIdNotIn(List<Long> values) {
            addOrCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria orIdBetween(Long value1, Long value2) {
            addOrCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria orIdNotBetween(Long value1, Long value2) {
            addOrCriterion("`id` not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria orNicknameIsNull() {
            addOrCriterion("`nickname` is null");
            return (Criteria) this;
        }

        public Criteria orNicknameIsNotNull() {
            addOrCriterion("`nickname` is not null");
            return (Criteria) this;
        }

        public Criteria orNicknameEqualTo(String value) {
            addOrCriterion("`nickname` =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameNotEqualTo(String value) {
            addOrCriterion("`nickname` <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameGreaterThan(String value) {
            addOrCriterion("`nickname` >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameGreaterThanOrEqualTo(String value) {
            addOrCriterion("`nickname` >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameLessThan(String value) {
            addOrCriterion("`nickname` <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameLessThanOrEqualTo(String value) {
            addOrCriterion("`nickname` <=", value, "nickname");
            return (Criteria) this;
        }
        public Criteria orNicknameLike(String value) {
            addOrCriterion("`nickname` like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameNotLike(String value) {
            addOrCriterion("`nickname` not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameIn(List<String> values) {
            addOrCriterion("`nickname` in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameNotIn(List<String> values) {
            addOrCriterion("`nickname` not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameBetween(String value1, String value2) {
            addOrCriterion("`nickname` between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria orNicknameNotBetween(String value1, String value2) {
            addOrCriterion("`nickname` not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria orPasswordIsNull() {
            addOrCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria orPasswordIsNotNull() {
            addOrCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria orPasswordEqualTo(String value) {
            addOrCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordNotEqualTo(String value) {
            addOrCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordGreaterThan(String value) {
            addOrCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordGreaterThanOrEqualTo(String value) {
            addOrCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordLessThan(String value) {
            addOrCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordLessThanOrEqualTo(String value) {
            addOrCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }
        public Criteria orPasswordLike(String value) {
            addOrCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordNotLike(String value) {
            addOrCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordIn(List<String> values) {
            addOrCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordNotIn(List<String> values) {
            addOrCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordBetween(String value1, String value2) {
            addOrCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria orPasswordNotBetween(String value1, String value2) {
            addOrCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria orSaltIsNull() {
            addOrCriterion("`salt` is null");
            return (Criteria) this;
        }

        public Criteria orSaltIsNotNull() {
            addOrCriterion("`salt` is not null");
            return (Criteria) this;
        }

        public Criteria orSaltEqualTo(String value) {
            addOrCriterion("`salt` =", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltNotEqualTo(String value) {
            addOrCriterion("`salt` <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltGreaterThan(String value) {
            addOrCriterion("`salt` >", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltGreaterThanOrEqualTo(String value) {
            addOrCriterion("`salt` >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltLessThan(String value) {
            addOrCriterion("`salt` <", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltLessThanOrEqualTo(String value) {
            addOrCriterion("`salt` <=", value, "salt");
            return (Criteria) this;
        }
        public Criteria orSaltLike(String value) {
            addOrCriterion("`salt` like", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltNotLike(String value) {
            addOrCriterion("`salt` not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltIn(List<String> values) {
            addOrCriterion("`salt` in", values, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltNotIn(List<String> values) {
            addOrCriterion("`salt` not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltBetween(String value1, String value2) {
            addOrCriterion("`salt` between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria orSaltNotBetween(String value1, String value2) {
            addOrCriterion("`salt` not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria orHeadIsNull() {
            addOrCriterion("`head` is null");
            return (Criteria) this;
        }

        public Criteria orHeadIsNotNull() {
            addOrCriterion("`head` is not null");
            return (Criteria) this;
        }

        public Criteria orHeadEqualTo(String value) {
            addOrCriterion("`head` =", value, "head");
            return (Criteria) this;
        }

        public Criteria orHeadNotEqualTo(String value) {
            addOrCriterion("`head` <>", value, "head");
            return (Criteria) this;
        }

        public Criteria orHeadGreaterThan(String value) {
            addOrCriterion("`head` >", value, "head");
            return (Criteria) this;
        }

        public Criteria orHeadGreaterThanOrEqualTo(String value) {
            addOrCriterion("`head` >=", value, "head");
            return (Criteria) this;
        }

        public Criteria orHeadLessThan(String value) {
            addOrCriterion("`head` <", value, "head");
            return (Criteria) this;
        }

        public Criteria orHeadLessThanOrEqualTo(String value) {
            addOrCriterion("`head` <=", value, "head");
            return (Criteria) this;
        }
        public Criteria orHeadLike(String value) {
            addOrCriterion("`head` like", value, "head");
            return (Criteria) this;
        }

        public Criteria orHeadNotLike(String value) {
            addOrCriterion("`head` not like", value, "head");
            return (Criteria) this;
        }

        public Criteria orHeadIn(List<String> values) {
            addOrCriterion("`head` in", values, "head");
            return (Criteria) this;
        }

        public Criteria orHeadNotIn(List<String> values) {
            addOrCriterion("`head` not in", values, "head");
            return (Criteria) this;
        }

        public Criteria orHeadBetween(String value1, String value2) {
            addOrCriterion("`head` between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria orHeadNotBetween(String value1, String value2) {
            addOrCriterion("`head` not between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria orRegisterDateIsNull() {
            addOrCriterion("`register_date` is null");
            return (Criteria) this;
        }

        public Criteria orRegisterDateIsNotNull() {
            addOrCriterion("`register_date` is not null");
            return (Criteria) this;
        }

        public Criteria orRegisterDateEqualTo(Date value) {
            addOrCriterion("`register_date` =", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria orRegisterDateNotEqualTo(Date value) {
            addOrCriterion("`register_date` <>", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria orRegisterDateGreaterThan(Date value) {
            addOrCriterion("`register_date` >", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria orRegisterDateGreaterThanOrEqualTo(Date value) {
            addOrCriterion("`register_date` >=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria orRegisterDateLessThan(Date value) {
            addOrCriterion("`register_date` <", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria orRegisterDateLessThanOrEqualTo(Date value) {
            addOrCriterion("`register_date` <=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria orRegisterDateIn(List<Date> values) {
            addOrCriterion("`register_date` in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria orRegisterDateNotIn(List<Date> values) {
            addOrCriterion("`register_date` not in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria orRegisterDateBetween(Date value1, Date value2) {
            addOrCriterion("`register_date` between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria orRegisterDateNotBetween(Date value1, Date value2) {
            addOrCriterion("`register_date` not between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria orLastLoginDateIsNull() {
            addOrCriterion("`last_login_date` is null");
            return (Criteria) this;
        }

        public Criteria orLastLoginDateIsNotNull() {
            addOrCriterion("`last_login_date` is not null");
            return (Criteria) this;
        }

        public Criteria orLastLoginDateEqualTo(Date value) {
            addOrCriterion("`last_login_date` =", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria orLastLoginDateNotEqualTo(Date value) {
            addOrCriterion("`last_login_date` <>", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria orLastLoginDateGreaterThan(Date value) {
            addOrCriterion("`last_login_date` >", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria orLastLoginDateGreaterThanOrEqualTo(Date value) {
            addOrCriterion("`last_login_date` >=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria orLastLoginDateLessThan(Date value) {
            addOrCriterion("`last_login_date` <", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria orLastLoginDateLessThanOrEqualTo(Date value) {
            addOrCriterion("`last_login_date` <=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria orLastLoginDateIn(List<Date> values) {
            addOrCriterion("`last_login_date` in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria orLastLoginDateNotIn(List<Date> values) {
            addOrCriterion("`last_login_date` not in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria orLastLoginDateBetween(Date value1, Date value2) {
            addOrCriterion("`last_login_date` between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria orLastLoginDateNotBetween(Date value1, Date value2) {
            addOrCriterion("`last_login_date` not between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria orLoginCountIsNull() {
            addOrCriterion("`login_count` is null");
            return (Criteria) this;
        }

        public Criteria orLoginCountIsNotNull() {
            addOrCriterion("`login_count` is not null");
            return (Criteria) this;
        }

        public Criteria orLoginCountEqualTo(Integer value) {
            addOrCriterion("`login_count` =", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria orLoginCountNotEqualTo(Integer value) {
            addOrCriterion("`login_count` <>", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria orLoginCountGreaterThan(Integer value) {
            addOrCriterion("`login_count` >", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria orLoginCountGreaterThanOrEqualTo(Integer value) {
            addOrCriterion("`login_count` >=", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria orLoginCountLessThan(Integer value) {
            addOrCriterion("`login_count` <", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria orLoginCountLessThanOrEqualTo(Integer value) {
            addOrCriterion("`login_count` <=", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria orLoginCountIn(List<Integer> values) {
            addOrCriterion("`login_count` in", values, "loginCount");
            return (Criteria) this;
        }

        public Criteria orLoginCountNotIn(List<Integer> values) {
            addOrCriterion("`login_count` not in", values, "loginCount");
            return (Criteria) this;
        }

        public Criteria orLoginCountBetween(Integer value1, Integer value2) {
            addOrCriterion("`login_count` between", value1, value2, "loginCount");
            return (Criteria) this;
        }

        public Criteria orLoginCountNotBetween(Integer value1, Integer value2) {
            addOrCriterion("`login_count` not between", value1, value2, "loginCount");
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

    public List<String> getUpdateFields() {
        return updateFields;
    }

    public void setUpdateFields(List<String> updateFields) {
        this.updateFields = updateFields;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOredCriteria(
        List<Criteria> oredCriteria) {
        this.oredCriteria = oredCriteria;
    }
}
