package EjercicioFinal;

public class Empleado {
  private String nombre;
  private String id;
  private float valorHora;
  private int cantHoras;
  private float salario;

  public Empleado(String nombre, String id, float valorHora, int cantHoras) {
    this.nombre = nombre;
    this.id = id;
    this.valorHora = valorHora;
    this.cantHoras = cantHoras;
    this.salario = valorHora * cantHoras;
  }

  public String mostrarDatos() {
    return "Nombre: " + nombre + "\nID: " + id + "\nValor Hora: " + valorHora + "\nCantidad de Horas: " + cantHoras
        + "\nSalario: " + salario;
  }

  public String mostrarNombreYsalario() {
    return "Nombre: " + nombre + "\nSalario: " + salario;
  }

  public float obtenerSalario() {
    return salario;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setSalario(float salario) {
    this.salario = salario;
  }

  public void setValorHora(float valorHora) {
    this.valorHora = valorHora;
    setSalario(valorHora * cantHoras);
  }

  public void setCantHoras(int cantHoras) {
    this.cantHoras = cantHoras;
    setSalario(valorHora * cantHoras);
  }
  // getters

  public String getNombre() {
    return nombre;
  }

  public String getId() {
    return id;
  }

  public float getValorHora() {
    return valorHora;
  }

  public int getCantHoras() {
    return cantHoras;
  }

  public float getSalario() {
    return salario;
  }

}
