package eu.gr8conf

import spock.lang.Specification

class E9_Stubbing extends Specification {

    void 'should return predefined value'() {
        given:
            def stubbedRepository = Stub(PersonRepository) {
                findById(_) >> new Person('John', 'Doe')
            }

        when:
            def person = stubbedRepository.findById(1)

        then:
            person.name == 'John'
            person.lastName == 'Doe'
    }

    void 'should return different values in every call'() {
        given:
            def stubbedRepository = Stub(PersonRepository) {
                findById(_) >>> [
                    new Person('John', 'Doe'),
                    new Person('Jane', 'Doe')
                ]
            }

        when:
            def person1 = stubbedRepository.findById(1)
            def person2 = stubbedRepository.findById(1)
            def person3 = stubbedRepository.findById(1)

        then:
            person1.name == 'John'
            person2.name == 'Jane'
            person3.name == 'Jane'
    }

    void 'should return values depending the parameters'() {
        given:
            def stubbedRepository = Stub(PersonRepository) {
                findById(20) >> new Person('Jane', 'Doe')
                findById(11) >> new Person('John', 'Doe')
            }

        when:
            def person1 = stubbedRepository.findById(11)
            def person2 = stubbedRepository.findById(20)

        then:
            person1.name == 'John'
            person2.name == 'Jane'
    }

    void 'should throw an exception'() {
        given:
            def stubbedRepository = Stub(PersonRepository) {
                findById(_) >> { throw new RuntimeException("Person does not exist") }
            }

        when:
            stubbedRepository.findById(1)

        then:
            def e = thrown RuntimeException
            e.message == 'Person does not exist'
    }

    void 'should stub more than one method'() {
        given:
            def stubbedRepository = Stub(PersonRepository) {
                findById(_) >> new Person('Peter', 'Smith')
                findAllByLastName('Doe') >> [
                    new Person('John', 'Doe'),
                    new Person('Jane', 'Doe')
                ]
            }

        expect:
            stubbedRepository.findById(99).name == 'Peter'
            stubbedRepository.findAllByLastName('Doe').size() == 2
    }

}
