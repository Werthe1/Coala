package space.jiyun.coala.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import io.realm.Realm
import io.realm.Sort
import io.realm.kotlin.where
import space.jiyun.coala.R
import space.jiyun.coala.data.Question
import space.jiyun.coala.data.addUser
import space.jiyun.coala.databinding.HomeFragmentBinding
import java.util.*

class HomeFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: HomeViewModel

    private val realm = Realm.getDefaultInstance()

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
            adapter = HomeItemAdapter(realm.where<Question>().findAll().sort(Question::date.name, Sort.DESCENDING), true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        realm.close()
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
