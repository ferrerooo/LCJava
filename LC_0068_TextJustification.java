import java.util.*;

public class LC_0068_TextJustification {
    
    public List<String> fullJustify(String[] words, int L) {

    List<String> al = new ArrayList<String>(); 
    if (words==null || words.length==0) 
        return al; 

    String line= ""; 
    for (int i=0;i<words.length; i++) { 
        if (line.length() + words[i].length() < L) { 
            line = line+words[i]+" ";
        } else if (line.length() + words[i].length() == L) { 
            al.add(line+words[i]); 
            line = ""; 
        } else { 
            i--; 
            processAndSave(line, al, L); 
            line = ""; 
        } 
    } 

    // handle the last line 
    if ("".equals(line)) 
        return al; 
    else { 
        int spaceLen = L-line.length(); 
        String lastSpace = ""; 
        for (int i=0; i<spaceLen; i++) 
            lastSpace +=" "; 
        al.add(line+lastSpace); 
        return al; 
    } 
} 

private void processAndSave(String line, List<String> al, int L) { 
    line = line.trim(); 
    String[] wordArr = line.split(" "); 
    int totalWordLen = 0; 
    for (String str:wordArr) 
        totalWordLen += str.length(); 
    
    int totalSpaceLen = L-totalWordLen; 
    if (wordArr.length==1){ 
        String oneSpace = ""; 
        for (int i=0;i<totalSpaceLen;i++) 
            oneSpace += " "; 
        al.add(wordArr[0]+oneSpace); 
        return; 
    } 

    String[] spaceArr = new String[wordArr.length-1]; 
    for (int i=0; i<spaceArr.length; i++) 
        spaceArr[i] = ""; 
     
    for (int i=0;i<totalSpaceLen; i++) { 
        spaceArr[i%spaceArr.length] +=" "; 
    } 

    StringBuilder sb = new StringBuilder(); 
    for (int i=0;i<spaceArr.length; i++) { 
        sb.append(wordArr[i]); 
        sb.append(spaceArr[i]); 
    } 

    sb.append(wordArr[wordArr.length-1]); 
    al.add(sb.toString()); 
} 
} 

