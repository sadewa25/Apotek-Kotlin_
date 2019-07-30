package edu.stts.submenu_home.principal.detail

import edu.stts.apotek_kotlin.model.ResultItem

interface DetailPrincipalView {
    fun showMessage(message: Boolean?)
    fun getDataBank(dataItemsBank:List<ResultItem>):List<ResultItem>
}