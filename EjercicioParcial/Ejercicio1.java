package EjercicioParcial;

import javax.swing.JOptionPane;

public class Ejercicio1 {

  public static void main(String[] args) {

    int amount = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas: "));

    int[] persons = new int[amount];

    for (int i = 0; i < amount; i++) {
      persons[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la persona " + (i + 1)));
    }

    boolean flag = true;

    while (flag) {
      int option = Integer.parseInt(JOptionPane.showInputDialog(
          "1. Cantidad de personas mayores de edad\n2. Edad menor y cuantas veces se encuentra en el vector\n3. Cantidad de personas con edad menor al promedio\n4. Dias vividos de la persona con mayor edad\n5. Mostrar todas las edades ingresadas\n6. Salir\nIngrese una opción:"));

      switch (option) {
        case 1:
          int count = 0;
          for (int i = 0; i < persons.length; i++) {
            if (persons[i] >= 18) {
              count++;
            }
          }
          JOptionPane.showMessageDialog(null, "La cantidad de personas mayores de edad es: " + count);
          break;

        case 2:
          int min = persons[0];

          for (int i = 0; i < persons.length; i++) {
            if (persons[i] < min) {
              min = persons[i];
            }
          }

          int countMin = 0;
          for (int i = 0; i < persons.length; i++) {
            if (persons[i] == min) {
              countMin++;
            }
          }

          JOptionPane.showMessageDialog(null,
              "La edad menor es: " + min + " y se encuentra " + countMin + " veces en el vector");
          break;

        case 3:
          int sum = 0;

          for (int i = 0; i < persons.length; i++) {
            sum += persons[i];
          }

          double average = sum / persons.length;
          int countLess = 0;

          for (int i = 0; i < persons.length; i++) {
            if (persons[i] < average) {
              countLess++;
            }
          }

          JOptionPane.showMessageDialog(null, "La cantidad de personas con edad menor al promedio es: " + countLess
              + ". (El promedio es: " + average + "s)");
          break;

        case 4:
          int max = persons[0];

          for (int i = 0; i < persons.length; i++) {
            if (persons[i] > max) {
              max = persons[i];
            }
          }

          double days = max * 365.25;
          JOptionPane.showMessageDialog(null, "La persona con mayor edad ha vivido " + days + " días");
          break;

        case 5:
          String allAges = "";
          for (int i = 0; i < persons.length; i++) {
            allAges += persons[i] + "\n";
          }
          JOptionPane.showMessageDialog(null, allAges);
          break;

        case 6:
          flag = false;
          break;

        default:
          JOptionPane.showMessageDialog(null, "Opción no válida");
          break;

      }

    }

  }

}
