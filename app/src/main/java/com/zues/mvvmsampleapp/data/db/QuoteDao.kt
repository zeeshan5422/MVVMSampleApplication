package com.zues.mvvmsampleapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zues.mvvmsampleapp.data.db.entities.CURRENT_USER_ID
import com.zues.mvvmsampleapp.data.db.entities.Quote
import com.zues.mvvmsampleapp.data.db.entities.User

/* ---  Created by akhtarz on 12/4/2019. ---*/
@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllQuotes(quotes : List<Quote>)

    @Query("SELECT * FROM Quote")
    fun getQuotes() : LiveData<List<Quote>>
}