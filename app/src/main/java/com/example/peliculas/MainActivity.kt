package com.example.peliculas

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.peliculas.api.RetrofitInstance
import com.example.peliculas.model.MovieResponse
import pl.droidsonroids.gif.GifImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var loadingGif: GifImageView
    private lateinit var noConnectionImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar imágenes
        loadingGif = findViewById(R.id.loadingGif)
        noConnectionImage = findViewById(R.id.noConnectionImage)

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Adaptador
        movieAdapter = MovieAdapter()
        recyclerView.adapter = movieAdapter

        // Obtener datos de la API
        fetchMovies()
    }

    private fun fetchMovies() {
        // Mostrar gif de carga y ocultar la imagen de error de conexión
        loadingGif.visibility = View.VISIBLE
        noConnectionImage.visibility = View.GONE

        val apiKey = "3356865d41894a2fa9bfa84b2b5f59bb"
        val language = "es"

        // Realizar la solicitud a la API usando Retrofit
        RetrofitInstance.api.getUpcomingMovies(apiKey, language)
            .enqueue(object : Callback<MovieResponse> {
                // Si la respuesta es exitosa
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    loadingGif.visibility = View.GONE // Ocultar gif de carga
                    if (response.isSuccessful) {
                        // Obtener lista de películas de la respuesta
                        val movies = response.body()?.results
                        if (!movies.isNullOrEmpty()) {
                            // Si hay películas, actualizar el adaptador
                            movieAdapter.submitList(movies)
                        } else {
                            Toast.makeText(this@MainActivity, "Sin películas disponibles", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this@MainActivity, "Error en la respuesta del servidor", Toast.LENGTH_SHORT).show()
                    }
                }

                // Si la solicitud falla
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    loadingGif.visibility = View.GONE // Ocultar gif de carga
                    noConnectionImage.visibility = View.VISIBLE // Mostrar imagen de error de conexión
                    Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
    }
}
