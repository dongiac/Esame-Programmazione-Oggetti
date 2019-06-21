package com.example.demo1;

import java.util.ArrayList;
/**Interface containing the abstract method for math stats implementation
 * @param <T> Class objects we want to get stats from.
 */
public interface Stats<T> {
	public Object compute(ArrayList<T> src, String fieldName);
}
