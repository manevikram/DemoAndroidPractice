package com.demo.practice.solid_principles

/**
 * Created by Vikram Mane on 4/13/24.
 */
class Solid {
}

// High level module
class ProductCatalog {
    fun listOfAllProduct() {
        val listOfAllProduct : ProductRepo = MangoProductRepo()
        listOfAllProduct.getProductList().forEach(){
            println(it)
        }
    }
}

interface ProductRepo {
    fun getProductList() : MutableList<String>
}
// low level module
class SQLProductRepo : ProductRepo {
    override fun getProductList() : MutableList<String> {
        return mutableListOf("Apple", "Banana")
    }
}

class MangoProductRepo : ProductRepo {
    override fun getProductList(): MutableList<String> {
        return mutableListOf("Cherry")
    }
}

fun main() {
    val listOfProduct = ProductCatalog()
    listOfProduct.listOfAllProduct()
}