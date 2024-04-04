package EjerciciosActividad1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el tamaño del vector: ");
    int N = scanner.nextInt();

    int[] vector = new int[N];

    for (int i = 0; i < N; i++) {
      System.out.print("Ingrese el entero " + (i + 1) + ": ");
      vector[i] = scanner.nextInt();
    }

    Map<Integer, Integer> frecuencias = new HashMap<>();

    for (int number : vector) {
      frecuencias.put(number, frecuencias.getOrDefault(number, 0) + 1);
    }

    System.out.println("Frecuencia de cada valor en el vector:");
    for (Map.Entry<Integer, Integer> item : frecuencias.entrySet()) {
      System.out.println(item.getKey() + ": " + item.getValue());
    }
    scanner.close();
  }

}
