package edu.stts.submenu_home.lokasirak

import edu.stts.apotek_kotlin.model.ResultItem

interface LokasiRakFragmentView {
    fun showToast(message: String)
    fun showDataLokasiRak(dataItems:List<ResultItem>)
}