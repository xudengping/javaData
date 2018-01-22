package xdp.test.dataStruct.sort;

public class PrintUtil {
	
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
