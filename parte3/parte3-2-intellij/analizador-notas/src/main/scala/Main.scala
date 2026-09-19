object Main extends App {
  val estudiantes = List("Ana", "Luis", "Marta", "Pedro", "Sofia")
  val notas = Array(8, 4, 10, 6, 3)

  def aprobado(nota: Int): Boolean = {
    if (nota >= 5) true
    else false
  }

  def estadoNota(nota: Int): String = {
    if (aprobado(nota)) "APROBADO"
    else "SUSPENSO"
  }

  def maxNota(a: Int, b: Int): Int = {
    if (a > b) a
    else b
  }

  def clasificacion(nota: Int): String = {
    if (nota >= 9) "EXCELENTE"
    else if (nota >= 7) "NOTABLE"
    else if (nota >= 5) "APROBADO"
    else "SUSPENSO"
  }

  println("Primera evaluación")
  var i = 0
  var aprobados = 0
  var suspensos = 0
  var mejorNota = 0

  while (i < notas.length) {
    val e = estudiantes(i)
    val n = notas(i)
    val est = estadoNota(n)
    println(s"$e -> $n -> $est")
    
    if (est == "APROBADO") {
      aprobados += 1
    } else {
      suspensos += 1
    }
    
    mejorNota = maxNota(mejorNota, n)
    i += 1
  }

  println("Resumen del grupo")
  println(s"Estudiantes: ${estudiantes.length}")
  println(s"Aprobados: $aprobados")
  println(s"Suspensos: $suspensos")
  println(s"Mejor nota: $mejorNota")

  println("Clasificación adicional")
  var j = 0
  while (j < notas.length) {
    val e = estudiantes(j)
    val n = notas(j)
    val clasif = clasificacion(n)
    println(s"$e -> $n -> $clasif")
    j += 1
  }

  val notasSegundaEvaluacion = Array(9, 5, 8, 7, 6)

  println("Segunda evaluación")
  var k = 0
  var aprobadosR2 = 0
  var mejorNotaR2 = 0

  while (k < notasSegundaEvaluacion.length) {
    val e = estudiantes(k)
    val n = notasSegundaEvaluacion(k)
    val est = estadoNota(n)
    println(s"$e -> $n -> $est")
    
    if (est == "APROBADO") {
      aprobadosR2 += 1
    }
    
    mejorNotaR2 = maxNota(mejorNotaR2, n)
    k += 1
  }

  println("Comparación de evaluaciones")
  println(s"Mejor nota de la primera evaluación: $mejorNota")
  println(s"Mejor nota de la segunda evaluación: $mejorNotaR2")
  println(s"Número de aprobados de la primera: $aprobados")
  println(s"Número de aprobados de la segunda: $aprobadosR2")

  if (aprobadosR2 > aprobados) {
    println("El grupo ha mejorado.")
  } else if (aprobados > aprobadosR2) {
    println("El grupo ha empeorado.")
  } else {
    println("El grupo se ha mantenido igual.")
  }

  val nuevosEstudiantes = "Carlos" :: estudiantes
  println(s"Lista original: $estudiantes")
  println(s"Lista nueva: $nuevosEstudiantes")
}
