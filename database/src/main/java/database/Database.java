package database;

import java.util.List;

/**
 * Generic Database who offer CRUD operations
 * @param <T>
 */
public interface Database<T> {

    /**
     * Adds a item
     * @param item the item to add
     */
    void add(T item);

    /**
     * Check if the item exists
     * @param item the item to check
     * @return whether or not the item exists
     */
   boolean exists(T item);

    /**
     * Gets a with the specified key
     * @param key the key of the item in the database
     * @return the item who belongs the key
     */
    T get(String key);

    /**
     * Gets all the items T
     * @return Collection of items
     */
    List<T> getAll();

    /**
     * Updates a item
     * @param item the item to update
     */
    void update(T item);
}
