package example.com.yasma.ui.home.fragment.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import example.com.yasma.R
import example.com.yasma.databinding.PostsFragmentBinding
import example.com.yasma.ui.base.BaseFragment
import example.com.yasma.ui.comments.CommentsActivity
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 18/09/2019.
 */
class PostsFragment : BaseFragment(), PostsContract.View {

    private lateinit var mBinding: PostsFragmentBinding

    lateinit var mPresenter: PostsContract.Presenter<PostsContract.View>
        @Inject set

    lateinit var mAdapter: PostsAdapter
        @Inject set

    companion object {
        fun newInstance() = PostsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.posts_fragment, container, false)
        getActivityComponent()?.inject(this)

        mPresenter.onAttach(this)
        return mBinding.root

    }

    override fun setUpRecyclerView() {

        with(mBinding.recyclerView){
            if (adapter == null)
                layoutManager = LinearLayoutManager(activity?.applicationContext)

            visibility = View.VISIBLE
            adapter = mAdapter

            hideProgressView()
        }
    }


    override fun hideProgressView() {
        mBinding.progressBar.visibility = View.GONE
    }

    override fun launchCommentsActivity(postId: Int) {
        startActivity(activity?.applicationContext?.let { CommentsActivity.startActivity(it, postId) })
    }
}