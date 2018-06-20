package com.test.jdk8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 *	可重复注解@Repeatable
 */
public class TestRepeatingAnnotations {
	 @Target( ElementType.TYPE )
	    @Retention( RetentionPolicy.RUNTIME )
	    public @interface Filters {
	        Filter[] value();
	    }

	    @Target( ElementType.TYPE )
	    @Retention( RetentionPolicy.RUNTIME )
	    //@Repeatable
	    @Repeatable( Filters.class )
	    public @interface Filter {
	        String value();
	    };

	    @Filter( "filter1" )
	    @Filter( "filter2" )
	    public interface Filterable {        
	    }

	    public static void main(String[] args) {
	        for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
	            System.out.println( filter.value() );
	        }
	    }
}
