package com.nozdormu.parser.interfaces;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public interface FileParser {

    <T> T read(Class<T> objectClass, String file) throws IOException, JAXBException;

    <T> void write(T object, String file) throws IOException, JAXBException;
}
