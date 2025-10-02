package mendoza.omar.popcornfactory2_omarmendoza

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeliculaAdapter(private val peliculas: ArrayList<Pelicula>) : RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder>() {

    // Crea la vista para cada item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_movie, parent, false)
        return PeliculaViewHolder(view)
    }

    // Vincula los datos de la película a la vista
    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val pelicula = peliculas[position]
        holder.bind(pelicula)
    }

    // Obtiene el tamaño de la lista
    override fun getItemCount(): Int = peliculas.size

    // ViewHolder que maneja cada item
    inner class PeliculaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.image_movie_cell)
        private val titleTextView: TextView = itemView.findViewById(R.id.movie_title_cell)

        // Enlaza los datos de la película a la vista
        fun bind(pelicula: Pelicula) {
            imageView.setImageResource(pelicula.image) // Carga la imagen de la película
            titleTextView.text = pelicula.titulo // Asigna el título de la película

            imageView.setOnClickListener {
                // Acción cuando se hace clic en la imagen (por ejemplo, abrir detalles de la película)
                val context = itemView.context
                val intent = Intent(context, MovieDetail::class.java).apply {
                    putExtra("titulo", pelicula.titulo)
                    putExtra("image", pelicula.image)
                    putExtra("header", pelicula.header)
                    putExtra("sinopsis", pelicula.sinopsis)
                    putExtra("numberSeats", (20 - pelicula.seats.size))
                }
                context.startActivity(intent)
            }
        }
    }
}
