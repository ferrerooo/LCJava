import java.util.*;

public class LC_0770_BasicCalculatorIV {
    
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {

    List<String> result = new ArrayList<>();
    
    if (expression == null || expression.isEmpty()) {
        return result;
    }
    
    Map<String, Integer> evalMap = buildEvalMap(evalvars, evalints);
    
    Stack<List<Token>> operands = new Stack<>();
    Stack<Character> operations = new Stack<>();
    
    int n = expression.length();
    int i = 0;
    while (i < n) {
        char ci = expression.charAt(i);
        
        if ('(' == ci) {
            operations.push(ci);
            ++i;
            continue;
        }
        
        if ('a' <= ci && ci <= 'z') {
            int j = i + 1;
            while (j < n) {
                char cj = expression.charAt(j);
                if ('a' <= cj && cj <= 'z') {
                    ++j;
                } else {
                    break;
                }
            }
            String var = expression.substring(i, j);
            List<Token> operand = new ArrayList<>();
            if (evalMap.containsKey(var)) {
                operand.add(new Token(evalMap.get(var)));
            } else {
                operand.add(new Token(1, Arrays.asList(var)));
            }
            operands.add(operand);
            i = j;
            continue;
        }
        
        if ('0' <= ci && ci <= '9') {
            int j = i + 1;
            while (j < n) {
                char cj = expression.charAt(j);
                if ('0' <= cj && cj <= '9') {
                    ++j;
                } else {
                    break;
                }
            }
            int coef = Integer.parseInt(expression.substring(i, j));
            List<Token> operand = new ArrayList<>();
            operand.add(new Token(coef));
            operands.add(operand);
            i = j;
            continue;
        }
        
        if ('+' == ci || '-' == ci || '*' == ci) {
            int curPriority = getPriority(ci);
            // Execute all previous operations >= current.
            while (!operations.isEmpty() && '(' != operations.peek()) {
                int prePriority = getPriority(operations.peek());
                if (curPriority <= prePriority) {
                    execute(operands, operations);
                } else {
                    break;
                }
            }
            operations.push(ci);
            ++i;
            continue;
        }
        
        if (')' == ci) {
            while ('(' != operations.peek()) {
                execute(operands, operations);
            }
            // remove '('
            operations.pop();
            ++i;
            continue;
        }
        
        // space
        ++i;
    }
    
    while (!operations.isEmpty()) {
        execute(operands, operations);
    }
    
    result = toResult(operands.pop());
    return result;
}

private Map<String, Integer> buildEvalMap(String[] vars, int[] ints) {
    if (vars == null) {
        vars = new String[0];
    }
    
    if (ints == null) {
        ints = new int[0];
    }
    
    if (vars.length != ints.length) {
        throw new IllegalArgumentException();
    }
    
    Map<String, Integer> evalMap = new HashMap<>();
    
    int n = vars.length;
    for (int i = 0; i < n; ++i) {
        evalMap.put(vars[i], ints[i]);
    }
    
    return evalMap;
}

private int getPriority(char operation) {
    if ('+' == operation || '-' == operation) {
        return -2;
    }
    
    if ('*' == operation) {
        return -1;
    }
    
    throw new IllegalArgumentException();
}

private void execute(Stack<List<Token>> operands,
                     Stack<Character> operations) {
    char operation = operations.pop();
    List<Token> operand2 = operands.pop();
    List<Token> operand1 = operands.pop();
    
    List<Token> operand = new ArrayList<>();
    
    // Convert - to +
    if ('-' == operation) {
        for (Token t : operand2) {
            t.coef = t.coef * -1;
        }
    }
    
    // Convert * to +
    if ('*' == operation) {
        List<Token> temp = new ArrayList<>();
        for (Token t1 : operand1) {
            for (Token t2 : operand2) {
                temp.add(t1.multiply(t2));
            }
        }
        operand1 = temp;
        operand2.clear();
    }
    
    // +
    PriorityQueue<Token> minHeap = new PriorityQueue<>();
    minHeap.addAll(operand2);
    minHeap.addAll(operand1);
    while (!minHeap.isEmpty()) {
        Token cur = minHeap.poll();
        if (operand.isEmpty()) {
            operand.add(cur);
            continue;
        }
        Token pre = operand.remove(operand.size() - 1);
        operand.addAll(pre.add(cur));
    }
    operands.add(operand);
}

private List<String> toResult(List<Token> operand) {
    List<String> result = new ArrayList<>();
    for (Token t: operand) {
        if (t.coef == 0) {
            continue;
        }
        
        if (t.isNum()) {
            result.add(Integer.toString(t.coef));
            continue;
        }
        
        result.add(Integer.toString(t.coef) + "*" + t.term);
    }
    return result;
}

private class Token implements Comparable<Token> {
    public final List<String> vars = new ArrayList<>();
    public final int degr;
    public final String term;
    
    public int coef;
    
    public Token(int coef) {
        this(coef, new ArrayList<>());
    }
    
    public Token(int coef, List<String> vars) {
        this.coef = coef;
        this.vars.addAll(vars);
        this.degr = vars.size();
        this.term = String.join("*", vars);
    }
    
    public boolean isNum() {
        return vars.isEmpty();
    }
    
    public boolean isVar() {
        return !isNum();
    }
    
    public List<Token> add(Token t) {
        List<Token> result = new ArrayList<>();
        
        if (this.isNum() && t.isNum()) {
            Token token = new Token(this.coef + t.coef);
            result.add(token);
            return result;
        }
        
        if (this.isVar() && t.isVar()) {
            if (this.term.equals(t.term)) {
                Token token = new Token(this.coef + t.coef, this.vars);
                result.add(token);
                return result;
            }
        }
        
        if (this.compareTo(t) < 0) {
            result.add(this);
            result.add(t);
            return result;
        }
        
        result.add(t);
        result.add(this);
        return result;
    }
    
    public Token multiply(Token t) {
        List<String> vars = new ArrayList<>();
        vars.addAll(this.vars);
        vars.addAll(t.vars);
        Collections.sort(vars);
        return new Token(this.coef * t.coef, vars);
    }
    
    @Override
    public int compareTo(Token t) {
        if (this.degr == t.degr) {
            if (t.term.equals(this.term)) {
                return this.coef - t.coef;
            }
            return this.term.compareTo(t.term);
        }
        
        return t.degr - this.degr;
    }
}
}