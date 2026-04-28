import projson.model.*
import projson.core.*
import kotlin.collections.listOf

val t1 = Task("T1", Date(30,2,2026), emptyList())
val t2 = Task("T2", Date(31,4,2026), emptyList())
val t3 = Task("T3", null, listOf(t1, t2))
val all = listOf(t1, t2, t3)

val d = Date(31, 4, 2026)
val json1 = ProJson().toJson(d) as JsonObject

val list = listOf("a", null, "b")
val json2 = ProJson().toJson(list) as JsonArray

val mapa = mapOf("nome" to "Afonso", "idade" to 20)
val motor = ProJson()
val json = motor.toJson(mapa)

//val json3 = ProJson().toJson(all) as JsonArray

//val d1 = Date(30, 2, 2026)
//val d2 = Date(31, 4, 2026)
//val json4 = ProJson().toJson(listOf(d1, d2)) as JsonArray


fun main() {
    json1.setProperty("year", JsonPrimitive(2027))

    json2.add(JsonPrimitive("c"))
    //json2.set(3, JsonPrimitive("test"))

    //println(json1)
    println(json2)
    //println(json)
    //println(json3)
    //println(json4)
}

