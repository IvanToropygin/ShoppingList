package com.stepik.shoppinglist.domain

data class ShopItem(
    val id: Int,
    val name: String,
    val count: Double,
    val enabled: Boolean
)
