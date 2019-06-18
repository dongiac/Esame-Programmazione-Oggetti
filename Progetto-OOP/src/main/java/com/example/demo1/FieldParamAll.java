package com.example.demo1;

public class FieldParamAll {
	String fieldName;
	FieldParam fieldParam;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FieldParamAll [fieldName=" + fieldName + ", fieldParam=" + fieldParam + ", getFieldName()="
				+ getFieldName() + ", getFieldParam()=" + getFieldParam() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	/**
	 * 
	 */
	public FieldParamAll() {
	}
	/**
	 * @param fieldName
	 * @param fieldParam
	 */
	public FieldParamAll(String fieldName, FieldParam fieldParam) {
		this.fieldName = fieldName;
		this.fieldParam = fieldParam;
	}
	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * @return the fieldParam
	 */
	public FieldParam getFieldParam() {
		return fieldParam;
	}
	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * @param fieldParam the fieldParam to set
	 */
	public void setFieldParam(FieldParam fieldParam) {
		this.fieldParam = fieldParam;
	}
}