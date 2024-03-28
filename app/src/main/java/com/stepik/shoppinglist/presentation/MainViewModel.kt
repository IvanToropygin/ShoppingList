package com.stepik.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.stepik.shoppinglist.data.ShopListRepositoryImpl
import com.stepik.shoppinglist.domain.DeleteShopItemUseCase
import com.stepik.shoppinglist.domain.EditShopItemUseCase
import com.stepik.shoppinglist.domain.GetShopListUseCase
import com.stepik.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun changeEnabledState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }
}