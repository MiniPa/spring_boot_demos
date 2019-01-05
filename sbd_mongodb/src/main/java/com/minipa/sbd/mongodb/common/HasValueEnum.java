package com.minipa.sbd.mongodb.common;

/**
 * Generic interface to return an integer value for myBatis mapping purposes
 * @author nzhu
 *
 */
public interface HasValueEnum {
	
	/**
	 * Returns the integer value of the enum
	 * @return
	 */
	public int getValue();

}
