object Main extends App {
  val jugadores = List("Alex", "Chen", "Marta", "Sindhu", "Luis")
  val puntuaciones = Array(18, 24, 21, 20, 26)

  def bust(puntuacion: Int): Boolean = {
    if (puntuacion > 21) true
    else false
  }

  def estadoMano(puntuacion: Int): String = {
    if (bust(puntuacion)) "BUST"
    else "VALIDA"
  }

  def mejorMano(handA: Int, handB: Int): Int = {
    if (bust(handA) && bust(handB)) 0
    else if (bust(handA)) handB
    else if (bust(handB)) handA
    else if (handA > handB) handA
    else handB
  }

  println("Primera ronda")
  var i = 0
  var manosValidas = 0
  var bustCount = 0
  var mejorPuntValida = 0

  while (i < puntuaciones.length) {
    val j = jugadores(i)
    val p = puntuaciones(i)
    val est = estadoMano(p)
    println(s"$j -> $p -> $est")
    
    if (est == "VALIDA") {
      manosValidas += 1
      mejorPuntValida = mejorMano(mejorPuntValida, p)
    } else {
      bustCount += 1
    }
    
    i += 1
  }

  println("Resumen")
  println(s"Jugadores: ${jugadores.length}")
  println(s"Manos: $manosValidas")
  println(s"Bust: $bustCount")
  println(s"Mejor: $mejorPuntValida")

  val puntuacionesRonda2 = Array(22, 19, 20, 21, 17)

  println("Segunda ronda")
  var i2 = 0
  var mejorPuntValidaR2 = 0

  while (i2 < puntuacionesRonda2.length) {
    val j = jugadores(i2)
    val p = puntuacionesRonda2(i2)
    val est = estadoMano(p)
    println(s"$j -> $p -> $est")
    
    if (est == "VALIDA") {
      mejorPuntValidaR2 = mejorMano(mejorPuntValidaR2, p)
    }
    
    i2 += 1
  }

  println("Comparación rondas")
  println(s"Mejor puntuación primera ronda: $mejorPuntValida")
  println(s"Mejor puntuación segunda ronda: $mejorPuntValidaR2")

  if (mejorPuntValida > mejorPuntValidaR2) {
    println("La primera ronda tuvo la mejor puntuación.")
  } else if (mejorPuntValidaR2 > mejorPuntValida) {
    println("La segunda ronda tuvo la mejor puntuación.")
  } else {
    println("Ambas rondas tuvieron la misma mejor puntuación.")
  }

  println("foreach")
  puntuaciones.foreach { p =>
    println(s"$p -> ${estadoMano(p)}")
  }
}
