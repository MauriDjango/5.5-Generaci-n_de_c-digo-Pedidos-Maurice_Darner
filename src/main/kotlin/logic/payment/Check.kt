package logic.payment

data class Check(val amount: Double, val name: String, val bank: String): Payment()