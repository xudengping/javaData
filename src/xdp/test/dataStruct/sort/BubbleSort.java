package xdp.test.dataStruct.sort;
/**
 * ð������
 * @author dell
 *
 */
public class BubbleSort {
	
	public static void sort(int arr[]){
		for(int i=0;i<arr.length-1;i++){
			for(int j=arr.length-1;j>i;j--){
				if(arr[j]<arr[j-1]){
					swap(arr,j,j-1);
				}
			}
			System.out.println("��"+(i+1)+"��ð����������");
			ArrayUtil.print(arr);
		}
		
		
	}
	
	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public static void main(String[] args) {
//		int[] arr = ArrayUtil.randomInt(10);
		int[] arr = new int[]{9,8,7,6,5,4,3,2,1,0};
		ArrayUtil.print(arr);
		BubbleSort.sort(arr);
		ArrayUtil.print(arr);
	}

}
