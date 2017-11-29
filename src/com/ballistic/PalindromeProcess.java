package com.ballistic;

import org.apache.commons.lang.StringUtils;
import java.util.*;

/**
 * Created by Nabeel on 11/27/2017.
 */
public class PalindromeProcess {

    public static final String SPACE = " ";

    // checking the palindrome
    public Boolean isPalindrome(String message) {
        // we first check string palindrome or not
        if(StringUtils.reverse(message).equals(message)){
            return true;
        }else{
            // check in deep
            char realMessageChar[] = message.toCharArray();
            char reverseMessageChar[] = StringUtils.reverse(message).toCharArray();

            List<Character> palindromeMessageChar = new ArrayList<Character>();
            Stack<Character> specialChar = new Stack<Character>();

            // realMessageIndex
            for(int realMessageIndex = 0; realMessageIndex < realMessageChar.length; realMessageIndex++){
                for(int reverseMessageIndex = 0; reverseMessageIndex < reverseMessageChar.length; reverseMessageIndex++){
                    // this case like 'a' == 'a' then enter
                    if(realMessageChar[realMessageIndex] == reverseMessageChar[reverseMessageIndex]){
                        // add the message into the palindromeMessageChar
                        palindromeMessageChar.add(reverseMessageChar[reverseMessageIndex]);
                        realMessageIndex++;
                    // this case like 'A' convert to 'a' == 'a' Or 'a' != 'b' either 'B' convert then enter and check 'reverseMessageChar[reverseMessageIndex]'
                     // are special character or not 'true' ---> false and 'false' -----> 'true'
                    }else if((Character.toLowerCase(realMessageChar[realMessageIndex]) == Character.toLowerCase(reverseMessageChar[reverseMessageIndex])
                            || Character.toLowerCase(realMessageChar[realMessageIndex]) != Character.toLowerCase(reverseMessageChar[reverseMessageIndex]))
                            && (Character.isAlphabetic(reverseMessageChar[reverseMessageIndex]))) {

                        // this case like if 'letter are upper case' then 'put the upper case letter' other wise 'put lower case letter'
                        palindromeMessageChar.add(Character.isUpperCase(realMessageChar[realMessageIndex]) == true ?
                                Character.toUpperCase(reverseMessageChar[reverseMessageIndex]) :
                                Character.toLowerCase(reverseMessageChar[reverseMessageIndex]));
                        realMessageIndex++;

                    }else {
                        System.out.println("Pakistan zindabad");
                    }
                }
            }
            return false;

        }
    }


    // count the total line ----> ok
    public Integer countLines(List<String> lines){ return lines.size(); }

    // count total word in whole file ----> ok
    public Integer getTotalWords(List<String> lines) {
        final Integer[] totalWords = {0};
        lines.forEach((line) -> totalWords[0] += getWordsPerLine(line));

        return totalWords[0];
    }

    // count the word's per line  ----> ok
    public Integer getWordsPerLine(String line){ return StringUtils.split(line).length; }

    // count the total char ----> ok
    public Map<Character, Integer> getTotalChar(List<String> lines) {
        Map<Character, Integer> charAllLine = new HashMap<Character, Integer>();
        lines.forEach(line ->
            getCharPerLine(line).forEach((character, integer) ->
                charAllLine.put(character, charAllLine.get(character) != null ?
                   charAllLine.get(character)+ integer : integer)));

        return charAllLine;
    }

    // count the total char per line  ----> ok
    public Map<Character, Integer> getCharPerLine(String line) {
        Integer increment = 1;
        Map<Character, Integer> charPerLine = new HashMap<Character, Integer>();
        for (char character: line.toCharArray()){
            if(!Character.isSpaceChar(character) && Character.isAlphabetic(character)){
                charPerLine.put(character, charPerLine.containsKey(character)?
                        charPerLine.get(character)+ increment : increment);
            }
        }

        return charPerLine;
    }

    // count the total vowel( a,e,i,o,u)  ----> ok
    public Map<Character, Integer> getTotalVowel(List<String> lines){
        Map<Character, Integer> totalVowel = new HashMap<Character, Integer>();
        for (String line: lines) {
            for (Character character: line.toCharArray()) {
                switch (character){
                    case 'a':
                    case 'A':
                        putVowel(totalVowel, character);
                        break;
                    case 'e':
                    case 'E':
                        putVowel(totalVowel, character);
                        break;
                    case 'i':
                    case 'I':
                        putVowel(totalVowel, character);
                        break;
                    case 'o':
                    case 'O':
                        putVowel(totalVowel, character);
                        break;
                    case 'u':
                    case 'U':
                        putVowel(totalVowel, character);
                        break;
                }
            }
        }

        return totalVowel;
    }

    // put vowel ----> ok
    public void putVowel(Map<Character, Integer> totalVowel,Character character){
        totalVowel.put(character, totalVowel.get(character) != null ? totalVowel.get(character) + 1 : 1);
    }

    // count the total space per line ---> ok
    public Integer getSpacePerLine(String line) {
        Integer spacePerLine = 0;
        for (Character character: line.toCharArray()){
            if(Character.isSpaceChar(character)){ spacePerLine += 1; }
        }

        return spacePerLine;
    }

    // count all space in the file ---> ok
    public Integer getTotalSpace(List<String> lines) {
        final Integer[] totalSpace = {0};
        lines.forEach(line -> totalSpace[0] += getSpacePerLine(line));

        return totalSpace[0];
    }

}
