package com.example.criminalintent

import java.util.*

data class Crime(var id: UUID = UUID.randomUUID()) {
    var title: String = ""
    var date: Date = Date()
    var isSolved: Boolean = false
    constructor(id: UUID, title: String, date: Int, isSolved: Boolean) : this(id){
        this.title = title
        this.date = Date()
        this.id = id
        this.isSolved = isSolved
    }
}