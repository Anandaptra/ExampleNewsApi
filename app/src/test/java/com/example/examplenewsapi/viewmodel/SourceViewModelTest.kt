package com.example.examplenewsapi.viewmodel

import com.example.examplenewsapi.model.ResponseDataSource
import com.example.examplenewsapi.model.Source
import com.example.examplenewsapi.model.SourceX
import com.example.examplenewsapi.network.ApiService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Call

class SourceViewModelTest {
    lateinit var service : ApiService

    @Before
    fun setup() {
        service = mockk()
    }

    @Test
    fun testRetriveData() : Unit = runBlocking {
        val responseRetrive = mockk<Call<ResponseDataSource>>()

        every {
            runBlocking {
                service.getAllSources("sdcsdciducbsdkjcbuibu")
            }
        } returns responseRetrive
        val result = service.getAllSources("sdvbsds")

        verify {
            runBlocking {
                service.getAllSources("dssdvcsvd")
            }
        }
        assertEquals(result, responseRetrive)
    }
}