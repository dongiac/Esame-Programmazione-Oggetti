package com.example.demo1;

import java.util.ArrayList;
/**Interface containing the abstract method for filter implementation.
 * @param <E> Objects in a collection we want to analyze.
 */
public interface Filter<E> {
	abstract ArrayList<E> filterField(FieldParamAll filterParams);
}
