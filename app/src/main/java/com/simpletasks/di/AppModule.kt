package com.simpletasks.di

import android.content.Context
import com.simpletasks.data.localdb.AppDatabase
import com.simpletasks.data.localdb.dao.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context) : AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideTasksDao(appDatabase: AppDatabase) : TaskDao{
        return appDatabase.tasksDao()
    }
}