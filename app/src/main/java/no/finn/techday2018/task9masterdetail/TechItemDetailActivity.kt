package no.finn.techday2018.task9masterdetail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_techitem_detail.*
import no.finn.techday2018.R

class TechItemDetailActivity : AppCompatActivity() {
    companion object {
        const val ARG_ITEM_ID = "1450"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_techitem_detail)
        setSupportActionBar(detail_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //This the activity we want to launch when clicking on a item in the list
        //In some way we need to know which item was clicked and retrieve it from the set of dummy items
        //Hint check the savedInstance
        //Show some info about the items
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
