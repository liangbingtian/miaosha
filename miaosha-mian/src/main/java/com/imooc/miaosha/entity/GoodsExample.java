package com.imooc.miaosha.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 的查询类
 * goods
 * @author liuqiangm
 *
 */
public class GoodsExample {

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

    public GoodsExample updateIdField() {
        updateFields.add("id");
        return this;
    }

    public GoodsExample updateGoodsNameField() {
        updateFields.add("goods_name");
        return this;
    }

    public GoodsExample updateGoodsTitleField() {
        updateFields.add("goods_title");
        return this;
    }

    public GoodsExample updateGoodsImgField() {
        updateFields.add("goods_img");
        return this;
    }

    public GoodsExample updateGoodsDetailField() {
        updateFields.add("goods_detail");
        return this;
    }

    public GoodsExample updateGoodsPriceField() {
        updateFields.add("goods_price");
        return this;
    }

    public GoodsExample updateGoodsStockField() {
        updateFields.add("goods_stock");
        return this;
    }

    public GoodsExample addPageNumAndPageSize(Integer pageNum, Integer pageSize) {
        if(pageNum != null && pageSize != null) {
            this.setStartPos((pageNum - 1) * pageSize);
            this.setPageSize(pageSize);
        }
        return this;
    }

    public GoodsExample addPageNumAndPageSize(String pageNum, String pageSize) {
        if(pageNum != null && pageSize != null) {
            int num = Integer.valueOf(pageNum);
            int size = Integer.valueOf(pageSize);
            this.setStartPos((num - 1) * size);
            this.setPageSize(size);
        }
        return this;
    }

    public GoodsExample() {
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

    public GoodsExample orderByIdAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`id` asc";
        }
        else {
            orderByClause += ",`id` asc";
        }
        return this;
    }

    public GoodsExample orderByIdDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`id` desc";
        }
        else {
            orderByClause += ",`id` desc";
        }
        return this;
    }
    public GoodsExample orderByGoodsNameAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_name` asc";
        }
        else {
            orderByClause += ",`goods_name` asc";
        }
        return this;
    }

    public GoodsExample orderByGoodsNameDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_name` desc";
        }
        else {
            orderByClause += ",`goods_name` desc";
        }
        return this;
    }
    public GoodsExample orderByGoodsTitleAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_title` asc";
        }
        else {
            orderByClause += ",`goods_title` asc";
        }
        return this;
    }

    public GoodsExample orderByGoodsTitleDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_title` desc";
        }
        else {
            orderByClause += ",`goods_title` desc";
        }
        return this;
    }
    public GoodsExample orderByGoodsImgAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_img` asc";
        }
        else {
            orderByClause += ",`goods_img` asc";
        }
        return this;
    }

    public GoodsExample orderByGoodsImgDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_img` desc";
        }
        else {
            orderByClause += ",`goods_img` desc";
        }
        return this;
    }
    public GoodsExample orderByGoodsDetailAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_detail` asc";
        }
        else {
            orderByClause += ",`goods_detail` asc";
        }
        return this;
    }

    public GoodsExample orderByGoodsDetailDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_detail` desc";
        }
        else {
            orderByClause += ",`goods_detail` desc";
        }
        return this;
    }
    public GoodsExample orderByGoodsPriceAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_price` asc";
        }
        else {
            orderByClause += ",`goods_price` asc";
        }
        return this;
    }

    public GoodsExample orderByGoodsPriceDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_price` desc";
        }
        else {
            orderByClause += ",`goods_price` desc";
        }
        return this;
    }
    public GoodsExample orderByGoodsStockAsc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_stock` asc";
        }
        else {
            orderByClause += ",`goods_stock` asc";
        }
        return this;
    }

    public GoodsExample orderByGoodsStockDesc() {
        if(this.orderByClause == null || this.orderByClause.length() == 0) {
            orderByClause = "`goods_stock` desc";
        }
        else {
            orderByClause += ",`goods_stock` desc";
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

        public Criteria andGoodsTitleIsNull() {
            addAndCriterion("`goods_title` is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIsNotNull() {
            addAndCriterion("`goods_title` is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleEqualTo(String value) {
            addAndCriterion("`goods_title` =", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotEqualTo(String value) {
            addAndCriterion("`goods_title` <>", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleGreaterThan(String value) {
            addAndCriterion("`goods_title` >", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleGreaterThanOrEqualTo(String value) {
            addAndCriterion("`goods_title` >=", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLessThan(String value) {
            addAndCriterion("`goods_title` <", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLessThanOrEqualTo(String value) {
            addAndCriterion("`goods_title` <=", value, "goodsTitle");
            return (Criteria) this;
        }
        public Criteria andGoodsTitleLike(String value) {
            addAndCriterion("`goods_title` like", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotLike(String value) {
            addAndCriterion("`goods_title` not like", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIn(List<String> values) {
            addAndCriterion("`goods_title` in", values, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotIn(List<String> values) {
            addAndCriterion("`goods_title` not in", values, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleBetween(String value1, String value2) {
            addAndCriterion("`goods_title` between", value1, value2, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotBetween(String value1, String value2) {
            addAndCriterion("`goods_title` not between", value1, value2, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIsNull() {
            addAndCriterion("`goods_img` is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIsNotNull() {
            addAndCriterion("`goods_img` is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgEqualTo(String value) {
            addAndCriterion("`goods_img` =", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotEqualTo(String value) {
            addAndCriterion("`goods_img` <>", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgGreaterThan(String value) {
            addAndCriterion("`goods_img` >", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgGreaterThanOrEqualTo(String value) {
            addAndCriterion("`goods_img` >=", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLessThan(String value) {
            addAndCriterion("`goods_img` <", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLessThanOrEqualTo(String value) {
            addAndCriterion("`goods_img` <=", value, "goodsImg");
            return (Criteria) this;
        }
        public Criteria andGoodsImgLike(String value) {
            addAndCriterion("`goods_img` like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotLike(String value) {
            addAndCriterion("`goods_img` not like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIn(List<String> values) {
            addAndCriterion("`goods_img` in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotIn(List<String> values) {
            addAndCriterion("`goods_img` not in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgBetween(String value1, String value2) {
            addAndCriterion("`goods_img` between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotBetween(String value1, String value2) {
            addAndCriterion("`goods_img` not between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIsNull() {
            addAndCriterion("`goods_detail` is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIsNotNull() {
            addAndCriterion("`goods_detail` is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailEqualTo(String value) {
            addAndCriterion("`goods_detail` =", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNotEqualTo(String value) {
            addAndCriterion("`goods_detail` <>", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailGreaterThan(String value) {
            addAndCriterion("`goods_detail` >", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailGreaterThanOrEqualTo(String value) {
            addAndCriterion("`goods_detail` >=", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailLessThan(String value) {
            addAndCriterion("`goods_detail` <", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailLessThanOrEqualTo(String value) {
            addAndCriterion("`goods_detail` <=", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIn(List<String> values) {
            addAndCriterion("`goods_detail` in", values, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNotIn(List<String> values) {
            addAndCriterion("`goods_detail` not in", values, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailBetween(String value1, String value2) {
            addAndCriterion("`goods_detail` between", value1, value2, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNotBetween(String value1, String value2) {
            addAndCriterion("`goods_detail` not between", value1, value2, "goodsDetail");
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

        public Criteria andGoodsStockIsNull() {
            addAndCriterion("`goods_stock` is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIsNotNull() {
            addAndCriterion("`goods_stock` is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStockEqualTo(Integer value) {
            addAndCriterion("`goods_stock` =", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotEqualTo(Integer value) {
            addAndCriterion("`goods_stock` <>", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockGreaterThan(Integer value) {
            addAndCriterion("`goods_stock` >", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockGreaterThanOrEqualTo(Integer value) {
            addAndCriterion("`goods_stock` >=", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockLessThan(Integer value) {
            addAndCriterion("`goods_stock` <", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockLessThanOrEqualTo(Integer value) {
            addAndCriterion("`goods_stock` <=", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIn(List<Integer> values) {
            addAndCriterion("`goods_stock` in", values, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotIn(List<Integer> values) {
            addAndCriterion("`goods_stock` not in", values, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockBetween(Integer value1, Integer value2) {
            addAndCriterion("`goods_stock` between", value1, value2, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotBetween(Integer value1, Integer value2) {
            addAndCriterion("`goods_stock` not between", value1, value2, "goodsStock");
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

        public Criteria orGoodsTitleIsNull() {
            addOrCriterion("`goods_title` is null");
            return (Criteria) this;
        }

        public Criteria orGoodsTitleIsNotNull() {
            addOrCriterion("`goods_title` is not null");
            return (Criteria) this;
        }

        public Criteria orGoodsTitleEqualTo(String value) {
            addOrCriterion("`goods_title` =", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria orGoodsTitleNotEqualTo(String value) {
            addOrCriterion("`goods_title` <>", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria orGoodsTitleGreaterThan(String value) {
            addOrCriterion("`goods_title` >", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria orGoodsTitleGreaterThanOrEqualTo(String value) {
            addOrCriterion("`goods_title` >=", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria orGoodsTitleLessThan(String value) {
            addOrCriterion("`goods_title` <", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria orGoodsTitleLessThanOrEqualTo(String value) {
            addOrCriterion("`goods_title` <=", value, "goodsTitle");
            return (Criteria) this;
        }
        public Criteria orGoodsTitleLike(String value) {
            addOrCriterion("`goods_title` like", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria orGoodsTitleNotLike(String value) {
            addOrCriterion("`goods_title` not like", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria orGoodsTitleIn(List<String> values) {
            addOrCriterion("`goods_title` in", values, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria orGoodsTitleNotIn(List<String> values) {
            addOrCriterion("`goods_title` not in", values, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria orGoodsTitleBetween(String value1, String value2) {
            addOrCriterion("`goods_title` between", value1, value2, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria orGoodsTitleNotBetween(String value1, String value2) {
            addOrCriterion("`goods_title` not between", value1, value2, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria orGoodsImgIsNull() {
            addOrCriterion("`goods_img` is null");
            return (Criteria) this;
        }

        public Criteria orGoodsImgIsNotNull() {
            addOrCriterion("`goods_img` is not null");
            return (Criteria) this;
        }

        public Criteria orGoodsImgEqualTo(String value) {
            addOrCriterion("`goods_img` =", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria orGoodsImgNotEqualTo(String value) {
            addOrCriterion("`goods_img` <>", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria orGoodsImgGreaterThan(String value) {
            addOrCriterion("`goods_img` >", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria orGoodsImgGreaterThanOrEqualTo(String value) {
            addOrCriterion("`goods_img` >=", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria orGoodsImgLessThan(String value) {
            addOrCriterion("`goods_img` <", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria orGoodsImgLessThanOrEqualTo(String value) {
            addOrCriterion("`goods_img` <=", value, "goodsImg");
            return (Criteria) this;
        }
        public Criteria orGoodsImgLike(String value) {
            addOrCriterion("`goods_img` like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria orGoodsImgNotLike(String value) {
            addOrCriterion("`goods_img` not like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria orGoodsImgIn(List<String> values) {
            addOrCriterion("`goods_img` in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria orGoodsImgNotIn(List<String> values) {
            addOrCriterion("`goods_img` not in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria orGoodsImgBetween(String value1, String value2) {
            addOrCriterion("`goods_img` between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria orGoodsImgNotBetween(String value1, String value2) {
            addOrCriterion("`goods_img` not between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria orGoodsDetailIsNull() {
            addOrCriterion("`goods_detail` is null");
            return (Criteria) this;
        }

        public Criteria orGoodsDetailIsNotNull() {
            addOrCriterion("`goods_detail` is not null");
            return (Criteria) this;
        }

        public Criteria orGoodsDetailEqualTo(String value) {
            addOrCriterion("`goods_detail` =", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria orGoodsDetailNotEqualTo(String value) {
            addOrCriterion("`goods_detail` <>", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria orGoodsDetailGreaterThan(String value) {
            addOrCriterion("`goods_detail` >", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria orGoodsDetailGreaterThanOrEqualTo(String value) {
            addOrCriterion("`goods_detail` >=", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria orGoodsDetailLessThan(String value) {
            addOrCriterion("`goods_detail` <", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria orGoodsDetailLessThanOrEqualTo(String value) {
            addOrCriterion("`goods_detail` <=", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria orGoodsDetailIn(List<String> values) {
            addOrCriterion("`goods_detail` in", values, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria orGoodsDetailNotIn(List<String> values) {
            addOrCriterion("`goods_detail` not in", values, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria orGoodsDetailBetween(String value1, String value2) {
            addOrCriterion("`goods_detail` between", value1, value2, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria orGoodsDetailNotBetween(String value1, String value2) {
            addOrCriterion("`goods_detail` not between", value1, value2, "goodsDetail");
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

        public Criteria orGoodsStockIsNull() {
            addOrCriterion("`goods_stock` is null");
            return (Criteria) this;
        }

        public Criteria orGoodsStockIsNotNull() {
            addOrCriterion("`goods_stock` is not null");
            return (Criteria) this;
        }

        public Criteria orGoodsStockEqualTo(Integer value) {
            addOrCriterion("`goods_stock` =", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria orGoodsStockNotEqualTo(Integer value) {
            addOrCriterion("`goods_stock` <>", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria orGoodsStockGreaterThan(Integer value) {
            addOrCriterion("`goods_stock` >", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria orGoodsStockGreaterThanOrEqualTo(Integer value) {
            addOrCriterion("`goods_stock` >=", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria orGoodsStockLessThan(Integer value) {
            addOrCriterion("`goods_stock` <", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria orGoodsStockLessThanOrEqualTo(Integer value) {
            addOrCriterion("`goods_stock` <=", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria orGoodsStockIn(List<Integer> values) {
            addOrCriterion("`goods_stock` in", values, "goodsStock");
            return (Criteria) this;
        }

        public Criteria orGoodsStockNotIn(List<Integer> values) {
            addOrCriterion("`goods_stock` not in", values, "goodsStock");
            return (Criteria) this;
        }

        public Criteria orGoodsStockBetween(Integer value1, Integer value2) {
            addOrCriterion("`goods_stock` between", value1, value2, "goodsStock");
            return (Criteria) this;
        }

        public Criteria orGoodsStockNotBetween(Integer value1, Integer value2) {
            addOrCriterion("`goods_stock` not between", value1, value2, "goodsStock");
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
