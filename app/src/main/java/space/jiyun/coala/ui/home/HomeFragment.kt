package space.jiyun.coala.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import space.jiyun.coala.R
import space.jiyun.coala.data.Question
import space.jiyun.coala.databinding.HomeFragmentBinding
import java.util.*

class HomeFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: HomeViewModel

    private val mAdapter = HomeItemAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        binding.viewmodel = viewModel

        setUpRecyclerView()
    }


    private fun setUpRecyclerView() {
        with(binding.recyclerHome) {
            setHasFixedSize(true)

            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@HomeFragment.context)
            adapter = this@HomeFragment.mAdapter.apply {
                for (i in 1..10) {
                    val isLike = if (i % 3== 0) true else false

                    addItem(Question(1, "코틀린은 왜 코틀린 인가요?? 자바는 왜 자바인가요?? 알고싶다", "이지윤", "dd", Date(), i%3, isLike , 3))
                }
            }
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
