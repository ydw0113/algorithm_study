import java.util.*;

public class Solution {
	static class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public void add(int value) {
			if (value < this.value) {
				if (left == null)
					left = new Node(value);
				else
					left.add(value);
			} else if (value > this.value) {
				if (right == null)
					right = new Node(value);
				else
					right.add(value);
			} // (value == this.value)인 경우 add 하지 않고 무시한다;
		}

		public void print() {
			if (left != null)
				left.print();
			System.out.printf("%d ", value);
			if (right != null)
				right.print();
		}

	}

	static Stack <Integer> a = new Stack();
	public static void preorder(Node root) {
		if (root != null) {
			System.out.print(root.value + " ");
			a.push(root.value);
			preorder(root.left);
			preorder(root.right);
		}

	}

	public static void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			a.push(root.value);
//			System.out.print(root.value + " ");
		}
	}

	public static void main(String[] args) {
//		int[] a = { 11, 3, 5, 13, 1, 7, 2, 6 };
//		Node root = new Node(8);
//		for (int i = 0; i < a.length; ++i)
//			root.add(a[i]);
//		// root.print();
//		preorder(root);
		int b[][]= {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		solution(b);
	}

	public static int[][] solution(int[][] nodeinfo) {
		int[][] answer = new int[nodeinfo.length][2];
		HashMap <Integer,Integer> hash = new HashMap();
		for(int i=0; i< nodeinfo.length; i++) {
        	hash.put(nodeinfo[i][0], i+1);
		}
		
        Arrays.sort(nodeinfo, new Comparator<int[]>() {
            @Override
            public int compare(final int[] a, final int[] b) {
            	return b[1]- a[1];
            }
        });
        Node root = new Node(nodeinfo[0][0]);
        for (int i = 0; i < nodeinfo.length; i++) {
        	root.add(nodeinfo[i][0]);
//            System.out.println(nodeinfo[i][0]+" "+nodeinfo[i][1]);
        }
        preorder(root);
        System.out.println();
        for (int i=nodeinfo.length-1; i>=0; i--) {
        	answer[i][0]=hash.get(a.pop());
        }
        postorder(root);
        for (int i=nodeinfo.length-1; i>=0; i--) {
        	answer[i][1]=hash.get(a.pop());
        }
        for (int i=0; i<nodeinfo.length; i++) {
        	System.out.print(answer[i][1]+" ");
        }
		return answer;
	}
}