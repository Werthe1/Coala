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
import space.jiyun.coala.R
import space.jiyun.coala.data.Question
import space.jiyun.coala.databinding.QuestionFragmentBinding
import space.jiyun.coala.util.setupActionBar
import java.util.*


class QuestionFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: QuestionFragmentBinding

    private lateinit var viewModel: QuestionViewModel
    val adapter = QuestionItemAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.question_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)

        (activity as AppCompatActivity).setupActionBar(R.id.toolbar_main) {
            title = getString(R.string.title_my_q)
        }

        setUpRecyclerView()
    }


    private fun setUpRecyclerView() {
        with(binding.recyclerQuestion) {
            setHasFixedSize(true)

            layoutManager = LinearLayoutManager(this@QuestionFragment.context)
            adapter = this@QuestionFragment.adapter.apply {
                for (i in 1..10) {
                    addItem(Question(1, "코틀린은 왜 코틀린 인가요?? 자바는 왜 자바인가요?? 알고싶다", "이지윤", "dd", Date(), i%3, true , 3))
                }
            }
        }
    }

    companion object {
        fun newInstance() = QuestionFragment()
    }
}