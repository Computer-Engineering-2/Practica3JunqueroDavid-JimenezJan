package paquet1;

import java.util.TreeSet;

public class ArbreTrieTau implements ArbreTrie{

	private static int size;
	private Node root;

	
	public ArbreTrieTau(int size){
		this.size=size;
		this.root=new Node();
	}
	
	private class Node{
		
		private Node[] next;
		private Node(){
			this.next=new Node[size+1]; // La taula es deixa amb valors nulls al principi
		}
	}
	
	@Override
	public void addWord(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasWord(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {return root==null;}

	@Override
	public TreeSet<String> samePrefix(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mostrarDiccionari() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDiccionari() {this.root=null;}
	
	public int letterToIndex(char c){
			throw new IllegalArgumentException("No existeix el caràcter indicat en el diccionari");
		}
	
	
	public char indexToLetter(int i){
		return 0;
	}

}
