package space.jiyun.coala.ui.answer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import space.jiyun.coala.R
import space.jiyun.coala.data.Answer
import space.jiyun.coala.databinding.AnswerFragmentBinding
import space.jiyun.coala.ui.answer.AnswerItemAdapter
import space.jiyun.coala.util.setupActionBar
import java.util.*

class AnswerFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding : AnswerFragmentBinding
    private lateinit var viewModel: AnswerViewModel

    private val mAdapter = AnswerItemAdapter()

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
            adapter = this@AnswerFragment.mAdapter.apply {
                for (i in 1..10) {
                    addItem(Answer(i, "코틀린은 왜 코틀린 인가요?? 자바는 왜 자바인가요?? 알고싶다", "이지윤", "정답은 어디에도 정해져 있지 않습니다.", Date(), true, i % 3))
                    addItem(Answer(i, "코틀린은 왜 코틀린 인가요?? 자바는 왜 자바인가요?? 알고싶다", "이지윤", "정답은 어디에도 정해져 있지 않습니다.", Date(), false, i % 3))
                }
            }
        }
    }

    companion object {
        fun newInstance() = AnswerFragment()
    }
}