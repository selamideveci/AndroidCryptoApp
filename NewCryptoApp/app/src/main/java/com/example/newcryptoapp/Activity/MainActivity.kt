package com.example.newcryptoapp.Activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newcryptoapp.Adapter.CryptoAdapter
import com.example.newcryptoapp.Adapter.StockAdapter
import com.example.newcryptoapp.databinding.ActivityMainBinding
import com.example.newcryptoapp.model.Model

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val lineData= arrayListOf(1000,1100,1200,1100)
    private val lineData2= arrayListOf(2100,2000,1900,2000)
    private val lineData3= arrayListOf(900,1100,1200,1150)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS

        )
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor= Color.WHITE
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_VISIBLE

        cryptoList()
        stockList()
    }

    private fun stockList() {
        binding.stockView.layoutManager=
            LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        val  domainArrayList= arrayListOf(
            Model("NASDAQ100","BTC",80000.12,9.12,lineData,1234.12,0.123),
            Model("S&P 500","ETH",3400.12,8.12,lineData2,2314.12,0.223),
            Model("Dow Jones","TRX",80000.12,1.12,lineData3,234.12,0.023)
        )
        binding.stockView.adapter=StockAdapter(domainArrayList)
    }

    private fun cryptoList(){
        binding.cyrptoView.layoutManager=
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val  domainArrayList= arrayListOf(
            Model("bitcoin","BTC",80000.12,9.12,lineData,1234.12,0.123),
            Model("etherium","ETH",3400.12,8.12,lineData2,2314.12,0.223),
            Model("trox","TRX",80000.12,1.12,lineData3,234.12,0.023)
        )
        binding.cyrptoView.adapter=CryptoAdapter(domainArrayList)


    }


}