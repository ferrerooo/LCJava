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

        String name = "Beck,David Victor";
    
        NameParser1.parse(name);
    }  

}

/*
 * Name can be constructed in a set of different ways:
  - <First Name>
  - <Last Name>,<First Name>
  - <First Name> <Last Name>
  - <First Initial>. <Middle Initial>. <Last Name>
  - <First Name> <Middle Name> <Last Name>
  - <First Name> <Middle Initial>. <Last Name>
  - <Last Name>,<First Name> <Middle Name>
 * 
*/

interface NameParserConstants1 {
    static Pattern regex1 =
        Pattern.compile("^(?<lastName>\\w+),(?<firstName>\\w+) ?(?<middleName>\\w+)?$");
    static String[] matcherGroups1 = {"firstName", "lastName", "middleName"};
  
    static Pattern regex2 =
        Pattern.compile("^(?<firstInitial>\\w\\.) ?(?<middleInitial>\\w\\.) ?(?<lastName>\\w+)$");
    static String[] matcherGroups2 = {"firstInitial", "middleInitial", "lastName"};
  
    static Pattern regex3 =
        Pattern.compile("^(?<firstName>\\w+) (?<middleName>\\w+)? (?<lastName>\\w+)$");
    static String[] matcherGroups3 = {"firstName", "middleName", "lastName"};
  
    static Pattern regex4 = Pattern.compile("^(?<firstName>\\w+) ?(?<lastName>\\w+)?$");
    static String[] matcherGroups4 = {"firstName", "lastName"};
  
    static Pattern regex5 =
        Pattern.compile("^(?<firstInitial>\\w\\.) (?<middleName>\\w+) (?<lastName>\\w+)$");
    static String[] matcherGroups5 = {"firstInitial", "middleName", "lastName"};
  
    static Pattern regex6 =
        Pattern.compile("^(?<firstName>\\w+) (?<middleInitial>\\w\\.) (?<lastName>\\w+)$");
    static String[] matcherGroups6 = {"firstName", "middleInitial", "lastName"};
  
    static Pattern[] regexes = {regex1, regex2, regex3, regex4, regex5, regex6};
    static String[][] matcherGroups = {
      matcherGroups1, matcherGroups2, matcherGroups3, matcherGroups4, matcherGroups5, matcherGroups6
    };
  }
  
  
class NameParser1 implements NameParserConstants1 {
  
    /**
     * Parse a string containing a persons name into a Name object, which separates out the parts
     * (first, middle, and last name).
     *
     * This works by checking each regular expression one at a time to extract the name parts. A
     * {@code Name} object is created then updated based on the name parts (first/middle/last
     * name/initial) it extracts. The final {@code Name} object is returned. To change the behavior of
     * this function, update the regular expressions.
     *
     * @param name The string to parse containing then name.
     * @return A Name representation of {@code name}.
     */
    public static void parse(String name) {
      //Name result = new Name();
      for (int i = 0; i < regexes.length; i++) {
        Pattern p = regexes[i];
        String[] matcherGroup = matcherGroups[i];
        Matcher matcher = p.matcher(name);
  
        if (matcher.find()) {
          System.out.println("matched rule #" + i);
          for (int j = 0; j < matcherGroup.length; j++) {
            String groupName = matcherGroup[j];
            System.out.println(groupName +","+matcher.group(groupName));
            //result.setPart(groupName, matcher.group(groupName));
          }
          break;
        }
      }
  
    }
  }
  
