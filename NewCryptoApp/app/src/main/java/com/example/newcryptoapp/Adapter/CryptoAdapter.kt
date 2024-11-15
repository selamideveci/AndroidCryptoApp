package com.example.newcryptoapp.Adapter

import android.graphics.Color
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.newcryptoapp.model.Model
import  androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newcryptoapp.databinding.ViewholderCryptoBinding

class CryptoAdapter(private val dataList: ArrayList<Model>) :RecyclerView.Adapter<CryptoAdapter.ViewHolder>(){
    
    private val formatter=DecimalFormat("###,###,###,###.##")
        

    class ViewHolder(var binding: ViewholderCryptoBinding):RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoAdapter.ViewHolder {
        val binding=ViewholderCryptoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoAdapter.ViewHolder, position: Int) {
       val item=dataList[position]
        holder.binding.apply {
            cryptoNameText2.text=item.name
            cryptoPriceText2.text="$${formatter.format(item.price)}"
            cryptoPercentText2.text="${item.changePercent}%"
            propertySizeText.text="${item.propertySize}${item.symbol}"
            propertyAmountText.text="${formatter.format(item.propertyAmount)}"
            sparkLineLayout2.setData(item.lineData)


            val changeColor=when{
                item.changePercent>0-> Color.parseColor("#12c737")
                item.changePercent<0-> Color.parseColor("#ff0000")
                else ->Color.WHITE
            }
            cryptoPercentText2.setTextColor(changeColor)
            sparkLineLayout2.sparkLineColor=changeColor

            val drawableResourceId=holder.itemView.context.resources.getIdentifier(item.name,"drawable",holder.itemView.context.packageName)

            Glide.with(holder.itemView.context)
                .load(drawableResourceId)
                .into(logoImg2)
        }
    }



    override fun getItemCount():Int=dataList.size

}