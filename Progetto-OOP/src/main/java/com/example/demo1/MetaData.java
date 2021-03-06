package com.example.demo1;
/**
 * 
 * Class containing attributes of metadata parsed by the csv.
 *
 */
public class MetaData {
	/**
	 * alias
	 */
	protected String alias;
	/**
	 * sourceField
	 */
	protected String sourceField;
	/**
	 * type
	 */
	protected String type;
	/**Constructor
	 * @param alias
	 * @param sourceField
	 * @param type
	 */
	public MetaData(String alias, String sourceField, String type) {
		this.alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}
	/**
	 * Constructor
	 */
	public MetaData() {
	}
	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * @return the sourceField
	 */
	public String getSourceField() {
		return sourceField;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * @param sourceField the sourceField to set
	 */
	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}
