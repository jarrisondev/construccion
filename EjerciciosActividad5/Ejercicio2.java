package EjerciciosActividad5;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JFrame;
import java.awt.*;

public class Ejercicio2 {

  public static void main(String[] args) {

    int numeroDeEstudiantesVirtuales = Integer
        .parseInt(JOptionPane.showInputDialog("Ingrese el numero de estudiantes virtuales"));
    EstudianteVirtual[] estudiantesVirtuales = new EstudianteVirtual[numeroDeEstudiantesVirtuales];

    int numeroDeEstudiantesPresenciales = Integer
        .parseInt(JOptionPane.showInputDialog("Ingrese el numero de estudiantes presenciales"));
    EstudiantePresencial[] estudiantesPresenciales = new EstudiantePresencial[numeroDeEstudiantesPresenciales];

    for (int i = 0; i < numeroDeEstudiantesVirtuales; i++) {
      String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante virtual" + (i + 1) + " ");
      String apellido = JOptionPane.showInputDialog("Ingrese el apellido del estudiante");
      int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante"));
      String carrera = JOptionPane
          .showInputDialog("Ingrese la carrera del estudiante \n-ingenieria \n-licenciatura \n-tecnico");

      int[] notas = new int[5];
      for (int j = 0; j < 5; j++) {
        notas[j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota " + (j + 1) + " del estudiante"));
      }

      String plataforma = JOptionPane.showInputDialog("Ingrese la plataforma del estudiante virtual");
      EstudianteVirtual estudianteVirtual = new EstudianteVirtual(nombre, apellido, edad, carrera, notas, plataforma);
      estudianteVirtual.calcularBeca();
      estudiantesVirtuales[i] = estudianteVirtual;
    }

    for (int i = 0; i < numeroDeEstudiantesPresenciales; i++) {
      String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiantepresencial" + (i + 1) + " ");
      String apellido = JOptionPane.showInputDialog("Ingrese el apellido del estudiante");
      int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante"));
      String carrera = JOptionPane
          .showInputDialog("Ingrese la carrera del estudiante \n-ingenieria \n-licenciatura \n-tecnico");

      int[] notas = new int[5];
      for (int j = 0; j < 5; j++) {
        notas[j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota " + (j + 1) + " del estudiante"));
      }

      int numeroSalon = Integer
          .parseInt(JOptionPane.showInputDialog("Ingrese el numero de salon"));
      EstudiantePresencial estudiantePresencial = new EstudiantePresencial(nombre, apellido, edad, carrera, notas,
          numeroSalon);
      estudiantePresencial.calcularBeca();
      estudiantesPresenciales[i] = estudiantePresencial;
    }

    // show in a JTable all the students
    String[] columnNames = { "Nombre", "Apellido", "Edad", "Carrera", "Notas", "Promedio",
        "Plataforma/Salon" };
    String[][] data = new String[numeroDeEstudiantesVirtuales + numeroDeEstudiantesPresenciales][7];

    for (int i = 0; i < numeroDeEstudiantesVirtuales; i++) {
      data[i][0] = estudiantesVirtuales[i].nombre;
      data[i][1] = estudiantesVirtuales[i].apellido;
      data[i][2] = String.valueOf(estudiantesVirtuales[i].edad);
      data[i][3] = estudiantesVirtuales[i].carrera;
      data[i][4] = estudiantesVirtuales[i].obtenerNotas();
      data[i][5] = String.valueOf(estudiantesVirtuales[i].promedio);
      data[i][6] = estudiantesVirtuales[i].plataformaAprendizaje;
    }

    for (int i = 0; i < numeroDeEstudiantesPresenciales; i++) {
      data[i + numeroDeEstudiantesVirtuales][0] = estudiantesPresenciales[i].nombre;
      data[i + numeroDeEstudiantesVirtuales][1] = estudiantesPresenciales[i].apellido;
      data[i + numeroDeEstudiantesVirtuales][2] = String.valueOf(estudiantesPresenciales[i].edad);
      data[i + numeroDeEstudiantesVirtuales][3] = estudiantesPresenciales[i].carrera;
      data[i + numeroDeEstudiantesVirtuales][4] = estudiantesPresenciales[i].obtenerNotas();
      data[i + numeroDeEstudiantesVirtuales][5] = String.valueOf(estudiantesPresenciales[i].promedio);
      data[i + numeroDeEstudiantesVirtuales][6] = String.valueOf(estudiantesPresenciales[i].numeroDeSalon);

    }

    JFrame frame = new JFrame("Estudiantes");
    JTable table = new JTable(data, columnNames);

    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(800, 400);
    frame.setVisible(true);

  }

}
