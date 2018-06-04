package br.cefsa.ftt.ec;

import java.util.Arrays;

public class TranspilerMain {

	public TranspilerMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transpiler t = new Transpiler();
		
		System.out.println(Arrays.deepToString(t.lex("mul -1.4 sub 2 sum 1 3 4")));

	}

}
