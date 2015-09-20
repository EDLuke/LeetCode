/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author lzhang
 */
public class MinimumWindow {
    public MinimumWindow(){
        System.out.println(minWindow("abc", "cba"));
    }
    
    
    public String minWindow(String s, String t) {
        
        int sLength = s.length();
        int tLength = t.length();
        
        if(tLength > sLength){
            return "";
        }
        int minWindowBegin = 0;
        int minWindowEnd = 0;
       
        int[] needToFind = new int[256];
        
        for(int i = 0; i < tLength; i++){
            needToFind[t.charAt(i)]++;
        }
        
        int[] hasFound = new int[256];
        int minWindowLen = Integer.MAX_VALUE;
        int count = 0;
        
        for(int begin = 0, end = 0; end < sLength; end++){
            if(needToFind[s.charAt(end)] == 0) 
                continue;
            hasFound[s.charAt(end)]++;
            if(hasFound[s.charAt(end)] <= needToFind[s.charAt(end)]) 
                count++;
            
            if(count == tLength){
                while(needToFind[s.charAt(begin)] == 0 ||
                        hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)])
                        {
                            if(hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)]){
                                hasFound[s.charAt(begin)]--;
                            }
                            begin++;
                        }
                int windowLen = end - begin + 1;
                if(windowLen < minWindowLen){
                    minWindowBegin = begin;
                    minWindowEnd = end + 1;
                    minWindowLen = windowLen;
                }
            }
            
        }
        
        return (minWindowBegin < minWindowEnd) ? s.substring(minWindowBegin, minWindowEnd) : "";
        
        
    }
}
