package com.abc.hibernatedemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Optional<String> result = Optional.ofNullable(null);
    	result.orElseThrow(() -> new RuntimeException("Value is not present"));
    }
}
