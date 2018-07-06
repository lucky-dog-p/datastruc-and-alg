package alg4th.datastrucs;

/**
 * ValueNode,this ia Node class that only contains value.
 * @author  panguangze
 */
public class ValueNode<Item> {

    public ValueNode<Item> next;
    public Item value;

    /**
     * @param   value the type of the Item.
     */
    public ValueNode(Item value){
        this.value = value;
    }
}