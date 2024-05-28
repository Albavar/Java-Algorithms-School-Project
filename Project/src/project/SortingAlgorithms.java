package project;

import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SortingAlgorithms {

    // MERGE SORT
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // DIVIDE AND CONQ SORT
    public static void divideAndConquer(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            divideAndConquer(arr, l, m);
            divideAndConquer(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    // QUICKSORT
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Diziyi bölme işlemi
            int pi = partition(arr, low, high);

            // Bölünmüş parçaları sıralama
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Son elemanı pivot olarak seçiyoruz
        int i = (low - 1); // Döngüdeki küçük elemanın dizideki yerini takip etmek için

        for (int j = low; j < high; j++) {
            // Geçici olarak pivot'tan küçük elemanları bul ve yer değiştir
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // QUICKSORT3
    public static void quickSort3(int arr[], int low, int high) {
        if (low < high) {
            // pivotlar seçiliyor
            int[] pivots = partition3(arr, low, high);

            // pivotlar arasındaki kısımlar sıralanıyor
            quickSort3(arr, low, pivots[0] - 1);
            quickSort3(arr, pivots[1] + 1, high);
        }
    }

    private static int[] partition3(int arr[], int low, int high) {
        int pivot1 = arr[low];
        int pivot2 = arr[high];
        int pivot3 = arr[(low + high) / 2];
        int i = low - 1, j = high + 1;
        int[] pivots = new int[2];

        while (true) {
            // Pivot1'den küçük ve pivot2'den büyük olan ilk elemanı bul
            do {
                i++;
            } while (arr[i] < pivot1);
            do {
                j--;
            } while (arr[j] > pivot2);

            // Pivotler arasındaki kısıma ulaşıldığında döngüden çık
            if (i >= j) {
                pivots[0] = j;
                break;
            }

            // Pivot1'den küçük ve pivot2'den büyük olan elemanlar yer değiştiriyor
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Pivotlarla bölme (3 pivot kullanarak)
        i = low - 1;
        j = high + 1;
        while (true) {
            // Pivot2'den küçük ve pivot3'den büyük olan ilk elemanı bul
            do {
                i++;
            } while (arr[i] < pivot2);
            do {
                j--;
            } while (arr[j] > pivot3);

            // Pivotler arasındaki kısıma ulaşıldığında döngüden çık
            if (i >= j) {
                pivots[1] = i;
                break;
            }

            // Pivot2'den küçük ve pivot3'den büyük olan elemanlar yer değiştiriyor
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Pivotlar sırasıyla dizinin ilk ve son elemanına yerleştiriliyor
        int temp = arr[pivots[0]];
        arr[pivots[0]] = arr[low];
        arr[low] = temp;

        temp = arr[pivots[1]];
        arr[pivots[1]] = arr[high];
        arr[high] = temp;

        // Pivotlar geri döndürülüyor
        return pivots;
    }

    // HEAP SORT
    void heapify(int arr[], int n, int i) {
        int largest = i; // En büyük eleman
        int l = 2 * i + 1; // Sol çocuk
        int r = 2 * i + 2; // Sağ çocuk

        // Sol çocuk, kökten daha büyükse
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // Sağ çocuk, en büyük olanı seç
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // En büyük eleman kök değilse değiştir
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Değiştirilen alt ağacı yeniden düzenle
            heapify(arr, n, largest);
        }
    }

    public void heapSort(int arr[]) {
        int n = arr.length;

        // Max heap oluşturma
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Heap'dan bir elemanı birer birer alıp düzenleme
        for (int i = n - 1; i > 0; i--) {
            // Kök ile son elemanı değiştir
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Kökü yeniden düzenle (küçük alt ağaçta)
            heapify(arr, i, 0);
        }
    }

    // RADIX SORT
    public void radixSort(int arr[]) {
        // Dizideki en büyük sayıyı bulma
        int max = Arrays.stream(arr).max().getAsInt();

        // En büyük sayının basamak sayısını bulma
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    // Counting Sort
    private void countSort(int arr[], int exp) {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Her basamaktaki elemanları sayma
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // count[] güncelleme
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // output[] oluşturma
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // output[]'u arr[]'a kopyalama
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Shaker Sort
    public void shakerSort(int arr[]) {
        int n = arr.length;
        boolean swapped;

        do {
            swapped = false;
            // Büyükten küçüğe doğru iterasyon
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Elemanların yer değiştirmesi
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            // Sonraki iterasyon
            if (!swapped) {
                break;
            }
            swapped = false;
            // Küçükten büyüğe doğru iterasyon
            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    // Elemanların yer değiştirmesi
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            // Bir sonraki iterasyon için
        } while (swapped);
    }

    // BogoSort
    public static void bogoSort(int[] array) {
        while (!isSorted(array)) {
            shuffle(array);
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void shuffle(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    // LuckySort
    public static void luckySort(int[] array) {
        Random random = new Random();
        while (!isSorted(array)) {
            shuffleArray(array, random);
        }
    }

    private static void shuffleArray(int[] array, Random random) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    // SerseriSort
    public static void serseriSort(int[] arr) {
        Random rand = new Random();
        int n = arr.length;

        while (!isSorted(arr)) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int j = rand.nextInt(n);
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // FlashSort
    public static void flashSort(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        int min = arr[0], max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        double c = 0.45 * n / (max - min);

        int[] L = new int[n];
        Arrays.fill(L, 0);

        for (int i = 0; i < n; i++) {
            int k = (int) (c * (arr[i] - min));
            L[k]++;
        }

        for (int i = 1; i < n; i++) {
            L[i] += L[i - 1];
        }

        int[] sorted = new int[n];
        System.arraycopy(arr, 0, sorted, 0, n);

        for (int i = n - 1; i >= 0; i--) {
            int k = (int) (c * (sorted[i] - min));
            arr[--L[k]] = sorted[i];
        }
    }
    
    // CombSort
    public static void combSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;

        while (gap > 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;

            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    private static int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        return Math.max(gap, 1);
    }
    
    //GnomeSort
    public static void gnomeSort(int[] arr) {
        int index = 0;
        int n = arr.length;

        while (index < n) {
            if (index == 0) {
                index++;
            }
            if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
    
    //PermütasyonSort
    public static void permutationSort(int[] arr) {
        int n = arr.length;

        do {
            boolean sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        } while (true);
    }
    
    //StrandSort
    public static List<Integer> strandSort(List<Integer> arr) {
        List<Integer> sortedList = new ArrayList<>();
        
        while (!arr.isEmpty()) {
            List<Integer> sublist = new ArrayList<>();
            sublist.add(arr.remove(0));
            
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) > sublist.get(sublist.size() - 1)) {
                    sublist.add(arr.remove(i));
                    i--;
                }
            }
            
            sortedList = merge(sortedList, sublist);
        }
        
        return sortedList;
    }
    
    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i++));
            } else {
                mergedList.add(list2.get(j++));
            }
        }
        
        while (i < list1.size()) {
            mergedList.add(list1.get(i++));
        }
        
        while (j < list2.size()) {
            mergedList.add(list2.get(j++));
        }
        
        return mergedList;
    }
    
    //KovaSort
    public static List<Integer> bucketSort(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            return arr;
        }
        
        int minVal = Collections.min(arr);
        int maxVal = Collections.max(arr);
        int bucketCount = (maxVal - minVal) / arr.size() + 1;
        
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        
        for (int num : arr) {
            int index = (num - minVal) / arr.size();
            buckets.get(index).add(num);
        }
        
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        
        List<Integer> sortedList = new ArrayList<>();
        for (List<Integer> bucket : buckets) {
            sortedList.addAll(bucket);
        }
        
        return sortedList;
    }
}

