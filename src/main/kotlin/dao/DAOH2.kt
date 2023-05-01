package dao

import logic.Product
import logic.client.Client
import logic.client.ClientImpl
import logic.inventory.Inventory
import logic.order.Order
import logic.order.OrderImpl
import logic.payment.Payment
import java.sql.Date
import java.sql.ResultSet
import java.util.*
import javax.sql.DataSource

class DAOH2(private val dataSource: DataSource): DAO {

    override fun create(product: Product): Int {
        val sql = "INSERT INTO PRODUCTS (id, name, description, price, tax) VALUES (?, ?, ?, ?, ?)"
        dataSource.connection.use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, product.id.toString())
                stmt.setString(2, product.name)
                stmt.setString(4, product.description)
                stmt.setString(3, product.price.toString())
                stmt.setString(5, product.tax.toString())

                return stmt.executeUpdate()
            }
        }
    }

    override fun create(order: Order): Int {
        val sql = "INSERT INTO ORDERS (id, total, due, date, tax) VALUES (?, ?, ?, ?, ?)"
        dataSource.connection.use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, order.id.toString())
                stmt.setString(2, order.total.toString())
                stmt.setString(4, order.due.toString())
                stmt.setString(3, order.date.toString())

                return stmt.executeUpdate()
            }
        }
    }

    override fun create(client: Client): Int {
        val sql = "INSERT INTO CLIENTS (id, name) VALUES (?, ?)"
        dataSource.connection.use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, client.id.toString())
                stmt.setString(2, client.name)

                return stmt.executeUpdate()
            }
        }
    }

    override fun create(payment: Payment): Int {
        val sql = "INSERT INTO PAYMENTS (id, amount, client, order) VALUES (?, ?)"
        dataSource.connection.use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1,payment.id.toString())
                stmt.setString(2, payment.amount.toString())
                stmt.setString(2, payment.client.toString())
                stmt.setString(2, payment.order.toString())


                return stmt.executeUpdate()
            }
        }
    }

    override fun readProduct(id: UUID):Product? {
        val sql = "SELECT * FROM products WHERE ID = ?"
        var product: Product? = null
        dataSource.connection.use {conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id.toString())
                val result = stmt.executeQuery()
                if (result.next()) {
                    product = Product(
                        name = result.getString("name"),
                        description = result.getString("description"),
                        price = result.getDouble("price"),
                        tax = result.getDouble("tax"),
                    )
                    product?.id = UUID.fromString(result.getString("id"))
                }
            }
        }
        return product
    }

    override fun readOrder(id: UUID): Order? {
        val sql = "SELECT * FROM ORDERS WHERE ID = ?"
        var order: Order? = null
        dataSource.connection.use {conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id.toString())
                val result = stmt.executeQuery()
                if (result.next()) {
                    order = OrderImpl(mutableListOf())
                    order?.id = UUID.fromString(result.getString("id"))
                    order?.date = result.getTimestamp(result.getString("date")).toLocalDateTime()
                }
            }
        }
        return order
    }

    override fun readClient(id: UUID): Client? {
        val sql = "SELECT * FROM CLIENTS WHERE ID = ?"
        var client: Client? = null
        dataSource.connection.use {conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id.toString())
                val result = stmt.executeQuery()
                if (result.next()) {
                    client = ClientImpl(result.getString("name"))
                }
            }
        }
        return client
    }

    override fun readPayment(id: UUID): Payment? {
        val sql = "SELECT * FROM PAYMENTS WHERE ID = ?"
        var payment: Payment? = null
        dataSource.connection.use {conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id.toString())
                val result = stmt.executeQuery()
                if (result.next()) {
                }
            }
        }
        return payment
    }

    override fun updateProduct(id: UUID): Product? {
        TODO("Not yet implemented")
    }

    override fun updateOrder(id: UUID): Order?{
        TODO("Not yet implemented")
    }

    override fun updateClient(id: UUID):Client?{
        TODO("Not yet implemented")
    }

    override fun updatePayment(id: UUID): Payment? {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(id: UUID): Product? {
        TODO("Not yet implemented")
    }

    override fun deleteOrder(id: UUID): Order? {
        TODO("Not yet implemented")
    }

    override fun deleteClient(id: UUID): Client? {
        TODO("Not yet implemented")
    }

    override fun deletePayment(id: UUID): Payment? {
        TODO("Not yet implemented")
    }
}

/* override fun getById(id: Int): Product? {
        val sql = "SELECT * FROM products WHERE ID = ?"
        var product: Product? = null
        dataSource.connection.use {conn ->
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id.toString())
                val result = stmt.executeQuery()
                    if (result.next()) {
                        //TODO This portion could have a problem if the id is ever repeated
                        product = Product(
                            id = result.getInt("id"),
                            name = result.getString("name"),
                            price = result.getFloat("price"),
                            description = result.getString("description"),
                            brand = result.getString("brand"),
                            category = result.getString("category")
                        )
                    }
                }
            }
            return product
        }"""

    override fun createTable() {
        val sql =
            "CREATE TABLE products (id INT PRIMARY KEY, name VARCHAR(50), price FLOAT, description VARCHAR(100), brand VARCHAR(50), category VARCHAR(50));"
        dataSource.connection.use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                val result = stmt.executeUpdate()
            }
        }
    } */
