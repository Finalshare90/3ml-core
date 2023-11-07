package com.kogaplanet.lunarlatteMarkupLanguage.util.serialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.kogaplanet.lunarlatteMarkupLanguage.TagNode;

public class TagTree {
	
	Map<String, TagNode> tagTable;
	List<String> identifiers;
	
	/*
	 "Tree" tag Structure, we are just going to specify the declaration order of a Tag Table.
	 More like a "log" data structure, *wink*.
	*/
	ArrayList<SerializableTagNode> tagTree = new ArrayList<SerializableTagNode>();
	
	public void getTree(Map<String, TagNode> tagTable, List<String> identifiers) {
		this.tagTable = tagTable;
		this.identifiers = identifiers;
	}
	
	private void iterateTable(Map<String, TagNode> table) {
		
	}
	
}
