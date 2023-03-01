import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/*1. Напишите метод, который заполнит массив из 1000 элементов случайными цифрами от 0 до 24.
    
    2. Создайте метод, в который передайте заполненный выше массив и с помощью Set вычислите процент уникальных 
    значений в данном массиве и верните его в виде числа с плавающей запятой.
    
    Для вычисления процента используйте формулу:
    
    процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.
 */

 /**
  * task1
  */
 public class task1 {
 
    public static void main(String[] args) {
    int[] arr = getArr(24, 100);
    System.out.println(getPercentUniq(arr)); 

    }

    public static int[] getArr(int max, int num) {
        int[] ints = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(max + 1))
        .limit(num)
        .toArray();
        return ints;
    }

    public static float getPercentUniq(int[] arr) {
        HashSet<Integer> unique1 = new HashSet<>();
        HashSet<Integer> unique2 = new HashSet<>();
        for (Integer item : arr) {
            if (!unique1.contains(item)) {
                unique1.add(item);
            } else unique2.add(item);
        }
        unique1.removeAll(unique2);
        return unique1.size() * 100 / arr.length;
    }
 }
