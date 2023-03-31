package com.kogaplanet.lunarlatteMarkupLanguage;


public  class Token	{
	
	public TokenType token;
	public int line;
	public String data;
	
	public Token(TokenType token, String data) {
		this.token = token;
		this.data = data;
	}
	
	public Token(TokenType token) {
		this.token = token;
	}
	
	public void setLine(int line) {
		this.line = line;
	}
}
