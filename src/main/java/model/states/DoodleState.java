package model.states;

/**
 * Interface, amí segít megvalósítani a doodle állapotait
 * strategy minta segítségével
 */
public interface DoodleState {

    /**
     * Megváltoztatja a doodle állapotát
     */
    void updateState();
}
