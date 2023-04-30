package logic

import logic.payment.Payment
import logic.state.State
import java.time.LocalDateTime
import java.util.*

class OrderImpl(proList: MutableList<Product>, state: State = State.Pending): Order(proList, state) {

    override val payments = mutableListOf<Payment>()

    override fun getTotal(): Double {
        var total = 0.00
        products.forEach {
            total += it.price + it.tax
        }
        return total
    }

    override fun addItem(product: Product) = products.add(product)

    override fun recvPmy(payment: Payment) = payments.add(payment)

    override fun getAmtPaid(): Double {
        var amtPaid = 0.00
        if (payments.isNotEmpty()) {
            payments.forEach {
                amtPaid += it.amount
            }
        }
        return amtPaid
    }

    override fun getDue() = getTotal().minus(getAmtPaid())
}
