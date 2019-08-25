package buu.informatics.s59160631.bookparking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.AbsListView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var praking = listOf<Car>(Car(),Car(),Car())
    var book = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prak1.setText("ว่าง")
        prak2.setText("ว่าง")
        prak3.setText("ว่าง")
        var set = listOf<Button>(findViewById(R.id.prak1), findViewById(R.id.prak2),findViewById(R.id.prak3))
        for (i in set){
            i.setOnClickListener{
                setCar(i)
            }
        }
        findViewById<Button>(R.id.update).setOnClickListener{inputCar()}
        findViewById<Button>(R.id.delete).setOnClickListener{deleteCar()}

    }
    fun setCar(view: Button){
        book = view.id.toString();
        when(view.id){
            R.id.prak1 -> {
                findViewById<TextView>(R.id.number).requestFocus()
                findViewById<TextView>(R.id.number).text = praking.get(0).number
                findViewById<TextView>(R.id.brand).text = praking.get(0).brand
                findViewById<TextView>(R.id.name).text = praking.get(0).name
            }
            R.id.prak2 -> {
                findViewById<TextView>(R.id.number).requestFocus()
                findViewById<TextView>(R.id.number).text = praking.get(1).number
                findViewById<TextView>(R.id.brand).text = praking.get(1).brand
                findViewById<TextView>(R.id.name).text = praking.get(1).name
            }
            R.id.prak3 -> {
                findViewById<TextView>(R.id.number).requestFocus()
                findViewById<TextView>(R.id.number).text = praking.get(2).number
                findViewById<TextView>(R.id.brand).text = praking.get(2).brand
                findViewById<TextView>(R.id.name).text = praking.get(2).name
            }
        }
    }
    fun inputCar(){
        if(book != ""){
            when (book){
                R.id.prak1.toString() -> {
                    praking[0].number = findViewById<TextView>(R.id.number).text.toString()
                    praking[0].brand = findViewById<TextView>(R.id.brand).text.toString()
                    praking[0].name = findViewById<TextView>(R.id.name).text.toString()
                    prak1.setText("ไม่ว่าง")
                }
                R.id.prak2.toString() -> {
                    praking[1].number = findViewById<TextView>(R.id.number).text.toString()
                    praking[1].brand = findViewById<TextView>(R.id.brand).text.toString()
                    praking[1].name = findViewById<TextView>(R.id.name).text.toString()
                    prak2.setText("ไม่ว่าง")
                }
                R.id.prak3.toString() -> {
                    praking[2].number = findViewById<TextView>(R.id.number).text.toString()
                    praking[2].brand = findViewById<TextView>(R.id.brand).text.toString()
                    praking[2].name = findViewById<TextView>(R.id.name).text.toString()
                    prak2.setText("ไม่ว่าง")
                }
            }
            Toast.makeText(this , "บันทึก" , Toast.LENGTH_SHORT).show()


        }else{
            Toast.makeText(this , "เลือกที่จอด" , Toast.LENGTH_SHORT).show()
        }

    }
    fun deleteCar() {
        when (book) {

            R.id.prak1.toString() -> {
                praking[0].number = ""
                praking[0].brand = ""
                praking[0].name = ""
            }
            R.id.prak2.toString() -> {
                praking[1].number = ""
                praking[1].brand = ""
                praking[1].name = ""
            }
            R.id.prak3.toString() -> {
                praking[2].number = ""
                praking[2].brand = ""
                praking[2].name = ""
            }

        }
        number.setText("")
        brand.setText("")
        name.setText("")


    }

}
