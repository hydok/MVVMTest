package kr.co.mvvmsample

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.mvvmsample.model.Person
import kr.co.mvvmsample.view.MainAdapter

object MainCustomBinding {

    @BindingAdapter("items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: List<Person>) {
        val adapter: MainAdapter = recyclerView.adapter as MainAdapter
        adapter.setItems(items)
    }
}