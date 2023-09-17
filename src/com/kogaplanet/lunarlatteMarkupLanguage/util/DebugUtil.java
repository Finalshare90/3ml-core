package com.kogaplanet.lunarlatteMarkupLanguage.util;

import java.util.ArrayList;

import com.kogaplanet.lunarlatteMarkupLanguage.Parser;
import com.kogaplanet.lunarlatteMarkupLanguage.Scanner;
import com.kogaplanet.lunarlatteMarkupLanguage.TagNode;
import com.kogaplanet.lunarlatteMarkupLanguage.Token;
import com.kogaplanet.lunarlatteMarkupLanguage.TokenType;

public class DebugUtil {
	
	ArrayList<Token> tokenTable;
	public Parser parser;
	Scanner scanner;
	
	public DebugUtil(Parser parser, Scanner scanner) {
		
		this.parser = parser;
		this.scanner = scanner;
		
		tokenTable = scanner.tokenTable;
	}
	
	public void printNodeTree() {
		
		for(String Identifiers : getNodesIdentifiers()){
			System.out.println(Identifiers);
		}
		
	}
	
	public void printNodeData(TagNode node) {
		for(String data : node.data) {
			System.out.println(data);
		}
	}
	
	public String[] getNodesIdentifiers(){
		
		String[] nodesIdentifiers = new String[Parser.TAGTABLE.size()];
		
		
		for(int currentIdentifier = 0, currentToken = 0; currentToken < tokenTable.size(); currentToken++ ){
			
			if(tokenTable.get(currentToken).token == TokenType.DECLARE){
				
				nodesIdentifiers[currentIdentifier] = tokenTable.get(currentToken).data;
				
				currentIdentifier =+ 1;
			}
		}
		
		return nodesIdentifiers;
	}
	
	public void printTokenTree() {
		for(int currentToken = 0; currentToken < tokenTable.size(); currentToken++) {
			System.out.println(tokenTable.get(currentToken).token.toString() +
								" content: "+ tokenTable.get(currentToken).data);
		}
	}
	
	
	
	
}
