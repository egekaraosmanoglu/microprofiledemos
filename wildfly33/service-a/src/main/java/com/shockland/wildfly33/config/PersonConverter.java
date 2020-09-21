package com.shockland.wildfly33.config;

import org.eclipse.microprofile.config.spi.Converter;

public class PersonConverter implements Converter<Person> {
    @Override
    public Person convert(String name) {
        Person p = searchPersonBySocialSecurity(name);
        return p;
    }
	public Person searchPersonBySocialSecurity(String name) {
	   return new Person(name);
	}
}

