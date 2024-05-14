## Práctica

Desarrollar un programa Java que implemente los principios de la programación orientada a objetos (POO) y herencia mediante la creación de una clase base "Estudiante" y dos clases derivadas "EstudiantePresencial" y "Estudiante Virtual". El programa debe permitir gestionar la información de los estudiantes, incluyendo sus atributos, notas[], cálculo de matricula, cálculo de nota definitiva y beca.

### Enunciado:

1. Creación de clases:
   - Crear una clase base "Estudiante" con atributos como nombre, apellido, edad, carrera, matrícula, notas (arreglo o lista) y promedio.Incluir métodos para:
     - Agregar notas al estudiante.
     - Calcular el promedio de notas.
     - Calcular la beca (método abstracto a implementar en las clases derivadas).
     - Calcular la matrícula (implementar según la carrera y créditos).
     - Calcular la nota definitiva (promedio de notas).
   - Crear clases derivadas "EstudiantePresencial" y "Estudiante Virtual" que hereden de la clase base "Estudiante".
   - Incluir en las clases derivadas atributos específicos como número de salón
(EstudiantePresencial) y plataforma de aprendizaje (Estudiante Virtual).

2.  Implementación de métodos:
    - Implementar el método "calcularBeca" en cada clase derivada, considerando las características de cada tipo de estudiante.
    - Implementar el método "calcular Matricula" en la clase base, utilizando una fórmula o lógica específica según la carrera y créditos.
  
3. Creación y uso de objetos:
    - Crear objetos de las clases "Estudiante Presencial" y "Estudiante Virtual".
    - Asignar valores a los atributos de cada objeto, incluyendo notas.
    - Mostrar la información de cada estudiante: nombre, apellido, edad, carrera, matrícula, notas, matrícula calculada, nota definitiva y beca.