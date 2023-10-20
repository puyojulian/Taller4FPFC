package object SubsecuenciaMasLarga {
  type Secuencia = Seq[Int]
  type Subsecuencia = Seq[Int]

  // Una subsecuencia es definida por una secuencia creciente de enteros que representan
  // los indicesde los elementos en la secuencia que hacen parte de la subsecuencia
  // si Seq(i1, i2, i3) , con i1<i2<i3 es una secuencia creciente de enteros en [0..s.lenght-1]
  // esta secuencia de indices representa la subsecuencia Seq(s[i1], s[i2], s[i3]) de s

  def subindices(i: Int, n: Int): Set[Seq[Int]] = {
    def generateSublists(list: List[Int]): List[List[Int]] = {
      list match {
        case Nil => List(Nil) // Return an empty sublist for an empty list
        case head :: tail =>
          val tailSublists = generateSublists(tail)
          val withHead = tailSublists.map(head :: _)
          tailSublists ++ withHead
      }
    }

    // dados i y n devuelve todas las posibles secuencias crecientes de enteros entre i y n
    (for(j <- i until n; k <- j until n) yield (j to k).toList).flatMap(generateSublists).toSet
  }

  def subSecuenciaAsoc(s: Secuencia, inds: Seq[Int]): Subsecuencia = {
  // Dadas s, una secuencia, e inds, una secuencia creciente de indices asociada a s,
  // Devuelve la secuencia correspondiente a la secuencia creciente de indices inds
  }

  def subSecuenciasDe(s: Secuencia): Set[Subsecuencia] = {
  // Dada s , devuelve el conjunto de todas las subsecuencias posibles de s
  }

  def incremental(s: Subsecuencia): Boolean = {

  }

  def subSecuenciasInc(s: Secuencia): Set[Subsecuencia] = {

  }

  def subsecuenciaIncrementalMasLarga(s: Secuencia): Subsecuencia = {

  }

  def ssimlComenzandoEn(i: Int, s: Secuencia): Subsecuencia = {
  // Devuelve la subsecuencia incremental mas larga de s que comienza en s(i)
  }

  def subSecIncMasLargaV2(s: Secuencia): Subsecuencia = {
    // Devuelve una subsecuencia incremental mas larga de s
  }

}
