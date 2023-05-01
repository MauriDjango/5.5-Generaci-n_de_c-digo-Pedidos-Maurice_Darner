package logic.inventory

import logic.Product

class InventoryImpl: Inventory() {

    override val productList: MutableList<Product> = mutableListOf<Product>()

    override fun inStock(proName: String): List<Product>? {
        productList.filter { it.name == proName }.apply {
            return this.ifEmpty { null }
        }
    }

    override fun addInventory(proList: List<Product>) {
        for (product in proList) {
            productList.add(product)
        }
    }

    override fun remInv(proList: List<Product>) {
        for (product in proList) {
            productList.remove(product)
        }
    }
}