package br.edu.ifsp.dados

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.edu.ifsp.dados.databinding.ActivityMainBinding
import br.edu.ifsp.dados.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var activitySettingsBinding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySettingsBinding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(activitySettingsBinding.root)

        activitySettingsBinding.salvarBt.setOnClickListener {
            val numeroDado: Int = (activitySettingsBinding.numeroDadosSp.selectedView as TextView).text.toString().toInt()
            val numeroFaces: Int = activitySettingsBinding.numeroFacesEt.text.toString().toInt()
            val config: Configuracao = Configuracao(numeroDado, numeroFaces)
            val retornoIntent = Intent()
            retornoIntent.putExtra(Intent.EXTRA_USER, config)
            setResult(RESULT_OK, retornoIntent)
            finish()
        }
    }
}