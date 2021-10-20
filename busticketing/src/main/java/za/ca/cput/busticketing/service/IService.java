package za.ca.cput.busticketing.service;

public interface IService<T,ID> {
    public T create(T d);
    public T read(ID id);
    public T update(T t);
    public boolean delete(ID id);



}
