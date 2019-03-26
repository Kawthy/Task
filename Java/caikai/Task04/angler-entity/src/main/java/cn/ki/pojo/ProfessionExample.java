package cn.ki.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProfessionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProfessionExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionIsNull() {
            addCriterion("job_description is null");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionIsNotNull() {
            addCriterion("job_description is not null");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionEqualTo(String value) {
            addCriterion("job_description =", value, "jobDescription");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionNotEqualTo(String value) {
            addCriterion("job_description <>", value, "jobDescription");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionGreaterThan(String value) {
            addCriterion("job_description >", value, "jobDescription");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("job_description >=", value, "jobDescription");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionLessThan(String value) {
            addCriterion("job_description <", value, "jobDescription");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionLessThanOrEqualTo(String value) {
            addCriterion("job_description <=", value, "jobDescription");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionLike(String value) {
            addCriterion("job_description like", value, "jobDescription");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionNotLike(String value) {
            addCriterion("job_description not like", value, "jobDescription");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionIn(List<String> values) {
            addCriterion("job_description in", values, "jobDescription");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionNotIn(List<String> values) {
            addCriterion("job_description not in", values, "jobDescription");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionBetween(String value1, String value2) {
            addCriterion("job_description between", value1, value2, "jobDescription");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionNotBetween(String value1, String value2) {
            addCriterion("job_description not between", value1, value2, "jobDescription");
            return (Criteria) this;
        }

        public Criteria andSalary01IsNull() {
            addCriterion("salary01 is null");
            return (Criteria) this;
        }

        public Criteria andSalary01IsNotNull() {
            addCriterion("salary01 is not null");
            return (Criteria) this;
        }

        public Criteria andSalary01EqualTo(Long value) {
            addCriterion("salary01 =", value, "salary01");
            return (Criteria) this;
        }

        public Criteria andSalary01NotEqualTo(Long value) {
            addCriterion("salary01 <>", value, "salary01");
            return (Criteria) this;
        }

        public Criteria andSalary01GreaterThan(Long value) {
            addCriterion("salary01 >", value, "salary01");
            return (Criteria) this;
        }

        public Criteria andSalary01GreaterThanOrEqualTo(Long value) {
            addCriterion("salary01 >=", value, "salary01");
            return (Criteria) this;
        }

        public Criteria andSalary01LessThan(Long value) {
            addCriterion("salary01 <", value, "salary01");
            return (Criteria) this;
        }

        public Criteria andSalary01LessThanOrEqualTo(Long value) {
            addCriterion("salary01 <=", value, "salary01");
            return (Criteria) this;
        }

        public Criteria andSalary01In(List<Long> values) {
            addCriterion("salary01 in", values, "salary01");
            return (Criteria) this;
        }

        public Criteria andSalary01NotIn(List<Long> values) {
            addCriterion("salary01 not in", values, "salary01");
            return (Criteria) this;
        }

        public Criteria andSalary01Between(Long value1, Long value2) {
            addCriterion("salary01 between", value1, value2, "salary01");
            return (Criteria) this;
        }

        public Criteria andSalary01NotBetween(Long value1, Long value2) {
            addCriterion("salary01 not between", value1, value2, "salary01");
            return (Criteria) this;
        }

        public Criteria andSalary02IsNull() {
            addCriterion("salary02 is null");
            return (Criteria) this;
        }

        public Criteria andSalary02IsNotNull() {
            addCriterion("salary02 is not null");
            return (Criteria) this;
        }

        public Criteria andSalary02EqualTo(Long value) {
            addCriterion("salary02 =", value, "salary02");
            return (Criteria) this;
        }

        public Criteria andSalary02NotEqualTo(Long value) {
            addCriterion("salary02 <>", value, "salary02");
            return (Criteria) this;
        }

        public Criteria andSalary02GreaterThan(Long value) {
            addCriterion("salary02 >", value, "salary02");
            return (Criteria) this;
        }

        public Criteria andSalary02GreaterThanOrEqualTo(Long value) {
            addCriterion("salary02 >=", value, "salary02");
            return (Criteria) this;
        }

        public Criteria andSalary02LessThan(Long value) {
            addCriterion("salary02 <", value, "salary02");
            return (Criteria) this;
        }

        public Criteria andSalary02LessThanOrEqualTo(Long value) {
            addCriterion("salary02 <=", value, "salary02");
            return (Criteria) this;
        }

        public Criteria andSalary02In(List<Long> values) {
            addCriterion("salary02 in", values, "salary02");
            return (Criteria) this;
        }

        public Criteria andSalary02NotIn(List<Long> values) {
            addCriterion("salary02 not in", values, "salary02");
            return (Criteria) this;
        }

        public Criteria andSalary02Between(Long value1, Long value2) {
            addCriterion("salary02 between", value1, value2, "salary02");
            return (Criteria) this;
        }

        public Criteria andSalary02NotBetween(Long value1, Long value2) {
            addCriterion("salary02 not between", value1, value2, "salary02");
            return (Criteria) this;
        }

        public Criteria andSalary03IsNull() {
            addCriterion("salary03 is null");
            return (Criteria) this;
        }

        public Criteria andSalary03IsNotNull() {
            addCriterion("salary03 is not null");
            return (Criteria) this;
        }

        public Criteria andSalary03EqualTo(Long value) {
            addCriterion("salary03 =", value, "salary03");
            return (Criteria) this;
        }

        public Criteria andSalary03NotEqualTo(Long value) {
            addCriterion("salary03 <>", value, "salary03");
            return (Criteria) this;
        }

        public Criteria andSalary03GreaterThan(Long value) {
            addCriterion("salary03 >", value, "salary03");
            return (Criteria) this;
        }

        public Criteria andSalary03GreaterThanOrEqualTo(Long value) {
            addCriterion("salary03 >=", value, "salary03");
            return (Criteria) this;
        }

        public Criteria andSalary03LessThan(Long value) {
            addCriterion("salary03 <", value, "salary03");
            return (Criteria) this;
        }

        public Criteria andSalary03LessThanOrEqualTo(Long value) {
            addCriterion("salary03 <=", value, "salary03");
            return (Criteria) this;
        }

        public Criteria andSalary03In(List<Long> values) {
            addCriterion("salary03 in", values, "salary03");
            return (Criteria) this;
        }

        public Criteria andSalary03NotIn(List<Long> values) {
            addCriterion("salary03 not in", values, "salary03");
            return (Criteria) this;
        }

        public Criteria andSalary03Between(Long value1, Long value2) {
            addCriterion("salary03 between", value1, value2, "salary03");
            return (Criteria) this;
        }

        public Criteria andSalary03NotBetween(Long value1, Long value2) {
            addCriterion("salary03 not between", value1, value2, "salary03");
            return (Criteria) this;
        }

        public Criteria andThresholdIsNull() {
            addCriterion("threshold is null");
            return (Criteria) this;
        }

        public Criteria andThresholdIsNotNull() {
            addCriterion("threshold is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdEqualTo(Integer value) {
            addCriterion("threshold =", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotEqualTo(Integer value) {
            addCriterion("threshold <>", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdGreaterThan(Integer value) {
            addCriterion("threshold >", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("threshold >=", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLessThan(Integer value) {
            addCriterion("threshold <", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("threshold <=", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdIn(List<Integer> values) {
            addCriterion("threshold in", values, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotIn(List<Integer> values) {
            addCriterion("threshold not in", values, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdBetween(Integer value1, Integer value2) {
            addCriterion("threshold between", value1, value2, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("threshold not between", value1, value2, "threshold");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNull() {
            addCriterion("difficulty is null");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNotNull() {
            addCriterion("difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultyEqualTo(Integer value) {
            addCriterion("difficulty =", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotEqualTo(Integer value) {
            addCriterion("difficulty <>", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThan(Integer value) {
            addCriterion("difficulty >", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThanOrEqualTo(Integer value) {
            addCriterion("difficulty >=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThan(Integer value) {
            addCriterion("difficulty <", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThanOrEqualTo(Integer value) {
            addCriterion("difficulty <=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyIn(List<Integer> values) {
            addCriterion("difficulty in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotIn(List<Integer> values) {
            addCriterion("difficulty not in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyBetween(Integer value1, Integer value2) {
            addCriterion("difficulty between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotBetween(Integer value1, Integer value2) {
            addCriterion("difficulty not between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleIsNull() {
            addCriterion("growth_cycle is null");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleIsNotNull() {
            addCriterion("growth_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleEqualTo(String value) {
            addCriterion("growth_cycle =", value, "growthCycle");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleNotEqualTo(String value) {
            addCriterion("growth_cycle <>", value, "growthCycle");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleGreaterThan(String value) {
            addCriterion("growth_cycle >", value, "growthCycle");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleGreaterThanOrEqualTo(String value) {
            addCriterion("growth_cycle >=", value, "growthCycle");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleLessThan(String value) {
            addCriterion("growth_cycle <", value, "growthCycle");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleLessThanOrEqualTo(String value) {
            addCriterion("growth_cycle <=", value, "growthCycle");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleLike(String value) {
            addCriterion("growth_cycle like", value, "growthCycle");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleNotLike(String value) {
            addCriterion("growth_cycle not like", value, "growthCycle");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleIn(List<String> values) {
            addCriterion("growth_cycle in", values, "growthCycle");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleNotIn(List<String> values) {
            addCriterion("growth_cycle not in", values, "growthCycle");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleBetween(String value1, String value2) {
            addCriterion("growth_cycle between", value1, value2, "growthCycle");
            return (Criteria) this;
        }

        public Criteria andGrowthCycleNotBetween(String value1, String value2) {
            addCriterion("growth_cycle not between", value1, value2, "growthCycle");
            return (Criteria) this;
        }

        public Criteria andNeedIsNull() {
            addCriterion("need is null");
            return (Criteria) this;
        }

        public Criteria andNeedIsNotNull() {
            addCriterion("need is not null");
            return (Criteria) this;
        }

        public Criteria andNeedEqualTo(Long value) {
            addCriterion("need =", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedNotEqualTo(Long value) {
            addCriterion("need <>", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedGreaterThan(Long value) {
            addCriterion("need >", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedGreaterThanOrEqualTo(Long value) {
            addCriterion("need >=", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedLessThan(Long value) {
            addCriterion("need <", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedLessThanOrEqualTo(Long value) {
            addCriterion("need <=", value, "need");
            return (Criteria) this;
        }

        public Criteria andNeedIn(List<Long> values) {
            addCriterion("need in", values, "need");
            return (Criteria) this;
        }

        public Criteria andNeedNotIn(List<Long> values) {
            addCriterion("need not in", values, "need");
            return (Criteria) this;
        }

        public Criteria andNeedBetween(Long value1, Long value2) {
            addCriterion("need between", value1, value2, "need");
            return (Criteria) this;
        }

        public Criteria andNeedNotBetween(Long value1, Long value2) {
            addCriterion("need not between", value1, value2, "need");
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