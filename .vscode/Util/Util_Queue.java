import org.junit.Test;
import java.util.*;

public class Util_Queue {

    // https://plentymore.github.io/2019/01/09/Java-Queue%E6%8E%A5%E5%8F%A3%E5%B8%B8%E7%94%A8%E5%AE%9E%E7%8E%B0%E7%B1%BB/
    // https://www.geeksforgeeks.org/queue-interface-java/

    /*
    // 添加一个元素到队列，在先进先出队列中，是添加到队列尾部
    // 如果由于容量不足插入失败，则抛出异常，不会返回false
    boolean add(E e);
    
    // 和add方法一样，不过不同之处在于，这个方法添加失败一般是返回false，而不是抛出异常
    boolean offer(E e);
    
    // 移除队列头部的元素（最先进来的元素），如果队列为空，则抛出异常，不返回false
    E remove();

    // 和remove方法一样，不过这个方法在队列为空时会返回false，不抛出异常
    E poll();

    // 查看队列头部的元素（最先进来的元素），如果队列为空，则抛出异常，不返回null
    E element();
    
    // 和element方法一样，不过这个在队列为空时，返回null，不抛出异常
    E peek();
    */

    /*
     * 其他的概念：
     * 
     * 队列也可以分为阻塞队列和非阻塞队列
     * 
     * 不阻塞 调用之后如果操作失败（一般都是因为队列容量不足或者队列为空），则立即返回，不发生阻塞，add(e)，offer(e)remove(e)，poll()，element()，peek()等，在Queue接口的方法一般都是不阻塞的
       阻塞 调用之后如果暂时无法操作成功，则一直阻塞到操作成功，put(e)，take()等
       限时阻塞 调用之后如果暂时无法操作成功，则阻塞一段时间，超时后仍为操作仍然未成功则返回，offer(e,timeout,unit)，poll(timeout,unit)等

     * PriorityQueue - 非线程安全，非阻塞
     * priorityBlockingQueue - 线程安全，阻塞，无容量限制
     * ArrayBlockingQueue - 线程安全，阻塞，有容量限制
     * 
     * Deque - 
    */

    @Test
    public void test() {

        // most common queue
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        queue.size();

        queue.remove();
        System.out.println(queue);

        queue.poll();
        System.out.println(queue);

        // deque
        /*
         * 	                    Queue	                     Deque
            添加元素到队尾	      add(E e) / offer(E e)	        addLast(E e) / offerLast(E e)
            取队首元素并删除	  E remove() / E poll()	        E removeFirst() / E pollFirst()
            取队首元素但不删除	  E element() / E peek()	    E getFirst() / E peekFirst()
            添加元素到队首	     无	                            addFirst(E e) / offerFirst(E e)
            取队尾元素并删除	  无	                        E removeLast() / E pollLast()
            取队尾元素但不删除	  无	                        E getLast() / E peekLast()
        */
    }
    
}
