package com.imooc.miaosha.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 的查询类
 * miaosha_order
 * @author liuqiangm
 *
 */
public class MiaoshaOrderVOExample {

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

    public MiaoshaOrderVOExample updateIdField() {
        updateFields.add("id");
        return this;
    }

    public MiaoshaOrderVOExample updateUserIdField() {
        updateFields.add("user_id");
        return this;
    }

    public MiaoshaOrderVOExample updateOrderIdField() {
        updateFields.add("order_id");
        return this;
    }

    public MiaoshaOrderVOExample updateGoodsIdField() {
        updateFields.add("goods_id");
        return this;
    }

    public MiaoshaOrderVOExample addPageNumAndPageSize(Integer pageNum, Integer pageSize) {
        if(pageNum != null && pageSize != null) {
            this.setStartPos((pageNum - 1) * pageSize);
            this.setPageSize(pageSize);
        }
        return this;
    }

    public MiaoshaOrderVOExample addPageNumAndPageSize(String pageNum, String pageSize) {
        if(pageNum != null && pageSize != null) {
            int num = Integer.valueOf(pageNum);
            int size = Integer.valueOf(pageSize);
            this.setStartPos((num - 1) * size);
            this.setPageSize(size);
        }
        return this;
    }

    public MiaoshaOrderVOExample() {
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

    public MiaoshaOrderVOExample orderByIdAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`id` asc";
        }
        else {
            orderByClause += ",`id` asc";
        }
        return this;
    }

    public MiaoshaOrderVOExample orderByIdDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`id` desc";
        }
        else {
            orderByClause += ",`id` desc";
        }
        return this;
    }
    public MiaoshaOrderVOExample orderByUserIdAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`user_id` asc";
        }
        else {
            orderByClause += ",`user_id` asc";
        }
        return this;
    }

    public MiaoshaOrderVOExample orderByUserIdDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`user_id` desc";
        }
        else {
            orderByClause += ",`user_id` desc";
        }
        return this;
    }
    public MiaoshaOrderVOExample orderByOrderIdAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`order_id` asc";
        }
        else {
            orderByClause += ",`order_id` asc";
        }
        return this;
    }

    public MiaoshaOrderVOExample orderByOrderIdDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`order_id` desc";
        }
        else {
            orderByClause += ",`order_id` desc";
        }
        return this;
    }
    public MiaoshaOrderVOExample orderByGoodsIdAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_id` asc";
        }
        else {
            orderByClause += ",`goods_id` asc";
        }
        return this;
    }

    public MiaoshaOrderVOExample orderByGoodsIdDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_id` desc";
        }
        else {
            orderByClause += ",`goods_id` desc";
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

        public Criteria andOrderIdIsNull() {
            addAndCriterion("`order_id` is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addAndCriterion("`order_id` is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addAndCriterion("`order_id` =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addAndCriterion("`order_id` <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addAndCriterion("`order_id` >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addAndCriterion("`order_id` >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addAndCriterion("`order_id` <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addAndCriterion("`order_id` <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addAndCriterion("`order_id` in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addAndCriterion("`order_id` not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addAndCriterion("`order_id` between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addAndCriterion("`order_id` not between", value1, value2, "orderId");
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

        public Criteria orOrderIdIsNull() {
            addOrCriterion("`order_id` is null");
            return (Criteria) this;
        }

        public Criteria orOrderIdIsNotNull() {
            addOrCriterion("`order_id` is not null");
            return (Criteria) this;
        }

        public Criteria orOrderIdEqualTo(Long value) {
            addOrCriterion("`order_id` =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria orOrderIdNotEqualTo(Long value) {
            addOrCriterion("`order_id` <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria orOrderIdGreaterThan(Long value) {
            addOrCriterion("`order_id` >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria orOrderIdGreaterThanOrEqualTo(Long value) {
            addOrCriterion("`order_id` >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria orOrderIdLessThan(Long value) {
            addOrCriterion("`order_id` <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria orOrderIdLessThanOrEqualTo(Long value) {
            addOrCriterion("`order_id` <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria orOrderIdIn(List<Long> values) {
            addOrCriterion("`order_id` in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria orOrderIdNotIn(List<Long> values) {
            addOrCriterion("`order_id` not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria orOrderIdBetween(Long value1, Long value2) {
            addOrCriterion("`order_id` between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria orOrderIdNotBetween(Long value1, Long value2) {
            addOrCriterion("`order_id` not between", value1, value2, "orderId");
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
