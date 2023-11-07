package com.kogaplanet.lunarlatteMarkupLanguage.util.serialization;

import java.util.List;
import java.util.Map;

import com.kogaplanet.lunarlatteMarkupLanguage.TagNode;
import com.kogaplanet.lunarlatteMarkupLanguage.Token;

public class Serializator {
	
	List<Token> tokenBuffer; 	
	Map<String, TagNode> tagTable;
	
	public Serializator(Map<String, TagNode> tagTable)  {
		this.tagTable = tagTable;
	}
	
	/*
	 Set an identifier list for tag tree parsing.
	 Due to the use of maps, you need to set a list of the tag
	 names that is going to be serialized. Childs not included*
	 */
	public void setIdentifiers() {
	
	}
	
	private void parseTagTree() {
		
	}
	
}
