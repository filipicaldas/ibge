package aed2.dao;

import aed2.model.Person;

public class PersonDAO extends AbstractDAO<Person> {
    /**
     * Nome do arquivo.
     */
    protected static final String fileName = "data.txt";

    /**
     * {@inheritDoc}
     */
    @Override
    protected Person factory(List args) {
        return new Person(
            Long.parseLong(args.get(0)),
            (String) name, 
            (String) sex, 
            Integer.parseInt(age), 
            (String) area, 
            (String) civilStatus, 
            (String) race
        );
    }

}