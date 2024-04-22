package EjerciciosActividad4;

import javax.swing.JOptionPane;

public class Ejercicio1 {

  public static String printMatrix(int[][] matrix) {
    String result = "";
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        result += matrix[i][j] + " ";
      }
      result += "\n";
    }
    return result;
  }

  public static void main(String[] args) {

    // ### Escribir un programa que permita llenar con enteros dos matrices de
    // tamaño ingresado por el usuario y que realice las sieguiente operaciones:

    // 1. Mostrar
    // 2. Sumar dos matrices
    // 3. Multiplicar dos matrices
    // 4. Mostrar las traspuestas
    // 5. Multiplicar las traspuestas
    // 6. comparar dos matrices
    // 7. Salir

    int columnsM1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas de la matriz 1: "));
    int rowsM1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas de la matriz 1: "));

    int[][] matrix1 = new int[rowsM1][columnsM1];

    for (int i = 0; i < rowsM1; i++) {
      for (int j = 0; j < columnsM1; j++) {
        matrix1[i][j] = Integer.parseInt(
            JOptionPane.showInputDialog("Ingrese el valor de la matriz 1 en la posición [" + i + "][" + j + "]: "));
      }
    }

    int columnsM2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas de la matriz 2: "));
    int rowsM2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas de la matriz 2: "));

    int[][] matrix2 = new int[rowsM2][columnsM2];

    for (int i = 0; i < rowsM2; i++) {
      for (int j = 0; j < columnsM2; j++) {
        matrix2[i][j] = Integer.parseInt(
            JOptionPane.showInputDialog("Ingrese el valor de la matriz 2 en la posición [" + i + "][" + j + "]: "));
      }
    }

    boolean flag = true;

    while (flag) {
      int option = Integer.parseInt(JOptionPane.showInputDialog(
          "1. Mostrar\n2. Sumar dos matrices\n3. Multiplicar dos matrices\n4. Mostrar las traspuestas\n5. Multiplicar las traspuestas\n6. Comparar dos matrices\n7. Salir\nIngrese una opción:"));

      switch (option) {
        case 1:
          // 1. Mostrar
          JOptionPane.showMessageDialog(null,
              "Matriz 1: \n" + printMatrix(matrix1) + "\nMatriz 2: \n" + printMatrix(matrix2));
          break;

        case 2:
          // 2. Sumar dos matrices
          if (rowsM1 == rowsM2 && columnsM1 == columnsM2) {

            int[][] sum = new int[rowsM1][columnsM1];

            for (int i = 0; i < rowsM1; i++) {
              for (int j = 0; j < columnsM1; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
              }
            }

            JOptionPane.showMessageDialog(null, "La suma de las matrices es: \n" +
                printMatrix(sum));
          } else {
            JOptionPane.showMessageDialog(null, "Las matrices no tienen las mismas dimensiones");
          }
          break;

        case 3:
          // 3. Multiplicar dos matrices

          if (columnsM1 == rowsM2) {
            int[][] product = new int[rowsM1][columnsM2];

            for (int i = 0; i < rowsM1; i++) {
              for (int j = 0; j < columnsM2; j++) {
                for (int k = 0; k < columnsM1; k++) {
                  product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
              }
            }

            JOptionPane.showMessageDialog(null, "El producto de las matrices es: \n" +
                printMatrix(product));
          } else {
            JOptionPane.showMessageDialog(null, "Las matrices no tienen las dimensiones adecuadas para multiplicarse");
          }
          break;

        case 4:
          // 4. Mostrar las traspuestas
          int[][] transposedMatrix1 = new int[columnsM1][rowsM1];
          int[][] transposedMatrix2 = new int[columnsM2][rowsM2];

          for (int i = 0; i < columnsM1; i++) {
            for (int j = 0; j < rowsM1; j++) {
              transposedMatrix1[i][j] = matrix1[j][i];
            }
          }

          for (int i = 0; i < columnsM2; i++) {
            for (int j = 0; j < rowsM2; j++) {
              transposedMatrix2[i][j] = matrix2[j][i];
            }
          }

          JOptionPane.showMessageDialog(null, "La traspuesta de la matriz 1 es: \n" + printMatrix(transposedMatrix1)
              + "\nLa traspuesta de la matriz 2 es: \n" + printMatrix(transposedMatrix2));
          break;
        case 5:
          // 5. Multiplicar las traspuestas
          if (rowsM1 == rowsM2 && columnsM1 == columnsM2) {

            int[][] transposedMatrixx1 = new int[columnsM1][rowsM1];
            int[][] transposedMatrixx2 = new int[columnsM2][rowsM2];

            for (int i = 0; i < columnsM1; i++) {
              for (int j = 0; j < rowsM1; j++) {
                transposedMatrixx1[i][j] = matrix1[j][i];
              }
            }

            for (int i = 0; i < columnsM2; i++) {
              for (int j = 0; j < rowsM2; j++) {
                transposedMatrixx2[i][j] = matrix2[j][i];
              }
            }

            int[][] transposedProduct = new int[rowsM1][columnsM1];

            for (int i = 0; i < rowsM1; i++) {
              for (int j = 0; j < columnsM1; j++) {
                for (int k = 0; k < columnsM1; k++) {
                  transposedProduct[i][j] += transposedMatrixx1[i][k] * transposedMatrixx2[k][j];
                }
              }
            }

            JOptionPane.showMessageDialog(null, "El producto de las traspuestas de las matrices es: \n" +
                printMatrix(transposedProduct));
          } else {
            JOptionPane.showMessageDialog(null, "Las matrices no tienen las mismas dimensiones");
          }
          break;
        case 6:
          // 6. comparar dos matrices
          if (rowsM1 == rowsM2 && columnsM1 == columnsM2) {
            boolean areEqual = true;
            for (int i = 0; i < rowsM1; i++) {
              for (int j = 0; j < columnsM1; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                  areEqual = false;
                  break;
                }
              }
            }
            if (areEqual) {
              JOptionPane.showMessageDialog(null, "Las matrices son iguales");
            } else {
              JOptionPane.showMessageDialog(null, "Las matrices no son iguales");
            }
          } else {
            JOptionPane.showMessageDialog(null, "Las matrices no tienen las mismas dimensiones");
          }
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
