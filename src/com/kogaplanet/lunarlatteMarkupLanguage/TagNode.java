package com.kogaplanet.lunarlatteMarkupLanguage;

import java.util.ArrayList;
import java.util.HashMap;
import com.kogaplanet.lunarlatteMarkupLanguage.util.TagUtil;

public class TagNode {
	
	public String name;
	public ArrayList<String> data = new ArrayList<>();
	
	public TagNode parent;
	public HashMap<String,TagNode> children = new HashMap<String, TagNode>();
	public ArrayList<String> childrenIdentifiers = new ArrayList<>();
	
	ArrayList<TagNode> callers  = new ArrayList<>();
	ArrayList<TagNode> calledIn = new ArrayList<>();
	
	public TagNode(String name){
		this.name = name;
	}
	
	public void addChildren(String identifier, TagNode child) {
		
		children.put(identifier, child);
		
		childrenIdentifiers.add(identifier);
	
	}
	
	public void setCaller(TagNode tagNode) {
		if(TagUtil.checkForDuplicate(tagNode, calledIn)) {
			callers.add(tagNode);
		}
	}
	
	public void setCalled(TagNode tagNode) {
		if(TagUtil.checkForDuplicate(tagNode, calledIn)) {
			calledIn.add(tagNode);
		}
	}
	
	
	public void setData(String data) {
		this.data.add(data);
	}
	
}
