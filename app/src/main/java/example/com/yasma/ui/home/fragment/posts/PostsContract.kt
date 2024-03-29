package example.com.yasma.ui.home.fragment.posts

import example.com.yasma.data.network.model.response.PostsResponse
import example.com.yasma.ui.base.BaseFragmentContract

/**
 * Created by Abhijeet Raahi on 18/09/2019.
 */
interface PostsContract {

    interface View: BaseFragmentContract.View{

        fun setUpRecyclerView()

        fun hideProgressView()

        fun launchCommentsActivity(postId: Int)
    }

    interface Presenter<V: View>: BaseFragmentContract.Presenter<V>{

        fun getPostsData()

        fun getPostsResponse(): List<PostsResponse>

        fun itemClicked(position: Int)
    }
}