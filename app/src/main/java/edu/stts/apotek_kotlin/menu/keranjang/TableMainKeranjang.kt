package edu.stts.apotek_kotlin.menu.keranjang

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.*
import android.widget.TextView
import android.view.Gravity
import android.view.View

class TableMainKeranjang(context: Context?,val sampleObjects: List<KeranjangModel>,val headers:Array<String>) : RelativeLayout(context) {

    var tableA: TableLayout? = null
    var tableB: TableLayout? = null
    var tableC: TableLayout? = null
    var tableD: TableLayout? = null

    var horizontalScrollViewB: HorizontalScrollView? = null
    var horizontalScrollViewD: HorizontalScrollView? = null

    var scrollViewC: ScrollView? = null
    var scrollViewD: ScrollView? = null

    var headerCellsWidth = IntArray(headers.size)

    init {
        // initialize the main components (TableLayouts, HorizontalScrollView, ScrollView)
        this.initComponents();
        this.setComponentsId();
        this.setScrollViewAndHorizontalScrollViewTag();


        // no need to assemble component A, since it is just a table
        this.horizontalScrollViewB?.addView(this.tableB);

        this.scrollViewC?.addView(this.tableC);

        this.scrollViewD?.addView(this.horizontalScrollViewD);
        this.horizontalScrollViewD?.addView(this.tableD);

        // add the components to be part of the main layout
        this.addComponentToMainLayout();
        this.setBackgroundColor(Color.RED);


        // add some table rows
        this.addTableRowToTableA();
        this. addTableRowToTableB();

        this.resizeHeaderHeight();

        this.getTableRowHeaderCellWidth();

        this.generateTableC_AndTable_B();

        this.resizeBodyTableRowHeight();
    }

    fun initComponents(){

        this.tableA = TableLayout(this.context)
        this.tableB = TableLayout(this.context)
        this.tableC = TableLayout(this.context)
        this.tableD = TableLayout(this.context)

        this.horizontalScrollViewB = MyHorizontalScrollView(this.context)
        this.horizontalScrollViewD = MyHorizontalScrollView(this.context)

        this.scrollViewC = MyScrollView(this.context)
        this.scrollViewD = MyScrollView(this.context)

        this.tableA!!.setBackgroundColor(Color.GREEN)
        /*this.horizontalScrollViewB.setBackgroundColor(Color.LTGRAY);*/

    }

    // set essential component IDs
    private fun setComponentsId() {
        this.tableA?.id = 1
        this.horizontalScrollViewB?.id = 2
        this.scrollViewC?.id = 3
        this.scrollViewD?.id = 4
    }

    // this is just the sample data

    // set tags for some horizontal and vertical scroll view
    private fun setScrollViewAndHorizontalScrollViewTag() {
        this.horizontalScrollViewB?.setTag("horizontal scroll view b")
        this.horizontalScrollViewD?.setTag("horizontal scroll view d")

        this.scrollViewC?.setTag("scroll view c")
        this.scrollViewD?.setTag("scroll view d")
    }

    private fun addComponentToMainLayout() {

        // RelativeLayout params were very useful here
        // the addRule method is the key to arrange the components properly
        val componentB_Params = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        componentB_Params.addRule(RelativeLayout.RIGHT_OF, this.tableA?.getId()!!)

        val componentC_Params = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        componentC_Params.addRule(RelativeLayout.BELOW, this.tableA?.getId()!!)

        val componentD_Params = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        componentD_Params.addRule(RelativeLayout.RIGHT_OF, this.scrollViewC?.getId()!!)
        componentD_Params.addRule(RelativeLayout.BELOW, this.horizontalScrollViewB?.getId()!!)

        // 'this' is a relative layout,
        // we extend this table layout as relative layout as seen during the creation of this class
        this.addView(this.tableA)
        this.addView(this.horizontalScrollViewB, componentB_Params)
        this.addView(this.scrollViewC, componentC_Params)
        this.addView(this.scrollViewD, componentD_Params)

    }
    private fun addTableRowToTableA() {
        this.tableA?.addView(this.componentATableRow())
    }
    // generate table row of table B
    fun componentBTableRow(): TableRow {

        val componentBTableRow = TableRow(this.context)
        val headerFieldCount = this.headers.size

        val params =
            TableRow.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        params.setMargins(2, 0, 0, 0)

        for (x in 0 until headerFieldCount - 1) {
            val textView = this.headerTextView(this.headers[x + 1])
            textView.setLayoutParams(params)
            componentBTableRow.addView(textView)
        }

        return componentBTableRow
    }
    private fun addTableRowToTableB() {
        this.tableB?.addView(this.componentBTableRow())
    }
    // generate table row of table A
    fun componentATableRow(): TableRow {

        val componentATableRow = TableRow(this.context)
        val textView = this.headerTextView(this.headers[0])
        componentATableRow.addView(textView)

        return componentATableRow
    }
    fun taleRowForTableD(sampleObject: KeranjangModel): TableRow {
        val taleRowForTableD = TableRow(this.context)

        val loopCount = (this.tableB?.getChildAt(0) as TableRow).childCount
        val info = arrayOf<String>(
            sampleObject.header2.toString(),
            sampleObject.header3.toString(),
            sampleObject.header4.toString(),
            sampleObject.header5.toString(),
            sampleObject.header6.toString(),
            sampleObject.header7.toString(),
            sampleObject.header8.toString(),
            sampleObject.header9.toString()
        )

        for (x in 0 until loopCount) {
            val params = TableRow.LayoutParams(headerCellsWidth[x + 1], RelativeLayout.LayoutParams.MATCH_PARENT)
            params.setMargins(2, 2, 0, 0)

            val textViewB = this.bodyTextView(info[x])
            taleRowForTableD.addView(textViewB, params)
        }

        return taleRowForTableD

    }
    // a TableRow for table C
    fun tableRowForTableC(sampleObject: KeranjangModel): TableRow {

        val params = TableRow.LayoutParams(this.headerCellsWidth[0], RelativeLayout.LayoutParams.MATCH_PARENT)
        params.setMargins(0, 2, 0, 0)

        val tableRowForTableC = TableRow(this.context)
        val textView = this.bodyTextView(sampleObject.header1.toString())
        tableRowForTableC.addView(textView, params)

        return tableRowForTableC
    }

    // generate table row of table C and table D
    private fun generateTableC_AndTable_B() {

        // just seeing some header cell width
        for (x in 0 until this.headerCellsWidth.size) {
            Log.v("TableMainLayout.java", this.headerCellsWidth[x].toString() + "")
        }

        for (sampleObject in this.sampleObjects) {

            val tableRowForTableC = this.tableRowForTableC(sampleObject)
            val taleRowForTableD = this.taleRowForTableD(sampleObject)

            tableRowForTableC.setBackgroundColor(Color.LTGRAY)
            taleRowForTableD.setBackgroundColor(Color.LTGRAY)

            this.tableC?.addView(tableRowForTableC)
            this.tableD?.addView(taleRowForTableD)

        }
    }


    fun getTableRowHeaderCellWidth() {
        val tableAChildCount = (this.tableA?.getChildAt(0) as TableRow).childCount
        val tableBChildCount = (this.tableB?.getChildAt(0) as TableRow).childCount

        for (x in 0 until tableAChildCount + tableBChildCount) {
            if (x == 0) {
                this.headerCellsWidth[x] = this.viewWidth((this.tableA?.getChildAt(0) as TableRow).getChildAt(x))
            } else {
                this.headerCellsWidth[x] = this.viewWidth((this.tableB?.getChildAt(0) as TableRow).getChildAt(x - 1))
            }
        }
    }
    // resize body table row height
    fun resizeBodyTableRowHeight() {

        val tableC_ChildCount = this.tableC?.getChildCount()

        for (x in 0 until tableC_ChildCount!!) {

            val productNameHeaderTableRow = this.tableC?.getChildAt(x) as TableRow
            val productInfoTableRow = this.tableD?.getChildAt(x) as TableRow

            val rowAHeight = this.viewHeight(productNameHeaderTableRow)
            val rowBHeight = this.viewHeight(productInfoTableRow)

            val tableRow = if (rowAHeight < rowBHeight) productNameHeaderTableRow else productInfoTableRow
            val finalHeight = if (rowAHeight > rowBHeight) rowAHeight else rowBHeight

            this.matchLayoutHeight(tableRow, finalHeight)
        }

    }
    // check if the view has the highest height in a TableRow
    private fun isTheHeighestLayout(tableRow: TableRow, layoutPosition: Int): Boolean {

        val tableRowChildCount = tableRow.childCount
        var heighestViewPosition = -1
        var viewHeight = 0

        for (x in 0 until tableRowChildCount) {
            val view = tableRow.getChildAt(x)
            val height = this.viewHeight(view)

            if (viewHeight < height) {
                heighestViewPosition = x
                viewHeight = height
            }
        }

        return heighestViewPosition == layoutPosition
    }
    // match all height in a table row
    // to make a standard TableRow height
    private fun matchLayoutHeight(tableRow: TableRow, height: Int) {
        val tableRowChildCount = tableRow.childCount

        // if a TableRow has only 1 child
        if (tableRow.childCount === 1) {

            val view = tableRow.getChildAt(0)
            val params = view.layoutParams as TableRow.LayoutParams
            params.height = height - (params.bottomMargin + params.topMargin)

            return
        }

        // if a TableRow has more than 1 child
        for (x in 0 until tableRowChildCount) {

            val view = tableRow.getChildAt(x)

            val params = view.layoutParams as TableRow.LayoutParams

            if (!isTheHeighestLayout(tableRow, x)) {
                params.height = height - (params.bottomMargin + params.topMargin)
                return
            }
        }
    }
    // read a view's height
    private fun viewHeight(view: View): Int {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        return view.getMeasuredHeight()
    }
    // read a view's width
    private fun viewWidth(view: View): Int {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        return view.getMeasuredWidth()
    }

    fun resizeHeaderHeight() {
        val productNameHeaderTableRow = this.tableA?.getChildAt(0) as TableRow
        val productInfoTableRow = this.tableB?.getChildAt(0) as TableRow

        val rowAHeight = this.viewHeight(productNameHeaderTableRow)
        val rowBHeight = this.viewHeight(productInfoTableRow)

        val tableRow = if (rowAHeight < rowBHeight) productNameHeaderTableRow else productInfoTableRow
        val finalHeight = if (rowAHeight > rowBHeight) rowAHeight else rowBHeight

        this.matchLayoutHeight(tableRow, finalHeight)
    }

    /*CELL*/
    // table cell standard TextView
    fun bodyTextView(label: String): TextView {

        val bodyTextView = TextView(this.context)
        bodyTextView.setBackgroundColor(Color.WHITE)
        bodyTextView.text = label
        bodyTextView.gravity = Gravity.CENTER
        bodyTextView.setPadding(5, 5, 5, 5)

        return bodyTextView
    }
    // header standard TextView
    fun headerTextView(label: String): TextView {

        val headerTextView = TextView(this.context)
        headerTextView.setBackgroundColor(Color.WHITE)
        headerTextView.text = label
        headerTextView.gravity = Gravity.CENTER
        headerTextView.setPadding(5, 5, 5, 5)

        return headerTextView
    }
    /*END CELL*/

    // horizontal scroll view custom class
    internal inner class MyHorizontalScrollView(context: Context) : HorizontalScrollView(context) {

        override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
            val tag = this.tag as String

            if (tag.equals("horizontal scroll view b", ignoreCase = true)) {
                horizontalScrollViewD?.scrollTo(l, 0)
            } else {
                horizontalScrollViewB?.scrollTo(l, 0)
            }
        }

    }

    // scroll view custom class
    internal inner class MyScrollView(context: Context) : ScrollView(context) {

        override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {

            val tag = this.tag as String

            if (tag.equals("scroll view c", ignoreCase = true)) {
                scrollViewD?.scrollTo(0, t)
            } else {
                scrollViewC?.scrollTo(0, t)
            }
        }
    }


}