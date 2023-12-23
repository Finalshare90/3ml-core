package com.kogaplanet.lunarlatteMarkupLanguage.util.serialization;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import com.kogaplanet.lunarlatteMarkupLanguage.Token;

public class Serializer {

	PrintWriter writer;
	List<Token> tokenList;
	
	public Serializer(String path, List<Token> tokenList) {
		
		this.tokenList = tokenList;
		
		try {
			writer = new PrintWriter(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}	
	}
	
	public void writeFile() {
		for(int currentToken = 0; currentToken < tokenList.size(); currentToken++){
			writer.println(tokenList.get(currentToken).toString());
		}
		writer.flush();
	}
	
}
