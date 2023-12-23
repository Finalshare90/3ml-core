package com.kogaplanet.lunarlatteMarkupLanguage.api.serialization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kogaplanet.lunarlatteMarkupLanguage.TagNode;
import com.kogaplanet.lunarlatteMarkupLanguage.Token;
import com.kogaplanet.lunarlatteMarkupLanguage.util.serialization.Serializer;
import com.kogaplanet.lunarlatteMarkupLanguage.util.serialization.TableParser;

public class SerializerHandler implements SerializationProtocol{
	
	
	private HashMap<String, TagNode> table;
	private List<String> identifiers;
	
	/**
	 * Starts a empty serializer with a empty table instance
	*/
	public SerializerHandler() {
		table = new HashMap<>();
		identifiers = new ArrayList<>();
	}
	
	/**
	 * Starts a ready-to-use serializer with a table instance
	 * 
	 * @param identifiers A list of keys for <strong>table</strong> elements
	 * @param table A set of tagNodes organized by identifiers keys.
	*/
	public SerializerHandler(HashMap<String, TagNode> table, List<String> identifiers){
		this.table = table;
		this.identifiers = identifiers;
	}
	
	/**
	 * Starts a ready-to-use serializer with a table instance
	 * 
	 * NOTE: This constructor cast String[] identifiers to a List<String>, passing a List<String> is
	 * prefereble, but it works with String[] in the same way.
	 * 
	 * @param identifiers A vector of keys for <strong>table</strong> elements
	 * @param table A set of tagNodes organized by identifiers keys.
	*/
	public SerializerHandler(HashMap<String, TagNode> table, String[] identifiers){
		this.table = table;
		
		List<String> identifiersList = new ArrayList<>();
		
		for(int currentIdentifier = 0; currentIdentifier < identifiers.length; currentIdentifier++) {
			identifiersList.add(identifiers[currentIdentifier]);
		}
		
		this.identifiers = identifiersList;
	}
	
	@Override
	public void add(String identifier, TagNode node) {
		table.put(identifier, node);
		identifiers.add(identifier);
	}
	
	@Override
	public void flush() {
		table.clear();
		identifiers.clear();
	}
	
	@Override
	public void remove(String node) {
		table.remove(node);
		identifiers.remove(node);
	}
	
	@Override
	public void setTable(HashMap<String, TagNode> table, List<String> identifiers) {
		this.table = table;
		this.identifiers = identifiers;
	}
	
	@Override
	public void write(String path) {
		TableParser tableParser = new TableParser(table, identifiers);
		List<Token> tokens = tableParser.parseTable();
		Serializer serializer = new Serializer(path, tokens);
		serializer.writeFile();		
	}
}
