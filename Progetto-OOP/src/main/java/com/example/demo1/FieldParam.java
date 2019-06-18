package com.example.demo1;

import java.util.Arrays;

public class FieldParam {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FieldParam [operator=" + operator + ", value=" + Arrays.toString(value) + "]";
	}
	String operator;
	Object[] value;
	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * @return the value
	 */
	public Object[] getValue() {
		return value;
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
