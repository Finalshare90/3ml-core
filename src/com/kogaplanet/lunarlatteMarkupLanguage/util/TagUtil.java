package com.kogaplanet.lunarlatteMarkupLanguage.util;

import com.kogaplanet.lunarlatteMarkupLanguage.*;
import java.util.ArrayList;
import java.util.List;

public class TagUtil {

	
	// Place to put all the "gambiarras" together:)
	// Doesn't know what gambiarras means? search it by yourself.
	
	/*
	 note: it will be processing the tag name, removing anything, but the name.
	 also, its kinda like a getter, try using this to do your tag calls;)
	 */
	static public List<String> callTagData(String tag) {	
		if(tag.contains("[")){
			tag = formatTag(tag);
		}	
		try {
			return Parser.TAGTABLE.get(tag).data;	
		} catch (Exception e) {
				System.err.print("CALL ERROR: " + tag + " not found, consider to check your"
							   + " 3ML tag structure, or for mistyping");
			return null;
		}
	}
	
	// For debug purposes only.
	static public void printTag(TagNode tag) {
		System.out.println(tag.name + ":");
		for(int count = 0; count < tag.data.size(); count++) {
			System.out.println(" |_" + tag.data.get(count));
		}
		System.out.println();
	}
	
	static public String formatTag(String tagName) {
		
		ArrayList<Character> tagChars = new ArrayList<>();
		
		// Dismember tagName into array of chars
		for(int currentChar = 0; currentChar < tagName.length(); currentChar++) {
			tagChars.add(tagName.charAt(currentChar));
		}
		
		// Remove the "[" from the current tag
		if(tagName.contains("[")) {
			tagChars.remove(0);
		}
		
		String formatedString;
		
		try {
			formatedString = tagChars.get(0).toString();
		} catch (IndexOutOfBoundsException e) {
			System.err.println("FORMAT ERROR: DECLARE its null, consider putting a name with at least 1 char");
			return " ";
		}
		
		// Unite the chars back into a String
		for(int currentChar = 1; currentChar < tagChars.size(); currentChar++) {
			formatedString += tagChars.get(currentChar).toString();	
		}
				
		return formatedString;
	}
	

	static public String removeAchar(String line, char removableChar) {
		
		ArrayList<Character> tagChars = new ArrayList<>();
		
		// Dismember tagName into array of chars
		for(int currentChar = 0; currentChar < line.length(); currentChar++) {
			tagChars.add(line.charAt(currentChar));
		}
		
		// Remove the desired char from the current line
		for (int count = 0; count < tagChars.size(); count++) {
			if(tagChars.get(count).equals(removableChar)) {				
				tagChars.remove(count);
			}
		}
				
		String formatedString = "";
		
		// Unite the chars back into a String
		for(int currentChar = 0; currentChar < tagChars.size(); currentChar++) {
			formatedString += tagChars.get(currentChar).toString();	
		}
				
		return formatedString;
	}
	
	static public String containsLine(String line, String expectedLine) {	
		if(line.contains(expectedLine)){		
			return expectedLine;	
		}	
		return line;
	}
	
}
