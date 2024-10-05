import java.util.Random;  

public class RandomArraySelectionSort {  
    public static void main(String[] args) {  
        // Создаем массив  
        int[] array = new int[1000];  
        
        // Генератор случайных чисел  
        Random random = new Random();  
        
        // Массив случайных чисел от 0 до 100  
        for (int i = 0; i < array.length; i++) {  
            array[i] = random.nextInt(101);  
        }  

        // Сортировка  
        selectionSort(array);  

        // Вывод отсортированного массива  
        for (int number : array) {  
            System.out.print(number + " ");  
        }  
        
        // Пример использования парсера  
        String input = "-123";  
        try {  
            int result = parseInteger(input);  
            System.out.println("\nParsed integer: " + result);  
        } catch (NumberFormatException e) {  
            System.out.println(e.getMessage());  
        }  
    }  

    // Сортировка методом простого выбора  
    public static void selectionSort(int[] array) {  
        int n = array.length;  

        for (int i = 0; i < n - 1; i++) {  
            int minIndex = i;  

            // Запоминаем индекс минимального элемента в оставшейся части массива  
            for (int j = i + 1; j < n; j++) {  
                if (array[j] < array[minIndex]) {  
                    minIndex = j;  
                }  
            }  

            // Текущий элемент с минимальным меняем местами  
            if (minIndex != i) {  
                int temp = array[i];  
                array[i] = array[minIndex];  
                array[minIndex] = temp;  
            }  
        }  
    }  

    // Парсер строки в целое число  
    public static int parseInteger(String str) {  
        if (str == null || str.isEmpty()) {  
            throw new NumberFormatException("Input string is null or empty.");  
        }  

        int index = 0;  
        int length = str.length();  
        int result = 0;  
        boolean isNegative = false;  

        // Обработка знака  
        if (str.charAt(index) == '-') {  
            isNegative = true;  
            index++;  
        } else if (str.charAt(index) == '+') {  
            index++;  
        }  

        // Чтение цифр  
        while (index < length) {  
            int digit = Character.digit(str.charAt(index), 10);  
            if (digit < 0) {  
                throw new NumberFormatException("Invalid character at index " + index);  
            }  

            // Проверка переполнения  
            if (result > (Integer.MAX_VALUE - digit) / 10) {  
                throw new NumberFormatException("Integer overflow");  
            }  

            result = result * 10 + digit;  
            index++;  
        }  

        return isNegative ? -result : result;  
    }  
}