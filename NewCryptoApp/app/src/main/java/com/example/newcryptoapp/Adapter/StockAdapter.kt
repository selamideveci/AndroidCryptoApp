package com.example.newcryptoapp.Adapter

import android.graphics.Color
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.newcryptoapp.model.Model
import  androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newcryptoapp.databinding.ViewholderCryptoBinding
import com.example.newcryptoapp.databinding.ViewholderStockBinding

class StockAdapter(private val dataList: ArrayList<Model>) :RecyclerView.Adapter<StockAdapter.ViewHolder>(){
    
    private val formatter=DecimalFormat("###,###,###,###.##")
        

    class ViewHolder(var binding: ViewholderStockBinding):RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockAdapter.ViewHolder {
        val binding=ViewholderStockBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StockAdapter.ViewHolder, position: Int) {
       val item=dataList[position]
        holder.binding.apply {
            cryptoNameText.text=item.name
            cryptoPriceText.text="$${formatter.format(item.price)}"
            changePercentText.text="${item.changePercent}%"
            sparkLayoutLine1.setData(item.lineData)


            val changeColor=when{
                item.changePercent>0-> Color.parseColor("#12c737")
                item.changePercent<0-> Color.parseColor("#ff0000")
                else ->Color.WHITE
            }
            changePercentText.setTextColor(changeColor)
            sparkLayoutLine1.sparkLineColor=changeColor


            val pickName=when (item.name){
                "NASDAQ100"->"stock_1"
                "S&P 500"-> "stock_2"
                "Dow Jones"->"stock_1"
                else->""

            }
            val drawableResourceId=holder.itemView.context.resources.getIdentifier(pickName,"drawable",holder.itemView.context.packageName)

            Glide.with(holder.itemView.context)
                .load(drawableResourceId)
                .into(logoImg2)
        }
    }



    override fun getItemCount():Int=dataList.size

}