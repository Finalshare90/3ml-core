package com.kogaplanet.lunarlatteMarkupLanguage.api;


import com.kogaplanet.lunarlatteMarkupLanguage.Parser;
import com.kogaplanet.lunarlatteMarkupLanguage.TagNode;

public class TagHandler implements ParserProtocol {

	private Parser parser;
	
	/**
	 * Poor design choose of mine, use call(String tagIdentifier).children directly instead.
	 * */
	@Deprecated
	@Override
	public TagNode callChild(String parent, String child) {
		return call(parent).children.get(child);
	}
	
	/**
	 * Poor design choose of mine, use call(String tagIdentifier).parent directly instead.
	 * */
	@Deprecated
	@Override
	public TagNode callParent(String tag) {
		return call(tag).parent;
	}
	
	@Override
	public TagNode call(String tagIdentifier) {
		return TABLE.get(tagIdentifier);
	}
	
	@Override
	public void read(String path) {
		this.parser = new Parser(path);		
	}
	
	@Deprecated
	@Override
	public void parserInit(Parser parser) {
		this.parser = parser;
	}
	
}
