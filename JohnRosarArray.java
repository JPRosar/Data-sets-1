//John Rosar
//COSC 2436
//Assignment 2

public class JohnRosarArray 
{
 
 
 private int[] A;
 private int N;

 
 
 public JohnRosarArray(int[] A) {
     this.A = A;
     this.N = this.A.length;
 }
 
 public void insertionSort()
 {
     for (int i = 1; i<this.N; i++) 
     {
         int key = A[i];
         int z = i - 1;

         while (z>=0 && A[z]>key) 
         {
             A[z + 1] = A[z];
             z--;
         }
         A[z + 1] = key;
         
     }
 }
 
 
 // bubblesort

 public void bubbleSort()
 {
     for (int i=0; i<N-1; i++)
     {
         for (int z=0; z<N-i-1; z++)
         {
             if (A[z] > A[z+1])
             {
                 int t = A[z];
                 A[z] = A[z+1];
                 A[z+1] = t;
             }
         }
     }
 }
 
 

 // quicksort
 public void quickSort()
 {
     quickSort(A, 0, N-1);
 }

 
 
 private void quickSort(int[] A, int low, int high) 
 {
     if (low < high)
     {
         int partitionIndex = partition(A, low, high);

         quickSort(A, low, partitionIndex-1);
         quickSort(A, partitionIndex+1, high);
     }
 }

 
 private int partition(int[] A, int low, int high) 
 {
     int pivot = A[high]; 
     int i = (low-1); 
     for (int z=low; z<high; z++)
     {
         if (A[z] <= pivot)
         {
             i++;

             int temp = A[i];
             A[i] = A[z];
             A[z] = temp;
         }
     }

     int temp = A[i+1];
     A[i+1] = A[high];
     A[high] = temp;

     return i+1;
 }
 
 
 
 
 // mergeSort 
 
 public void mergeSort()
 {
     mergeSort(A, 0, N-1);
 }

 
 
 private void mergeSort(int[] A, int first, int second) {
     if (first < second) 
     {
    	 
         int m = first + (second-first)/2;
      
         mergeSort(A, first, m);
         mergeSort(A, m + 1, second);

         merge(A, first, m, second);
     }
 }

  
 private void merge(int[] A, int first, int m, int second) 
 {
     int n1 = m - first + 1;
     int n2 = second - m;

     int First[] = new int[n1];
     int Second[] = new int[n2];

     for (int i = 0; i < n1; ++i)
         First[i] = A[first + i];
     for (int z = 0; z < n2; ++z)
         Second[z] = A[m + 1 + z];


     int i = 0, z = 0;

     int k = first;
     while (i < n1 && z < n2) {
         if (First[i] <= Second[z]) {
             A[k] = First[i];
             i++;
         }
         else {
             A[k] = Second[z];
             z++;
         }
         k++;
     }

     while (i < n1) {
         A[k] = First[i];
         i++;
         k++;
     }

     while (z < n2) {
         A[k] = Second[z];
         z++;
         k++;
     }
 }
 
 
 

 public void SortArray()
 {
     System.out.println("\nSorted Array : ");
     this.mergeSort();
     
     for(int i : A)
     {
         System.out.print(i + " ");
     }
     System.out.println();
 }
 public void SortAlgorithmComplexity()
 {
     System.out.println("Insertion Sort :  O(N^2)");
     System.out.println("Bubble Sort    :  O(N^2)");
     System.out.println("Quick Sort     :  O(N logN)");
     System.out.println("Merge Sort     :  O(N logN)");
     

 }
 
}

