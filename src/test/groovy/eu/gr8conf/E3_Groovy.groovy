package eu.gr8conf

import spock.lang.Specification

class E3_Groovy extends Specification {

    void 'should add an element to a list'() {
        given:
            def numbers = DataHelper.someFibonacciNumbers()

        when:
            numbers << 21 // same as: numbers.add(21)

        then:
            numbers.contains(21)
    }

    void 'should make some assertions in elements in a list'() {
        when:
            def persons = DataHelper.makePersonList()

        then:
            persons.size() == 3
            persons.name == ['Jack', 'Emily', 'Sarah']
            persons.name.sort() == ['Emily', 'Jack', 'Sarah']
            persons.lastName.collect { it.size() } == [5, 5, 5]
            persons.name.min { it.length() } == 'Jack'
    }

    void 'should remove an element from a map'() {
        given:
            def map = DataHelper.makePersonMap()

        when:
            map.remove('name')

        then:
            map.size() == 2
            !map.keySet().contains('name')
    }

}
