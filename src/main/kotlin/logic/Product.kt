package logic

import java.time.LocalDateTime
import java.util.*

class Product(
    val name: String,
    val description: String,
    val price: Double,
    val tax: Double,
    ) {

    var id: UUID

    init {
        id = UUID.randomUUID()

    }
}