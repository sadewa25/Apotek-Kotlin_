package edu.stts.submenu_home.supplier

import edu.stts.apotek_kotlin.model.ResultItem

interface SupplierView {
    fun showMessage(data:String)
    fun getDataSupplier(dataItems:List<ResultItem?>?)
}