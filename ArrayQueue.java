public class ArrayQueue implements Queue {

	private int head = 0;
	private int tail = 0;
	private int size = 10;
	private Object queue[] = new Object[size]; 

	public Object dequeue() {
		Object retval;
		retval = queue[head];
		head = (head + 1) % size;
		return retval;
	}

	@Override
	public void enqueue(Object item) {
		try {
			if(tail+1 != head){
				queue[tail++] = item;
				if (tail == queue.length)
					tail = 0;
			}
		} catch (Exception e) {
			grow_queue();
		}

	}

	@Override
	public boolean empty() {
		return head == tail;
	}

	private void grow_queue() {
		int i;
		Object newdata[];

		newdata = new Object[size * 2];
		for (i = 0; i < size; i++) {
			newdata[i] = queue[i];
		}
		queue = newdata;
		size = size * 2;

	}

}
