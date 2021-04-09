package kr.co.mvvmsample.viewmodel

import androidx.databinding.BaseObservable
import kr.co.mvvmsample.model.Database
import kr.co.mvvmsample.model.Person
import java.util.*

class MainViewModel : BaseObservable(), Database.DatabaseListener {
    private val items: MutableList<Person> = ArrayList<Person>()
    private val database: Database = Database(this)

    fun load() {
        items.clear()
        items.addAll(database.getPersonList())
        notifyChange()  //data binding refresh
    }

    fun addPerson(person: Person) = database.add(person)
    fun removePerson(person: Person) = database.remove(person)
    fun getItems(): List<Person> = items

    override fun onChanged() = load()

}