package edu.stts.submenu_home.kemasan

import edu.stts.apotek_kotlin.model.ResultItem

interface KemasanView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(data:String)
    fun getDataSupplier(dataItems:List<ResultItem?>?)
}