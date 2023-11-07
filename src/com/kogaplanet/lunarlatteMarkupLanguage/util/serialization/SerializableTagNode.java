package com.kogaplanet.lunarlatteMarkupLanguage.util.serialization;

import java.util.List;
import java.util.Map;

import com.kogaplanet.lunarlatteMarkupLanguage.TagNode;

public class SerializableTagNode {
	
	private TagNode tag;
	
	
	public SerializableTagNode(TagNode tag) {
		this.tag = tag;
	}
	
	public List<String> getData(){
		return tag.data;
	}
	
	public String getName() {
		return tag.name;
	}
	
	public TagNode getParent() {
		return tag.parent;
	}
	
	public Map<String, TagNode> getChildren(){
		return tag.children;
	}
	
	public boolean isParent() {
		return tag.children.size() > 0; 
	}
	
	public boolean isChild() {
		return tag.parent != null;
	}
		
}
