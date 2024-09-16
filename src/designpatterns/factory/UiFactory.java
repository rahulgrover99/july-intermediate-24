package designpatterns.factory;


// Abstract factory since it contains all the factory methods.
public interface UiFactory {
    Object createButton();
    Object createDropdown();
    Object createMenu();
}
