class Solution {
    public void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int partition(int[] arr,int st,int end)
    {
        int pivot=arr[st];int small=0;
        for (int i = st+1; i <= end; i++) if(arr[i]<=pivot)small++;
        swap(arr,st+small,st);
        int i=st,j=end;
        int pivotidx=st+small;
        while(i < pivotidx && j > pivotidx)
        {
            if(arr[i] <= pivot) i++;
            else if(arr[j] > pivot) j--;
            else if(i < pivotidx && j > pivotidx)
            {
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        return pivotidx;
    }
    public void quicksort(int[] arr,int st,int end,int k)
    {
        if(st>=end)return;
        int idx=partition(arr,st,end);
        if(idx==k-1)return;
        else if(idx>k-1)quicksort(arr,st,idx-1,k);
        quicksort(arr,idx+1, end,k);
        
    }
    public int findKthLargest(int[] arr, int k) {
        k=arr.length-k+1;
        quicksort(arr,0,arr.length-1,k);
        return arr[k-1];
    }
}
