package com.imooc.miaosha.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 的查询类
 * miaosha_goods
 * @author liuqiangm
 *
 */
public class MiaoshaGoodsVOExample {

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

    public MiaoshaGoodsVOExample updateIdField() {
        updateFields.add("id");
        return this;
    }

    public MiaoshaGoodsVOExample updateGoodsIdField() {
        updateFields.add("goods_id");
        return this;
    }

    public MiaoshaGoodsVOExample updateMiaoshaPriceField() {
        updateFields.add("miaosha_price");
        return this;
    }

    public MiaoshaGoodsVOExample updateStockCountField() {
        updateFields.add("stock_count");
        return this;
    }

    public MiaoshaGoodsVOExample updateStartDateField() {
        updateFields.add("start_date");
        return this;
    }

    public MiaoshaGoodsVOExample updateEndDateField() {
        updateFields.add("end_date");
        return this;
    }

    public MiaoshaGoodsVOExample addPageNumAndPageSize(Integer pageNum, Integer pageSize) {
        if(pageNum != null && pageSize != null) {
            this.setStartPos((pageNum - 1) * pageSize);
            this.setPageSize(pageSize);
        }
        return this;
    }

    public MiaoshaGoodsVOExample addPageNumAndPageSize(String pageNum, String pageSize) {
        if(pageNum != null && pageSize != null) {
            int num = Integer.valueOf(pageNum);
            int size = Integer.valueOf(pageSize);
            this.setStartPos((num - 1) * size);
            this.setPageSize(size);
        }
        return this;
    }

    public MiaoshaGoodsVOExample() {
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

    public MiaoshaGoodsVOExample orderByIdAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`id` asc";
        }
        else {
            orderByClause += ",`id` asc";
        }
        return this;
    }

    public MiaoshaGoodsVOExample orderByIdDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`id` desc";
        }
        else {
            orderByClause += ",`id` desc";
        }
        return this;
    }
    public MiaoshaGoodsVOExample orderByGoodsIdAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_id` asc";
        }
        else {
            orderByClause += ",`goods_id` asc";
        }
        return this;
    }

    public MiaoshaGoodsVOExample orderByGoodsIdDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_id` desc";
        }
        else {
            orderByClause += ",`goods_id` desc";
        }
        return this;
    }
    public MiaoshaGoodsVOExample orderByMiaoshaPriceAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`miaosha_price` asc";
        }
        else {
            orderByClause += ",`miaosha_price` asc";
        }
        return this;
    }

    public MiaoshaGoodsVOExample orderByMiaoshaPriceDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`miaosha_price` desc";
        }
        else {
            orderByClause += ",`miaosha_price` desc";
        }
        return this;
    }
    public MiaoshaGoodsVOExample orderByStockCountAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`stock_count` asc";
        }
        else {
            orderByClause += ",`stock_count` asc";
        }
        return this;
    }

    public MiaoshaGoodsVOExample orderByStockCountDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`stock_count` desc";
        }
        else {
            orderByClause += ",`stock_count` desc";
        }
        return this;
    }
    public MiaoshaGoodsVOExample orderByStartDateAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`start_date` asc";
        }
        else {
            orderByClause += ",`start_date` asc";
        }
        return this;
    }

    public MiaoshaGoodsVOExample orderByStartDateDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`start_date` desc";
        }
        else {
            orderByClause += ",`start_date` desc";
        }
        return this;
    }
    public MiaoshaGoodsVOExample orderByEndDateAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`end_date` asc";
        }
        else {
            orderByClause += ",`end_date` asc";
        }
        return this;
    }

    public MiaoshaGoodsVOExample orderByEndDateDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`end_date` desc";
        }
        else {
            orderByClause += ",`end_date` desc";
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

        public Criteria andGoodsIdIsNull() {
            addAndCriterion("`goods_id` is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addAndCriterion("`goods_id` is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addAndCriterion("`goods_id` =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addAndCriterion("`goods_id` <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addAndCriterion("`goods_id` >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addAndCriterion("`goods_id` >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addAndCriterion("`goods_id` <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addAndCriterion("`goods_id` <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addAndCriterion("`goods_id` in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addAndCriterion("`goods_id` not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addAndCriterion("`goods_id` between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addAndCriterion("`goods_id` not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andMiaoshaPriceIsNull() {
            addAndCriterion("`miaosha_price` is null");
            return (Criteria) this;
        }

        public Criteria andMiaoshaPriceIsNotNull() {
            addAndCriterion("`miaosha_price` is not null");
            return (Criteria) this;
        }

        public Criteria andMiaoshaPriceEqualTo(BigDecimal value) {
            addAndCriterion("`miaosha_price` =", value, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria andMiaoshaPriceNotEqualTo(BigDecimal value) {
            addAndCriterion("`miaosha_price` <>", value, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria andMiaoshaPriceGreaterThan(BigDecimal value) {
            addAndCriterion("`miaosha_price` >", value, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria andMiaoshaPriceGreaterThanOrEqualTo(BigDecimal value) {
            addAndCriterion("`miaosha_price` >=", value, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria andMiaoshaPriceLessThan(BigDecimal value) {
            addAndCriterion("`miaosha_price` <", value, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria andMiaoshaPriceLessThanOrEqualTo(BigDecimal value) {
            addAndCriterion("`miaosha_price` <=", value, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria andMiaoshaPriceIn(List<BigDecimal> values) {
            addAndCriterion("`miaosha_price` in", values, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria andMiaoshaPriceNotIn(List<BigDecimal> values) {
            addAndCriterion("`miaosha_price` not in", values, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria andMiaoshaPriceBetween(BigDecimal value1, BigDecimal value2) {
            addAndCriterion("`miaosha_price` between", value1, value2, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria andMiaoshaPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addAndCriterion("`miaosha_price` not between", value1, value2, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria andStockCountIsNull() {
            addAndCriterion("`stock_count` is null");
            return (Criteria) this;
        }

        public Criteria andStockCountIsNotNull() {
            addAndCriterion("`stock_count` is not null");
            return (Criteria) this;
        }

        public Criteria andStockCountEqualTo(Integer value) {
            addAndCriterion("`stock_count` =", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountNotEqualTo(Integer value) {
            addAndCriterion("`stock_count` <>", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountGreaterThan(Integer value) {
            addAndCriterion("`stock_count` >", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountGreaterThanOrEqualTo(Integer value) {
            addAndCriterion("`stock_count` >=", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountLessThan(Integer value) {
            addAndCriterion("`stock_count` <", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountLessThanOrEqualTo(Integer value) {
            addAndCriterion("`stock_count` <=", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountIn(List<Integer> values) {
            addAndCriterion("`stock_count` in", values, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountNotIn(List<Integer> values) {
            addAndCriterion("`stock_count` not in", values, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountBetween(Integer value1, Integer value2) {
            addAndCriterion("`stock_count` between", value1, value2, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountNotBetween(Integer value1, Integer value2) {
            addAndCriterion("`stock_count` not between", value1, value2, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addAndCriterion("`start_date` is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addAndCriterion("`start_date` is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addAndCriterion("`start_date` =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addAndCriterion("`start_date` <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addAndCriterion("`start_date` >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addAndCriterion("`start_date` >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addAndCriterion("`start_date` <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addAndCriterion("`start_date` <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addAndCriterion("`start_date` in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addAndCriterion("`start_date` not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addAndCriterion("`start_date` between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addAndCriterion("`start_date` not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addAndCriterion("`end_date` is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addAndCriterion("`end_date` is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addAndCriterion("`end_date` =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addAndCriterion("`end_date` <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addAndCriterion("`end_date` >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addAndCriterion("`end_date` >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addAndCriterion("`end_date` <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addAndCriterion("`end_date` <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addAndCriterion("`end_date` in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addAndCriterion("`end_date` not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addAndCriterion("`end_date` between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addAndCriterion("`end_date` not between", value1, value2, "endDate");
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

        public Criteria orGoodsIdIsNull() {
            addOrCriterion("`goods_id` is null");
            return (Criteria) this;
        }

        public Criteria orGoodsIdIsNotNull() {
            addOrCriterion("`goods_id` is not null");
            return (Criteria) this;
        }

        public Criteria orGoodsIdEqualTo(Long value) {
            addOrCriterion("`goods_id` =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria orGoodsIdNotEqualTo(Long value) {
            addOrCriterion("`goods_id` <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria orGoodsIdGreaterThan(Long value) {
            addOrCriterion("`goods_id` >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria orGoodsIdGreaterThanOrEqualTo(Long value) {
            addOrCriterion("`goods_id` >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria orGoodsIdLessThan(Long value) {
            addOrCriterion("`goods_id` <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria orGoodsIdLessThanOrEqualTo(Long value) {
            addOrCriterion("`goods_id` <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria orGoodsIdIn(List<Long> values) {
            addOrCriterion("`goods_id` in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria orGoodsIdNotIn(List<Long> values) {
            addOrCriterion("`goods_id` not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria orGoodsIdBetween(Long value1, Long value2) {
            addOrCriterion("`goods_id` between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria orGoodsIdNotBetween(Long value1, Long value2) {
            addOrCriterion("`goods_id` not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria orMiaoshaPriceIsNull() {
            addOrCriterion("`miaosha_price` is null");
            return (Criteria) this;
        }

        public Criteria orMiaoshaPriceIsNotNull() {
            addOrCriterion("`miaosha_price` is not null");
            return (Criteria) this;
        }

        public Criteria orMiaoshaPriceEqualTo(BigDecimal value) {
            addOrCriterion("`miaosha_price` =", value, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria orMiaoshaPriceNotEqualTo(BigDecimal value) {
            addOrCriterion("`miaosha_price` <>", value, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria orMiaoshaPriceGreaterThan(BigDecimal value) {
            addOrCriterion("`miaosha_price` >", value, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria orMiaoshaPriceGreaterThanOrEqualTo(BigDecimal value) {
            addOrCriterion("`miaosha_price` >=", value, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria orMiaoshaPriceLessThan(BigDecimal value) {
            addOrCriterion("`miaosha_price` <", value, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria orMiaoshaPriceLessThanOrEqualTo(BigDecimal value) {
            addOrCriterion("`miaosha_price` <=", value, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria orMiaoshaPriceIn(List<BigDecimal> values) {
            addOrCriterion("`miaosha_price` in", values, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria orMiaoshaPriceNotIn(List<BigDecimal> values) {
            addOrCriterion("`miaosha_price` not in", values, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria orMiaoshaPriceBetween(BigDecimal value1, BigDecimal value2) {
            addOrCriterion("`miaosha_price` between", value1, value2, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria orMiaoshaPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addOrCriterion("`miaosha_price` not between", value1, value2, "miaoshaPrice");
            return (Criteria) this;
        }

        public Criteria orStockCountIsNull() {
            addOrCriterion("`stock_count` is null");
            return (Criteria) this;
        }

        public Criteria orStockCountIsNotNull() {
            addOrCriterion("`stock_count` is not null");
            return (Criteria) this;
        }

        public Criteria orStockCountEqualTo(Integer value) {
            addOrCriterion("`stock_count` =", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria orStockCountNotEqualTo(Integer value) {
            addOrCriterion("`stock_count` <>", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria orStockCountGreaterThan(Integer value) {
            addOrCriterion("`stock_count` >", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria orStockCountGreaterThanOrEqualTo(Integer value) {
            addOrCriterion("`stock_count` >=", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria orStockCountLessThan(Integer value) {
            addOrCriterion("`stock_count` <", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria orStockCountLessThanOrEqualTo(Integer value) {
            addOrCriterion("`stock_count` <=", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria orStockCountIn(List<Integer> values) {
            addOrCriterion("`stock_count` in", values, "stockCount");
            return (Criteria) this;
        }

        public Criteria orStockCountNotIn(List<Integer> values) {
            addOrCriterion("`stock_count` not in", values, "stockCount");
            return (Criteria) this;
        }

        public Criteria orStockCountBetween(Integer value1, Integer value2) {
            addOrCriterion("`stock_count` between", value1, value2, "stockCount");
            return (Criteria) this;
        }

        public Criteria orStockCountNotBetween(Integer value1, Integer value2) {
            addOrCriterion("`stock_count` not between", value1, value2, "stockCount");
            return (Criteria) this;
        }

        public Criteria orStartDateIsNull() {
            addOrCriterion("`start_date` is null");
            return (Criteria) this;
        }

        public Criteria orStartDateIsNotNull() {
            addOrCriterion("`start_date` is not null");
            return (Criteria) this;
        }

        public Criteria orStartDateEqualTo(Date value) {
            addOrCriterion("`start_date` =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria orStartDateNotEqualTo(Date value) {
            addOrCriterion("`start_date` <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria orStartDateGreaterThan(Date value) {
            addOrCriterion("`start_date` >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria orStartDateGreaterThanOrEqualTo(Date value) {
            addOrCriterion("`start_date` >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria orStartDateLessThan(Date value) {
            addOrCriterion("`start_date` <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria orStartDateLessThanOrEqualTo(Date value) {
            addOrCriterion("`start_date` <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria orStartDateIn(List<Date> values) {
            addOrCriterion("`start_date` in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria orStartDateNotIn(List<Date> values) {
            addOrCriterion("`start_date` not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria orStartDateBetween(Date value1, Date value2) {
            addOrCriterion("`start_date` between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria orStartDateNotBetween(Date value1, Date value2) {
            addOrCriterion("`start_date` not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria orEndDateIsNull() {
            addOrCriterion("`end_date` is null");
            return (Criteria) this;
        }

        public Criteria orEndDateIsNotNull() {
            addOrCriterion("`end_date` is not null");
            return (Criteria) this;
        }

        public Criteria orEndDateEqualTo(Date value) {
            addOrCriterion("`end_date` =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria orEndDateNotEqualTo(Date value) {
            addOrCriterion("`end_date` <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria orEndDateGreaterThan(Date value) {
            addOrCriterion("`end_date` >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria orEndDateGreaterThanOrEqualTo(Date value) {
            addOrCriterion("`end_date` >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria orEndDateLessThan(Date value) {
            addOrCriterion("`end_date` <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria orEndDateLessThanOrEqualTo(Date value) {
            addOrCriterion("`end_date` <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria orEndDateIn(List<Date> values) {
            addOrCriterion("`end_date` in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria orEndDateNotIn(List<Date> values) {
            addOrCriterion("`end_date` not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria orEndDateBetween(Date value1, Date value2) {
            addOrCriterion("`end_date` between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria orEndDateNotBetween(Date value1, Date value2) {
            addOrCriterion("`end_date` not between", value1, value2, "endDate");
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
