class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        List<String> results = new ArrayList<>();
        Set<String> foundRecipes = new HashSet<>();
        Set<String> recipesSet = new HashSet<>();
        Map<String, Integer> inDegreeMap = new HashMap<>();
        Map<String, Set<String>> dependencyMap = new HashMap<>();

        for (int i=0; i<recipes.length; i++) {

            String recipe = recipes[i];
            recipesSet.add(recipe);

            List<String> ingre = ingredients.get(i);
            inDegreeMap.put(recipe, ingre.size());

            for (String ing : ingre) {

                if (!dependencyMap.containsKey(ing)) {
                    dependencyMap.put(ing, new HashSet<String>());
                } 

                dependencyMap.get(ing).add(recipe);
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (String s: supplies) {
            queue.offer(s);
        }

        while (queue.size() > 0){

            String current = queue.poll();
            if (recipesSet.contains(current)) {
                foundRecipes.add(current);
                if (inDegreeMap.containsKey(current)){
                    inDegreeMap.remove(current);
                }
            } 

            if (dependencyMap.containsKey(current)) {
                for (String r : dependencyMap.get(current)) {
                    if (inDegreeMap.containsKey(r)) {
                        inDegreeMap.put(r, inDegreeMap.get(r)-1);
                        if (inDegreeMap.get(r) == 0) {
                            inDegreeMap.remove(r);
                            queue.offer(r);
                        }
                    }
                }
            }
        }

        for (String fr : foundRecipes) {
            results.add(fr);
        }

        return results;
    }
}
