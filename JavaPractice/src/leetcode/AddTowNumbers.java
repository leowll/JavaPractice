package leetcode;

public class AddTowNumbers {
	public static void main(String[] args) {
		ListNode a1 = new ListNode(0);
		ListNode a2 = new ListNode(0);
		ListNode a3 = new ListNode(1);
		a1.setNext(a2);
		a2.setNext(a3);

		ListNode b1 = new ListNode(0);
		ListNode b2 = new ListNode(0);
		ListNode b3 = new ListNode(9);
		b1.setNext(b2);
		b2.setNext(b3);

		solution(a1, b1);

	}

	public static void solution(ListNode n1, ListNode n2) {
		ListNode newNode = new ListNode(0);
		ListNode startNode = newNode;
		int addUp = 0, newVal = 0, sum = 0;
		while (n1 != null && n2 != null) {
			sum = n1.getVal() + n2.getVal() + addUp;
			addUp = sum / 10;
			newVal = sum % 10;
			newNode.setVal(newVal);

			n1 = n1.getNext();
			n2 = n2.getNext();
			
			if(n1!=null && n2!=null) {
				ListNode nextNode = new ListNode(0);
				newNode.setNext(nextNode);
				newNode = newNode.getNext();
			}else {
				if (addUp > 0) {
					newNode.setNext(new ListNode(1));
				}
			}
			
		}
		printList(startNode);
	}

	public static void printList(ListNode n) {
		while (n != null) {
			System.out.print(n.getVal() + " ");
			n = n.getNext();
		}
		System.out.print("\n");
	}
}

class ListNode {
	private int val;
	private ListNode next;

	public ListNode(int v) {
		this.val = v;
	}

	public ListNode getNext() {
		return this.next;
	}

	public int getVal() {
		return this.val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

}
