package EjerciciosActividad5;

import javax.swing.JOptionPane;

public class Ejercicio {

  public static void main(String[] args) {
    EstudianteVirtual estudianteVirtual = new EstudianteVirtual("Juan", "Perez", 20, "ingenieria",
        new int[] { 4, 5, 3, 4, 5 }, "Google Classroom");
    EstudiantePresencial estudiantePresencial = new EstudiantePresencial("Maria", "Gomez", 22, "licenciatura",
        new int[] { 4, 5, 3, 4, 5 }, 101);

    estudianteVirtual.calcularBeca();
    estudiantePresencial.calcularBeca();

    JOptionPane.showMessageDialog(null, "Estudiante Virtual: \n" + estudianteVirtual.mostrarDatos()
        + "\n\nEstudiante Presencial: \n" + estudiantePresencial.mostrarDatos());

  }

}
