package mendoza.omar.popcornfactory2_omarmendoza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_detail)

        var infoPelicula = intent.extras
        var ns= 0;
        var id= -1;



        if (infoPelicula != null) {


            ns = infoPelicula.getInt("numberSeats")
            title = infoPelicula.getString("titulo")
            findViewById<android.widget.ImageView>(R.id.iv_pelicula_imagen).setImageResource(infoPelicula.getInt("header"))
            findViewById<android.widget.TextView>(R.id.tv_nombre_pelicula).setText(infoPelicula.getString("titulo"))
            findViewById<android.widget.TextView>(R.id.tv_pelicula_desc).setText(infoPelicula.getString("sinopsis"))
            findViewById<android.widget.TextView>(R.id.seatsLeft).setText("$ns seats available")
            id = infoPelicula.getInt("pos")


            findViewById<TextView>(R.id.tv_pelicula_desc).movementMethod = android.text.method.ScrollingMovementMethod()

        }

        val buyTickets = findViewById<Button>(R.id.buyTickets)

        if(ns==0){
            buyTickets.isEnabled = false;
        }else{
            buyTickets.isEnabled = true;
            buyTickets.setOnClickListener(){
            val intent = Intent(this, SeatSelection::class.java)

            intent.putExtra("movie", id)
            intent.putExtra("name", title)
            this.startActivity(intent)
            }








        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}