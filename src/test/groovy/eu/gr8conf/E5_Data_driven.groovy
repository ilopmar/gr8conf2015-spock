package eu.gr8conf

import spock.lang.Specification
import spock.lang.Unroll

class E5_Data_driven extends Specification {

    void 'all numbers should be even'() {
        expect:
            number % 2 == 0

        where:
            number << [-10, 0, 2, 42, 1000]
    }

    void 'should get the minium'() {
        expect:
            Math.min(x, y) == result

        where:
            x << [1, -1, 0]
            y << [2, -2, 1]
            result << [1, -2 , 0]
    }

    void 'should get the minimum of two numbers'() {
        expect:
            Math.min(x, y) == result

        where:
            x  | y  | result
            1  | 2  | 1
            -1 | -2 | -2
            0  | 1  | 0
    }

    @Unroll
    void 'should get the minimum of two numbers (II)'() {
        expect:
            Math.min(x, y) == result

        where:
            x  | y  | result
            1  | 2  | 1
            -1 | -2 | -2
            0  | 1  | 0
    }

    @Unroll
    void 'should check that minimum of #x and #y is #result'() {
        expect:
            Math.min(x, y) == result

        where:
            x  | y  | result
            1  | 2  | 1
            -1 | -2 | -2
            0  | 1  | 0
    }

    void 'should read data from an iterable'() {
        given:
            def person = [name: theName, lastName: theLastName] as Person

        expect:
            person instanceof Person
            person.name == theName
            person.lastName == theLastName

        where:
            [theName, theLastName] << new File('src/test/resources/users.csv')
                                          .readLines()
                                          .collect { it.split(',') }

    }

}
