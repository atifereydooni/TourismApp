package com.aferi.placelist.domain

import javax.inject.Inject

class GetPlaceListUseCase @Inject constructor(
    private val tourismRepository: TourismRepository
) {
}