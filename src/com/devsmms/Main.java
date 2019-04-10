package com.devsmms;


import com.devsmms.mindgames.ui.console.CheckersConsole;
import com.devsmms.mindgames.ui.console.Console;
import com.devsmms.mindgames.ui.enums.Color;
import com.devsmms.mindgames.ui.print.ColorPrinter;

public class Main {

	public static void main(String[] args) {
//		Console c = Console.getInstance();
//		c.start();
		CheckersConsole cc = new CheckersConsole();
		cc.printTable();
	}
}
