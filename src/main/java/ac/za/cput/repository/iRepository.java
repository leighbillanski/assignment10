package ac.za.cput.repository;

public interface iRepository <T, ID> {
    T create(T t);
    T update(T t);
    T read(ID id);
    boolean delete(T t);
}
