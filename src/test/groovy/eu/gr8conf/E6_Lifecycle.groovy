package eu.gr8conf

import spock.lang.Specification

class E6_Lifecycle extends Specification {

    def person = new Person('Iván', 'López')

    def setupSpec() {
        println '>> setupSpec'
    }

    def setup() {
        println '>>> setup'
    }

    def cleanup() {
        println '>>> cleanup'
    }

    def cleanupSpec() {
        println '>> cleanSpec'
    }

    void 'should get name'() {
        expect:
            println 'should get name'
            person.name == 'Iván'
    }

    void 'should get lastName'() {
        expect:
            println 'should get lastName'
            person.lastName == 'López'
    }

}
