package com.kogaplanet.lunarlatteMarkupLanguage.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kogaplanet.lunarlatteMarkupLanguage.Parser;
import com.kogaplanet.lunarlatteMarkupLanguage.Scanner;
import com.kogaplanet.lunarlatteMarkupLanguage.TagNode;
import com.kogaplanet.lunarlatteMarkupLanguage.Token;
import com.kogaplanet.lunarlatteMarkupLanguage.api.TagHandler;
import com.kogaplanet.lunarlatteMarkupLanguage.api.serialization.SerializerHandler;
import com.kogaplanet.lunarlatteMarkupLanguage.util.DebugUtil;
import com.kogaplanet.lunarlatteMarkupLanguage.util.serialization.TableParser;

public class MainTest {

	public static void main(String[] args) {
		
		DebugUtil debug = new DebugUtil(new Parser("config.3ml") ,new Scanner("config.3ml"));
		
		String[] identifiersVec = debug.getNodesIdentifiers();
		List<String> identifiersArray = new ArrayList<>();
		for(int i = 0; i < identifiersVec.length; i++) {
			identifiersArray.add(identifiersVec[i]);
		}
		
		TableParser tableParser = new TableParser(debug.parser.TAGTABLE, identifiersArray);
		
		List<Token> meinToken = tableParser.parseTable();
		
		for(int i =  0; i < meinToken.size(); i++) {
			System.out.println(meinToken.get(i).token);
		}
		
		HashMap<String, TagNode> table = new HashMap<>();
		table.put("sword1", new TagNode("sword1"));
		table.put("sword2", new TagNode("sword2"));
		table.put("sword3", new TagNode("sword3"));
		table.put("sword4", new TagNode("sword4"));
		table.put("sword5", new TagNode("sword5"));

		String[] identifiers =  (String[]) table.keySet().toArray(new String[table.size()]); 
		
		SerializerHandler handler2 = new SerializerHandler(table, identifiers);

		handler2.add("another1", new TagNode("another1"));
		handler2.add("another2", new TagNode("another2"));
		handler2.add("another3", new TagNode("another3"));
		
		handler2.write("serializable.3ml");
		
		
		//ArrayList<Token> tokenList = new ArrayList<>();
		
		//TagNode node = new TagNode("test1");
		//node.data.add("1");
		//node.data.add("2");
		//node.data.add("3");
		
		//debug.printNodeTree();
		
		
		
		TagHandler handler = new TagHandler();
		System.out.println(handler.call("caller").name);
		
	}
}
