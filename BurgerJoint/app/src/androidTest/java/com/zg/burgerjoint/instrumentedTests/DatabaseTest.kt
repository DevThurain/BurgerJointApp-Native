package com.zg.burgerjoint.instrumentedTests

import android.content.Context
import android.util.Log
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
class DatabaseTest {
    private lateinit var mBurgerDao: BurgerDao
    private lateinit var mBurgerDatabase: BurgerJointDatabase

    @Before
    fun initDatabase(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        mBurgerDatabase = Room.inMemoryDatabaseBuilder(context, BurgerJointDatabase::class.java).build()

        mBurgerDao = mBurgerDatabase.getBurgerDao()
    }

    @After
    fun onFinished(){
        mBurgerDatabase.close()
    }

    @Test
    fun insertBurgerToDatabaseTest(){
        val testBurger = BurgerVO()
        testBurger.burgerName = "Chicken Burger"
        testBurger.burgerDescription = "This is chicken burger."
        testBurger.burgerImageUrl = "url"

        mBurgerDao.insertBurger(testBurger)
        assert(testBurger.burgerId == mBurgerDao.findBurgerById(testBurger.burgerId).value?.burgerId)

    }
}