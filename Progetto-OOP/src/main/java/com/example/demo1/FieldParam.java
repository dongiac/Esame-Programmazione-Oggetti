package com.example.demo1;

import java.util.Arrays;

public class FieldParam {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	String operator;
	Object[] values;
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
