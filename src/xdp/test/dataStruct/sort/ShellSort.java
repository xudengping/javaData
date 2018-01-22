package xdp.test.dataStruct.sort;
/**
 * ϣ������
 * @author dell
 *
 */
public class ShellSort {
	
	private static void shellSort(int[] arr){
		// ��ʼ�����
		int h = 1;
		// ���������
		while(h<arr.length/3){
			h = h *3 +1;
		}
		
		// ����
		while(h>0){
			// ��������
			int temp = 0;// ����
			for(int i=h;i<arr.length;i++){
				temp = arr[i];
				int j = i;
				while(j>h-1 && arr[j-h] > temp){
					arr[j] = arr[j-h];
					j -= h;
				}
				arr[j] = temp;
				
			}
			
			// ��С���
			h = (h-1)/3;
		}
		
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{1,0,3,5,9,2,4,8,7,6,-1,-4};
		long l1 = System.currentTimeMillis();
		shellSort(arr);
		long l2 = System.currentTimeMillis();
		System.out.println("time:"+(l2-l1));
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for(int i=0;i<arr.length;i++){
			buffer.append(" "+arr[i]);
		}
		buffer.append("]");
		System.out.println(buffer.toString());
	}

}
