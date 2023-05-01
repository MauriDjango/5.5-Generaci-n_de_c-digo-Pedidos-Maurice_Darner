package dao

import logic.Product
import logic.client.Client
import logic.inventory.Inventory
import logic.order.Order
import logic.payment.Payment import java.sql.ResultSet
import java.util.*

interface DAO {
    fun create(product: Product): Int
    fun create(order: Order): Int
    fun create(client: Client): Int
    fun create(payment: Payment): Int

    fun readProduct(id: UUID):Product?
    fun readOrder(id: UUID): Order?
    fun readClient(id: UUID): Client?
    fun readPayment(id: UUID): Payment?

    fun updateProduct(id: UUID): Product?
    fun updateOrder(id: UUID): Order?
    fun updatePayment(id: UUID): Payment?
    fun updateClient(id: UUID): Client?


    fun deleteProduct(id: UUID): Product?
    fun deleteOrder(id: UUID): Order?
    fun deleteClient(id: UUID): Client?
    fun deletePayment(id: UUID): Payment?
}