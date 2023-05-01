package logic.payment

data class Check(override val amount: Double, val name: String, val bank: String): Payment()