package com.example.pilmobilebasics.mvp.view

import android.app.Activity
import com.example.pilmobilebasics.R
import com.example.pilmobilebasics.databinding.ActivityCountBinding
import com.example.pilmobilebasics.mvp.contract.CountContract
import com.example.pilmobilebasics.mvp.view.base.ActivityView
import com.example.pilmobilebasics.util.Constants

class CountView(activity: Activity) : ActivityView(activity), CountContract.View {
    private var binding: ActivityCountBinding = ActivityCountBinding.inflate(activity.layoutInflater)

    init {
        activity.setContentView(binding.root)
        binding.result.text = Constants.ZERO.toString()
    }

    override fun onAddBtnPressed(onClick: () -> Unit) {
        binding.addBtn.setOnClickListener { onClick() }
    }

    override fun onSubtractBtnPressed(onClick: () -> Unit) {
        binding.subtractBtn.setOnClickListener { onClick() }
    }

    override fun onResetBtnPressed(onClick: () -> Unit) {
        binding.resetBtn.setOnClickListener { onClick() }
    }

    override fun showResult(result: String) {
        binding.result.text = result
    }

    override fun getInputNumber(): String = binding.inputNumber.text.toString()

    override fun getEmptyInputNumberError() {
        binding.inputNumber.error = context?.getString(R.string.error_required_input)
    }

    override fun clearInput() {
        binding.inputNumber.text.clear()
    }
}
