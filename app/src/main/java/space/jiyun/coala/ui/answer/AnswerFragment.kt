package space.jiyun.coala.ui.answer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import space.jiyun.coala.R
import space.jiyun.coala.databinding.AnswerFragmentBinding

class AnswerFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding : AnswerFragmentBinding

    private lateinit var viewModel: AnswerViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.answer_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AnswerViewModel::class.java)

    }

    companion object {
        fun newInstance() = AnswerFragment()
    }
}