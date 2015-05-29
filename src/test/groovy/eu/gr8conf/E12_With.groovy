package eu.gr8conf

import spock.lang.Specification

class E12_With extends Specification {

    void 'should check value on person'() {
        when:
            def person = new Person('Iván', 'López')

        then:
            with(person) {
                name == 'Iván'
                lastName == 'López'
            }

    }

}
