package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtWeight: EditText=findViewById(R.id.edtWeight)
        val edtHeightFt: EditText=findViewById(R.id.edtHeightFt)
        val edtHeightIn: EditText=findViewById(R.id.edtHeightIn)
        val txtResult: TextView=findViewById(R.id.txtResult)
        val btnCalculate: Button=findViewById(R.id.btnCalculate)
        val txtBmi: TextView=findViewById(R.id.txtBmi)
        val llMain: LinearLayout=findViewById(R.id.llMain)


        btnCalculate.setOnClickListener {
            if(!edtWeight.text.toString().equals("")&&!edtHeightFt.text.toString().equals("")&& !edtHeightIn.text.toString().equals("")){
                 val wt=(edtWeight.text.toString()).toDouble()
                 val htFeet=(edtHeightFt.text.toString()).toDouble()
                 val htInch= (edtHeightIn.text.toString()).toDouble()


                val totalInch= (htFeet*12)+htInch
                val totalCM = totalInch*2.54

                val totalM=totalCM/100

                val bmi= wt/(totalM*totalM)


                txtBmi.text="${bmi.toInt()}"



                when {
                    bmi>25 -> {
                        Toast.makeText(this@MainActivity,R.string.strOver, Toast.LENGTH_LONG).show()
                        txtResult.text=resources.getString(R.string.strOver)
                        llMain.setBackgroundColor(resources.getColor(R.color.red))


                    }
                    bmi<18 -> {
                        Toast.makeText(this@MainActivity, R.string.strUnder, Toast.LENGTH_LONG).show()
                        txtResult.text=resources.getString(R.string.strUnder)
                        llMain.setBackgroundColor(resources.getColor(R.color.yellow))


                    }
                    else -> {
                        Toast.makeText(this@MainActivity, R.string.strFit, Toast.LENGTH_LONG).show()
                        txtResult.text=resources.getString(R.string.strFit)
                        llMain.setBackgroundColor(resources.getColor(R.color.green))

                    }
                }
            }else{
                Toast.makeText(this@MainActivity,"Please fill all required details", Toast.LENGTH_LONG).show()

        }



        }
    }
}
