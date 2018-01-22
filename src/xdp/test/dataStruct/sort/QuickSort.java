package xdp.test.dataStruct.sort;

public class QuickSort {
	
	public static void sort(int[] arr,int left,int right){
		if(left>right){
			return;
		}
		int i = left; 
		int j = right; 
//		int piontIndex = middle3(arr,left,right);
		int point =arr[left];// ��׼��pivot
		while(i != j){
			while(j>i && arr[j]>=point)// �ҵ�С��pointֹͣ
			{
				j--;// �����ƶ�
			}
			while(i<j && arr[i]<=point)// �ҵ�����pointֹͣ
			{
				i++;// �����ƶ�
			}
			if(i<j){
				// ����
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		// ��ʱi==j
		System.out.println("i==j"+(i==j));
		// ��׼����λ
		arr[left] = arr[i];
		arr[i] = point;
		
		sort(arr,left,i-1);// �����������
		sort(arr,i+1,right);// ���������ұ�
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
	
	
		public static void sort2(int[] arr,int left,int right){
			if(left < right){
				int s = left,e = right;
				int pivot = arr[left];
				
				while(s<e){
					while(e>s && pivot<=arr[e]){
						e--;
					}
					while(s<e && pivot>=arr[s]){
						s++;
					}
					if(s<e){
						swap(arr,s,e);
					}
					ArrayUtil.print(arr);
				}
				// ��׼ֵ��λ
				arr[left] = arr[s];
				arr[s] = pivot;
				
				sort2(arr,left,s-1);
				sort2(arr,s+1,right);
			}
		}
	

	private static void swap(int[] arr, int s, int e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
		}

	public static void main(String[] args){
//		int[] arr = ArrayUtil.randomInt(10);
		int[] arr = new int[]{5,1,6,3,4,5,6,3,8,2,10};
		ArrayUtil.print(arr);
		QuickSort.sort2(arr,0,arr.length-1);
		ArrayUtil.print(arr);
	}
	
	

}
