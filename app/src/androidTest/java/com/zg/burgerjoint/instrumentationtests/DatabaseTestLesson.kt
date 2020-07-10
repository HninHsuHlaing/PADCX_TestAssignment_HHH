package com.zg.burgerjoint.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.zg.burgerjoint.data.vos.BurgerVO
import com.zg.burgerjoint.persistence.BurgerJointDatabase
import com.zg.burgerjoint.persistence.daos.BurgerDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTestLesson {

    private lateinit var burgarDao : BurgerDao
    private  lateinit var db : BurgerJointDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,BurgerJointDatabase::class.java
        ).build()
        burgarDao = db.getBurgerDao()
    }

    @After
    fun closeDb(){
        db.close()
    }

    @Test
    fun insertIntoDataBaseTest(){
        val burgerone = BurgerVO()
        burgerone.burgerId = 1
        burgerone.burgerName = " Big Mac"
        burgerone.burgerImageUrl = " "
        burgerone.burgerDescription = " Big Mac Burger Description "
        burgarDao.insert(burgerone)
        assert(burgarDao.findBurgerById(burgerone.burgerId).value?.burgerId == burgerone.burgerId)
    }
}