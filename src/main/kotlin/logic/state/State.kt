package logic.state

open class State() {
    companion object {
        val Delivered = Delivered()
        val Paid = Paid()
        val Pending = Pending()
        val Processed = Processed()
        val Shipped = Shipped()
    }
}
//TODO Detect tecommending should be refactored as object, but there's an issues later with inheriting state