package kr.co.mvvmsample

import kr.co.mvvmsample.model.Person

interface HolderClickListener {
    fun onDeleteClick(person: Person)
}