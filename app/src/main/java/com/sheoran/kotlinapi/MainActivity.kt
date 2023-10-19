package com.sheoran.kotlinapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sheoran.kotlinapi.RetrofitClient.initRetrofit
import com.sheoran.kotlinapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    lateinit var  binding: ActivityMainBinding
    var demoDataModel=ArrayList<DemoDataModelItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       val rerofitAPI= initRetrofit()!!.create(RetrofitAPI::class.java)
        rerofitAPI.demoData().enqueue(object :
            retrofit2.Callback<DemoDataModel?> {
            override fun onResponse(
                call: Call<DemoDataModel?>,
                response: Response<DemoDataModel?>
            ) {

                if (response.code()==200){
                    for (i in demoDataModel.withIndex()){
                        demoDataModel.add(response.body()!![i.index])
                    }
                    demoDataModel.addAll(response.body()!!)
                    binding.recycler.adapter=DemoAdapter(this@MainActivity,demoDataModel)
                    Toast.makeText(this@MainActivity,"${response.message()}",Toast.LENGTH_LONG).show()
                    Toast.makeText(this@MainActivity,"${response.body()}",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<DemoDataModel?>, t: Throwable) {
                Toast.makeText(this@MainActivity,"${t.message}",Toast.LENGTH_LONG).show()
            }


        })
    }
}