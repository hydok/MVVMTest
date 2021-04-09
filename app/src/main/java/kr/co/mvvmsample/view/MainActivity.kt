package kr.co.mvvmsample.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.mvvmsample.HolderClickListener
import kr.co.mvvmsample.R
import kr.co.mvvmsample.databinding.ActivityMainBinding
import kr.co.mvvmsample.model.Person
import kr.co.mvvmsample.viewmodel.MainViewModel
import kr.co.mvvmsample.viewmodel.TestViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.getViewModel
import java.util.*

class MainActivity : BaseActivity(), HolderClickListener {


    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    private val viewModel: MainViewModel by inject()
    private val testViewModel : TestViewModel by lazy {getViewModel()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MainAdapter(this@MainActivity)
        }

        //viewModel = MainViewModel()
        binding.viewModel = viewModel
        viewModel.load()

        testViewModel.data.observe(this,{
            Toast.makeText(this,"$it",Toast.LENGTH_SHORT).show()
        })
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
