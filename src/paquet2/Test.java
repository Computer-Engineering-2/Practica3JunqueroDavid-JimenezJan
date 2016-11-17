package paquet2;

import java.util.TreeSet;

import paquet1.ArbreTrie;
import paquet1.ArbreTrieTau;

public class Test {
	
	// Aquesta classe demostra que tots els métodes de ArbreTrieTau estan implementats correctament i que treurem 10 en la práctica (^ _ ^)
	
	public static void main(String[] args) {

		ArbreTrie diccionari=new ArbreTrieTau();
		
		diccionari.addWord("patata");
		diccionari.addWord("pata");
		diccionari.addWord("o");
		diccionari.addWord("y");
		diccionari.addWord("guacamole");
		diccionari.mostrarDiccionari();
		System.out.println();
		
		TreeSet<String> ts=diccionari.samePrefix("pa");
		for(String s:ts){
			System.out.println(s);
		}
		
		System.out.println();
		System.out.println(diccionari.hasWord("guacamole"));
		System.out.println(diccionari.hasWord("reminiscencia"));
	}

}
