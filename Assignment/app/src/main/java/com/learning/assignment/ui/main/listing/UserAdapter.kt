package com.learning.assignment.ui.main.listing

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.learning.domain.model.User
import com.learning.assignment.R
import com.learning.assignment.databinding.ItemUserBinding


class OnClickListener(val clickListener: (user: User, imageView: ImageView) -> Unit) {
    fun onClick(user: User, imageView: ImageView) = clickListener(user, imageView)
}

class UserAdapter(
    private val context: Context,
    private val clickListener: OnClickListener
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var users = mutableListOf<User>()

    fun setAds(usersList: List<User>) {
        users.clear()
        users.addAll(usersList)
        notifyDataSetChanged()
    }

    fun getUserAtPosition(position: Int): User = users[position]

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class ViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.imageView.transitionName = user.id.toString()
            binding.cardView.setOnClickListener {
                clickListener.onClick(user, binding.imageView)
            }
            binding.title.text = user.login
            binding.nodeId.text = user.node_id

            val drawable = CircularProgressDrawable(context).apply {
                setColorSchemeColors(
                    R.color.purple_200,
                    R.color.purple_700,
                    R.color.purple_500
                )
                centerRadius = 30f
                strokeWidth = 5f
                start()
            }

            Glide
                .with(context)
                .load(user.avatar_url)
                .error(R.drawable.ic_default_ad)
                .centerCrop()
                .apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
                .placeholder(drawable)
                .into(binding.imageView)
        }
    }
}