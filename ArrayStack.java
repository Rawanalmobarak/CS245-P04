
public class ArrayStack implements Stack {
	
	private int top = 0;	   
	private int size = 10;   
	private Object stack[] =  new Object[size]; 

	
	@Override
	public void push(Object item) {
		if (top == size){
			grow_stack();
		}
		stack[top] = item;
		top++;
		

	}

	@Override
	public Object pop() {
		
		if (top > 0){
			return stack[--top];
		}else{
			return null;
		}
	}

	@Override
	public Object peek() {
		
		if(!empty()){
			return stack[top-1];
		}
		System.err.println("The stack is empty");
		return null;
	}

	@Override
	public boolean empty() {
		return top == 0;
	}
	
	
	protected void grow_stack() {
		int i;
		Object newdata[];

		newdata = new Object[size * 2];
		for (i = 0; i < size; i++){
			newdata[i] = stack[i];
		}
		stack = newdata;
		size = size * 2;
	}

}
