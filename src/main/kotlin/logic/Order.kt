package logic

import logic.payment.Payment
import logic.state.State
import java.time.LocalDateTime
import java.util.*

abstract class Order(val products: MutableList<Product> = mutableListOf(), val state: State = State.Pending) {

    abstract val payments: Any
    val total: Double = getTotal()

    var date: LocalDateTime
    var id: UUID
    init {
        date = LocalDateTime.now()
        id = UUID.randomUUID()

    }
    abstract fun getTotal(): Double
    abstract fun getDue(): Double
    abstract fun addItem(product: Product): Boolean
    abstract fun recvPmy(payment: Payment): Boolean
    abstract fun getAmtPaid(): Double


}