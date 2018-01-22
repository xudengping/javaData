package xdp.test.dataStruct.sort;

import java.util.Random;

public class ArrayUtil {
	
	public static int[] randomInt(int n){
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			 int nextInt = new Random().nextInt(10);
			 arr[i] = nextInt;
			 if(nextInt==1||nextInt==3||nextInt==5||nextInt==7||nextInt==9){
				 arr[i] = 0-nextInt;
			 }
		}
		return arr;
	}
	
	public static void print(int[] arr){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for(int i=0;i<arr.length;i++){
			buffer.append(" "+arr[i]);
		}
		buffer.append("]");
		System.out.println(buffer.toString());
	}

}
