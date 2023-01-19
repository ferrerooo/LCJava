import java.util.*;

public class LC_2115_FindAllPossibleRecipesfromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
       
       Map<String, Integer> reciMap = new HashMap<>();
       for (int i=0; i<recipes.length; i++) {
           reciMap.put(recipes[i], ingredients.get(i).size());
           // pizza --> dough, cheese ---> dough --> flour, yeast
           // pizza --> 2 
       }
       
       Map<String, Set<String>> ingreRecipesMap = new HashMap<>();
       // build map e.g.   <yeast>. <bread, XXX>
       for (int i=0; i<ingredients.size(); i++) {
           List<String> ingredientArr = ingredients.get(i);
           
           for (String s : ingredientArr) {
               
               if (!ingreRecipesMap.containsKey(s)) {
                   ingreRecipesMap.put(s, new HashSet<>());
               }
               ingreRecipesMap.get(s).add(recipes[i]);
           }
       }
       
       Set<String> avail = new HashSet<>();
       for (String s: supplies) {
           avail.add(s);
       }
       
       
       while (avail.size() > 0) {
           
           String sup = getOneSupply(avail);
           avail.remove(sup);
           
           if (!ingreRecipesMap.containsKey(sup)){
               continue;
           }
           
           Set<String> toCook = ingreRecipesMap.get(sup);
           
           for (String s:toCook) {
               if (!reciMap.containsKey(s))
                    continue;
                
               reciMap.put(s, reciMap.get(s)-1);
               if (reciMap.get(s) == 0) {
                   reciMap.remove(s);
                   avail.add(s);
                   result.add(s);
               }
           }
           
       }
       
       return result;      
   }
   
   private static String getOneSupply(Set<String> avail) {
       String res = null;
       for (String s:avail) {
           res = s;
           break;
       }
       
       return res;
   }
    
}