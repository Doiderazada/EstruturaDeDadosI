package pratica_ED1.Interfaces;

import java.util.Collection;

public interface DoiderasQueue<T> extends Collection<T>{
    


    public boolean add(Object element);
    
    
    public boolean offer(Object element);
    
    
    public Object remove();
    

    public Object poll();
    
    
    public Object element();
    
    
    public Object peek();

    
    public String show();
}
