package com.kogaplanet.lunarlatteMarkupLanguage.api.serialization;

import java.util.HashMap;
import java.util.List;

import com.kogaplanet.lunarlatteMarkupLanguage.TagNode;

public interface SerializationProtocol {
	
	/**
	 * Set a new table for serialization
	 */
	public void setTable(HashMap<String, TagNode> table, List<String> identifiers);
	
	public void add(String identifier, TagNode node);
	public void remove(String node);
	
	/**
	 * Serialize the class attribute table using the path parameter.
	 */
	public void write(String path);
	
	/**
	 * Clear the table attribute. 
	 */
	public void flush();
}
