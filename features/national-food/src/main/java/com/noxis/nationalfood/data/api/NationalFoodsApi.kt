package com.noxis.nationalfood.data.api

import co.infinum.retromock.meta.Mock
import co.infinum.retromock.meta.MockResponse
import com.noxis.nationalfood.data.model.NationalFoodsContentDto
import retrofit2.http.GET


interface NationalFoodsApi {

    @Mock
    @MockResponse(body = "mockApi/national_foods.json")
    @GET("/")
    suspend fun getAllNationalFoodsType(): NationalFoodsContentDto
}
