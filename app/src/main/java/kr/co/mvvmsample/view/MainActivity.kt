package kr.co.mvvmsample.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.mvvmsample.HolderClickListener
import kr.co.mvvmsample.R
import kr.co.mvvmsample.databinding.ActivityMainBinding
import kr.co.mvvmsample.model.Person
import kr.co.mvvmsample.viewmodel.MainViewModel
import java.util.*

class MainActivity : BaseActivity(), HolderClickListener {


    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MainAdapter(this@MainActivity)
        }

        viewModel = MainViewModel()
        binding.viewModel = viewModel

        viewModel.load()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add("Add")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.addPerson(Person(System.currentTimeMillis(), String.format("New Item %d", Random().nextInt(1000))))
        return super.onOptionsItemSelected(item)
    }

    override fun onDeleteClick(person: Person) {
        viewModel.removePerson(person)
    }

}
