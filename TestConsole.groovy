package samples.groovyconsole
 
import groovy.ui.Console;
 
class GroovyConsole {
 
    static main(args) {
        Console console = new Console();
        console.setVariable("name", "John");
        console.setVariable("surname", "Doe");
        console.run();
    }
     
}