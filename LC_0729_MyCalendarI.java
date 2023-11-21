class MyCalendar {

    private TreeMap<Integer, Integer> map;

    public MyCalendar() {
        this.map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        
        Map.Entry<Integer, Integer> floor = map.floorEntry(start);
        if (floor != null) {
            if (floor.getValue() > start)
                return false;
        }

        Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(start);
        if (ceiling != null) {
            if (ceiling.getKey() < end)
                return false;
        }

        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
