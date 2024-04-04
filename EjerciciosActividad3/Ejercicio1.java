package EjerciciosActividad3;

import javax.swing.JOptionPane;

public class Ejercicio1 {

  public static void main(String[] args) {

    String[] days = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };

    int vectorLength = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de empleados: "));

    String[][] vector = new String[vectorLength][2];

    for (int i = 0; i < vectorLength; i++) {
      String name = JOptionPane.showInputDialog("Ingrese el nombre del empleado " + (i + 1) + ": ");
      vector[i] = new String[] { name };
    }

    for (int i = 0; i < vectorLength; i++) {
      for (int j = 0; j < days.length; j++) {
        String tintos = JOptionPane.showInputDialog(
            "Ingrese la cantidad de tintos que tomo el empleado " + vector[i][0] + " el día " + days[j] + " :");

        vector[i] = new String[] { vector[i][0], tintos };
      }

    }

    boolean flag = true;

    while (flag) {
      String option = JOptionPane.showInputDialog(
          "1. cantidad de tintos por cada empleado\n2. Total de tintos consumidos en la oficina\n3. Cantidad de tintos consumidos diariamente\n4.El empleado que tomo mas tintos en un día\n5. Día en que se consumieron la menor cantidad de tintos\n6. Salir\nIngrese una opción:");

      switch (option) {
        case "1":
          for (int i = 0; i < vectorLength; i++) {
            JOptionPane.showMessageDialog(null, "El empleado " + vector[i][0] + " tomo " + vector[i][1] + " tintos");
          }
          break;
        case "2":
          int total = 0;
          for (int i = 0; i < vectorLength; i++) {
            total += Integer.parseInt(vector[i][1]);
          }
          JOptionPane.showMessageDialog(null, "El total de tintos consumidos en la oficina es: " + total);
          break;
        case "3":
          for (int i = 0; i < days.length; i++) {
            int totalDay = 0;
            for (int j = 0; j < vectorLength; j++) {
              totalDay += Integer.parseInt(vector[j][1]);
            }
            JOptionPane.showMessageDialog(null, "El total de tintos consumidos el día " + days[i] + " es: " + totalDay);
          }
          break;
        case "4":
          int max = 0;
          String trabajador = "";

          for (int i = 0; i < vectorLength; i++) {
            int currTintos = Integer.parseInt(vector[i][1]);
            if (currTintos > max) {
              max = currTintos;
              trabajador = vector[i][0];
            }

          }
          JOptionPane.showMessageDialog(null,
              "El empleado que tomo mas tintos es: " + trabajador + " con " + max);
          break;
        case "5":
          int min = 0;
          String day = "";

          for (int i = 0; i < days.length; i++) {
            int totalDay = 0;
            for (int j = 0; j < vectorLength; j++) {
              totalDay += Integer.parseInt(vector[j][1]);
            }
            if (totalDay < min) {
              min = totalDay;
              day = days[i];
            }
          }

          JOptionPane.showMessageDialog(null, "El día en que se consumieron la menor cantidad de tintos es: " + day);

          break;
        case "6":
          flag = false;
          break;

      }
    }

  }
}
