package eu.gr8conf

import spock.lang.Specification

class E1_Basic extends Specification {

    void 'should add two integers'() {
        given: 'two numbers'
            def x = 1
            def y = 2

        expect: 'the right sum'
            x + y == 5
    }

    void 'should reverse a string'() {
        given: 'a string'
            def myString = 'Hello GR8Conf!'

        when: 'reversing it'
            def reversed = myString.reverse()

        then: 'it is reversed'
            reversed == '!fnoC8RG olleH'
    }

    void 'should reverse a string (II)'() {
        expect:
            'Hello GR8Conf!'.reverse() == '!fnoC8RG olleH'
    }

}
