package me.dio.materialdesignestudo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import me.dio.materialdesignestudo.databinding.BottomSheetModalBinding

class ModalBottomSheet : BottomSheetDialogFragment() {
    private val binding by lazy { BottomSheetModalBinding.inflate(LayoutInflater.from(requireContext())) }
    override fun onCreateView(
        inflater: LayoutInflater,
        group: ViewGroup?,
        saved: Bundle?): View {
        return binding.root
    }
    companion object{
        private const val TAG = "ModalBottomSheet"
        fun start(manager:FragmentManager){
            ModalBottomSheet().show(manager, TAG)
        }
    }
}