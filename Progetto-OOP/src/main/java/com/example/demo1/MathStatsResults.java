package com.example.demo1;

public class MathStatsResults {
	String field;
	double avg;
	double min;
	double max;
	double std;
	int count;
	/**
	 * @param util
	 * @param field
	 * @param avg
	 * @param min
	 * @param max
	 * @param std
	 * @param count
	 */
	public MathStatsResults(String field, double avg, double min, double max, double std, int count) {
		this.field = field;
		this.avg = avg;
		this.min = min;
		this.max = max;
		this.std = std;
		this.count = count;
	}

	/**
	 * 
	 */
	public MathStatsResults() {
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @return the avg
	 */
	public double getAvg() {
		return avg;
	}

	/**
	 * @return the min
	 */
	public double getMin() {
		return min;
	}

	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}

	/**
	 * @return the std
	 */
	public double getStd() {
		return std;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @param avg the avg to set
	 */
	public void setAvg(double avg) {
		this.avg = avg;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(double min) {
		this.min = min;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(double max) {
		this.max = max;
	}

	/**
	 * @param std the std to set
	 */
	public void setStd(double std) {
		this.std = std;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
