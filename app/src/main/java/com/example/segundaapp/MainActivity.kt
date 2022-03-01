package com.example.segundaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.segundaapp.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()

    }

    private fun initUI(){
        binding.button15.setOnClickListener {
            interfaceCalculateTip(.15)
            Toast.makeText( this, "Darás el 15% de propina", Toast.LENGTH_LONG).show()
        }
        binding.button20.setOnClickListener {
            interfaceCalculateTip(.20)
            Toast.makeText( this, "Darás el 20% de propina", Toast.LENGTH_LONG).show()
        }
        binding.button35.setOnClickListener {
            interfaceCalculateTip(.35)
            Toast.makeText( this, "Darás el 35% de propina", Toast.LENGTH_LONG).show()
        }
        binding.buttonRound.setOnClickListener {
            redondeo()
        }

    }
    private fun redondeo(){
        val roundTip = binding.totalTip.text.toString().toDouble()
        val roundTotal = binding.totalAmount.text.toString().toDouble()
        binding.totalTip.text= round(roundTip).toString()
        binding.totalAmount.text= round(roundTotal).toString()


    }
    private fun interfaceCalculateTip(percentage:Double){
        val amount= binding.editTextNumberDecimal.text.toString()
        val amountValue = amount.toDoubleOrNull()
        if(amountValue==null){
            binding.totalTip.text= "0.0"
            binding.totalAmount.text= "0.0"
            return
        }
        if(amountValue==0.0 || amountValue<0.0){
            Toast.makeText( this, "Error, número inválido", Toast.LENGTH_LONG).show()
        }
        binding.totalTip.text= "${ amountValue * percentage}"
        binding.totalAmount.text="${ amountValue * (1 + percentage)}"

    }
}