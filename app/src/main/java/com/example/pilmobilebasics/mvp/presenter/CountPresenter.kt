package com.example.pilmobilebasics.mvp.presenter

import com.example.pilmobilebasics.mvp.contract.CountContract

class CountPresenter(private val model: CountContract.Model, private val view: CountContract.View) : CountContract.Presenter {

    init {
        view.onAddBtnPressed { onAddBtnPressed(view.getInputNumber()) }
        view.onSubtractBtnPressed { onSubtractBtnPressed(view.getInputNumber()) }
        view.onResetBtnPressed { onResetBtnPressed() }
    }

    override fun onAddBtnPressed(number: String) {
        model.add(number)
        view.showResult(model.getCount())
    }

    override fun onSubtractBtnPressed(number: String) {
        model.subtract(number)
        view.showResult(model.getCount())
    }

    override fun onResetBtnPressed() {
        model.resetCount()
        view.showResult(model.getCount())
    }
}
