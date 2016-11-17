package paquet2;

import paquet1.*;
import java.io.*;
import java.util.Set;

public class Application {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Corregir.txt")));
		String word="";
		char letter=' ';
		String correction="";
		ArbreTrie diccionari=loadDiccionari();
		
		String line = br.readLine();
		while (line != null) {
			try {
				while (true) {
					letter = line.charAt(0);
					if (letter != ' ')
						word += letter;
					else if (diccionari.hasWord(word)) correction += word + " ";
					else correction += correctWord(diccionari, word) + " ";
					line=line.substring(1);
				}
			} catch (IndexOutOfBoundsException e) {
				correction+='\n';
				line = br.readLine();
			}
		}	
		br.close();
		System.out.println(correction);
	}
	
	private static String correctWord(ArbreTrie diccionari, String word){
		Set<String> corrections= diccionari.samePrefix(word);
		word= "*"+word+"* ";
		for(String c:corrections){
			word+="("+c+")";
		}
		return word;
	}
	
	private static ArbreTrie loadDiccionari() throws FileNotFoundException{
		ArbreTrie diccionari=new ArbreTrieTau();
		 BufferedReader br = new BufferedReader(new FileReader(new File("Diccionari.txt")));
		 
		 try{
			 for(String line=br.readLine();line!=null;line=br.readLine()){
				 String aux=line;
				 while(line.length()>=1){
					 if(Character.isLetter(line.charAt(0))) aux+=line.charAt(0);
					 else if(line.charAt(0)=='\n'){
						 System.out.println("Adding: " + aux);
						 diccionari.addWord(aux);
						 aux="";
					 }
					 if(line.length()==1)break;
					 line=line.substring(1);
				 }
			 }
			 br.close();
		 }
		 catch(IOException e){e.printStackTrace();}
		 return diccionari;
		 }
		 
	}


