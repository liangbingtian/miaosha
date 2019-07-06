package com.imooc.miaosha.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 的查询类
 * order_info
 * @author liuqiangm
 *
 */
public class OrderInfoVOExample {

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

    public OrderInfoVOExample updateIdField() {
        updateFields.add("id");
        return this;
    }

    public OrderInfoVOExample updateUserIdField() {
        updateFields.add("user_id");
        return this;
    }

    public OrderInfoVOExample updateGoodsIdField() {
        updateFields.add("goods_id");
        return this;
    }

    public OrderInfoVOExample updateDeliveryAddrIdField() {
        updateFields.add("delivery_addr_id");
        return this;
    }

    public OrderInfoVOExample updateGoodsNameField() {
        updateFields.add("goods_name");
        return this;
    }

    public OrderInfoVOExample updateGoodsCountField() {
        updateFields.add("goods_count");
        return this;
    }

    public OrderInfoVOExample updateGoodsPriceField() {
        updateFields.add("goods_price");
        return this;
    }

    public OrderInfoVOExample updateOrderChannelField() {
        updateFields.add("order_channel");
        return this;
    }

    public OrderInfoVOExample updateStatusField() {
        updateFields.add("status");
        return this;
    }

    public OrderInfoVOExample updateCreateDateField() {
        updateFields.add("create_date");
        return this;
    }

    public OrderInfoVOExample updatePayDateField() {
        updateFields.add("pay_date");
        return this;
    }

    public OrderInfoVOExample addPageNumAndPageSize(Integer pageNum, Integer pageSize) {
        if(pageNum != null && pageSize != null) {
            this.setStartPos((pageNum - 1) * pageSize);
            this.setPageSize(pageSize);
        }
        return this;
    }

    public OrderInfoVOExample addPageNumAndPageSize(String pageNum, String pageSize) {
        if(pageNum != null && pageSize != null) {
            int num = Integer.valueOf(pageNum);
            int size = Integer.valueOf(pageSize);
            this.setStartPos((num - 1) * size);
            this.setPageSize(size);
        }
        return this;
    }

    public OrderInfoVOExample() {
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

    public OrderInfoVOExample orderByIdAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`id` asc";
        }
        else {
            orderByClause += ",`id` asc";
        }
        return this;
    }

    public OrderInfoVOExample orderByIdDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`id` desc";
        }
        else {
            orderByClause += ",`id` desc";
        }
        return this;
    }
    public OrderInfoVOExample orderByUserIdAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`user_id` asc";
        }
        else {
            orderByClause += ",`user_id` asc";
        }
        return this;
    }

    public OrderInfoVOExample orderByUserIdDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`user_id` desc";
        }
        else {
            orderByClause += ",`user_id` desc";
        }
        return this;
    }
    public OrderInfoVOExample orderByGoodsIdAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_id` asc";
        }
        else {
            orderByClause += ",`goods_id` asc";
        }
        return this;
    }

    public OrderInfoVOExample orderByGoodsIdDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_id` desc";
        }
        else {
            orderByClause += ",`goods_id` desc";
        }
        return this;
    }
    public OrderInfoVOExample orderByDeliveryAddrIdAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`delivery_addr_id` asc";
        }
        else {
            orderByClause += ",`delivery_addr_id` asc";
        }
        return this;
    }

    public OrderInfoVOExample orderByDeliveryAddrIdDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`delivery_addr_id` desc";
        }
        else {
            orderByClause += ",`delivery_addr_id` desc";
        }
        return this;
    }
    public OrderInfoVOExample orderByGoodsNameAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_name` asc";
        }
        else {
            orderByClause += ",`goods_name` asc";
        }
        return this;
    }

    public OrderInfoVOExample orderByGoodsNameDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_name` desc";
        }
        else {
            orderByClause += ",`goods_name` desc";
        }
        return this;
    }
    public OrderInfoVOExample orderByGoodsCountAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_count` asc";
        }
        else {
            orderByClause += ",`goods_count` asc";
        }
        return this;
    }

    public OrderInfoVOExample orderByGoodsCountDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_count` desc";
        }
        else {
            orderByClause += ",`goods_count` desc";
        }
        return this;
    }
    public OrderInfoVOExample orderByGoodsPriceAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_price` asc";
        }
        else {
            orderByClause += ",`goods_price` asc";
        }
        return this;
    }

    public OrderInfoVOExample orderByGoodsPriceDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_price` desc";
        }
        else {
            orderByClause += ",`goods_price` desc";
        }
        return this;
    }
    public OrderInfoVOExample orderByOrderChannelAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`order_channel` asc";
        }
        else {
            orderByClause += ",`order_channel` asc";
        }
        return this;
    }

    public OrderInfoVOExample orderByOrderChannelDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`order_channel` desc";
        }
        else {
            orderByClause += ",`order_channel` desc";
        }
        return this;
    }
    public OrderInfoVOExample orderByStatusAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`status` asc";
        }
        else {
            orderByClause += ",`status` asc";
        }
        return this;
    }

    public OrderInfoVOExample orderByStatusDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`status` desc";
        }
        else {
            orderByClause += ",`status` desc";
        }
        return this;
    }
    public OrderInfoVOExample orderByCreateDateAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`create_date` asc";
        }
        else {
            orderByClause += ",`create_date` asc";
        }
        return this;
    }

    public OrderInfoVOExample orderByCreateDateDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`create_date` desc";
        }
        else {
            orderByClause += ",`create_date` desc";
        }
        return this;
    }
    public OrderInfoVOExample orderByPayDateAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`pay_date` asc";
        }
        else {
            orderByClause += ",`pay_date` asc";
        }
        return this;
    }

    public OrderInfoVOExample orderByPayDateDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`pay_date` desc";
        }
        else {
            orderByClause += ",`pay_date` desc";
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

        public Criteria andUserIdIsNull() {
            addAndCriterion("`user_id` is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addAndCriterion("`user_id` is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addAndCriterion("`user_id` =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addAndCriterion("`user_id` <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addAndCriterion("`user_id` >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addAndCriterion("`user_id` >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addAndCriterion("`user_id` <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addAndCriterion("`user_id` <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addAndCriterion("`user_id` in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addAndCriterion("`user_id` not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addAndCriterion("`user_id` between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addAndCriterion("`user_id` not between", value1, value2, "userId");
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

        public Criteria andDeliveryAddrIdIsNull() {
            addAndCriterion("`delivery_addr_id` is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIdIsNotNull() {
            addAndCriterion("`delivery_addr_id` is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIdEqualTo(Long value) {
            addAndCriterion("`delivery_addr_id` =", value, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIdNotEqualTo(Long value) {
            addAndCriterion("`delivery_addr_id` <>", value, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIdGreaterThan(Long value) {
            addAndCriterion("`delivery_addr_id` >", value, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIdGreaterThanOrEqualTo(Long value) {
            addAndCriterion("`delivery_addr_id` >=", value, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIdLessThan(Long value) {
            addAndCriterion("`delivery_addr_id` <", value, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIdLessThanOrEqualTo(Long value) {
            addAndCriterion("`delivery_addr_id` <=", value, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIdIn(List<Long> values) {
            addAndCriterion("`delivery_addr_id` in", values, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIdNotIn(List<Long> values) {
            addAndCriterion("`delivery_addr_id` not in", values, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIdBetween(Long value1, Long value2) {
            addAndCriterion("`delivery_addr_id` between", value1, value2, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIdNotBetween(Long value1, Long value2) {
            addAndCriterion("`delivery_addr_id` not between", value1, value2, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addAndCriterion("`goods_name` is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addAndCriterion("`goods_name` is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addAndCriterion("`goods_name` =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addAndCriterion("`goods_name` <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addAndCriterion("`goods_name` >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addAndCriterion("`goods_name` >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addAndCriterion("`goods_name` <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addAndCriterion("`goods_name` <=", value, "goodsName");
            return (Criteria) this;
        }
        public Criteria andGoodsNameLike(String value) {
            addAndCriterion("`goods_name` like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addAndCriterion("`goods_name` not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addAndCriterion("`goods_name` in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addAndCriterion("`goods_name` not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addAndCriterion("`goods_name` between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addAndCriterion("`goods_name` not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNull() {
            addAndCriterion("`goods_count` is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNotNull() {
            addAndCriterion("`goods_count` is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountEqualTo(Integer value) {
            addAndCriterion("`goods_count` =", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotEqualTo(Integer value) {
            addAndCriterion("`goods_count` <>", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThan(Integer value) {
            addAndCriterion("`goods_count` >", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThanOrEqualTo(Integer value) {
            addAndCriterion("`goods_count` >=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThan(Integer value) {
            addAndCriterion("`goods_count` <", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThanOrEqualTo(Integer value) {
            addAndCriterion("`goods_count` <=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIn(List<Integer> values) {
            addAndCriterion("`goods_count` in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotIn(List<Integer> values) {
            addAndCriterion("`goods_count` not in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountBetween(Integer value1, Integer value2) {
            addAndCriterion("`goods_count` between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotBetween(Integer value1, Integer value2) {
            addAndCriterion("`goods_count` not between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addAndCriterion("`goods_price` is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addAndCriterion("`goods_price` is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(BigDecimal value) {
            addAndCriterion("`goods_price` =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
            addAndCriterion("`goods_price` <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
            addAndCriterion("`goods_price` >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addAndCriterion("`goods_price` >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(BigDecimal value) {
            addAndCriterion("`goods_price` <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addAndCriterion("`goods_price` <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<BigDecimal> values) {
            addAndCriterion("`goods_price` in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
            addAndCriterion("`goods_price` not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addAndCriterion("`goods_price` between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addAndCriterion("`goods_price` not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andOrderChannelIsNull() {
            addAndCriterion("`order_channel` is null");
            return (Criteria) this;
        }

        public Criteria andOrderChannelIsNotNull() {
            addAndCriterion("`order_channel` is not null");
            return (Criteria) this;
        }

        public Criteria andOrderChannelEqualTo(Integer value) {
            addAndCriterion("`order_channel` =", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelNotEqualTo(Integer value) {
            addAndCriterion("`order_channel` <>", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelGreaterThan(Integer value) {
            addAndCriterion("`order_channel` >", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelGreaterThanOrEqualTo(Integer value) {
            addAndCriterion("`order_channel` >=", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelLessThan(Integer value) {
            addAndCriterion("`order_channel` <", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelLessThanOrEqualTo(Integer value) {
            addAndCriterion("`order_channel` <=", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelIn(List<Integer> values) {
            addAndCriterion("`order_channel` in", values, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelNotIn(List<Integer> values) {
            addAndCriterion("`order_channel` not in", values, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelBetween(Integer value1, Integer value2) {
            addAndCriterion("`order_channel` between", value1, value2, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andOrderChannelNotBetween(Integer value1, Integer value2) {
            addAndCriterion("`order_channel` not between", value1, value2, "orderChannel");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addAndCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addAndCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addAndCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addAndCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addAndCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addAndCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addAndCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addAndCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addAndCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addAndCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addAndCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addAndCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addAndCriterion("`create_date` is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addAndCriterion("`create_date` is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addAndCriterion("`create_date` =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addAndCriterion("`create_date` <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addAndCriterion("`create_date` >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addAndCriterion("`create_date` >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addAndCriterion("`create_date` <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addAndCriterion("`create_date` <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addAndCriterion("`create_date` in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addAndCriterion("`create_date` not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addAndCriterion("`create_date` between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addAndCriterion("`create_date` not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNull() {
            addAndCriterion("`pay_date` is null");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNotNull() {
            addAndCriterion("`pay_date` is not null");
            return (Criteria) this;
        }

        public Criteria andPayDateEqualTo(Date value) {
            addAndCriterion("`pay_date` =", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotEqualTo(Date value) {
            addAndCriterion("`pay_date` <>", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThan(Date value) {
            addAndCriterion("`pay_date` >", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThanOrEqualTo(Date value) {
            addAndCriterion("`pay_date` >=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThan(Date value) {
            addAndCriterion("`pay_date` <", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThanOrEqualTo(Date value) {
            addAndCriterion("`pay_date` <=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateIn(List<Date> values) {
            addAndCriterion("`pay_date` in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotIn(List<Date> values) {
            addAndCriterion("`pay_date` not in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateBetween(Date value1, Date value2) {
            addAndCriterion("`pay_date` between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotBetween(Date value1, Date value2) {
            addAndCriterion("`pay_date` not between", value1, value2, "payDate");
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

        public Criteria orUserIdIsNull() {
            addOrCriterion("`user_id` is null");
            return (Criteria) this;
        }

        public Criteria orUserIdIsNotNull() {
            addOrCriterion("`user_id` is not null");
            return (Criteria) this;
        }

        public Criteria orUserIdEqualTo(Long value) {
            addOrCriterion("`user_id` =", value, "userId");
            return (Criteria) this;
        }

        public Criteria orUserIdNotEqualTo(Long value) {
            addOrCriterion("`user_id` <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria orUserIdGreaterThan(Long value) {
            addOrCriterion("`user_id` >", value, "userId");
            return (Criteria) this;
        }

        public Criteria orUserIdGreaterThanOrEqualTo(Long value) {
            addOrCriterion("`user_id` >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria orUserIdLessThan(Long value) {
            addOrCriterion("`user_id` <", value, "userId");
            return (Criteria) this;
        }

        public Criteria orUserIdLessThanOrEqualTo(Long value) {
            addOrCriterion("`user_id` <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria orUserIdIn(List<Long> values) {
            addOrCriterion("`user_id` in", values, "userId");
            return (Criteria) this;
        }

        public Criteria orUserIdNotIn(List<Long> values) {
            addOrCriterion("`user_id` not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria orUserIdBetween(Long value1, Long value2) {
            addOrCriterion("`user_id` between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria orUserIdNotBetween(Long value1, Long value2) {
            addOrCriterion("`user_id` not between", value1, value2, "userId");
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

        public Criteria orDeliveryAddrIdIsNull() {
            addOrCriterion("`delivery_addr_id` is null");
            return (Criteria) this;
        }

        public Criteria orDeliveryAddrIdIsNotNull() {
            addOrCriterion("`delivery_addr_id` is not null");
            return (Criteria) this;
        }

        public Criteria orDeliveryAddrIdEqualTo(Long value) {
            addOrCriterion("`delivery_addr_id` =", value, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria orDeliveryAddrIdNotEqualTo(Long value) {
            addOrCriterion("`delivery_addr_id` <>", value, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria orDeliveryAddrIdGreaterThan(Long value) {
            addOrCriterion("`delivery_addr_id` >", value, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria orDeliveryAddrIdGreaterThanOrEqualTo(Long value) {
            addOrCriterion("`delivery_addr_id` >=", value, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria orDeliveryAddrIdLessThan(Long value) {
            addOrCriterion("`delivery_addr_id` <", value, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria orDeliveryAddrIdLessThanOrEqualTo(Long value) {
            addOrCriterion("`delivery_addr_id` <=", value, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria orDeliveryAddrIdIn(List<Long> values) {
            addOrCriterion("`delivery_addr_id` in", values, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria orDeliveryAddrIdNotIn(List<Long> values) {
            addOrCriterion("`delivery_addr_id` not in", values, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria orDeliveryAddrIdBetween(Long value1, Long value2) {
            addOrCriterion("`delivery_addr_id` between", value1, value2, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria orDeliveryAddrIdNotBetween(Long value1, Long value2) {
            addOrCriterion("`delivery_addr_id` not between", value1, value2, "deliveryAddrId");
            return (Criteria) this;
        }

        public Criteria orGoodsNameIsNull() {
            addOrCriterion("`goods_name` is null");
            return (Criteria) this;
        }

        public Criteria orGoodsNameIsNotNull() {
            addOrCriterion("`goods_name` is not null");
            return (Criteria) this;
        }

        public Criteria orGoodsNameEqualTo(String value) {
            addOrCriterion("`goods_name` =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria orGoodsNameNotEqualTo(String value) {
            addOrCriterion("`goods_name` <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria orGoodsNameGreaterThan(String value) {
            addOrCriterion("`goods_name` >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria orGoodsNameGreaterThanOrEqualTo(String value) {
            addOrCriterion("`goods_name` >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria orGoodsNameLessThan(String value) {
            addOrCriterion("`goods_name` <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria orGoodsNameLessThanOrEqualTo(String value) {
            addOrCriterion("`goods_name` <=", value, "goodsName");
            return (Criteria) this;
        }
        public Criteria orGoodsNameLike(String value) {
            addOrCriterion("`goods_name` like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria orGoodsNameNotLike(String value) {
            addOrCriterion("`goods_name` not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria orGoodsNameIn(List<String> values) {
            addOrCriterion("`goods_name` in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria orGoodsNameNotIn(List<String> values) {
            addOrCriterion("`goods_name` not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria orGoodsNameBetween(String value1, String value2) {
            addOrCriterion("`goods_name` between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria orGoodsNameNotBetween(String value1, String value2) {
            addOrCriterion("`goods_name` not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria orGoodsCountIsNull() {
            addOrCriterion("`goods_count` is null");
            return (Criteria) this;
        }

        public Criteria orGoodsCountIsNotNull() {
            addOrCriterion("`goods_count` is not null");
            return (Criteria) this;
        }

        public Criteria orGoodsCountEqualTo(Integer value) {
            addOrCriterion("`goods_count` =", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria orGoodsCountNotEqualTo(Integer value) {
            addOrCriterion("`goods_count` <>", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria orGoodsCountGreaterThan(Integer value) {
            addOrCriterion("`goods_count` >", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria orGoodsCountGreaterThanOrEqualTo(Integer value) {
            addOrCriterion("`goods_count` >=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria orGoodsCountLessThan(Integer value) {
            addOrCriterion("`goods_count` <", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria orGoodsCountLessThanOrEqualTo(Integer value) {
            addOrCriterion("`goods_count` <=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria orGoodsCountIn(List<Integer> values) {
            addOrCriterion("`goods_count` in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria orGoodsCountNotIn(List<Integer> values) {
            addOrCriterion("`goods_count` not in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria orGoodsCountBetween(Integer value1, Integer value2) {
            addOrCriterion("`goods_count` between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria orGoodsCountNotBetween(Integer value1, Integer value2) {
            addOrCriterion("`goods_count` not between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria orGoodsPriceIsNull() {
            addOrCriterion("`goods_price` is null");
            return (Criteria) this;
        }

        public Criteria orGoodsPriceIsNotNull() {
            addOrCriterion("`goods_price` is not null");
            return (Criteria) this;
        }

        public Criteria orGoodsPriceEqualTo(BigDecimal value) {
            addOrCriterion("`goods_price` =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria orGoodsPriceNotEqualTo(BigDecimal value) {
            addOrCriterion("`goods_price` <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria orGoodsPriceGreaterThan(BigDecimal value) {
            addOrCriterion("`goods_price` >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria orGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addOrCriterion("`goods_price` >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria orGoodsPriceLessThan(BigDecimal value) {
            addOrCriterion("`goods_price` <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria orGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addOrCriterion("`goods_price` <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria orGoodsPriceIn(List<BigDecimal> values) {
            addOrCriterion("`goods_price` in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria orGoodsPriceNotIn(List<BigDecimal> values) {
            addOrCriterion("`goods_price` not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria orGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addOrCriterion("`goods_price` between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria orGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addOrCriterion("`goods_price` not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria orOrderChannelIsNull() {
            addOrCriterion("`order_channel` is null");
            return (Criteria) this;
        }

        public Criteria orOrderChannelIsNotNull() {
            addOrCriterion("`order_channel` is not null");
            return (Criteria) this;
        }

        public Criteria orOrderChannelEqualTo(Integer value) {
            addOrCriterion("`order_channel` =", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria orOrderChannelNotEqualTo(Integer value) {
            addOrCriterion("`order_channel` <>", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria orOrderChannelGreaterThan(Integer value) {
            addOrCriterion("`order_channel` >", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria orOrderChannelGreaterThanOrEqualTo(Integer value) {
            addOrCriterion("`order_channel` >=", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria orOrderChannelLessThan(Integer value) {
            addOrCriterion("`order_channel` <", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria orOrderChannelLessThanOrEqualTo(Integer value) {
            addOrCriterion("`order_channel` <=", value, "orderChannel");
            return (Criteria) this;
        }

        public Criteria orOrderChannelIn(List<Integer> values) {
            addOrCriterion("`order_channel` in", values, "orderChannel");
            return (Criteria) this;
        }

        public Criteria orOrderChannelNotIn(List<Integer> values) {
            addOrCriterion("`order_channel` not in", values, "orderChannel");
            return (Criteria) this;
        }

        public Criteria orOrderChannelBetween(Integer value1, Integer value2) {
            addOrCriterion("`order_channel` between", value1, value2, "orderChannel");
            return (Criteria) this;
        }

        public Criteria orOrderChannelNotBetween(Integer value1, Integer value2) {
            addOrCriterion("`order_channel` not between", value1, value2, "orderChannel");
            return (Criteria) this;
        }

        public Criteria orStatusIsNull() {
            addOrCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria orStatusIsNotNull() {
            addOrCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria orStatusEqualTo(Integer value) {
            addOrCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria orStatusNotEqualTo(Integer value) {
            addOrCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria orStatusGreaterThan(Integer value) {
            addOrCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria orStatusGreaterThanOrEqualTo(Integer value) {
            addOrCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria orStatusLessThan(Integer value) {
            addOrCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria orStatusLessThanOrEqualTo(Integer value) {
            addOrCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria orStatusIn(List<Integer> values) {
            addOrCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria orStatusNotIn(List<Integer> values) {
            addOrCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria orStatusBetween(Integer value1, Integer value2) {
            addOrCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria orStatusNotBetween(Integer value1, Integer value2) {
            addOrCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria orCreateDateIsNull() {
            addOrCriterion("`create_date` is null");
            return (Criteria) this;
        }

        public Criteria orCreateDateIsNotNull() {
            addOrCriterion("`create_date` is not null");
            return (Criteria) this;
        }

        public Criteria orCreateDateEqualTo(Date value) {
            addOrCriterion("`create_date` =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria orCreateDateNotEqualTo(Date value) {
            addOrCriterion("`create_date` <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria orCreateDateGreaterThan(Date value) {
            addOrCriterion("`create_date` >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria orCreateDateGreaterThanOrEqualTo(Date value) {
            addOrCriterion("`create_date` >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria orCreateDateLessThan(Date value) {
            addOrCriterion("`create_date` <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria orCreateDateLessThanOrEqualTo(Date value) {
            addOrCriterion("`create_date` <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria orCreateDateIn(List<Date> values) {
            addOrCriterion("`create_date` in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria orCreateDateNotIn(List<Date> values) {
            addOrCriterion("`create_date` not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria orCreateDateBetween(Date value1, Date value2) {
            addOrCriterion("`create_date` between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria orCreateDateNotBetween(Date value1, Date value2) {
            addOrCriterion("`create_date` not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria orPayDateIsNull() {
            addOrCriterion("`pay_date` is null");
            return (Criteria) this;
        }

        public Criteria orPayDateIsNotNull() {
            addOrCriterion("`pay_date` is not null");
            return (Criteria) this;
        }

        public Criteria orPayDateEqualTo(Date value) {
            addOrCriterion("`pay_date` =", value, "payDate");
            return (Criteria) this;
        }

        public Criteria orPayDateNotEqualTo(Date value) {
            addOrCriterion("`pay_date` <>", value, "payDate");
            return (Criteria) this;
        }

        public Criteria orPayDateGreaterThan(Date value) {
            addOrCriterion("`pay_date` >", value, "payDate");
            return (Criteria) this;
        }

        public Criteria orPayDateGreaterThanOrEqualTo(Date value) {
            addOrCriterion("`pay_date` >=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria orPayDateLessThan(Date value) {
            addOrCriterion("`pay_date` <", value, "payDate");
            return (Criteria) this;
        }

        public Criteria orPayDateLessThanOrEqualTo(Date value) {
            addOrCriterion("`pay_date` <=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria orPayDateIn(List<Date> values) {
            addOrCriterion("`pay_date` in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria orPayDateNotIn(List<Date> values) {
            addOrCriterion("`pay_date` not in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria orPayDateBetween(Date value1, Date value2) {
            addOrCriterion("`pay_date` between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria orPayDateNotBetween(Date value1, Date value2) {
            addOrCriterion("`pay_date` not between", value1, value2, "payDate");
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
