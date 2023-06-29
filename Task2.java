package HomeWork2;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

//Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
public class Task2 {
    static File fileLog;
    static FileWriter fileWriter;

    public static void main(String[] args) {

        try {
            fileLog = new File("log.txt");
            fileWriter = new FileWriter(fileLog);

            System.out.println("Enter numbers separated by spaces: ");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            String[] items = str.split(" ");
            int[] intArray = new int[items.length];
            for (int i = 0; i < items.length; i++) {
                intArray[i] = Integer.parseInt(items[i]);
            }
            boolean sorted = false;
            while (sorted == false) {
                sorted = true;
                for (int i = 0; i < intArray.length - 1; i++) {
                    if (intArray[i] > intArray[i + 1]) {
                        sorted = false;

                        int temp = intArray[i];
                        intArray[i] = intArray[i + 1];
                        intArray[i + 1] = temp;
                        for (int j = 0; j < intArray.length; j++) {
                            fileWriter.write(intArray[j] + " ");
                        }

                        fileWriter.write("\n");
                    }
                }
            }

            for (int i = 0; i < intArray.length; i++) {
                System.out.print(intArray[i] + " ");
            }
            fileWriter.close();

        } catch (Exception e) {

        }
    }

}
