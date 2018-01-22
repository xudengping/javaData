package xdp.test.dataStruct.binaryTree;
/**
 * 二叉树类
 * @author dell
 *
 */
public class Tree {
	// 根节点
	private Node root;
	
	// 插入节点
	public void insert(long data,String sdata){
		// 封装节点
		Node newNode = new Node(data,sdata);
		
		// 查找父节点
		Node current = root;// 当前开始遍历的节点
		Node parent;// 要查找的父节点
		if(root == null){
			root = newNode;
		}else{
			while(true){
				parent = current;
				// 往左边遍历
				if(current.data>data){
					current = current.leftChild;
					if(current == null){// 叶子节点
						parent.leftChild =  newNode;
						return;
					}
				}else{// 往右边遍历
					current = current.rightChild;
					if(current == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	// 删除节点
	public boolean delete(long data){
		// 查找要删除的节点
		Node current = root;// 当前开始遍历的节点
		Node parent = root;// 要查找的父节点
		boolean isLeft = false;// 区分是父节点的左节点还是右节点
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
		
		// 删除节点
		
		// 没有子节点
		if(current.leftChild == null && current.rightChild == null){
			if(current == root){// 删除的节点为根节点
				root = null;
			}else if(isLeft){
				parent.leftChild = null;
			}else{
				parent.rightChild = null;
			}
		}else if(current.leftChild != null){
			// 存在左节点
			if(current == root){// 删除的节点为根节点
				root = current.leftChild;
			}else if(isLeft){
				parent.leftChild = current.leftChild;
			}else{
				parent.rightChild = current.leftChild;
			}
		}else if(current.rightChild != null){
			// 存在右节点
			if(current == root){// 删除的节点为根节点
				root = current.rightChild;
			}else if(isLeft){
				parent.leftChild = current.rightChild;
			}else{
				parent.rightChild = current.rightChild;
			}
		}else{
			// 中继后序节点,右节点的最小节点
			Node successor = getSuccessor(current);
			if(current == root){
				root = successor;
			}else if(isLeft){
				parent.leftChild = successor;
			}else{
				parent.rightChild = successor;
			}
			// 将删除节点的左子树赋值到中继后序节点的左子树
			successor.leftChild = current.leftChild;
		}
		return true;
	}
	
	// 获取删除节点的中继后序节点
	public Node getSuccessor(Node delNode){
		Node successor = delNode;
		Node successorParent = delNode;
		Node current = delNode.rightChild;
		
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		//找到了最左边的节点successor
		
		if(successor != delNode.rightChild){
			// 要删除节点的右节点 存在左子树
			// 转移节点操作
			successorParent.leftChild = successor.rightChild;
			// 将中继后序节点的右子树赋值为删除节点的右子树
			successor.rightChild = delNode.rightChild;
		}
		
		return successor;
	}
	
	// 查找节点
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
	
	// 前序遍历
	public static void frontOrder(Node node){
		if(node != null){
			// 访问根节点
			System.out.println(node.data+","+node.sdata);
			// 前序遍历左子树
			frontOrder(node.leftChild);
			// 前序遍历右子树
			frontOrder(node.rightChild);
		}
		
	}
	
	// 中序遍历
	public static void inOrder(Node node){
		if(node != null){
			// 中序遍历左子树
			inOrder(node.leftChild);
			// 访问根节点
			System.out.println(node.data+","+node.sdata);
			// 中序遍历右子树
			inOrder(node.rightChild);
		}
		
	}
	
	// 后序遍历
	public static void afterOrder(Node node){
		if(node != null){
			// 后序遍历左子树
			afterOrder(node.leftChild);
			// 后序遍历右子树
			afterOrder(node.rightChild);
			// 访问根节点
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
