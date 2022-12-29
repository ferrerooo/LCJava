public class LC_0028_FindtheIndexoftheFirstOccurrenceinaString_KMP {
    //https://www.zhihu.com/question/21923021/answer/281346746
    // example: "ababababca", "abababca", next[] -1,0,0,1,2,3,4,0,
    public int strStr(String source, String target) {

        // Write your code here
        if(target.length()==0 ){
            return 0;
        }
        int c = 0, d = 0;
        char[] sourceC = source.toCharArray();
        char[] targetC = target.toCharArray();
        int[] next = getNext(targetC); 

        for(int i:next)
            System.out.print(i+",");
        System.out.println();

        while(c<sourceC.length && d<targetC.length){
            if( d == -1 || sourceC[c] == targetC[d] ){
                c++;
                d++;
            }else{
                d = next[d];
            }
        }
        if(d ==targetC.length){
            return c-d;
        }
        return -1;      
    }
    
    //KMP算法的简明介绍：
    // https://www.zhihu.com/question/21923021/answer/281346746
    // https://www.jianshu.com/p/e2bd1ee482c3
    //得到KMP算法的next数组。
    protected int[] getNext(char[] p) {
        int[] next = new int[p.length];
        int a = -1, b = 0; 
        next[0]= -1;
        //一步步计算每一个next。
        while(b<p.length-1){
            if( a == -1 || p[a] == p[b] ){
                a++;
                b++;
                next[b] = a;
            }else{
                a = next[a];
            }
        }
        return next;
    }
}