package logic.payment

class Cash(val amount: Double, val type:String): Payment() {

    companion object {
        val type = listOf<String>("USD", "EUR", "LSB", "YEN")
    }
}