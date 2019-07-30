package edu.stts.submenu_home.supplier.insert

import edu.stts.apotek_kotlin.model.ResultItem

interface DetailSupplierView {
    fun getDataKota(dataItemsKota:List<ResultItem>)
    fun getDataBank(dataItemsBank:List<ResultItem>)
    fun getDataPrincipal(dataItemsPrincipal:List<ResultItem>)
    fun showToast(message: Boolean?)
}