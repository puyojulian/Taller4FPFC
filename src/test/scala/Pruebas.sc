/*
  Archivo: Pruebas.sc
  Autores:  Julian Ernesto Puyo Mora <julian.puyo@correounivalle.edu.co> <202226905>
            Sebastian Orrego Marin <orrego.sebastian@correounivalle.edu.co> <201941144>
  N° Taller: 04
  Fecha de realización: 26/10/2023
*/

import SubsecuenciaMasLarga.{subSecuenciasDe, _}

subindices(2,3)
subindices(0,3)
subindices(10,14)
subindices(6,6)
subindices(0,2)

val s = Seq(20,30,10,40,15,16,17)
subSecuenciaAsoc(s,Seq())
subSecuenciaAsoc(s,Seq(0,6))
subSecuenciaAsoc(s,Seq(0,2,4))
subSecuenciaAsoc(s,Seq(0,2,4,6))
subSecuenciaAsoc(s,Seq(0,1,2,3,4))

subSecuenciasDe(Seq(20,30,10,40))
subSecuenciasDe(Seq(20,30,10))
subSecuenciasDe(Seq(1,2))
subSecuenciasDe(Seq(14,10,15,20))
subSecuenciasDe(Seq(20,20,30,10,10))

val s1 = Seq(20,30,40)
incremental(s1)
val s2 = Seq(20,30,10,40,15,16,17)
incremental(s2)
val s3 = Seq()
incremental(s3)
val s4 = Seq(4,5)
incremental(s4)
val s5 = Seq(6,4,5)
incremental(s5)

subSecuenciasInc(s)
subSecuenciasInc(Seq(20,30,10))
subSecuenciasInc(Seq(10,20,30))
subSecuenciasInc(Seq(20,30,10,40,15,16,17,9))
subSecuenciasInc(Seq(14,10,15,20))

subsecuenciaIncrementalMasLarga(Seq(20,30,10,40,15,16,17))
subsecuenciaIncrementalMasLarga(Seq(20,30,10))
subsecuenciaIncrementalMasLarga(Seq(10,20,30))
subsecuenciaIncrementalMasLarga(Seq(20,30,10,40,15,16,17,11))
subsecuenciaIncrementalMasLarga(Seq(14,10,15,20))

subsecuenciaIncrementalMasLarga2(Seq(20,30,10,40,15,16,17))
subsecuenciaIncrementalMasLarga2(Seq(20,30,10))
subsecuenciaIncrementalMasLarga2(Seq(10,20,30))
subsecuenciaIncrementalMasLarga2(Seq(20,30,10,40,15,16,17,11))
subsecuenciaIncrementalMasLarga2(Seq(14,10,15,20))

ssimlComenzandoEn(4, Seq(10,9,8,7,6,7,5,4,3,2,1,7,22,21,20,19,18,17,16,15,14,13,12,11,3,8,9,1,2,3,12))
ssimlComenzandoEn(12, Seq(10,9,8,7,6,7,5,4,3,2,1,7,22,21,20,19,18,17,16,15,14,13,12,11,3,8,9,1,2,3,12))
ssimlComenzandoEn(1, Seq(1,2,3,4,3,2,1))
ssimlComenzandoEn(0, Seq(8,2,3,4,3,10,1))
ssimlComenzandoEn(0, Seq(3,2,3,4,3,1,0))

subSecIncMasLargaV2(Seq(20,30,10,40,15,16,17))
subSecIncMasLargaV2(Seq(20,30,10))
subSecIncMasLargaV2(Seq(10,20,30))
subSecIncMasLargaV2(Seq(20,30,10,40,15,16,17,11))
subSecIncMasLargaV2(Seq(14,10,15,20))
