package xdp.test.dataStruct.sort;
/**
 * 二分法插入排序
 * @author dell
 *
 */
public class DivisionInsertSort {
	
	public static void divisionInsertSort(int[] arr,int n){
		int i,j,temp,low,high,mid;
		for(i=1;i<n;i++){
			temp = arr[i];
			j = i-1;
			low = 0;
			high = i-1;
			// 找寻插入的位置
			while(low<=high){
				mid = (low+high)/2;
				if(arr[mid]>temp){
					//mid左边遍历
					high = mid-1;
				}else{
					//mid右边遍历
					low = mid+1;
				}
			}
			//low = high
			// 将右边的元素做个向右移一位
			for(;j>=high+1;j--){
				arr[j+1] = arr[j];
			}
			arr[high+1] = temp;
		}
	}

	public static void main(String[] args){
		int[] arr = new int[]{1,0,3,5,9,2,4,8,7,6,-1};
		long l1 = System.currentTimeMillis();
		divisionInsertSort(arr,arr.length);
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
