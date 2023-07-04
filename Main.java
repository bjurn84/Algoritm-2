public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        
        System.out.println("Before sorting:");
        printArray(arr);
        
        heapSort(arr);
        
        System.out.println("After sorting:");
        printArray(arr);
    }
    
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }
    
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int left = 2 * i + 1; // Левый потомок
        int right = 2 * i + 2; // Правый потомок
        
        // Если левый потомок больше корня
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // Если правый потомок больше, чем самый большой элемент на данный момент
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // Если самый большой элемент не является корнем
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            // Рекурсивно применяем процедуру heapify к поддереву
            heapify(arr, n, largest);
        }
    }
    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}