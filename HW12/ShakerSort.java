public class ShakerSort {
    public static void shakerSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Сортировка слева направо
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            right--;

            // Сортировка справа налево
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
            }
            left++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
