## 이진 트리 순회

>  이진 트리의 모든 데이터를 가져오는 방법에는 InOrder, PreOrder, PostOrder 가 있다



#### 중위순회 InOrder

> Left, Root, Right 



#### 전위순회 PreOrder

> Root, Left, Right



#### 후위순회 PostOrder

> Left, Right, Root



```java
public class TreeTraversal {
	/*
	 * 		(A)
	 * 		/ ＼
	 * 	  (B)  (C)
	 * 	  / ＼   
	 *  (D) (E)
	 *  
	 *   중위순회 (Left, Root, Right) : D B E A C
	 *   전위순회 (Root, Left, Right) : A B D E C
	 *   후위순회 (Left, Right, Root) : D E B C A
	 */

	static class Node{
		char data; //데이터
		Node left; //왼쪽 자식노드 
		Node right; //오른쪽 자식노드
	}
	
	static class Tree{
		public Node root; //트리의 시작점 root
		
		//get, set 루트 정의
		public void setRoot(Node node) { 
			this.root = node;
		}
		
		public Node getRoot() {
			return root;
		}
		
		public Node makeNode(Node left, char data, Node right) {
			//노드를 만드는 함수
			Node node = new Node();
			node.data = data;
			node.left = left;
			node.right = right;
			return node;
		}
		
		public void inorder(Node node) {
			//왼, 루, 오
			if(node != null) { //재귀호출
				inorder(node.left); //왼쪽 재귀호출을 돌고 나면
				System.out.print(node.data+" "); //자기자신 출력
				inorder(node.right); //오른쪽 재귀
			}
		}
		
		public void preorder(Node node) {
			//루, 왼, 오
			if(node != null) {
				System.out.print(node.data+" ");
				preorder(node.left);
				preorder(node.right);
			}
		}
		
		public void postorder(Node node) {
			//왼, 오, 루
			if(node != null) {
				postorder(node.left);
				postorder(node.right);
				System.out.print(node.data+" ");
				}
		}
		
	}
	public static void main(String[] args) {
		Tree t = new Tree();
		//마지막 노드부터 생성
		Node nd = t.makeNode(null, 'D', null);
		Node ne = t.makeNode(null, 'E', null);
		Node nb = t.makeNode(nd, 'B', ne);
		Node nc = t.makeNode(null, 'C', null);
		Node na = t.makeNode(nb, 'A', nc);
		
		t.setRoot(na);
		t.inorder(t.getRoot());
		System.out.println("중위순회");
		t.preorder(t.getRoot());
		System.out.println("전위순회");
		t.postorder(t.getRoot());
		System.out.println("후위순회");
	}
}
```



[연관 문제 :: BOJ 1991 트리순회 ](https://www.acmicpc.net/problem/1991)