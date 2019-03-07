package com.johnlewis.exercises

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

internal class MeasurementTest {
    val twoTablespoons = Measurement(2.0, Unit.TBSP)
    val oneTablespoons = Measurement(1.0, Unit.TBSP)
    val anotherTwoTablespoons = Measurement(2.0, Unit.TBSP)
    val threeTeaspoons = Measurement(3.0, Unit.TSP)
    val twoTeaspoons = Measurement(2.0, Unit.TSP)
    val fiveTeaspoons = Measurement(5.0, Unit.TSP)
    val nineTeaspoons = Measurement(9.0, Unit.TSP)
    val sixTeaspoons = Measurement(6.0, Unit.TSP)
    val oneOunce = Measurement(1.0, Unit.OZ)

    @Test
    fun ` should be equal when two amounts are the same`() {
        assertThat(twoTablespoons, equalTo(anotherTwoTablespoons))
    }

    @Test
    fun ` should not be equal when two amounts are different`() {
        assertThat(twoTablespoons, not(equalTo(threeTeaspoons)))
    }

    @Test
    fun ` should not be equal when two units are different`() {
        assertThat(twoTablespoons, not(equalTo(twoTeaspoons)))
    }

    @Test
    fun ` should not be equal when compared to a String`() {
        assertFalse(twoTablespoons.equals("Helen is great"))
    }

    @Test
    fun `should give the amount followed by the unit from ToString`() {
        assertThat(threeTeaspoons.toString(), equalTo("3.0 TSP"))
        assertThat(twoTeaspoons.toString(), equalTo("2.0 TSP"))
    }

    @Test
    fun `should add two amounts`() {
        assertThat(threeTeaspoons.add(twoTeaspoons), equalTo(fiveTeaspoons))
        //  assertThat(threeTeaspoons.add(twoTablespoons), equalTo(nineTeaspoons))
    }

    @Test
    fun `should convert tablespoons to teaspoons`() {
        assertThat(twoTablespoons.convertTo(Unit.TSP), equalTo(sixTeaspoons))
        assertThat(oneTablespoons.convertTo(Unit.TSP), equalTo(threeTeaspoons))

    }

    @Test
    fun `should convert ounces to teaspoons `() {
      assertThat(oneOunce.convertTo(Unit.TSP), equalTo(sixTeaspoons))
    }
    @Test
    fun `should convert ounces to tablespoons `() {
        assertThat(oneOunce.convertTo(Unit.TBSP), equalTo(twoTablespoons))
    }


    class Measurement(private val amount: Double, val unit: Unit) {
        override fun equals(other: Any?): Boolean {
            return other is Measurement && amount == other.amount && unit == other.unit
        }

        override fun toString(): String {
            return "$amount $unit"
        }

        fun add(other: Measurement): Measurement? {
            return Measurement(amount + other.amount, unit)
        }

        fun convertTo(target: Unit): Measurement {

                return Measurement(amount * unit.tspRatio / target.tspRatio, target)
            }
        }


    enum class Unit(val tspRatio :Double) {
        TBSP(3.0),
        TSP(1.0),
        OZ(6.0);


    }



}

