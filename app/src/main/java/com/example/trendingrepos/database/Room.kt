package com.example.trendingrepos.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RepositoryDatabase::class], version = 1, exportSchema = false)
abstract class RepositoryRoomDatabase : RoomDatabase() {

    abstract val repositoryDoa: RepositoryDoa

    companion object {
        private var INSTANCE: RepositoryRoomDatabase? = null

        fun getInstance(context: Context): RepositoryRoomDatabase {
            synchronized(context) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RepositoryRoomDatabase::class.java,
                        "trending_repository_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }
}