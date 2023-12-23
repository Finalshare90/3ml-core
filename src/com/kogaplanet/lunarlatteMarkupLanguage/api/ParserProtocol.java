package com.kogaplanet.lunarlatteMarkupLanguage.api;

import com.kogaplanet.lunarlatteMarkupLanguage.Parser;
import java.util.HashMap;

import com.kogaplanet.lunarlatteMarkupLanguage.TagNode;

public interface ParserProtocol {
	
	
	final HashMap<String, TagNode> TABLE = Parser.TAGTABLE;
	
	
	@Deprecated
	/**
	* DEPRECATED, do NOT use this in new implementations
	* Init the parser, always init a the parser before acessing TABLE
	*/ 
	public void parserInit(Parser parser);
	
	/**
	* Init the parser by reading a 3ml file specified in path
	* a new tag TABLE will be produced if successful
	*/ 
	public void read(String path);

	/**
	 * Calls the target tag from table.
	 * 
	 * @return A ready-to-use instance of  the called tag
	 */
	public TagNode call(String tagIdentifier);
	
	@Deprecated
	/**
	 * Poor design choose of mine, use call(String tagIdentifier).children directly instead.
	 * */
	public TagNode callChild(String parent, String child);
	
	@Deprecated
	/**
	 * Poor design choose of mine, use call(String tagIdentifier).parent directly instead.
	 * */
	public TagNode callParent(String parent);

}
