package ru.graphorismo.randomdonut.data.api

import retrofit2.Call
import retrofit2.http.GET
import ru.graphorismo.randomdonut.data.model.DonutData

public interface DonutAPI {
    @GET("/randomdonut")
    suspend fun getRandomDonut(): String
}