package kr.co.mvvmsample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.mvvmsample.HolderClickListener
import kr.co.mvvmsample.databinding.ViewMainBinding
import kr.co.mvvmsample.model.Person
import java.util.*

class MainAdapter(private val holderClickListener: HolderClickListener) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var items: List<Person> = ArrayList()
    private lateinit var binding: ViewMainBinding

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MainViewHolder {
        binding = ViewMainBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(mainViewHolder: MainViewHolder, position: Int) {
        mainViewHolder.setPerson(items[position])
    }

    fun setItems(items: List<Person>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItems(): List<Person> {
        return items
    }


    inner class MainViewHolder(private val viewBinding: ViewMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private var person: Person? = null

        init {
            viewBinding.delete.setOnClickListener {
                person?.let { holderClickListener.onDeleteClick(it) }
            }
        }

        fun setPerson(person: Person) {
            this.person = person
            viewBinding.name.text = person.name
        }
    }

}