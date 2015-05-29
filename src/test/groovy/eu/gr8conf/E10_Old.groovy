package eu.gr8conf

import spock.lang.Specification

class E10_Old extends Specification {

    void 'should add the number of elements in a list'() {
        given:
            def numbers = [1, 1, 2, 3, 5, 8, 13]

        when:
            numbers << 21

        then:
            numbers.size() == old(numbers.size()) + 1
   }
}
