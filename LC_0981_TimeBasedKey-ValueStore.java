class TimeMap {

    private HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<Integer, String>());
        }

        TreeMap<Integer, String> tmap = map.get(key);
        tmap.put(timestamp, value);

    }
    
    public String get(String key, int timestamp) {
        
        if (!map.containsKey(key))
            return "";
        
        TreeMap<Integer, String> tmap = map.get(key);

        Map.Entry<Integer, String> entry = tmap.floorEntry(timestamp);

        if (entry == null)
            return "";
        
        return entry.getValue();

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
