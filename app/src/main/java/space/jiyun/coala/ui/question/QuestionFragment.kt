package space.jiyun.coala.ui.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import space.jiyun.coala.R
import space.jiyun.coala.databinding.QuestionFragmentBinding


class QuestionFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: QuestionFragmentBinding

    private lateinit var viewModel: QuestionViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.question_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)

    }

    companion object {
        fun newInstance() = QuestionFragment()
    }
}