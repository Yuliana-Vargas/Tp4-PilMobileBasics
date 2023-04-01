package com.example.pilmobilebasics.mvp.presenter

import com.example.pilmobilebasics.mvp.contract.CountContract
import com.example.pilmobilebasics.mvp.model.CountModel
import com.example.pilmobilebasics.util.Constants.ZERO
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CounterPresenterTest {
    private lateinit var presenter: CountContract.Presenter
    private lateinit var model: CountContract.Model

    @MockK
    private lateinit var view: CountContract.View

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        model = CountModel()
        presenter = CountPresenter(model, view)
    }

    @Test
    fun `on reset button pressed, the count value becomes zero`() {
        val resetValue = ZERO.toString()
        presenter.onResetBtnPressed()
        verify { view.showResult(resetValue) }
        verify { view.clearInput() }
        assertEquals(resetValue, model.getCount())
    }

    @Test
    fun `on add button pressed with an empty input, an error message should be displayed`() {
        every { view.getInputNumber() } returns ""

        presenter.onAddBtnPressed("")

        verify { view.getEmptyInputNumberError() }
    }

    @Test
    fun `on add button pressed, the count value should increase`() {
        val number = "5"
        every { view.getInputNumber() } returns number

        presenter.onAddBtnPressed(number)

        verify { view.showResult(model.getCount()) }
        assertEquals(number, model.getCount())
    }

    @Test
    fun `on subtract button pressed with an empty input, an error message should be displayed`() {
        every { view.getInputNumber() } returns ""

        presenter.onSubtractBtnPressed("")

        verify { view.getEmptyInputNumberError() }
    }

    @Test
    fun `on subtract button pressed, the count value should decrease`() {
        val number = "10"
        every { view.getInputNumber() } returns number

        presenter.onSubtractBtnPressed(number)

        verify { view.showResult(model.getCount()) }
        assertEquals("-10", model.getCount())
    }
}
