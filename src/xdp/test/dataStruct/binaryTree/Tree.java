package xdp.test.dataStruct.binaryTree;
/**
 * ��������
 * @author dell
 *
 */
public class Tree {
	// ���ڵ�
	private Node root;
	
	// ����ڵ�
	public void insert(long data,String sdata){
		// ��װ�ڵ�
		Node newNode = new Node(data,sdata);
		
		// ���Ҹ��ڵ�
		Node current = root;// ��ǰ��ʼ�����Ľڵ�
		Node parent;// Ҫ���ҵĸ��ڵ�
		if(root == null){
			root = newNode;
		}else{
			while(true){
				parent = current;
				// ����߱���
				if(current.data>data){
					current = current.leftChild;
					if(current == null){// Ҷ�ӽڵ�
						parent.leftChild =  newNode;
						return;
					}
				}else{// ���ұ߱���
					current = current.rightChild;
					if(current == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	// ɾ���ڵ�
	public boolean delete(long data){
		// ����Ҫɾ���Ľڵ�
		Node current = root;// ��ǰ��ʼ�����Ľڵ�
		Node parent = root;// Ҫ���ҵĸ��ڵ�
		boolean isLeft = false;// �����Ǹ��ڵ����ڵ㻹���ҽڵ�
		while(current.data != data){
			parent = current;
			if(current.data>data){
				current = current.leftChild;
				isLeft = true;
			}else if(current.data<data){
				current = current.rightChild;
			}
			if(current == null){
				return false;
			}
		}
		
		// ɾ���ڵ�
		
		// û���ӽڵ�
		if(current.leftChild == null && current.rightChild == null){
			if(current == root){// ɾ���Ľڵ�Ϊ���ڵ�
				root = null;
			}else if(isLeft){
				parent.leftChild = null;
			}else{
				parent.rightChild = null;
			}
		}else if(current.leftChild != null){
			// ������ڵ�
			if(current == root){// ɾ���Ľڵ�Ϊ���ڵ�
				root = current.leftChild;
			}else if(isLeft){
				parent.leftChild = current.leftChild;
			}else{
				parent.rightChild = current.leftChild;
			}
		}else if(current.rightChild != null){
			// �����ҽڵ�
			if(current == root){// ɾ���Ľڵ�Ϊ���ڵ�
				root = current.rightChild;
			}else if(isLeft){
				parent.leftChild = current.rightChild;
			}else{
				parent.rightChild = current.rightChild;
			}
		}else{
			// �м̺���ڵ�,�ҽڵ����С�ڵ�
			Node successor = getSuccessor(current);
			if(current == root){
				root = successor;
			}else if(isLeft){
				parent.leftChild = successor;
			}else{
				parent.rightChild = successor;
			}
			// ��ɾ���ڵ����������ֵ���м̺���ڵ��������
			successor.leftChild = current.leftChild;
		}
		return true;
	}
	
	// ��ȡɾ���ڵ���м̺���ڵ�
	public Node getSuccessor(Node delNode){
		Node successor = delNode;
		Node successorParent = delNode;
		Node current = delNode.rightChild;
		
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		//�ҵ�������ߵĽڵ�successor
		
		if(successor != delNode.rightChild){
			// Ҫɾ���ڵ���ҽڵ� ����������
			// ת�ƽڵ����
			successorParent.leftChild = successor.rightChild;
			// ���м̺���ڵ����������ֵΪɾ���ڵ��������
			successor.rightChild = delNode.rightChild;
		}
		
		return successor;
	}
	
	// ���ҽڵ�
	public Node find(long data){
		Node current = root;
		while(true){
			if(current == null){
				return null;
			}
			if(current.data>data){
				current = current.leftChild;
			}else if(current.data<data){
				current = current.rightChild;
			}else{
				break;
			}
		}
		return current;
	}
	
	// ǰ�����
	public static void frontOrder(Node node){
		if(node != null){
			// ���ʸ��ڵ�
			System.out.println(node.data+","+node.sdata);
			// ǰ�����������
			frontOrder(node.leftChild);
			// ǰ�����������
			frontOrder(node.rightChild);
		}
		
	}
	
	// �������
	public static void inOrder(Node node){
		if(node != null){
			// �������������
			inOrder(node.leftChild);
			// ���ʸ��ڵ�
			System.out.println(node.data+","+node.sdata);
			// �������������
			inOrder(node.rightChild);
		}
		
	}
	
	// �������
	public static void afterOrder(Node node){
		if(node != null){
			// �������������
			afterOrder(node.leftChild);
			// �������������
			afterOrder(node.rightChild);
			// ���ʸ��ڵ�
			System.out.println(node.data+","+node.sdata);
		}
		
	}
	
	public static void main(String args[]){
		Tree tree = new  Tree();
		tree.insert(4l,"B");
		tree.insert(2l,"A");
		tree.insert(6l,"C");
		tree.insert(10l,"E");
		tree.insert(8l,"D");
		tree.insert(11l,"F");
		tree.insert(3l,"3");
		tree.insert(1l,"1");
		
		
		afterOrder(tree.root);
	}

}
