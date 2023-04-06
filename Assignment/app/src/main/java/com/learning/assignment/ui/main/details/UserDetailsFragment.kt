package com.learning.assignment.ui.main.details
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.learning.assignment.R
import com.learning.assignment.databinding.DetailsFragmentBinding
import com.learning.assignment.ui.main.base.BaseFragment
import com.learning.domain.model.User
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs

class UserDetailsFragment : BaseFragment<DetailsFragmentBinding, UserDetailsViewModel>() {
    override fun setupViewBinding(view: View): DetailsFragmentBinding {
        return DetailsFragmentBinding.bind(view)
    }

    override fun setupViewModel(): UserDetailsViewModel {
        val viewModel: UserDetailsViewModel by viewModels()
        return viewModel
    }

    override val layoutId: Int
        get() = R.layout.details_fragment

    override fun onViewCreated(inflater: LayoutInflater, view: View, savedInstanceState: Bundle?) {
        val args: UserDetailsFragmentArgs by navArgs()
        val user = args.user
        viewBinding.titleTv.text = user.login
        viewBinding.typeTv.text = user.type
        viewBinding.nodeIdTv.text = user.node_id
        setImage(user)
    }

    private fun setImage(user: User) {
        val drawable = CircularProgressDrawable(requireContext())
        drawable.setColorSchemeColors(
            R.color.purple_200,
            R.color.purple_700,
            R.color.purple_500
        )
        drawable.centerRadius = 30f
        drawable.strokeWidth = 5f
        drawable.start()
        Glide.with(requireContext())
            .load(user.avatar_url)
            .error(R.drawable.ic_default_ad)
            .placeholder(drawable)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(viewBinding.imageView)
    }
}
