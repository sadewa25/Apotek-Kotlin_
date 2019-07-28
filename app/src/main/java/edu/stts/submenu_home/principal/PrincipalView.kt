package edu.stts.submenu_home.principal

import edu.stts.apotek_kotlin.model.ResultItem

interface PrincipalView {
    fun showMessage(data:String)
    fun getDataPrincipal(dataItems:List<ResultItem?>?)
}