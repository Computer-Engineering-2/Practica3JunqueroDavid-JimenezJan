package paquet1;

import java.util.TreeSet;

public interface ArbreTrie {

	
	void addWord(String s);
	
	boolean hasWord(String s);
	
	boolean isEmpty();
	
	TreeSet<String> samePrefix(String s);
	
	void mostrarDiccionari();
	
	void deleteDiccionari();
}
