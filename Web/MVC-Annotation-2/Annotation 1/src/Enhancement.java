/****************************************************************************************
Name            : Enhancement
Revision Log    : 2015-10-17: Babalu patidar : created.
                : 
                : 
Use             : This interface is used to make annotaion .
                :
****************************************************************************************/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Enhancement {
	
	int id();
    String name();
    String engineer() default "[unassigned]";
    String date() default "[unknown]";
}
//End of interface