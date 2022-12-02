package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val n1: TextView = findViewById(R.id.n1)
        val n2: TextView = findViewById(R.id.n2)
        val total: TextView = findViewById(R.id.total)
        val place_ord: Button = findViewById(R.id.place_ord)
        val add1: Button = findViewById(R.id.add1)
        val sub1: Button = findViewById(R.id.sub1)
        val add2: Button = findViewById(R.id.add2)
        val sub2: Button = findViewById(R.id.sub2)

        val main_spinner : Spinner = findViewById(R.id.main_spinner)
        val main_op = arrayOf("none","Pizza ($7)","Shawerma ($3)","Burger ($5)")
        val prices1 = arrayOf(0,7,3,5)
        main_spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,main_op)
        var ind1 = 0
        var num1 = 1
        n1.text = num1.toString()

        val drink_spinner : Spinner = findViewById(R.id.drink_spinner)
        val drink_op = arrayOf("none", "Pepsi ($1)", "7-up ($1)", "Juice ($2)")
        val prices2 = arrayOf(0,1,1,2)
        drink_spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,drink_op)
        var ind2 = 0
        var num2 = 1
        n2.text = num2.toString()

        main_spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                ind1 = p2
                total.text = (num1*prices1[ind1] + num2*prices2[ind2]).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

        drink_spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                ind2 = p2
                total.text = (prices1[ind1] + prices2[ind2]).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

        add1.setOnClickListener{ view ->
            num1++
            n1.text = num1.toString()
            total.text = (num1*prices1[ind1] + num2*prices2[ind2]).toString()
        }

        sub1.setOnClickListener{ view ->
            num1--
            if(num1<1) num1=1
            n1.text = num1.toString()
            total.text = (num1*prices1[ind1] + num2*prices2[ind2]).toString()
        }

        add2.setOnClickListener{ view ->
            num2++
            n2.text = num2.toString()
            total.text = (num1*prices1[ind1] + num2*prices2[ind2]).toString()
        }

        sub2.setOnClickListener{ view ->
            num2--
            if(num2<1) num2=1
            n2.text = num2.toString()
            total.text = (num1*prices1[ind1] + num2*prices2[ind2]).toString()
        }


        place_ord.setOnClickListener{ view ->
            Toast.makeText(this, "Order Placed, screen was reset", Toast.LENGTH_SHORT).show()
            main_spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,main_op)
            drink_spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,drink_op)

            num1 = 1
            n1.text = num1.toString()
            num2 = 1
            n2.text = num2.toString()


        }




    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.sf-> {
                var dialog_var = FeedbackDialog()
                dialog_var.show(supportFragmentManager, "Custom Dialog")
            }



            R.id.cll-> {


                Toast.makeText(this, "Number copied", Toast.LENGTH_SHORT).show()



            }
        }

        return super.onOptionsItemSelected(item)
    }
}