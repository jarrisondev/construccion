package EjerciciosActividad5;

public class EstudianteVirtual extends Estudiante {

  String plataformaAprendizaje;

  public EstudianteVirtual(String nombre, String apellido, int edad, String carrera, int[] notas,
      String plataformaAprendizaje) {
    super(nombre, apellido, edad, carrera, notas);
    this.plataformaAprendizaje = plataformaAprendizaje;
  }

  @Override
  public void calcularBeca() {
    double beca = 0;
    if (promedio >= 4.5) {
      beca = 0.3;
    } else if (promedio >= 4) {
      beca = 0.2;
    }
    matricula = matricula - (matricula * beca);
  }

}
