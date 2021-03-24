package kr.co.mvvmsample.model

import java.util.*

class Database(private val databaseListener: DatabaseListener) {
    private val personList = ArrayList<Person>()

    init {
        for (index in 0..99) {
            personList.add(Person(index.toLong(), String.format("Item %d", index)))
        }
    }

    fun add(person: Person) {
        personList.add(0, person)
        notifyChange()
    }

    fun remove(person: Person) {
        val position = personList.indexOf(person)
        personList.removeAt(position)
        notifyChange()
    }

    private fun notifyChange() {
        databaseListener.onChanged()
    }

    fun getPersonList(): List<Person> {
        return personList
    }

    interface DatabaseListener {
        fun onChanged()
    }


}