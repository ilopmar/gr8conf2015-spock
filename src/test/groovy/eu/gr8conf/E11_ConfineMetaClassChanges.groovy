package eu.gr8conf

import spock.lang.Specification
import spock.util.mop.ConfineMetaClassChanges

class E11_ConfineMetaClassChanges extends Specification {

    @ConfineMetaClassChanges(String)
    void 'should have sayHi method on String'() {
        given:
            String.metaClass.sayHi = { -> "Hi ${delegate}" }

        expect:
            "GR8Conf".sayHi() == 'Hi GR8Conf'
    }

    void 'should not have sayHi method on String'() {
        when:
            "GR8Conf".sayHi()

        then:
            thrown MissingMethodException
    }

}
