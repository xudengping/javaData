package xdp.test.dataStruct.sort;
/**
 * ÷±Ω”≤Â»Î≈≈–Ú
 * @author dell
 *
 */
public class InsertSort {
	
	public static void main(String[] args){
		int[] arr = ArrayUtil.randomInt(10);
		ArrayUtil.print(arr);
		InsertSort.sort(arr);
		ArrayUtil.print(arr);
	}
	
	
	public static void sort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int temp = arr[i];
			int j = i-1;
			while(j>=0 && temp<arr[j]){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	

}
