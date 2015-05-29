package eu.gr8conf

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Timeout

import java.util.concurrent.TimeUnit

@Ignore("Remove to check that the test fails")
class E14_Timeout extends Specification {

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void 'should fail after 500 milliseconds'() {
        given:
            Thread.sleep 500

        expect:
            true
    }
}
