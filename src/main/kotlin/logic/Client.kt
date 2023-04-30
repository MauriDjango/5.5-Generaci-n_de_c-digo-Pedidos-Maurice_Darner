package logic

import logic.payment.Payment
import java.util.UUID

abstract class Client(
    val name: String
) {
    val id: UUID = UUID.randomUUID()
    val orders: MutableList<Order> = mutableListOf<Order>()
    val payments: MutableList<Payment> = mutableListOf<Payment>()

    abstract fun order(proList: List<Product>): Order?
    abstract fun pay(order: Order, payment: Payment): Payment?
}