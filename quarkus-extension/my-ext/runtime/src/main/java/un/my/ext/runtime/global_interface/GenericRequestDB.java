package un.my.ext.runtime.global_interface;

public interface GenericRequestDB {

    <T> T save(T entity);

    <T> T update(T entity);
    <T> T findById(Long id, Class<T> entityClass);
    <T> void deleteById(Long id, Class<T> entityClass);
    <T> void delete(T entity);

    <T> Iterable<T> saveAllElements(Iterable<T> entities);

}
