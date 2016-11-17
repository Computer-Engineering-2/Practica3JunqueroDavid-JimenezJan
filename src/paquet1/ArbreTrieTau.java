package paquet1;

import java.util.Set;
import java.util.TreeSet;

public class ArbreTrieTau implements ArbreTrie{

	private static int size;
	private Node root;

	
	public ArbreTrieTau(){
		size=26;
		this.root=new Node();
	}
	
	private class Node{
		
		private Node[] next;
		private Node(){
			this.next=new Node[size+1]; 
			for(int i=0;i>this.next.length;i++) this.next[i]=null; // La taula s'inicialitza tota a null
		}
	}
	
	@Override
	public void addWord(String s) {
		Node node=root;
		while(s.length()>=1){ 
			char c=s.charAt(0);
			int i=letterToIndex(c);
			if(node.next[i]==null){
				node.next[i]=new Node();
			}
			node=node.next[i];
			if(s.length()==1)break; // Si només queda el carácter que s'acaba de tractar, finalitza cicle.
			s=s.substring(1); 
		}
			node.next[size]=node;
	}

	@Override
	public boolean hasWord(String s) {
		Node node=root;
		while(s.length()>=1){
			char c=s.charAt(0);
			int i=letterToIndex(c);
			if(node.next[i]==null) return false;
			node=node.next[i];
			if(s.length()==1)break;
			s=s.substring(1);
		}
		if(node.next[size]!=null) return true;
		else return false;
	}

	@Override
	public boolean isEmpty() {return root==null;}

	@Override
	public TreeSet<String> samePrefix(String s) {
		Node node=root;
		String current=s;
		while(s.length()>=1){
			char c=s.charAt(0);
			int i=letterToIndex(c);
			if(node.next[i]==null) break;
			node=node.next[i];
			if(s.length()==1)break;
			s=s.substring(1);
		}
		TreeSet<String> words= new TreeSet<String>();
		for(int i=0;i<node.next.length-1;i++){
			if(node.next[i]!=null)words=cercarParaules(node.next[i],words,current+indexToLetter(i));
		}
		return words;
	}

	@Override
	public void mostrarDiccionari() {
		Node node=root;
		TreeSet<String> words= new TreeSet<String>();
		String current="";
		for(int i=0;i<node.next.length-1;i++){
			if(node.next[i]!=null) words=cercarParaules(node.next[i],words,current+indexToLetter(i));
		}
		for(String s:words){
			System.out.println(s);
		}
	}
	
	private TreeSet<String> cercarParaules(Node node, TreeSet<String> words, String current){
			for(int i=0;i<node.next.length-1;i++){
				if(node.next[i]!=null){
					if(node.next[size]!=null)words.add(current);
					words=cercarParaules(node.next[i],words,current+indexToLetter(i));
				}
				if(node.next[size]!=null) words.add(current); // Cal comprobar a les fulles
				
			}
			return words;
	}

	@Override
	public void deleteDiccionari() {this.root=null;}
	
	public int letterToIndex(char c){
		switch(Character.toLowerCase(c)){
		case 'a':return 0;
		case 'b':return 1;
		case 'c':return 2;
		case 'd':return 3;
		case 'e':return 4;
		case 'f':return 5;
		case 'g':return 6;
		case 'h':return 7;
		case 'i':return 8;
		case 'j':return 9;
		case 'k':return 10;
		case 'l':return 11;
		case 'm':return 12;
		case 'n':return 13;
		case 'ñ':return 14;
		case 'o':return 15;
		case 'p':return 16;
		case 'q':return 17;
		case 'r':return 18;
		case 's':return 19;
		case 't':return 20;
		case 'u':return 21;
		case 'v':return 22;
		case 'w':return 23;
		case 'x':return 24;
		case 'y':return 25;
		case 'z':return 26;
		default: throw new IllegalArgumentException("No existeix el caràcter indicat en el diccionari");
		}
		}
	
	
	public char indexToLetter(int i){
		switch(i){
			case 0:return 'a';
			case 1:return 'b';
			case 2:return 'c';
			case 3:return 'd';
			case 4:return 'e';
			case 5:return 'f';
			case 6:return 'g';
			case 7:return 'h';
			case 8:return 'i';
			case 9:return 'j';
			case 10:return 'k';
			case 11:return 'l';
			case 12:return 'm';
			case 13:return 'n';
			case 14:return 'ñ';
			case 15:return 'o';
			case 16:return 'p';
			case 17:return 'q';
			case 18:return 'r';
			case 19:return 's';
			case 20:return 't';
			case 21:return 'u';
			case 22:return 'v';
			case 23:return 'w';
			case 24:return 'x';
			case 25:return 'y';
			case 26:return 'z';
			default: throw new IndexOutOfBoundsException();
		}
	}

}
