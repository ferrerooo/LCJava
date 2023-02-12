import Google.*;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
    
    
    // Driver code that calls fun()
    public static void main(String[] args)
        throws ClassNotFoundException
    {
        //Pattern regex2 = Pattern.compile("^(\\w\\.) (\\w\\.) (\\w+)$");

        String name = "Beck,David    ";
    
        String[] arr = name.split(" ");

        System.out.println(arr.length);

        for (String s: arr)
          System.out.println(s);
        
    }  

}
