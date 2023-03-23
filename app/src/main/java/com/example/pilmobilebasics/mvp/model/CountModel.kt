package com.example.pilmobilebasics.mvp.model

import com.example.pilmobilebasics.mvp.contract.CountContract
import com.example.pilmobilebasics.util.Constants.ZERO

class CountModel : CountContract.Model {

    private var count = ZERO

    override fun resetCount() {
        count = ZERO
    }

    override fun getCount(): String = count.toString()

    override fun add(number: String) {
        count += number.toInt()
    }

    override fun subtract(number: String) {
        count -= number.toInt()
    }
}
