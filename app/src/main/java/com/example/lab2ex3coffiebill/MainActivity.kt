package com.example.lab2ex3coffiebill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var quantity : Int = 0
        var price : Int = 0
        var addCream : String = "no"
        var addChocolate : String = "no"

        var btnMinus = findViewById<Button>(R.id.btnMinus)
        var btnAdd = findViewById<Button>(R.id.btnAdd)
        var btnOrder = findViewById<Button>(R.id.btnOrder)
        var lblQuantity = findViewById<TextView>(R.id.lblQuantity)
        var lblOrderDetail = findViewById<TextView>(R.id.lblOrderDetail)
        var chkCream = findViewById<CheckBox>(R.id.chkCream)
        var chkChocolate = findViewById<CheckBox>(R.id.chkChocolate)

        btnAdd.setOnClickListener(){
            var quan : Int = Integer.valueOf(lblQuantity.text.toString())
            quan += 1
            quantity = quan
            lblQuantity.text = quan.toString()
        }
        btnMinus.setOnClickListener(){
            var quan : Int = Integer.valueOf(lblQuantity.text.toString())
            quan -= 1
            quantity = quan
            lblQuantity.text = quan.toString()
        }
        chkCream.setOnCheckedChangeListener { _, isChecked ->
            addCream = if(isChecked) {
                "yes"
            } else {
                "no"
            }
        }
        chkChocolate.setOnCheckedChangeListener { _, isChecked ->
            addChocolate = if(isChecked) {
                "yes"
            } else {
                "no"
            }
        }

        btnOrder.setOnClickListener(){
            price = quantity.times(3)
            var orderDetail = """Add whipped cream? $addCream
            Add Chocolate? $addChocolate
            Quantity: $quantity
            Price: $$price.00
            THANK YOU!"""
            lblOrderDetail.text = orderDetail
            Toast.makeText(this,"Order Placed.",Toast.LENGTH_SHORT).show()
        }
    }
}