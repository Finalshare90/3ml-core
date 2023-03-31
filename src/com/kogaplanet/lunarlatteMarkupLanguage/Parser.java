package com.kogaplanet.lunarlatteMarkupLanguage;

import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
	
	public static HashMap<String, TagNode> TAGTABLE = new HashMap<>();
	private ArrayList<Token> tokenTable;
	
	
	public Parser(Scanner scanner) {
		tokenTable = scanner.tokenTable;
		parse();
	}
	
	private void parse() {
		
		boolean isBlockClosed = true;
		
		for(int currentToken = 0; currentToken < tokenTable.size(); currentToken++){
			
			
			if(tokenTable.get(currentToken).token == TokenType.DECLARE){
				
				isBlockClosed = false;
				
				// Create a new node of data for a tag.
				// It contains all the data about a tag: values, names, type and much more
				TagNode node = new TagNode(tokenTable.get(currentToken).data);

				currentToken++;
				
				while(!isBlockClosed){
					
					// NOTE: Nodes are temporary, all the values will be
					// discarded after the closing of a block.
					
					switch (tokenTable.get(currentToken).token) {
					
					case END:
						isBlockClosed = true;
						TAGTABLE.put(node.name, node);
						break;

					case CALL:
						TagNode calledTag = TAGTABLE.get(tokenTable.get(currentToken).data);
						
						for(int currentData = 0; currentData < calledTag.data.size(); currentData++){
							node.setData(calledTag.data.get(currentData));
						}
						currentToken++;	
						break;
						
					default:
						// "Keep going!"
						node.data.add(tokenTable.get(currentToken).data);
						currentToken++;
						break;
					}
					
				}
			}
		}
		
	}
	
}



