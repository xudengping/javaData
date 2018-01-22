package xdp.test.dataStruct.binaryTree;
/**
 * 二叉树节点
 * @author dell
 *
 */
public class Node {
	// 数据项,作为索引 
	public long data;
	
	// 数据项,作为数据值
	public String sdata;
	
	// 左子节点
	public Node leftChild;
	
	// 右子节点
	public Node rightChild;
	
	public Node(long data,String sdata){
		this.data = data;
		this.sdata = sdata;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", sdata=" + sdata + ", leftChild=" + leftChild + ", rightChild=" + rightChild
				+ "]";
	}
	
}
