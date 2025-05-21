package zombie;

import java.util.HashMap;
import java.util.Map;

public class ZombieRegistry {
    private final Map<String, Zombie> zombieMap = new HashMap<>();

    public void registerZombie(String type, Zombie zombie) {
        zombieMap.put(type, zombie);
    }

    public Zombie getClone(String type) {
        return zombieMap.get(type).clone();
    }
}

