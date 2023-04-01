package com.example.pilmobilebasics.mvp.presenter

import com.example.pilmobilebasics.mvp.contract.CountContract
import com.example.pilmobilebasics.util.Constants.ZERO
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class CounterPresenterTest {
    private lateinit var presenter: CountContract.Presenter

    @MockK
    private lateinit var view: CountContract.View

    @MockK
    private lateinit var model: CountContract.Model

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        presenter = CountPresenter(model, view)
    }

    @Test
    fun `on add button pressed, the count value should increase`() {
        val increaseCountValue = "5"
        every { view.getInputNumber() } returns increaseCountValue
        every { model.getCount() } returns increaseCountValue

        presenter.onAddBtnPressed(increaseCountValue)

        verify { model.add(increaseCountValue) }
        verify { model.getCount() }
        verify { view.showResult(increaseCountValue) }
    }

    @Test
    fun `on add button pressed, an error message should be displayed`() {
        every { view.getInputNumber() } returns ""
        presenter.onAddBtnPressed("")
        verify { view.getInputNumber() }
        verify { view.getEmptyInputNumberError() }
    }

    @Test
    fun `on subtract button pressed, the count value should decrease`() {
        val decreaseCountValue = "2"
        every { view.getInputNumber() } returns decreaseCountValue
        every { model.getCount() } returns decreaseCountValue

        presenter.onSubtractBtnPressed(decreaseCountValue)

        verify { model.subtract(decreaseCountValue) }
        verify { model.getCount() }
        verify { view.showResult("2") }
    }

    @Test
    fun `on subtract button pressed with an empty input, an error message should be displayed`() {
        every { view.getInputNumber() } returns ""
        presenter.onSubtractBtnPressed("")
        verify { view.getInputNumber() }
        verify { view.getEmptyInputNumberError() }
    }

    @Test
    fun `on reset button pressed, the count value becomes zero`() {
        val resetValue = ZERO.toString()
        every { model.getCount() } returns resetValue

        presenter.onResetBtnPressed()

        verify { model.resetCount() }
        verify { model.getCount() }
        verify { view.showResult(resetValue) }
        verify { view.clearInput() }
    }
}
