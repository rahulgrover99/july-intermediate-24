package designpatterns.factory;

public class AndroidUiFactory implements UiFactory{
    @Override
    public Object createButton() {
        System.out.println("Creating android button");
        // return new AndroidButton();
        return null;
    }

    @Override
    public Object createDropdown() {
//        return new AndroidDropdown();
        return null;
    }

    @Override
    public Object createMenu() {
        return null;
    }
}
