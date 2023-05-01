package logic.client

import logic.order.Order
import logic.order.OrderImpl
import logic.Product
import logic.payment.Payment

class ClientImpl(name: String): Client(name) {

    override fun order(proList: MutableList<Product>): Order? = OrderImpl(proList)

    override fun pay(order: Order, payment: Payment) = order.recvPmy(payment)
}