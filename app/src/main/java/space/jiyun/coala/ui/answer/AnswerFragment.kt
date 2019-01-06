package space.jiyun.coala.ui.answer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults
import io.realm.Sort
import io.realm.kotlin.where
import space.jiyun.coala.R
import space.jiyun.coala.data.Answer
import space.jiyun.coala.data.Question
import space.jiyun.coala.databinding.AnswerFragmentBinding
import space.jiyun.coala.ui.answer.AnswerItemAdapter
import space.jiyun.coala.util.setupActionBar
import java.util.*

class AnswerFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: AnswerFragmentBinding
    private lateinit var viewModel: AnswerViewModel

    private val realm = Realm.getDefaultInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.answer_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AnswerViewModel::class.java)

        (activity as AppCompatActivity).setupActionBar(R.id.toolbar_main) {
            title = getString(R.string.title_my_a)
        }

        setUpRecyclerView()
    }


    private fun setUpRecyclerView() {
        with(binding.recyclerAnswer) {
            setHasFixedSize(true)

            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@AnswerFragment.context)
            adapter = AnswerItemAdapter(
                    realm.where<Answer>().findAll().sort(Answer::isAdopted.name, Sort.DESCENDING), true)
        }
    }

    override fun onStop() {
        super.onStop()

        realm.close()
    }

    companion object {
        fun newInstance() = AnswerFragment()
    }
}