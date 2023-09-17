package com.kogaplanet.lunarlatteMarkupLanguage;

import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import com.kogaplanet.lunarlatteMarkupLanguage.util.*;

public class Scanner {

	
	private File file;
	
	public ArrayList<LineContent> fileContent;
	public ArrayList<Token> tokenTable;
	int line = 0;
	
	public Scanner (String filename){
		file = new File(filename);
		readFile(file);
		processContent();
	}
	
	
	
	private void readFile(File file){
		
		fileContent = new ArrayList<>();
		String lineData;
		
		try {
			java.util.Scanner sc = new java.util.Scanner(file);
		while(sc.hasNext()){
		
			line++;
			lineData = sc.next();
				
			if(isAcomment(lineData)){	
				
				try {
					lineData = sc.nextLine();
					line++;
				}
				catch (NoSuchElementException e) {
					System.err.println("READING ERROR AT LINE: " + line);
					System.err.println("No more lines to read");			
				}
				
				}else{
					fileContent.add(new LineContent(lineData, line));	
				}
			}	
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private Boolean isAcomment(String data){
		if(data.contains("//"))
			return true;	
		return false;
	}
	
	// Process the 3ml file into a type-safe and detailed table of source-code.
	private void processContent(){
		
		tokenTable = new ArrayList<>();
		
		for(int currentLine = 0; currentLine < fileContent.size(); currentLine++){
			
			tokenTable.add(tokenize(fileContent.get(currentLine).data, 
									fileContent.get(currentLine).line));
			
		}
	}
	
	private Token tokenize(String data, int line){
		
		Token token;
		String tag;
		
		switch (lexSymbols(data)) {
		case "[":
			tag = TagUtil.formatTag(data);
			token = new Token(TokenType.DECLARE, tag);
			break;
			
		case "end]":
			token = new Token(TokenType.END);
			break;
			
		case "$":
			tag = TagUtil.removeAchar(data, '$');
			token = new Token(TokenType.CALL, tag);			
			break;
			
		case ">":
			
			tag = TagUtil.removeAchar(data, '$');
			token = new Token(TokenType.CALL_CHILDREN, tag);
			break;
			
		default:	
			token = new Token(TokenType.DATA, data);
			break;
		}
		
		return token;
	} 
	
	private String lexSymbols(String data){
		
		if(data.contains("[")){
			return "[";	
		}
		
		else if(data.contains(">") && data.contains("$")){
			return ">";
		}
		
		else if (data.contains("$")) {
			return "$";	
		}
		
		
		
		return data;
	}
	
	
	
}
