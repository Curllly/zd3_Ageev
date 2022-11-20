package com.example.criminalintent

import android.arch.lifecycle.LiveData
import android.content.Context
import androidx.room.Room
import com.example.criminalintent.database.CrimeDatabase
import java.util.*

class CrimeRepository private constructor(context: Context) {
    private val database: CrimeDatabase = Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()

    fun getCrimes(): LiveData<List<Crime>> = crimeDao.getCrimes()

    fun getCrime(id: UUID): LiveData<Crime?> = crimeDao.getCrime(id)

    companion object {
        private var INSTANCE: CrimeRepository? = null
    }
    fun initialize(context: Context) {
        if (INSTANCE == null) {
            INSTANCE = CrimeRepository(context)
        }
    }
    fun get(): CrimeRepository {
        return INSTANCE?: throw IllegalStateException("CrimeRepository must be initialized")
    }
}