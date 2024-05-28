package EjercicioFinal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.*;

public class Ejercicio {

  public static void main(String[] args) {

    int cantidadEmpleados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de empleados: "));

    Empleado[] empleados = new Empleado[cantidadEmpleados];

    for (int i = 0; i < cantidadEmpleados; i++) {

      String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado "
          + (i + 1) + ": ");
      String id = JOptionPane.showInputDialog("Ingrese el id del empleado " + (i +
          1) + ": ");
      float valorHora = Float
          .parseFloat(JOptionPane.showInputDialog("Ingrese el valor por hora del empleado " + (i + 1) + ": "));
      int cantHoras = Integer.parseInt(
          JOptionPane.showInputDialog("Ingrese la cantidad de horas trabajadas del empleado " + (i + 1) + ": "));

      empleados[i] = new Empleado(nombre, id, valorHora, cantHoras);
    }

    int opcion = 0;

    while (true) {
      opcion = Integer.parseInt(JOptionPane.showInputDialog(
          "Seleccione una opción: \n1. Mostrar datos ingresados\n2. Mostrar nombre y pago de cada empleado\n3. Mostrar identificación del empleado con menor pago\n4. Mostrar los empleados con pago menor al pago promedio\n5. Actualizar cualquier campo (nombre, id, valorHora o cantHora)\n6. Mostrar toda la información de los empleados ordenados por nombre\n7. Salir"));

      switch (opcion) {
        case 1:
          String datosIngresados = "";
          for (Empleado empleado : empleados) {
            datosIngresados += empleado.mostrarDatos() + "\n\n";
          }
          JOptionPane.showMessageDialog(null, datosIngresados);
          break;
        case 2:
          String nombreYPago = "";
          for (Empleado empleado : empleados) {
            nombreYPago += empleado.mostrarNombreYsalario() + "\n\n";
          }
          JOptionPane.showMessageDialog(null, nombreYPago);
          break;
        case 3:
          Empleado empleadoMenorPago = empleados[0];
          for (Empleado empleado : empleados) {
            if (empleado.obtenerSalario() < empleadoMenorPago.obtenerSalario()) {
              empleadoMenorPago = empleado;
            }
          }
          JOptionPane.showMessageDialog(null,
              "Empleado con menor pago: \n\n" + empleadoMenorPago.mostrarNombreYsalario());
          break;
        case 4:
          float promedio = 0;
          for (Empleado empleado : empleados) {
            promedio += empleado.obtenerSalario();
          }
          promedio = promedio / empleados.length;

          String empleadosMenorAlPromedio = "";
          for (Empleado empleado : empleados) {
            if (empleado.obtenerSalario() < promedio) {
              empleadosMenorAlPromedio += empleado.mostrarDatos() + "\n\n";
            }
          }
          JOptionPane.showMessageDialog(null, "Empleados con pago menor al promedio: \n" + empleadosMenorAlPromedio);
          break;
        case 5:
          // actualizar
          int index = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de empleado a actualizar: "));
          int campo = Integer.parseInt(JOptionPane.showInputDialog(
              "Seleccione el campo a actualizar: \n1. Nombre\n2. ID\n3. Valor Hora\n4. Cantidad de Horas"));

          if (empleados[index] == null) {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado");
            break;
          }

          switch (campo) {
            case 1:
              String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
              empleados[index].setNombre(nombre);
              break;
            case 2:
              String id = JOptionPane.showInputDialog("Ingrese el nuevo ID: ");
              empleados[index].setId(id);
              break;
            case 3:
              float valorHora = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo valor por hora: "));
              empleados[index].setValorHora(valorHora);
              break;
            case 4:
              int cantHoras = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de horas: "));
              empleados[index].setCantHoras(cantHoras);
              break;
          }

          break;

        case 6:
          String[] columnNames = { "Nombre", "ID", "Valor Hora", "Cant. Horas", "Salario" };

          String[][] data = new String[cantidadEmpleados][5];

          for (int i = 0; i < cantidadEmpleados; i++) {
            data[i][0] = empleados[i].getNombre();
            data[i][1] = empleados[i].getId();
            data[i][2] = String.valueOf(empleados[i].getValorHora());
            data[i][3] = String.valueOf(empleados[i].getCantHoras());
            data[i][4] = String.valueOf(empleados[i].getSalario());
          }

          // sort by name
          for (int i = 0; i < cantidadEmpleados; i++) {
            for (int j = i + 1; j < cantidadEmpleados; j++) {
              if (data[i][0].compareTo(data[j][0]) > 0) {
                String[] temp = data[i];
                data[i] = data[j];
                data[j] = temp;
              }
            }
          }

          JFrame frame = new JFrame("Empleados");
          JTable table = new JTable(data, columnNames);

          JScrollPane scrollPane = new JScrollPane(table);
          frame.add(scrollPane, BorderLayout.CENTER);
          frame.setSize(800, 400);
          frame.setVisible(true);

          break;

        case 7:
          System.exit(0);
          break;

        default:
          JOptionPane.showMessageDialog(null, "Opción no válida");
          break;

      }

    }

  }

}
