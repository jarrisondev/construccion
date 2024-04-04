package EjerciciosActividad1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el tamaño del vector: ");
    int N = scanner.nextInt();

    Set<Integer> valoresUnicos = new HashSet<>();

    for (int i = 0; i < N; i++) {
      boolean flag = true;

      while (flag) {
        System.out.print("Ingrese el entero " + (i + 1) + ": ");
        int entero = scanner.nextInt();
        boolean esRepetido = !valoresUnicos.add(entero);

        if (esRepetido) {
          System.out.println("El entero " + entero + " ya fue ingresado.");
        } else {
          flag = false;
        }
      }
    }

    System.out.println("Vector sin valores repetidos:");
    for (int valor : valoresUnicos) {
      System.out.print(valor + " ");
    }
    scanner.close();
  }
}
