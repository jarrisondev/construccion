package EjerciciosActividad1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el tamaño del vector: ");
    int N = scanner.nextInt();

    int[] vector = new int[N];

    for (int i = 0; i < N; i++) {
      System.out.print("Ingrese el entero " + (i + 1) + ": ");
      vector[i] = scanner.nextInt();
    }

    double promedio = Arrays.stream(vector).average().orElse(Double.NaN);
    System.out.println("El promedio de los enteros es: " + promedio);

    int indiceCercano = indiceValorMasCercano(vector, promedio);
    int valorCercano = vector[indiceCercano];

    System.out.println("El valor más cercano al promedio es: " + valorCercano);
    System.out.println("Se encuentra en la posición: " + indiceCercano);
    scanner.close();

  }

  public static int indiceValorMasCercano(int[] vector, double valor) {
    double diferenciaMinima = Math.abs(vector[0] - valor);
    int indice = 0;
    for (int i = 1; i < vector.length; i++) {
      double diferencia = Math.abs(vector[i] - valor);
      if (diferencia < diferenciaMinima) {
        diferenciaMinima = diferencia;
        indice = i;
      }
    }
    return indice;
  }
}
