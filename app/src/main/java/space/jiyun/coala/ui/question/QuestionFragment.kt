package space.jiyun.coala.ui.question

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.Realm
import io.realm.Sort
import io.realm.kotlin.where
import space.jiyun.coala.R
import space.jiyun.coala.data.Question
import space.jiyun.coala.databinding.QuestionFragmentBinding
import space.jiyun.coala.util.setupActionBar
import java.util.*


class QuestionFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: QuestionFragmentBinding

    private lateinit var viewModel: QuestionViewModel

    private val realm = Realm.getDefaultInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.question_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)

        (activity as AppCompatActivity).setupActionBar(R.id.toolbar_main) {
            title = getString(R.string.title_question)
        }

        setUpRecyclerView()
    }


    private fun setUpRecyclerView() {
        with(binding.recyclerQuestion) {
            setHasFixedSize(true)

            layoutManager = LinearLayoutManager(this@QuestionFragment.context)
            adapter = QuestionItemAdapter(
                realm.where<Question>().findAll().sort(Question::date.name, Sort.DESCENDING), true)
        }
    }

    override fun onStop() {
        super.onStop()

        realm.close()
    }

    companion object {
        fun newInstance() = QuestionFragment()
    }
}