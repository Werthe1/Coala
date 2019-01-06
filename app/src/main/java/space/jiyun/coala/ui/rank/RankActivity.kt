package space.jiyun.coala.ui.rank

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.Realm
import io.realm.Sort
import io.realm.kotlin.where
import space.jiyun.coala.R
import space.jiyun.coala.data.User
import space.jiyun.coala.databinding.RankActivityBinding
import space.jiyun.coala.ui.writequestion.WriteQuestionActivity
import space.jiyun.coala.util.setupActionBar

class RankActivity : AppCompatActivity() {

    private lateinit var binding: RankActivityBinding

    private val realm = Realm.getDefaultInstance()
    private lateinit var anim: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.rank_activity)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS) //for transparent statusBar.

        setupActionBar(R.id.toolbar_rank) {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_back_white_16dp)
            setDisplayShowTitleEnabled(true)
        }

        setUpRecyclerView()
        setUpBackgroundAnim()
    }

    private fun setUpBackgroundAnim() {
        anim = (binding.containerRank.background as AnimationDrawable).apply {
            setEnterFadeDuration(2000)
            setExitFadeDuration(2000)

            start()
        }
    }

    private fun setUpRecyclerView() {
        binding.recyclerRank.apply {
            setHasFixedSize(true)

            layoutManager = LinearLayoutManager(this@RankActivity)
            adapter = RankAdapter().apply {
                addItems(realm.where<User>().between(User::rank.name, 4, 100)
                        .sort(User::rank.name, Sort.ASCENDING).findAll()) //find 1~100 rank


                clickSubject.subscribe {
                    with(AlertDialog.Builder(this@RankActivity)) {
                        setMessage(String.format(getString(R.string.msg_rank), it.rank, it.name))
                        setPositiveButton(R.string.alert_yes){ _, _ ->
                            startActivity(Intent(this@RankActivity, WriteQuestionActivity::class.java))
                        }
                        create()
                    }.show()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
            when (item.itemId) {
                android.R.id.home -> {
                    finish()
                    true
                }
                else -> false
            }

    override fun onDestroy() {
        super.onDestroy()

        realm.close()
    }

    override fun onResume() {
        super.onResume()

        anim.start()
    }


    override fun onStop() {
        super.onStop()

        anim.stop()
    }

}
