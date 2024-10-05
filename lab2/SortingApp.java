import java.util.Random;  
import java.util.Scanner;  

public class SortingApp {  
    private static int[] array; // Объявляем массив как статическую переменную класса  

    public static void main(String[] args) {  
        createArray();  
        chooseSortingAlgorithm();  
        showSortedArray();  
    }  

    public static void chooseSortingAlgorithm() {  
        System.out.println(); // Пустая строка для улучшения читаемости  
        System.out.println("Choose Sorting Algorithm: 1 - Selection Sort, 2 - Bubble Sort");  
        Scanner scanner = new Scanner(System.in);  
        int choice = scanner.nextInt();  
        SortInterface sortingAlgorithm;  

        if (choice == 1) {  
            sortingAlgorithm = new SelectionSort();  
        } else if (choice == 2) {  
            sortingAlgorithm = new BubbleSort();  
        } else {  
            System.out.println("Using default sort: Selection Sort.");  
            sortingAlgorithm = new SelectionSort();  
        }  

        sortingAlgorithm.sort(array); // Сортируем массив  
        scanner.close(); // Закрываем scanner после использования  
    }  

    public static void createArray() {  
        Random random = new Random();  
        array = new int[20]; // Инициализируем массив  

        for (int i = 0; i < array.length; i++) {  
            array[i] = random.nextInt(51); // Случайное число от 0 до 50  
        }  

        System.out.println("\nOriginal Array: ");  
        for (int number : array) {  
            System.out.print(number + " ");  
        }  
    }  

    public static void showSortedArray() {  
        System.out.println(); // Пустая строка для улучшения читаемости  
        System.out.println("Sorted Array: ");  
        for (int number : array) {  
            System.out.print(number + " ");  // Выводим отсортированный массив  
        }  
        System.out.println(); // Пустая строка для красивого вывода  
    }  
}