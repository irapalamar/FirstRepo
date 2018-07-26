package cvs;

/**
 * Created by sbt-palamar-iy on 24.07.2018.
 */
public @interface Date {
    int month() default 01;
    int day() default 01;
    int year() default 1990;
    String previous();
}

