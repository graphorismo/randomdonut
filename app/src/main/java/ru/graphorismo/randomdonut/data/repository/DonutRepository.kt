package ru.graphorismo.randomdonut.data.repository

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import ru.graphorismo.randomdonut.data.api.DonutAPI

class DonutRepository {

    private val donutApi: DonutAPI

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8100/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        donutApi = retrofit.create<DonutAPI>()
    }

    suspend fun getRandomDonut(): String {
        return donutApi.getRandomDonut()
    }



    companion object{
        private var repo: DonutRepository? = null

        fun init(){
            if(repo == null)
                repo = DonutRepository()
        }

        fun getInstance() : DonutRepository{
            if(repo != null){
                return repo!!
            }
            else{
                throw Exception("Cant get an instance of DonutRepository. It wasn't initialized.")
            }
        }

    }
}