//Arturo Argueta
//Programacion de plataformas móviles - sección 20
//carné: 21527
// // No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList((listOf(5, "Enero", null, true)))
    println(result)

}
fun processList(inputList: List<Any?>?): List<ItemData>? {
    val result = inputList?.let {  //en caso de que sea un null, da un null de resultado
        var ArrayofItems = ArrayList<ItemData>()
        it.forEachIndexed{ inx, element -> //recorrer elementos del arreglo, y crear el objeto según sea el caso
            when(element){
                is Int -> {ArrayofItems.add(ItemData(inx,element,"entero", listOf(10,5,2).firstOrNull { (element % it) == 0 }?.let{"m$it"}))}
                is Boolean -> {ArrayofItems.add(ItemData(inx,element,"booleano",if(element){"verdadero"} else{"falso"}))}
                is String -> {ArrayofItems.add(ItemData(inx,element,"cadena","l${element.length}"))}
                else -> element?.let { ArrayofItems.add(ItemData(inx,element))}
            }
        }
        return ArrayofItems
    }
    return  result
}