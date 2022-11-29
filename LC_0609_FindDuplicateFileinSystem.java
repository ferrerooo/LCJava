import java.util.*;;

class LC_0609_FindDuplicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> results = new LinkedList<>();
        
        for (String path : paths) {
            this.parsePath(path, map);
        }
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue() != null && entry.getValue().size() > 1) {
                results.add(entry.getValue());
            }
        }
        
        return results;
    }
    
    private void parsePath(String path, Map<String, List<String>> map) {
        
        String[] arr = path.split(" ");
        String prefix = arr[0];
        
        for (int i=1; i<arr.length; i++) {
            System.out.println(arr[i]);
            String[] fileArr = arr[i].split("\\(");
            if (!map.containsKey(fileArr[1])) {
                map.put(fileArr[1], new LinkedList<String>());
            }
            
            map.get(fileArr[1]).add(prefix + "/" + fileArr[0]);   
        }
        
    }
}