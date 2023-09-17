package com.kogaplanet.lunarlatteMarkupLanguage;

import java.util.ArrayList;
import java.util.HashMap;

public class TagNode {
	
	public String name;
	public ArrayList<String> data = new ArrayList<>();
	public TagNode parent;
	public HashMap<String,TagNode> children = new HashMap<String, TagNode>();
	
	
	public TagNode(String name){
		this.name = name;
	}
	
	public void setData(String data) {
		this.data.add(data);
	}
	
}
