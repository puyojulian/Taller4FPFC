package object SubsecuenciaMasLarga {
  type Secuencia = Seq[Int]
  type Subsecuencia = Seq[Int]

  // Una subsecuencia es definida por una secuencia creciente de enteros que representan
  // los indicesde los elementos en la secuencia que hacen parte de la subsecuencia
  // si Seq(i1, i2, i3) , con i1<i2<i3 es una secuencia creciente de enteros en [0..s.lenght-1]
  // esta secuencia de indices representa la subsecuencia Seq(s[i1], s[i2], s[i3]) de s

  def subindices(i: Int, n: Int): Set[Seq[Int]] = {
    // dados i y n devuelve todas las posibles secuencias crecientes de enteros entre i y n
    val list = (i until n).toList
    (for {
      n <- 0 to list.length
      sublist <- list.combinations(n)
    } yield sublist).toSet
  }

  def subSecuenciaAsoc(s: Secuencia, inds: Seq[Int]): Subsecuencia = {
  // Dadas s, una secuencia, e inds, una secuencia creciente de indices asociada a s,
  // Devuelve la secuencia correspondiente a la secuencia creciente de indices inds
    (for{
      i <- inds
    }
    yield s(i)).toList
  }

  def subSecuenciasDe(s: Secuencia): Set[Subsecuencia] = {
  // Dada s , devuelve el conjunto de todas las subsecuencias posibles de s
    for{
      listaIndices <- subindices(0,s.length)
    }
    yield subSecuenciaAsoc(s,listaIndices)
  }

  def incremental(s: Subsecuencia): Boolean = {
    // Dada una subsecuencia decida si es incremental(devuelve true) o no (devuelve false).
    (for {
      x <- 0 until s.length
      y <- x+1 until s.length
    } yield (s(x) < s(y))).foldLeft(true)(_ && _)
  }

  def subSecuenciasInc(s: Secuencia): Set[Subsecuencia] = {
    for{
      subS <- subSecuenciasDe(s)
      if incremental(subS)
    }
    yield subS
  }

  def subsecuenciaIncrementalMasLarga(s: Secuencia): Subsecuencia = {
    (for{
      subS <- subSecuenciasInc(s)
    }
    yield subS).maxBy(_.length)
  }

  def subsecuenciaIncrementalMasLarga2(s: Seq[Int]): Seq[Int] = {
    (for {
      subseq <- subSecuenciasInc(s)
    } yield subseq).foldLeft(Seq.empty[Int]) {
      (acc, subS) =>
        if (incremental(subS) && subS.length > acc.length)
          subS
        else
          acc
    }
  }

  def ssimlComenzandoEn(i: Int, s: Secuencia): Subsecuencia = {
    // Devuelve la subsecuencia incremental mas larga de s que comienza en s(i)
    (for {
      x <- i until s.length
    } yield s.drop(x).foldLeft(List(s(i))) {
      (acc, x) =>
        if (acc.last < x)
          acc :+ x
        else
          acc
    }).maxBy(_.length)
  }

  def subSecIncMasLargaV2(s: Secuencia): Subsecuencia = {
    //Devuelve una subsecuencia incremental mas larga de s
    (for{
      i <- 0 until s.length
    }
    yield ssimlComenzandoEn(i,s)).maxBy(_.length)
  }
}
