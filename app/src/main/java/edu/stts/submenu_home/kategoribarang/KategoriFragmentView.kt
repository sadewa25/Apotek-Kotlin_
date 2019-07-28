package edu.stts.submenu_home.kategoribarang

import edu.stts.apotek_kotlin.model.ResultItem

interface KategoriFragmentView{
    fun showToast(message: String)
    fun showCategoryData(data: List<ResultItem>)
}