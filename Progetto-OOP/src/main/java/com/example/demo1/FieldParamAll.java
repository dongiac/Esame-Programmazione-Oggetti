package com.example.demo1;
/**
 * 
 * This class will contain parameters used to entually filter the data set and stats
 *
 */
public class FieldParamAll {
	/**
	 * Array of Strings that will contain as much as field names we want to filter, used ONLY if using conditional operators: in this case, "fieldName" will be left empty.
	 */
	String fieldNames[];
	/**
	 * String that will contain the field name we want to calculate math stats or use in filter: in this case, fieldNames[] must be left empty.
	 */
	String fieldName;
	/**
	 * FieldParam object that contains other info for the calculation of math stats and/or filter
	 */
	public FieldParam fieldParam;

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
	 * @return the fieldNames
	 */
	public String[] getFieldNames() {
		return fieldNames;
	}
	/**
	 * @param fieldNames the fieldNames to set
	 */
	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
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
