package EjercicioActividad2;

import javax.swing.JOptionPane;

// ### 2. Escribir un programa que permita llenar con enteros una matriz de tamaño dado por el usuario y que utilice métodos para:

// - Mostrar todos los datos de la matriz
// - Mostrar el mayor de cada fila
// - Mostrar la columna con menor promedio
// - Ordenar de menor a mayor los datos de la matriz

public class Ejercicio2 {
  public static void main(String[] args) {

    int rows = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de filas:"));
    int columns = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de columnas:"));

    int[][] matrix = new int[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        matrix[i][j] = Integer.parseInt(
            JOptionPane.showInputDialog("Ingrese el valor de la fila " + (i + 1) + " y columna " + (j + 1) + ":"));
      }
    }

    boolean flag = true;

    while (flag) {
      String option = JOptionPane.showInputDialog(
          "1. Mostrar todos los datos de la matriz\n2. Mostrar el mayor de cada fila\n3. Mostrar la columna con menor promedio\n4. Ordenar de menor a mayor los datos de la matriz\n5. Salir\nIngrese una opción:");

      switch (option) {
        case "1":
          String allData = "";
          for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
              allData += matrix[i][j] + " ";
            }
            allData += "\n";
          }
          JOptionPane.showMessageDialog(null, allData);

          break;
        case "2":
          String biggestOfEachRow = "";

          for (int i = 0; i < rows; i++) {
            int biggest = matrix[i][0];
            for (int j = 0; j < columns; j++) {
              if (matrix[i][j] > biggest) {
                biggest = matrix[i][j];
              }
            }
            biggestOfEachRow += "El mayor de la fila " + (i + 1) + " es: " + biggest + "\n";
          }

          JOptionPane.showMessageDialog(null, biggestOfEachRow);

          break;
        case "3":
          double[] averages = new double[columns];

          for (int i = 0; i < columns; i++) {
            double sum = 0;
            for (int j = 0; j < rows; j++) {
              sum += matrix[j][i];
            }
            averages[i] = sum / rows;
          }

          double lowestAverage = averages[0];
          int lowestAverageIndex = 0;

          for (int i = 0; i < averages.length; i++) {
            if (averages[i] < lowestAverage) {
              lowestAverage = averages[i];
              lowestAverageIndex = i;
            }
          }

          String columnWithLowestAverage = "La columna con menor promedio es la número " + (lowestAverageIndex + 1)
              + "\n";

          JOptionPane.showMessageDialog(null, columnWithLowestAverage);

          break;
        case "4":

          int[] temp = new int[rows * columns];
          int k = 0;

          for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
              temp[k] = matrix[i][j];
              k++;
            }
          }

          for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length - 1; j++) {
              if (temp[j] > temp[j + 1]) {
                int tempValue = temp[j];
                temp[j] = temp[j + 1];
                temp[j + 1] = tempValue;
              }
            }
          }

          k = 0;

          for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
              matrix[i][j] = temp[k];
              k++;
            }
          }

          JOptionPane.showMessageDialog(null, "La matriz ordenada de menor a mayor es:");

          String orderedMatrix = "";

          for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
              orderedMatrix += matrix[i][j] + " ";
            }
            orderedMatrix += "\n";
          }

          JOptionPane.showMessageDialog(null, orderedMatrix);

          break;
        case "5":
          flag = false;
          break;
        default:
          JOptionPane.showMessageDialog(null, "Opción no válida");
          break;
      }
    }
  }

}
