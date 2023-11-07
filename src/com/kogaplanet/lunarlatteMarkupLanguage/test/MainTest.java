package com.kogaplanet.lunarlatteMarkupLanguage.test;

import com.kogaplanet.lunarlatteMarkupLanguage.Parser;
import com.kogaplanet.lunarlatteMarkupLanguage.Scanner;
import com.kogaplanet.lunarlatteMarkupLanguage.util.DebugUtil;

public class MainTest {

	public static void main(String[] args) {

		DebugUtil debug = new DebugUtil(new Parser("config.3ml") ,new Scanner("config.3ml"));
		
		debug.printNodeTree();
		
	}
}
