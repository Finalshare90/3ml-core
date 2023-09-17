package com.kogaplanet.lunarlatteMarkupLanguage.api;


import com.kogaplanet.lunarlatteMarkupLanguage.Parser;
import com.kogaplanet.lunarlatteMarkupLanguage.TagNode;

public class TagHandler implements ParserProtocol {

	private Parser parser;
	
	@Override
	public TagNode callChild(String parent, String child) {
		return call(parent).children.get(child);
	}
	
	@Override
	public TagNode callParent(TagNode tag) {
		return tag.parent;
	}
	
	@Override
	public TagNode call(String tag) {
		return TABLE.get(tag);
	}
	
	@Override
	public void parserInit(Parser parser) {
		this.parser = parser;
	}
	
}
