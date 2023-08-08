package com.aferi.placelist.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aferi.placelist.data.model.Place
import com.aferi.placelist.domain.GetPlaceListUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
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
class PlaceListViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    private lateinit var viewModel: PlaceListViewModel

    @RelaxedMockK
    private lateinit var getPlaceListUseCase: GetPlaceListUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testCoroutineDispatcher)
        viewModel = PlaceListViewModel(getPlaceListUseCase)
    }

    @Test
    fun `placeList should be get successfully when getPlaceList is called`() = runTest {
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
        coEvery { getPlaceListUseCase.getPlaceList() } coAnswers {
            flow {
                emit(Result.success(places))
            }
        }

        runBlocking {
            // When
            viewModel.getPlaceList()
            delay(1000)

            // Then
            MatcherAssert.assertThat(viewModel.places.first(), CoreMatchers.`is`(places))
            coVerify {
                getPlaceListUseCase.getPlaceList()
            }
        }
    }
}