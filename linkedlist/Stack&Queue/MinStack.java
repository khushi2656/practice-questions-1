import java.util.Stack;

// method 1 : using one stack and one mini value 
class MinStack {
Stack<Long> stack;
long min;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push((long)val);
            min = val;
        } else if(val >= min){
            stack.push((long)val);
        }else{
            stack.push(2L*val - min);
            min = val;
        }
    }
    
    public void pop() {
        long top = stack.pop();
        if(top < min){
            min = 2 * min - top;
        }
    }
    
    public int top() {
        long top = stack.peek();
        if(top < min){
            return(int) min;
        } else{
            return(int) top;
        }
    }
    
    public int getMin() {
        return(int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// method 2 : using two stacks
class MinStack {
Stack<Integer> stack;
Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        } else{
            minStack.push(Math.min(val , minStack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
       return stack.peek();
       
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */