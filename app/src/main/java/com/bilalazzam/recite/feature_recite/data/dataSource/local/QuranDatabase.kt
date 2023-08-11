package com.bilalazzam.recite.feature_recite.data.dataSource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bilalazzam.recite.feature_recite.domain.model.entity.*

@Database(entities = [Ayah::class], version = 1)
abstract class QuranDatabase : RoomDatabase() {
    abstract val quranDao: QuranDao

    companion object {
        fun quranDatabaseInstance(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                QuranDatabase::class.java,
                "quran.db"
            )
                .createFromAsset("quran/databases/quran.db")
                .allowMainThreadQueries()
                .build()
    }
}