package EjerciciosActividad4;

import javax.swing.JOptionPane;

public class ClaseMatriz {
  int nfilas;
  int ncolumnas;
  int[][] matriz;

  public ClaseMatriz(int nfilas, int ncolumnas) {
    this.nfilas = nfilas;
    this.ncolumnas = ncolumnas;
    this.matriz = new int[nfilas][ncolumnas];
  }

  public void llenarMatriz() {
    for (int i = 0; i < this.nfilas; i++) {
      for (int j = 0; j < this.ncolumnas; j++) {
        this.matriz[i][j] = Integer.parseInt(
            JOptionPane.showInputDialog("Ingrese el valor de la matriz en la posición [" + i + "][" + j + "]: "));
      }
    }
  }

  public String mostrarMatriz(ClaseMatriz matriz) {
    String result = "";
    for (int i = 0; i < matriz.nfilas; i++) {
      for (int j = 0; j < matriz.ncolumnas; j++) {
        result += matriz.matriz[i][j] + " ";
      }
      result += "\n";
    }
    return result;
  }

  public void sumarMatrices(ClaseMatriz matriz2) {
    if (this.nfilas == matriz2.nfilas && this.ncolumnas == matriz2.ncolumnas) {
      ClaseMatriz newMatriz = new ClaseMatriz(this.nfilas, this.ncolumnas);
      for (int i = 0; i < this.nfilas; i++) {
        for (int j = 0; j < this.ncolumnas; j++) {
          newMatriz.matriz[i][j] = this.matriz[i][j] + matriz2.matriz[i][j];
        }
      }
      JOptionPane.showMessageDialog(null, "La suma de las matrices es:\n" + newMatriz.mostrarMatriz(newMatriz));
    } else {
      JOptionPane.showMessageDialog(null, "Las matrices no tienen las mismas dimensiones.");
    }
  }

  public void multiplicarMatrices(ClaseMatriz matriz2) {
    if (this.ncolumnas == matriz2.nfilas) {
      ClaseMatriz newMatriz = new ClaseMatriz(this.nfilas, matriz2.ncolumnas);
      for (int i = 0; i < this.nfilas; i++) {
        for (int j = 0; j < matriz2.ncolumnas; j++) {
          for (int k = 0; k < this.ncolumnas; k++) {
            newMatriz.matriz[i][j] += this.matriz[i][k] * matriz2.matriz[k][j];
          }
        }
      }
      JOptionPane.showMessageDialog(null, "El producto de las matrices es:\n" + newMatriz.mostrarMatriz(newMatriz));
    } else {
      JOptionPane.showMessageDialog(null, "Las matrices no tienen las dimensiones adecuadas para multiplicarse.");
    }
  }

  public ClaseMatriz traspuesta() {
    ClaseMatriz transposedMatrix = new ClaseMatriz(this.ncolumnas, this.nfilas);
    for (int i = 0; i < this.ncolumnas; i++) {
      for (int j = 0; j < this.nfilas; j++) {
        transposedMatrix.matriz[i][j] = this.matriz[j][i];
      }
    }
    return transposedMatrix;
  };

  public void mostrarTraspuesta() {
    JOptionPane.showMessageDialog(null, "La traspuesta de la matriz es:\n" + this.mostrarMatriz(this.traspuesta()));
  }

  public void multiplicarTraspuestas(ClaseMatriz matriz2) {
    ClaseMatriz transposedMatriz1 = this.traspuesta();
    ClaseMatriz transposedMatriz2 = matriz2.traspuesta();

    transposedMatriz1.multiplicarMatrices(transposedMatriz2);
  }

  public void compararMatrices(ClaseMatriz matriz2) {
    if (this.nfilas == matriz2.nfilas && this.ncolumnas == matriz2.ncolumnas) {
      boolean areEqual = true;
      for (int i = 0; i < this.nfilas; i++) {
        for (int j = 0; j < this.ncolumnas; j++) {
          if (this.matriz[i][j] != matriz2.matriz[i][j]) {
            areEqual = false;
            break;
          }
        }
      }
      if (areEqual) {
        JOptionPane.showMessageDialog(null, "Las matrices son iguales.");
      } else {
        JOptionPane.showMessageDialog(null, "Las matrices no son iguales.");
      }
    } else {
      JOptionPane.showMessageDialog(null, "Las matrices no tienen las mismas dimensiones.");
    }
  }
}
