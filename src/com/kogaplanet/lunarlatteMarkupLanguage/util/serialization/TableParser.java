package com.kogaplanet.lunarlatteMarkupLanguage.util.serialization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.kogaplanet.lunarlatteMarkupLanguage.TagNode;
import com.kogaplanet.lunarlatteMarkupLanguage.Token;
import com.kogaplanet.lunarlatteMarkupLanguage.TokenType;

public class TableParser {
	
	private HashMap<String, TagNode> table;
	private List<String> identifiers;
	
	public TableParser(HashMap<String, TagNode> table, List<String> identifiers) {
		this.table = table;
		this.identifiers = identifiers;
	}
	
	public ArrayList<Token> parseTable(){
		
		ArrayList<Token> tokenBuffer = new ArrayList<>();
		
		for(int currentNode = 0; currentNode < identifiers.size(); currentNode++){
			insertNode(tokenBuffer, table.get(identifiers.get(currentNode)));	
		}
		return tokenBuffer;
	}
	
	
	/**
	* Inserts a tagNode equivalent in tokens instructions to tokenList
	* myTagNode -> DECLARE{...} DATA{...} END{...}
	*/
	private void insertNode(ArrayList<Token> tokenList, TagNode node) {
		
		tokenList.add(new Token(TokenType.DECLARE, node.name));
		
		for(int currentData = 0; currentData < node.data.size(); currentData++) {
			tokenList.add(new Token(TokenType.DATA, node.data.get(currentData)));
		}	
		
		if(node.children.size() > 0) {
			
			TagNode currentChild;
			
			for(int currentChildid = 0; currentChildid < node.childrenIdentifiers.size(); currentChildid++) {
				
				currentChild = node.children.get(node.childrenIdentifiers.get(currentChildid));
				
				insertNode(tokenList, currentChild);	
			}
		}
		
		tokenList.add(new Token(TokenType.END));
	}
	
	
}
