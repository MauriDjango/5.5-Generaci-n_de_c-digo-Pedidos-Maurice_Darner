package logic.payment

data class Card(
    val amount: Double,
    val number: String,
    val exDate: String,
    val type: String)
    : Payment()