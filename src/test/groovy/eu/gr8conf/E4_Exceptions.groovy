package eu.gr8conf

import spock.lang.Specification

class E4_Exceptions extends Specification {

    void 'should throw an exception'() {
        when:
            Long.valueOf("foo")

        then:
            thrown NumberFormatException
    }
}
