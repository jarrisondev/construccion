package EjerciciosActividad4;

import javax.swing.JOptionPane;

public class Ejercicio2 {
  public static void main(String[] args) {

    int columnsM1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas de la matriz 1: "));
    int rowsM1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas de la matriz 1: "));
    ClaseMatriz matriz1 = new ClaseMatriz(rowsM1, columnsM1);
    matriz1.llenarMatriz();

    int columnsM2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas de la matriz 2: "));
    int rowsM2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas de la matriz 2: "));
    ClaseMatriz matriz2 = new ClaseMatriz(rowsM2, columnsM2);
    matriz2.llenarMatriz();

    boolean flag = true;

    while (flag) {
      int option = Integer.parseInt(JOptionPane.showInputDialog(
          "1. Mostrar\n2. Sumar dos matrices\n3. Multiplicar dos matrices\n4. Mostrar las traspuestas\n5. Multiplicar las traspuestas\n6. Comparar dos matrices\n7. Salir\nIngrese una opción:"));

      switch (option) {
        case 1:
          // 1. Mostrar
          JOptionPane.showMessageDialog(null,
              "Matriz 1: \n" + matriz1.mostrarMatriz(matriz1) + "\nMatriz 2: \n" + matriz2.mostrarMatriz(matriz2));
          break;

        case 2:
          // 2. Sumar dos matrices
          matriz1.sumarMatrices(matriz2);
          break;

        case 3:
          // 3. Multiplicar dos matrices
          matriz1.multiplicarMatrices(matriz2);
          break;

        case 4:
          // 4. Mostrar las traspuestas
          matriz1.mostrarTraspuesta();
          matriz2.mostrarTraspuesta();

          break;
        case 5:
          // 5. Multiplicar las traspuestas
          matriz1.multiplicarTraspuestas(matriz2);
          break;
        case 6:
          // 6. comparar dos matrices
          matriz1.compararMatrices(matriz2);
          break;
        case 7:
          flag = false;
          break;
        default:
          JOptionPane.showMessageDialog(null, "Opción no válida");
          break;
      }

    }
  }
}
