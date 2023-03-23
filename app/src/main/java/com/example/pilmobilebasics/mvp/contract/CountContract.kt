package com.example.pilmobilebasics.mvp.contract

interface CountContract {

    interface Model {
        fun resetCount()
        fun getCount(): String
        fun add(number: String)
        fun subtract(number: String)
    }

    interface View {
        fun onAddBtnPressed(onClick: () -> Unit)
        fun onSubtractBtnPressed(onClick: () -> Unit)
        fun onResetBtnPressed(onClick: () -> Unit)
        fun showResult(result: String)
        fun getInputNumber(): String
        fun getEmptyInputNumberError()
        fun clearInput()
    }

    interface Presenter {
        fun onAddBtnPressed(number: String)
        fun onSubtractBtnPressed(number: String)
        fun onResetBtnPressed()
    }
}
