

/**
 *
 * @author arriaza96
 * @param <E>
 */
public abstract class AbstractList<E>
       implements List<E>
{

    /**
     *
     */
    public AbstractList()
   // post: does nothing
   {
   }

    /**
     *
     * @return
     */
    public boolean isEmpty()
   // post: returns true iff list has no elements
   {
      return size() == 0;
   }
  
    /**
     *
     * @param value
     * @return
     */
    public boolean contains(E value)
  // pre: value is not null
  // post: returns true iff list contains an object equal to value
  {
	return -1 != indexOf(value);
  }
}