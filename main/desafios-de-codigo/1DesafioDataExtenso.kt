fun main() {
    val entrada: String? = readLine()

    val (dia, mes, ano) = entrada!!.split("/")

    val listaMes = listOf("Janeiro","Fevereiro","Março","Abril",
                          "Maio","Junho","Julho","Agosto",
                          "Setembro","Outubro","Novembro","Dezembro")

    val mesPorExtenso = when (mes.toInt()) {
        in 1..12 -> listaMes[mes.toInt()-1]
        else -> "Mês Inválido!"
    }

    println("$dia de $mesPorExtenso de $ano")
}