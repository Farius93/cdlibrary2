package pl.sdacademy;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        CD cd = new CD("YES", "90125", "???", LocalDate.of(1980, 1, 1));
        cd.addGenre(Genre.ROCK);
    }
}
