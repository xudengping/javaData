package xdp.test.dataStruct.sort;

public class QuickSort2 {
	
	public static void sort(int[] arr,int left,int right){
		if(left>right){
			return;
		}
		int i = left;
		int j = right;
		// 三数中指法获取基准值
		int pivotIndex = middle3(arr,i,j);
		
		// 排序
		while(i<j){
			while(arr[j]>=arr[pivotIndex] && i<j){// 右端往左边移动,找到小于arr[pivotIndex]值停止
				j--;
			}
			while(arr[i]<=arr[pivotIndex] && i<j){// 左端往右边移动,找到大于arr[pivotIndex]值停止
				i++;
			}
			if(i<j){// 当没有相遇或者超出的情况下交换两个值的位置
				swap(arr,i,j);
			}
		}
		// i=j
		swap(arr,left,i);
		sort(arr,left,pivotIndex-1);// 对底子表递归快速排序
		sort(arr,pivotIndex+1,right);// 对高子表递归快速排序
	}
	
	
	
	
    // 三数中指分割法
	private static int middle3(int[] a, int low, int high) {
		int mid = (low+high)/2;
		if(a[low]>a[mid] && a[high]>a[mid]){
			if(a[low] > a[high]){
				return high;
			}else{
				return low;
			}
		}else if(a[low]<a[mid] && a[high]<a[mid]){
			if(a[low] > a[high]){
				return low;
			}else{
				return high;
			}
		}
	    return mid; 
	}




	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}




	public static void main(String[] args){
		int[] arr = new int[]{1,3,2};
		PrintUtil.print(arr);
		sort(arr,0,arr.length-1);
		PrintUtil.print(arr);
	}

}
