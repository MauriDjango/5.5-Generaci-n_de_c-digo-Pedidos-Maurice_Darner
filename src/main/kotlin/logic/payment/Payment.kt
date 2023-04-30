package logic.payment

import java.util.*

open class Payment {

    var id: UUID

    init {
        id = UUID.randomUUID()
    }
}
