package logic.payment

import logic.client.Client
import logic.order.Order
import java.util.*

open class Payment() {

    val order: Order = TODO()
    val client: Client
    open val amount: Double
    var id: UUID

    init {
        id = UUID.randomUUID()
    }
}
