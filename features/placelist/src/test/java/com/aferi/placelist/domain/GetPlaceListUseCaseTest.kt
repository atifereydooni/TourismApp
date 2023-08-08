package com.aferi.placelist.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aferi.placelist.data.model.Place
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class GetPlaceListUseCaseTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    private lateinit var getPlaceListUseCase: GetPlaceListUseCase

    @RelaxedMockK
    lateinit var placeListRepository: PlaceListRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testCoroutineDispatcher)
        getPlaceListUseCase = GetPlaceListUseCase(placeListRepository)
    }

    @Test
    fun `the response should be get successfully when PlaceListRepository is called`() = runTest {
        // Given
        val places = listOf(
            Place(
                id = 1,
                title = "",
                subtitle = "",
                description = "",
                imageUrl = "",
                rate = ""
            )
        )
        coEvery { placeListRepository.getPlaceList() } coAnswers {
            flow {
                emit(Result.success(places))
            }
        }

        // When
        val result = getPlaceListUseCase.getPlaceList().first()

        // Then
        MatcherAssert.assertThat(result, CoreMatchers.`is`(Result.success(places)))
        coVerify {
            placeListRepository.getPlaceList()
        }
    }

}