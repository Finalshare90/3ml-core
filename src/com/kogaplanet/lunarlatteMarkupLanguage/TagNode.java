package com.kogaplanet.lunarlatteMarkupLanguage;

import java.util.ArrayList;

public class TagNode {
	
	public String name;
	public ArrayList<String> data = new ArrayList<>();
	
	public TagNode(String name){
		this.name = name;
	}
	
	public void setData(String data) {
		this.data.add(data);
	}
	
}
