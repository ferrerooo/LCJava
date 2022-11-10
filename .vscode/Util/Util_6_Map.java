import org.junit.Test;
import java.util.*;

public class Util_6_Map {



    /*
     *  (1)V put(K key, V value); 向集合中添加元素。
        (2)V get(Object key); 通过指定key获取value。
        (3)int size(); 获取集合中元素的个数。
        (4)void clear(); 清空集合，元素个数清0。
        (5)boolean isEmpty(); 判断集合元素个数是否为0。
        (6)boolean containsKey(Object key); 判断集合中是否包含指定key。
        (7)boolean containsValue(Object value); 判断集合中是否包含指定value。
        注意：contains()方法底层都调用了equals()方法，再次强调存入集合元素的类一定要重写equals()方法。
        (8)Set keySet(); 获取集合中所有的key，返回一个包含所有key元素的Set集合。
        (9)Collection values(); 获取集合中所有的value，返回一个包含所有value元素的Collection集合。
        (10)V remove(Object key); 删除指定key的键值对。
        (11)default boolean replace(K key, V oldValue, V newValue) 修改键值对<key, oldValue>的value为newValue。
        (12)Set<Map.Entry<K,V>> entrySet(); 将Map集合转换成Set集合
     * 
     * 
     * For TreeMap
     * 
     * public Map.Entry<K,V> ceilingEntry(K key)
     * public K ceilingKey(K key)
     * public Map.Entry<K,V> floorEntry(K key)
     * public K floorKey(K key)
     * 
     * public Map.Entry<K,V> higherEntry(K key)
     * public K higherKey(K key)
     * public Map.Entry<K,V> lowerEntry(K key)
     * public K lowerKey(K key)
     * 
     * public Map.Entry<K,V> firstEntry()
     * public K firstKey()
     * public Map.Entry<K,V> lastEntry()
     * public K lastKey()
     * 
     * 
    */

    @Test
    public void test() {

        Map<String,String> gfg = new HashMap<String,String>();
      
        // enter name/url pair
        gfg.put("GFG", "geeksforgeeks.org");
        gfg.put("Practice", "practice.geeksforgeeks.org");
        gfg.put("Code", "code.geeksforgeeks.org");
        gfg.put("Quiz", "quiz.geeksforgeeks.org");
          
        // using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<String,String> entry : gfg.entrySet()) 
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());

    }
    
}
