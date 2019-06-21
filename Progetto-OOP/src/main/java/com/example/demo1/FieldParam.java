package com.example.demo1;

import java.util.Arrays;
/**
 * 
 * This class contains other info for the filter method
 *
 */
public class FieldParam {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Operator used in the filter. Values allowed: "$bt", "$gt", "$or", "$not".
	 */
	String operator;
	/**
	 * Array of objects containing the values used in the filter: to be used with conditional filters or with "$bt" filter.
	 * In other cases this must be left empty.
	 */
	Object[] values;
	/**
	 * Object containing the value used in the filter: to be used exclusively with "$gt" filter.
	 * In othercases this must be left empty.
	 */
	Object value;
	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FieldParam [operator=" + operator + ", values=" + Arrays.toString(values) + ", value=" + value + "]";
	}
	/**
	 * @return the values
	 */
	public Object[] getValues() {
		return values;
	}
	/**
	 * @param values the values to set
	 */
	public void setValues(Object[] values) {
		this.values = values;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Object[] value) {
		this.value = value;
	}
	/**
	 * 
	 */
	public FieldParam() {
	}
	
	
}
