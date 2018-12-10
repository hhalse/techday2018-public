package no.finn.techday2018.masterDetail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_techitem_detail.*
import no.finn.techday2018.R
import no.finn.techday2018.masterDetail.dummy.DummyContent

class TechItemDetailActivity : AppCompatActivity() {
    companion object {
        const val ARG_ITEM_ID = "1450"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_techitem_detail)
        setSupportActionBar(detail_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            //Get the item id and retrieve the item from the static dummy items
            val itemId = intent.getStringExtra(ARG_ITEM_ID)

            //Show some info about the items
            techitem_detail.text = DummyContent.ITEMS[itemId.toInt()].details
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                navigateUpTo(Intent(this, TechItemListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
