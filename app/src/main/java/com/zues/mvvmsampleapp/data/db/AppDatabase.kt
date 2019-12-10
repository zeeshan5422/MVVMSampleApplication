package com.zues.mvvmsampleapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zues.mvvmsampleapp.data.db.entities.Quote
import com.zues.mvvmsampleapp.data.db.entities.User

/* ---  Created by akhtarz on 12/4/2019. ---*/
@Database(
    entities = [User::class, Quote::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getQuoteDao(): QuoteDao

    companion object {

        @Volatile // This annotation means that this variable is immidiately visible to all the other threads.
        private var instance: AppDatabase? = null
        private val LOCK =
            Any() // This will make sure we will not create two instances of database.

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            )
                .build()

    }
}