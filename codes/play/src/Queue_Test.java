import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queue_Test {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(2);
		System.out.println(queue.poll());
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		System.out.println(stack.pop());
/*		String s=null;
		StringBuffer s1 = null;*/
/*		ArrayList<Integer> list = new ArrayList<Integer>();
		list.size();*/
		
	}
}
