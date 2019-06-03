package aed2.dao;

import aed2.model.Person;

import aed2.structure.List;

public class PersonDAO extends AbstractDAO {
	/**
	 * Construtor.
	 */
    public PersonDAO() {
    	super.fileName = "data.txt";
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected Person factory(java.util.List args) {
        return new Person(
            Long.parseLong((String) args.get(0)),
            (String) args.get(1), 
            (String) args.get(2), 
            Integer.parseInt((String) args.get(3)), 
            (String) args.get(4), 
            (String) args.get(5), 
            (String) args.get(6)
        );
    }

}