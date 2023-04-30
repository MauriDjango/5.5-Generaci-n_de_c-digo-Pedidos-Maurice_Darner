package logic

import logic.payment.Payment
import java.util.*

class ClientImpl(name: String): Client(name) {

    override fun order(proList: List<Product>): Order? = OrderImpl(proList)

    override fun pay(order: Order, payment: Payment): Payment? = order.recvPmy(payment)
}