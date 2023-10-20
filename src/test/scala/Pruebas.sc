import SubsecuenciaMasLarga._

subindices(2,3)
subindices(0,3)

val s = Seq(20,30,10,40,15,16,17)
subSecuenciaAsoc(s,Seq())
//val r e s0 : SubsecuenciaMasLarga.Subsecuencia = List()
subSecuenciaAsoc(s,Seq(0,2,4))
//val r e s1 : SubsecuenciaMasLarga.Subsecuencia = List(20, 10, 15)
subSecuenciaAsoc(s,Seq(1,2,4,6))
//val r e s2 : SubsecuenciaMasLarga.Subsecuencia = List(30, 10, 15, 17)


subSecuenciasDe(Seq(20,30,10))

val s1 = Seq(20,30,40)
incremental(s1)
val s2 = Seq(20,30,10,40,15,16,17)
incremental(s2)
val s3 = Seq()
incremental(s3)
val s4 = Seq(4,5)
incremental(s4)

subSecuenciasInc(s)
subSecuenciasInc(Seq(20,30,10))
subSecuenciasInc(Seq(10,20,30))
subsecuenciaIncrementalMasLarga(Seq(20,30,10,40,15,16,17))
subsecuenciaIncrementalMasLarga(Seq(20,30,10))

subsecuenciaIncrementalMasLarga2(Seq(20,30,10,40,15,16,17))
subsecuenciaIncrementalMasLarga2(Seq(20,30,10))

//subSecIncMasLargaV2(Seq(20,30,10,40,15,16,17))
//subsecuenciaIncrementalMasLarga(Seq(20,30,10,40,15,16,17,11,12,13,14))
//subSecIncMasLargaV2(Seq(20,30,10,40,15,16,17,11,12,13,14))