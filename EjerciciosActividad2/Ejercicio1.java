package EjerciciosActividad2;

import javax.swing.JOptionPane;

public class Ejercicio1 {
  public static void main(String[] args) {

    int worsToAdd = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de palabras a agregar:"));

    String[] words = new String[0];

    for (int i = 0; i < worsToAdd; i++) {
      String word = JOptionPane.showInputDialog("Ingrese la palabra " + (i + 1) + ":");
      String[] temp = new String[words.length + 1];
      for (int j = 0; j < words.length; j++) {
        temp[j] = words[j];
      }
      temp[temp.length - 1] = word;
      words = temp;
    }

    boolean flag = true;

    while (flag) {
      String option = JOptionPane.showInputDialog(
          "1. Mostrar todas las palabras\n2. Mostrar la suma de todas las letras de las palabras\n3. Mostrar en mayúscula la palabra más corta\n4. Ordenar alfabéticamente todas las palabras\n5. Buscar en el vector una palabra\n6. Salir\nIngrese una opción:");

      switch (option) {
        case "1":
          String allWords = "";
          for (int i = 0; i < words.length; i++) {
            allWords += words[i] + "\n";
          }
          JOptionPane.showMessageDialog(null, allWords);
          break;
        case "2":
          int sum = 0;
          for (int i = 0; i < words.length; i++) {
            sum += words[i].length();
          }
          JOptionPane.showMessageDialog(null, "La suma de todas las letras de las palabras es: " + sum);
          break;
        case "3":
          String shortestWord = words[0];
          for (int i = 0; i < words.length; i++) {
            if (words[i].length() < shortestWord.length()) {
              shortestWord = words[i];
            }
          }
          JOptionPane.showMessageDialog(null, "La palabra más corta es: " + shortestWord.toUpperCase());
          break;
        case "4":
          for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length - 1; j++) {
              if (words[j].compareTo(words[j + 1]) > 0) {
                String temp = words[j];
                words[j] = words[j + 1];
                words[j + 1] = temp;
              }
            }
          }
          JOptionPane.showMessageDialog(null, "Las palabras ordenadas alfabéticamente son:");
          for (int i = 0; i < words.length; i++) {
            JOptionPane.showMessageDialog(null, words[i]);
          }
          break;
        case "5":
          String searchWord = JOptionPane.showInputDialog("Ingrese la palabra a buscar:");
          boolean found = false;
          for (int i = 0; i < words.length; i++) {
            if (words[i].equals(searchWord)) {
              found = true;
              break;
            }
          }
          if (found) {
            JOptionPane.showMessageDialog(null, "La palabra " + searchWord + " fue encontrada");
          } else {
            JOptionPane.showMessageDialog(null, "La palabra " + searchWord + " no fue encontrada");
          }
          break;
        case "6":
          flag = false;
          break;
        default:
          JOptionPane.showMessageDialog(null, "Opción no válida");
          break;
      }
    }
  }

}
