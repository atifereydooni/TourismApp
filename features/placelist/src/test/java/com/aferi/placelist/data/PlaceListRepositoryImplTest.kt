package com.aferi.placelist.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aferi.placelist.data.local.PlaceListLocalDataSource
import com.aferi.placelist.data.model.Place
import com.aferi.placelist.data.model.PlaceLocalModel
import com.aferi.placelist.data.remote.PlaceListRemoteDataSource
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
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class PlaceListRepositoryImplTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    private lateinit var placeListRepository: PlaceListRepositoryImpl

    @RelaxedMockK
    lateinit var placeListRemoteDataSource: PlaceListRemoteDataSource

    @RelaxedMockK
    lateinit var placeListLocalDataSource: PlaceListLocalDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testCoroutineDispatcher)
        placeListRepository =
            PlaceListRepositoryImpl(placeListRemoteDataSource, placeListLocalDataSource)
    }

    @Test
    fun `the response should be get successfully from Local when getPlaceList is called`() = runTest {
        // Given
        val places = listOf(
            PlaceLocalModel(
                id = 1,
                title = "",
                subtitle = "",
                description = "",
                imageUrl = "",
                rate = ""
            )
        )
        coEvery { placeListLocalDataSource.getPlaceList() } coAnswers { places }
        val mappedPlaces = places.map { place ->
            Place(
                id = place.id,
                title = place.title,
                subtitle = place.subtitle,
                description = place.description,
                imageUrl = place.imageUrl,
                rate = place.rate
            )
        }

        // When
        val result = placeListRepository.getPlaceList().first()

        // Then
        assertThat(result, `is`(Result.success(mappedPlaces)))
        coVerify {
            placeListLocalDataSource.getPlaceList()
        }
    }

    @Test
    fun `the response should be get successfully from Remote when getPlaceList is called`() = runTest {
        // Given
        coEvery { placeListLocalDataSource.getPlaceList() } coAnswers { listOf() }
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
        coEvery { placeListRemoteDataSource.getPlaceList() } coAnswers {
            flow {
                emit(Result.success(places))
            }
        }

        // When
        val result = placeListRepository.getPlaceList().first()

        // Then
        assertThat(result, `is`(Result.success(places)))
        coVerify {
            placeListLocalDataSource.getPlaceList()
        }
    }
}