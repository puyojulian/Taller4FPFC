package object SubsecuenciaMasLarga {
  type Secuencia = Seq[Int]
  type Subsecuencia = Seq[Int]

  // Una subsecuencia es definida por una secuencia creciente de enteros que representan
  // los indicesde los elementos en la secuencia que hacen parte de la subsecuencia
  // si Seq(i1, i2, i3) , con i1<i2<i3 es una secuencia creciente de enteros en [0..s.lenght-1]
  // esta secuencia de indices representa la subsecuencia Seq(s[i1], s[i2], s[i3]) de s

  def subindices(i: Int, n: Int): Set[Seq[Int]] = {
    // dados i y n devuelve todas las posibles secuencias crecientes de enteros entre i y n
    val indices = (i until n).toList
    (for {
      tamIndice <- 0 to indices.length
      sublista <- indices.combinations(tamIndice)
    } yield sublista).toSet
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
      subsecuencia <- subSecuenciasDe(s)
      if incremental(subsecuencia)
    }
    yield subsecuencia
  }

  def subsecuenciaIncrementalMasLarga(s: Secuencia): Subsecuencia = {
    (for{
      subSIncremental <- subSecuenciasInc(s)
    }
    yield subSIncremental).maxBy(_.length)
  }

  def subsecuenciaIncrementalMasLarga2(s: Seq[Int]): Seq[Int] = {
    (for {
      subSIncremental <- subSecuenciasInc(s)
    }
    yield subSIncremental).foldLeft(Seq.empty[Int]) {
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
      j <- i until s.length
    } yield s.drop(j).foldLeft(List(s(i))) {
      (acc, j) =>
        if (acc.last < j)
          acc :+ j
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
