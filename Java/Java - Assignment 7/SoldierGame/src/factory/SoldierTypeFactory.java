package factory;

import application.SoldierType;

import java.util.HashMap;
import java.util.Map;

public class SoldierTypeFactory {
    private static final Map<String, SoldierType> soldierTypeMap = new HashMap<>();

    public static SoldierType getSoldierType(String weapon, String uniform) {
        String key = weapon + "-" + uniform;

        if (!soldierTypeMap.containsKey(key)) {
            System.out.println("Creating new SoldierType: " + key);
            soldierTypeMap.put(key, new SoldierType(weapon, uniform));
        }

        return soldierTypeMap.get(key);
    }
}
