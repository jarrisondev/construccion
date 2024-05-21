package EjerciciosActividad5;

import javax.swing.JOptionPane;

public class Estudiante {
  String nombre;
  String apellido;
  int edad;
  String carrera;
  double matricula;
  int[] notas;
  double promedio;

  public Estudiante(String nombre, String apellido, int edad, String carrera, int[] notas) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.carrera = carrera;
    this.notas = notas;
    calcularPromedio();
    calcularMatricula();
  }

  public double calcularPromedio() {
    double suma = 0;
    for (int i = 0; i < notas.length; i++) {
      suma += notas[i];
    }
    promedio = suma / notas.length;
    return promedio;
  }

  public void agregarNotas(int[] notas) {
    this.notas = notas;
    calcularPromedio();
  }

  // metodo abstracto
  public void calcularBeca() {

  }

  public String obtenerNotas() {
    String notasString = "";
    for (int i = 0; i < notas.length; i++) {
      notasString += notas[i] + " ";
    }
    return notasString;
  }

  public void calcularMatricula() {
    if (carrera.contains("ingenieria")) {
      matricula = 2000000;
    } else if (carrera.contains("licenciatura")) {
      matricula = 1500000;
    } else if (carrera.contains("tecnico")) {
      matricula = 900000;
    } else {
      matricula = 1000000;
    }

  }

  public void calcularNotaFinal() {

    if (promedio >= 3.0) {
      JOptionPane.showMessageDialog(null, "El estudiante " + nombre + " " + apellido + " ha aprobado");
    } else {
      JOptionPane.showMessageDialog(null, "El estudiante " + nombre + " " + apellido + " ha reprobado");
    }
  }

  public String mostrarDatos() {
    return "Nombre: " + nombre + " " + apellido + "\nEdad: " + edad + "\nCarrera: " + carrera + "\nPromedio: "
        + promedio + "\nMatricula: " + matricula;
  }
}
