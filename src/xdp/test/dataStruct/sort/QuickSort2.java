package xdp.test.dataStruct.sort;

public class QuickSort2 {
	
	public static void sort(int[] arr,int left,int right){
		if(left>right){
			return;
		}
		int i = left;
		int j = right;
		// ������ָ����ȡ��׼ֵ
		int pivotIndex = middle3(arr,i,j);
		
		// ����
		while(i<j){
			while(arr[j]>=arr[pivotIndex] && i<j){// �Ҷ�������ƶ�,�ҵ�С��arr[pivotIndex]ֵֹͣ
				j--;
			}
			while(arr[i]<=arr[pivotIndex] && i<j){// ������ұ��ƶ�,�ҵ�����arr[pivotIndex]ֵֹͣ
				i++;
			}
			if(i<j){// ��û���������߳���������½�������ֵ��λ��
				swap(arr,i,j);
			}
		}
		// i=j
		swap(arr,left,i);
		sort(arr,left,pivotIndex-1);// �Ե��ӱ�ݹ��������
		sort(arr,pivotIndex+1,right);// �Ը��ӱ�ݹ��������
	}
	
	
	
	
    // ������ָ�ָ
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
