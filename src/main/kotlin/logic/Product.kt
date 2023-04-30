package logic

import java.time.LocalDateTime
import java.util.*

class Product(
    val name: String,
    val description: String,
    val price: Float,
    val tax: Float,
    ) {

    var id: UUID

    init {
        id = UUID.randomUUID()

    }
}