package xdp.test.dataStruct.binaryTree;
/**
 * �������ڵ�
 * @author dell
 *
 */
public class Node {
	// ������,��Ϊ���� 
	public long data;
	
	// ������,��Ϊ����ֵ
	public String sdata;
	
	// ���ӽڵ�
	public Node leftChild;
	
	// ���ӽڵ�
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
