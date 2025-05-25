package application;

import domain.MenuComponent;

import java.util.ArrayList;
import java.util.List;

public class SubMenu implements MenuComponent {
    private String name;
    private List<MenuComponent> children = new ArrayList<>();

    public SubMenu(String name) {
        this.name = name;
    }

    public void add(MenuComponent component) {
        children.add(component);
    }

    public void remove(MenuComponent component) {
        children.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "+ " + name);
        for (MenuComponent component : children) {
            component.display(indent + "  ");
        }
    }
}

