package com.kogaplanet.lunarlatteMarkupLanguage.api;

import com.kogaplanet.lunarlatteMarkupLanguage.Parser;
import java.util.HashMap;

import com.kogaplanet.lunarlatteMarkupLanguage.TagNode;

public interface ParserProtocol {
	
	
	final HashMap<String, TagNode> TABLE = Parser.TAGTABLE;
	
	// Init the parser, always init a the parser before acessing TABLE
	public void parserInit(Parser parser);
	
	public TagNode call(String tag);


}
