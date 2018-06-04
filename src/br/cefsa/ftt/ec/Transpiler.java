package br.cefsa.ftt.ec;

import java.util.Arrays;

/*
Grammar:

digit = 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
num = digit+
op = sum | sub | mul | div
expr = num | op expr+

*/

/*
Inspired by: 

http://blog.mgechev.com/2017/09/16/developing-simple-interpreter-transpiler-compiler-tutorial/
https://en.wikipedia.org/wiki/Extended_Backus%E2%80%93Naur_form
https://ruslanspivak.com/lsbasi-part1/
https://kosamari.com/presentation/jsconfcolombia-2016/#0
https://en.wikibooks.org/wiki/Compiler_Construction/Case_Study_1B#Abstract_Syntax_Trees

*/

public class Transpiler {
	
	private String[] keyWords = {"sum","sub","mul","div"};
	
	private String inputCode;

	public Transpiler() {
		// TODO Auto-generated constructor stub
	}
	
	public Transpiler(String icode) {
		this.inputCode(icode);
	}
	
	public void inputCode(String icode) {
		this.inputCode = icode;
	}
	
	public String[] lex(String icode) {
		
		String[] lexemas = icode.split(" ");
		
		for(int index=0; index < lexemas.length; index++) 
			lexemas[index] = lexemas[index].trim().toLowerCase();
		
		for(int index=0; index < lexemas.length; index++) {
		
			if (!this.isNumeric(lexemas[index]) && !this.isKeyword(lexemas[index])) {
				System.err.println("Lex: Invalid keyword: " + lexemas[index]);
				System.exit(1);			
			} //if
			
		}	//for
		
		return lexemas;
		
	}//lex
	
	private boolean isNumeric(String str) {
	  
		return str.matches("-?\\d+(\\.\\d+)?");  
	
	}//isNumeric
	
	private boolean isKeyword(String str) {
		
		for(String s : this.keyWords)
		    if(s.equals(str)) return true;
		
		return false;
		
	}//isKeyword

}
