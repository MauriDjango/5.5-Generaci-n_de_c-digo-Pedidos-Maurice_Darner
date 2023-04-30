package logic

abstract class Inventory {
    abstract val productList:List<Product>

    abstract fun inStock(proName: String): List<Product>?
    abstract fun addInventory(proList: List<Product>)
    abstract fun remInv(proList: List<Product>)
}