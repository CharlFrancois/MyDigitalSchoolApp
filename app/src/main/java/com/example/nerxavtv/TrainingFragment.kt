package com.example.nerxavtv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.nerxavtv.data.Training
import com.example.nerxavtv.data.TrainingDatabase


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Training.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrainingFragment() : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: TrainingViewModel by viewModels()

        super.onCreate(savedInstanceState)

        TrainingDatabase.getInstance(requireContext())
        val trainingTitle: TextView? = view?.findViewById(R.id.title_training)
        val trainingTitleObserver = Observer<Training?>{
            trainingTitle?.text = it?.title
        }

        val trainingDescription: TextView? = view?.findViewById(R.id.description_training)
        val trainingDescriptionObserver = Observer<Training?>{
            trainingDescription?.text = it?.description
        }

        val trainingCode: TextView? = view?.findViewById(R.id.code_training)
        val trainingCodeObserver = Observer<Training?>{
            trainingCode?.text = it?.code
        }

        viewModel.training.observe(this, trainingTitleObserver)
        viewModel.training.observe(this, trainingDescriptionObserver)
        viewModel.training.observe(this, trainingCodeObserver)
        viewModel.findTrainingById(1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_training, container, false)
    }
}