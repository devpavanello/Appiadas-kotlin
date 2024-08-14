package br.com.fiap.appiadas

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.fiap.appiadas.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //Criando variaveis
    //Var - Variavel
    //Val - Constante
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btTellJoker.setOnClickListener{
            showJoker()
        }

    }

    private fun showJoker() {
        //Pegar as piadas no array
        val jokers = resources.getStringArray(R.array.jokers)

        //Sortear uma piada
        val numberJoker = Random.nextInt(jokers.size)
        val joker = jokers[numberJoker]

        //Mostrar a piada
        binding.tvJoker.text = joker

        //Toca musica
        playSong()
    }

    private fun playSong() {
        val mediaPlayer = MediaPlayer.create(this, R.raw.badumtss)
        mediaPlayer.start()
    }
}