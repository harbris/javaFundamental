package base.string;

import java.util.ArrayList;
import java.util.HashMap;

public class RealatedChar {
	public static void main(String[] args) {
		//System.out.println(firstNonRepeatedMoreEffect("teeter"));
		//System.out.println(removeChar("Battle of the Vowels: Hawaii vs. Grozny","aejou"));
		System.out.println(reverseWords("Do or do not. there is no try."));
	}
	
	public static Character firstNonRepeated(String input){
		HashMap<Character,Integer> charHash = new HashMap<Character,Integer>();
		final int length = input.length();
		Character resultChar = null;

		for(int i = 0 ; i < length ; i++){
			Integer c = charHash.get(input.charAt(i));
			if(charHash.get(input.charAt(i)) != null){
				charHash.put(input.charAt(i),charHash.get(input.charAt(i))+1);
			}else{
				charHash.put(input.charAt(i),1);
			}
		}
		
		for(int i = 0 ; i < length ; i++){
			if(charHash.get(input.charAt(i)) == 1){
				resultChar = input.charAt(i);
				break;
			}
		}
		
		return resultChar;
	}
	
	public static String firstNonRepeatedMoreEffect(String str){
		HashMap<Integer,Object> charHash = new HashMap<Integer,Object>();
		Object seenOnce = new Object();
		Object seenMultiple = new Object();
		Object seen;
		final int length = str.length();
		
		for(int i = 0 ; i < length ;){
			int cp = str.codePointAt(i);
			i += Character.charCount(cp);
			seen = charHash.get(cp);
			if(seen == null){
				charHash.put(cp,seenOnce);
			}else{
				if(seen == seenOnce){
					charHash.put(cp,seenMultiple);
				}
			}
		}
		
		for(int i = 0 ; i < length ;){
			int cp = str.codePointAt(i);
			i += Character.charCount(cp);
			if(charHash.get(cp) == seenOnce){
				return new String(Character.toChars(cp));
			}
		}
		
		return null;
	}
	
	public static StringBuffer removeChar(String str, String remove){
		ArrayList<Integer> charList = new ArrayList<Integer>();
		StringBuffer resultSentence = new StringBuffer();
		for(int i=0 ; i < str.length();){
			int cp = str.codePointAt(i);
			i += Character.charCount(cp);
			charList.add(cp);
		}
		
		for(int i=0 ; i < charList.size(); i++){
			String word = new String(Character.toChars(charList.get(i).intValue()));
			if(!remove.contains(word)){
				resultSentence.append(word);
			}
		}
		
		return resultSentence;
	}
	
	public static StringBuffer reverseWords(String str){
		String[] words = str.split(" ");
		StringBuffer resultSentence = new StringBuffer();
		
		for(int i = words.length -1 ; i >= 0 ; i--){
			resultSentence.append(words[i]+" ");
		}
		
		return resultSentence;
	}
	
}
