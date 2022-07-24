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
    val result = processList((listOf(10, "Enero", null, true)))
    println(result)

}
fun processList(inputList: List<Any?>?): List<ItemData>? {
    if (inputList == null) { //si es null devolver null
        return null
    } else {//revisar cada objeto y actuar según caso
        var result = ArrayList<ItemData>()
        for ((index, element) in inputList.withIndex()) {
            when (element) {
                is Int -> {
                    result.add(
                        ItemData(
                            originalPos = index,
                            originalValue = element,
                            type = "entero",
                            info = IntegerType(element)
                        )
                    )
                }
                is String -> {
                    result.add(
                        ItemData(
                            originalPos = index,
                            originalValue =  element,
                            type = "cadena",
                            info = StringType(element)
                        )
                    )
                }
                is Boolean -> {
                    result.add(
                        ItemData(
                            originalPos = index,
                            originalValue = element,
                            type = "booleano",
                            info = Booleantype(element)
                        )
                    )
                }
                else ->{
                    if (element !=null){
                        result.add(
                            ItemData(
                                originalPos = index,
                                originalValue = element,
                                type = null,
                                info = null
                            )
                        )

                    }
                }

            }
        }
        return result

    }
}
//Info for Int tyes
fun IntegerType(valux: Int): String? {
    //covertir de any? a entero
    var type: String? = ""
    if((valux%10) == 0){
        type = "m10"
    }else if((valux%5) == 0){
        type = "m5"
    }else if ((valux%2) == 0){
        type = "m2"
    }else{
        type = null;
    }
    return type
}
//largo del array
fun StringType(valux: String): String? {
    return "l" + valux.length
}
//formato del boolean en strings
fun Booleantype(valux: Boolean): String?{
    if(valux){
        return "verdadero"
    }else return "falso"
}
