import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE> {

	ArrayList<PANCAKE> stack;

	public ALStack() {
		stack = new ArrayList<PANCAKE>();
	}

	public boolean isEmpty() {
		return this.stack.size() == 0;
	}

	public PANCAKE peekTop() {
		if (isEmpty()) return null;
		return this.stack.get(this.stack.size() - 1);
	}

	public PANCAKE pop() {
    if (stack.isEmpty()){
      return null;
    }
		PANCAKE lastItem = peekTop();
		this.stack.remove(this.stack.size() - 1);
		return lastItem;
	}

	public void push( PANCAKE x ) {
		this.stack.add(x);
	}

}
