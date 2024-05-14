package EjerciciosActividad5;

public class EstudiantePresencial extends Estudiante {
  int numeroDeSalon;

  public EstudiantePresencial(String nombre, String apellido, int edad, String carrera, int[] notas,
      int numeroDeSalon) {
    super(nombre, apellido, edad, carrera, notas);
    this.numeroDeSalon = numeroDeSalon;
  }

  @Override
  public void calcularBeca() {
    double beca = 0;
    if (promedio >= 4.5) {
      beca = 0.5;
    } else if (promedio >= 4.0) {
      beca = 0.4;
    } else if (promedio >= 3.5) {
      beca = 0.3;
    } else if (promedio >= 3.0) {
      beca = 0.2;
    }
    matricula = matricula - (matricula * beca);
  }
}
