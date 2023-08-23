package com.example.translate

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.translate.databinding.FragmentTranslatorBinding
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions

class TranslatorFragment : Fragment(R.layout.fragment_translator) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val options = TranslatorOptions.Builder().setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.RUSSIAN).build()

        val translator = Translation.getClient(options)
        lifecycle.addObserver(translator)

        FragmentTranslatorBinding.bind(view).run {
            btnTranslate.setOnClickListener {
                translator.downloadModelIfNeeded().addOnSuccessListener {
                        translator.translate(editText.text.toString()).addOnSuccessListener {
                                text.text = it
                            }.addOnFailureListener {
                                //Error
                                Log.e("err", "Error: " + it.localizedMessage)
                            }
                    }.addOnFailureListener {
                        Log.e("err", "Download Error: " + it.localizedMessage)

                    }

            }
        }
    }

}