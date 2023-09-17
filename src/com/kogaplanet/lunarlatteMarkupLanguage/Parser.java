package com.kogaplanet.lunarlatteMarkupLanguage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import com.kogaplanet.lunarlatteMarkupLanguage.util.TagUtil;

public class Parser {
	
	public static HashMap<String, TagNode> TAGTABLE = new HashMap<>();
	private ArrayList<Token> tokenTable;
	
	
	public Parser(String fileName) {
		tokenTable = new Scanner(fileName).tokenTable;
		parse();
	}
	
	private void parse() {
		
		boolean isBlockClosed = true;
		
		Stack<TagNode> nodeStack = new Stack<>();
		
		for(int currentToken = 0; currentToken < tokenTable.size(); currentToken++){
			
			if(tokenTable.get(currentToken).token == TokenType.DECLARE){
				
				isBlockClosed = false;
				
				// Create a new node of data for a tag.
				// It contains all the data about a tag: values, names, type and much more
				TagNode rootNode;
				
				// RootNode doesn't have a parent, so it needs to be declared first
				rootNode = new TagNode(tokenTable.get(currentToken).data);
				
				currentToken++;
				
				// Stack defines which node will receive the current data first.
				// Declare tokens add new tokens to the stack, and End tokens remove them.
				nodeStack.add(rootNode);
				
				while(!isBlockClosed){
					
					// NOTE: Nodes are temporary, all the values will be
					// discarded after the closing of a block.
					
					switch (tokenTable.get(currentToken).token) {
					
					// Note: This kind of declare token is different from the first declare Token usage.
					// Declare in this context will add a new token to the nodes Stack, it declares a new child.
					case DECLARE:
						nodeStack.add(new TagNode(tokenTable.get(currentToken).data));
						currentToken++;
						break;
					
					case END:
						
						TagNode tempNode = nodeStack.peek();
						nodeStack.pop();

						if(nodeStack.empty()) {
							
							TAGTABLE.put(rootNode.name, rootNode);
							isBlockClosed = true;
							
						}else {		
							
							nodeStack.peek().children.put(tempNode.name,tempNode);
							tempNode.parent = nodeStack.peek();
									
							currentToken++;
						}
						
						break;

					case CALL:
						
						TagNode calledTag = TAGTABLE.get(tokenTable.get(currentToken).data);
						
						for(int currentData = 0; currentData < calledTag.data.size(); currentData++){
							nodeStack.peek().setData(calledTag.data.get(currentData));
						}
						
						currentToken++;	
						break;
					
					case CALL_CHILDREN:
						
						String tokenData = tokenTable.get(currentToken).data;
						TagNode caller = nodeStack.peek();
						
						List<String> tagQueue = TagUtil.getPathIdentifiers(tokenData);
						
						TagNode children = null;
						TagNode parent = TAGTABLE.get(tagQueue.get(0));
						
						for(int currentParent = 0; currentParent < tagQueue.size(); currentParent++) {
							
							if(children != null) {
								parent = children;
							}
							
							if(tagQueue.size() > currentParent+1) {
								children = parent.children.get(tagQueue.get(currentParent + 1));
							}
						}
						
						for(int currentData = 0; currentData < children.data.size(); currentData++){
							caller.setData(children.data.get(currentData));
						}
						
						
						currentToken++;
						break;
					
					default:
						// "Keep going!"
						nodeStack.peek().setData(tokenTable.get(currentToken).data);
						currentToken++;
						break;
					}
					
				}
			}
		}
	}
	
}



