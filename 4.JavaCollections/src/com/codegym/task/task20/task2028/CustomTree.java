package com.codegym.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    /**
     * The tree's root;
     */
    private Entry<String> root;

    /**
     * root is initialized by default; it becomes the first node designated as the "new root node for
     * the current level of the tree"; The newLineRootElement is always the tree's leftmost and bottommost node.
     */
    public CustomTree() {
        root = new Entry<String>(null);
        root.newLineRootElement = true;
        root.lineNumber = 0;
    }

    /**
     * The getParent method accepts a String argument called value, searches the tree for an Entry whose elementName
     * matches value, and then returns this Entry's elementName (Entry.parent)
     *
     * @param value The elementName of the passed Entry
     * @return parent.elementName of the found Entry (Entry.parent)
     */
    public String getParent(String value) {
        setValidCollection();
        String s = null;
        for (Entry<String> entry : queue) {
            if (entry.lineNumber != 1) {
                if (entry.elementName.equals(value)) {
                    s = entry.parent.elementName;
                    break;
                }
            }
        }
        return s;
    }

    /**
     *  A collection for storing tree nodes.
     */
    private transient ArrayList<Entry<String>> queue;

    /**
     * The setUpCollection method traverses the tree starting at Entry<String> root and writes all nodes into
     * queue;
     *
     * @param root The initial Entry<String> node for traversing the tree from top to bottom.
     */
    private void setUpCollection(Entry<String> root) {
        queue = new ArrayList<>();
        Queue<Entry<String>> subQueue = new LinkedList<>();
        queue.add(root);
        subQueue.add(root);
        do {
            if (!subQueue.isEmpty()) root = subQueue.poll();
            if (root.leftChild != null) {
                queue.add(root.leftChild);
                subQueue.add(root.leftChild);
            }
            if (root.rightChild != null) {
                queue.add(root.rightChild);
                subQueue.add(root.rightChild);
            }
        } while (!subQueue.isEmpty());

    }

    /**
     * The getCollection method differs from the setUpCollection method only in that it returns the resulting collection;
     *
     * @param entry The initial Entry<String> node for traversing the tree from top to bottom.
     * @return The resulting collection (List<Entry<String>>) of tree nodes.
     */
    private List<Entry<String>> getCollection(Entry<String> entry) {
        ArrayList<Entry<String>> list = new ArrayList<>();
        Queue<Entry<String>> subQueue = new LinkedList<>();
        list.add(entry);
        subQueue.add(entry);
        do {
            if (!subQueue.isEmpty()) entry = subQueue.poll();
            if (entry.leftChild != null) {
                list.add(entry.leftChild);
                subQueue.add(entry.leftChild);
            }
            if (entry.rightChild != null) {
                list.add(entry.rightChild);
                subQueue.add(entry.rightChild);
            }
        } while (!subQueue.isEmpty());
        return list;
    }

    /**
     * The setValidCollection method writes the complete collection of tree nodes, and then removes one node from the collection,
     * the original root node.
     * This is used in the remove method and other methods to traverse the collection correctly.
     */
    private void setValidCollection() {
        setUpCollection(root);
        queue.remove(0);
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    /**
     * The indexOf() method returns the index of a node in the collection, or -1 if the node doesn't exist.
     *
     * @param o The node you are searching for
     * @return The node's index in the collection
     */
    @Override
    public int indexOf(Object o) {
        String string = String.valueOf(o);
        setValidCollection();
        for (Entry<String> entry : queue) if (entry.elementName.equals(string)) return queue.indexOf(entry);
        return -1;
    }

    /**
     * The lastIndexOf() method returns the index of a node in the collection, or -1 if the node doesn't exist.
     *
     * @param o The node you are searching for
     * @return The node's index in the collection
     */
    @Override
    public int lastIndexOf(Object o) {
        String string = String.valueOf(o);
        setValidCollection();
        Entry<String> element = null;
        for (Entry<String> entry : queue) if (entry.elementName.equals(string)) element = entry;
        return queue.lastIndexOf(element);
    }

    /**
     * The add method adds a node to the tree. First, the complete collection of nodes is established, then we
     * iterate over the nodes. During each iteration, the checkChildren method is used on each node to see if it might have
     * branches. isAvailableToAddChildren() returns true if it can; Then a new
     * Entry<String> is created, initialized, and added to the collection. After that, the collection is again
     * checked and initialized using setValidCollection();
     * If traversing the entire collection reveals no node able to have new branches, then all
     * of the vertices have been pruned. Then we iterate through the collection to find a node with the boolean flag
     * newLineRootElement; The found node and all subsequent nodes in the collection regain the ability to
     * have descendants;
     *
     * @param s A String that needs to be added to the collection;
     * @return true after the new node is added;
     */
    @Override
    public boolean add(String s) {
        setUpCollection(root);
        for (Entry<String> entry : queue) {
            entry.checkChildren();
            if (entry.isAvailableToAddChildren()) {
                createChild(entry, s);
                setValidCollection();
                return true;
            }
        }

        boolean reAddingChildren = false;
        for (Entry<String> entry : queue) {
            if (entry.newLineRootElement) reAddingChildren = true;
            if (reAddingChildren) {
                entry.availableToAddLeftChildren = true;
                entry.availableToAddRightChildren = true;
            }
        }

        return add(s);
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    /**
     * The toArray method returns an array of elementName values for the current nodes in the collection.
     *
     * @return An String array of elementName values;
     */
    @Override
    public String[] toArray() {
        setValidCollection();
        int size = size();
        String[] array = new String[size];
        for (int i = 0; i < size; i++) array[i] = queue.get(i).elementName;
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        int size = size();
        T[] array = a.length >= size ? a : (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        Iterator<String> iterator = iterator();
        for (int i = 0; i < array.length; i++) {
            if (!iterator.hasNext()) { // fewer elements than expected
                if (a != array) return Arrays.copyOf(array, i);
                array[i] = null; // null-terminate
                return array;
            }
            array[i] = (T) iterator.next();
        }
        return array;
    }

    /**
     * The changeNewLineRootElement method changes the newLineRootElement boolean flag for nodes to be deleted.
     * The new node is found using the following rule: if there are still nodes to the right, then select a neighbor; if not,
     * then move to the next level and search for the leftmost node.
     *
     * @param entry The current Entry<String> node where newLineRootElement is true;
     * @param delList The list of nodes to be removed from the Entry<String> collection;
     */
    private void changeNewLineRootElement(Entry<String> entry, List<Entry<String>> delList) {
        setValidCollection();
        int size = size();
        for (int i = 0; i < size; i++) {
            Entry<String> newEntry = queue.get(i);
            if (newEntry == entry) {
                newEntry.newLineRootElement = false;
                if (i < size - 1) {
                    for (int k = i + 1; k < size; k++) {
                        Entry<String> newRootEntry = queue.get(k);
                        if (!delList.contains(newRootEntry)) {
                            newRootEntry.newLineRootElement = true;
                            break;
                        }
                    }
                    Entry<String> element = getUndelRoot(newEntry.parent, delList);
                    element.newLineRootElement = true;
                } else {
                    Entry<String> element = getUndelRoot(newEntry.parent, delList);
                    element.newLineRootElement = true;
                }
                break;
            }
        }
    }

    /**
     * The getUndelRoot method searches top to bottom, left to right for the first Entry<String> node not in the delList list
     * (the list of items to be removed);
     *
     * @param entry The Entry<String> node where the search starts;
     * @param delList The list of nodes to be removed
     * @return The first top left Entry<String> node not included in delList;
     */
    private Entry<String> getUndelRoot(Entry<String> entry, List<Entry<String>> delList) {
        for (Entry<String> element : queue)
            if (element.lineNumber == entry.lineNumber) if (!delList.contains(element)) return element;
        if (entry.lineNumber == 0) return entry;
        return getUndelRoot(entry.parent, delList);
    }

    /**
     * Additional method just in case. Sometimes when removing nodes you'll end up with 2 newLineRootElement nodes;
     * This method collects all these nodes from top to bottom and removes the newLineRootElement flag;
     *
     * @param entry An Entry<String> object whose newLineRootElement field is true and needs to be
     *              changed;
     * @return A list starting with the Entry<String> entry and ending with all of its parents whose
     * newLineRootElement is true and needs to be changed;
     */
    private List<Entry<String>> getNewLineRootElementsCollection(Entry<String> entry) {
        ArrayList<Entry<String>> list = new ArrayList<>();
        list.add(entry);
        if ((entry.parent != null) && (entry.parent.newLineRootElement))
            list.addAll(getNewLineRootElementsCollection(entry.parent));
        return list;
    }

    /**
     * The createChild method creates a new Entry<String> and sets the value of the parent variable
     *
     * @param parent  The Entry<String> parent node;
     * @param s The value of the elementName for the new Entry<String>;
     */
    private void createChild(Entry<String> parent, String s) {
        Entry<String> newOne = new Entry<String>(s);
        newOne.parent = parent;
        newOne.lineNumber = parent.lineNumber + 1;
        setChild(parent, newOne);
    }

    /**
     * The setChild method sets the parent's leftChild/rightChild variable equal to a reference to Entry<String> child;
     * If the parent's newLineRootElement variable was true, this value will be passed to the child and
     * it will be changed to false for the parent;
     *
     * @param parent  The Entry<String> parent node
     * @param child The Entry<String> child node
     */
    private void setChild(Entry<String> parent, Entry<String> child) {
        if (parent.availableToAddLeftChildren) {
            parent.leftChild = child;
            parent.availableToAddLeftChildren = false;
            if (parent.newLineRootElement) {
                List<Entry<String>> list = getNewLineRootElementsCollection(parent);
                for (Entry<String> entry : list) entry.newLineRootElement = false;
                child.newLineRootElement = true;
            }
        } else {
            parent.rightChild = child;
            parent.availableToAddRightChildren = false;
            if (parent.newLineRootElement) {
                List<Entry<String>> list = getNewLineRootElementsCollection(parent);
                for (Entry<String> entry : list) entry.newLineRootElement = false;
                child.newLineRootElement = true;
            }
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        setValidCollection();
        for (Object o : c) if (!contains(o)) return false;
        return true;
    }

    /**
     * Unsupported Operation
     *
     * @param index param
     * @return UnsupportedOperationException();
     */
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * This implementation iterates over this collection, checking each
     * element returned by the iterator in turn to see if it's contained
     * in the specified collection.  If it's not, then it's removed
     * from this collection using the iterator's <tt>remove</tt> method.
     *
     * @param c Collection of nodes that will be left in the current collection.
     * @return true if the current collection was changed, otherwise false
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        setValidCollection();
        boolean modified = false;
        Iterator<String> iterator = iterator();
        while (iterator.hasNext()) {
            if (!c.contains(iterator.next())) {
                iterator.remove();
                modified = true;
            }
        }
        return modified;
    }

    /**
     * This implementation iterates over the specified collection, and adds
     * each object returned by the iterator to this collection, in turn.
     *
     * @param collection Nodes to add
     * @return true if the collection was changed
     */
    @Override
    public boolean addAll(Collection<? extends String> collection) {
        boolean modified = false;
        for (String line : collection) if (add(line)) modified = true;
        return modified;
    }

    /**
     * @return The size of the collection of Entry<String> nodes;
     */
    @Override
    public int size() {
        setValidCollection();
        return queue.size();
    }

    /**
     * If !(o instanceof String), throws an UnsupportedOperationException();
     * It deletes the first Entry<String> node whose elementName
     * matches o and, if successful, returns true. If such a node is not found, it returns false;
     *
     * @param o The String to be deleted from the tree.
     * @return true if the node is found and deleted, otherwise false;
     */
    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();
        String value = (String) o;
        setValidCollection();
        for (Entry<String> entry : queue) {
            if (entry.elementName.equals(value)) {
                List<Entry<String>> list = getCollection(entry);
                for (Entry<String> stringEntry : list)
                    if (stringEntry.newLineRootElement) changeNewLineRootElement(stringEntry, list);
                if (entry.parent.leftChild == entry) entry.parent.leftChild = null;
                else entry.parent.rightChild = null;
                setValidCollection();
                return true;
            }
        }
        return false;
    }

    /**
     * The removeAll method removes from the current queue all nodes whose elementName values are in the c collection;
     *
     * @param c The collection of nodes to be deleted;
     * @return true if 1 or more elements were deleted, otherwise false;
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        setValidCollection();
        for (Entry<String> entry : queue) {
            if (c.contains(entry.elementName)) {
                remove(entry.elementName);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * @return true if the collection is empty;
     */
    @Override
    public boolean isEmpty() {
        setValidCollection();
        return size() == 0;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        root.newLineRootElement = true;
        root.availableToAddLeftChildren = true;
        root.availableToAddRightChildren = true;
        root.leftChild = null;
        root.rightChild = null;
        setValidCollection();
    }

    /**
     * @param o The object being searched for (a String);
     * @return true if an Entry<String> node is found whose elementName
     * matches o; Otherwise, returns false;
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }


    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     */
    @Override
    protected CustomTree clone() throws CloneNotSupportedException {
        return (CustomTree) super.clone();
    }

    /**
     * Implementation of the equals method for testing purposes;
     *
     * @param o Another object
     * @return true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomTree customTree = (CustomTree) o;
        this.setValidCollection();
        customTree.setValidCollection();
        int size = size();
        for (int i = 0; i < size; i++) {
            Entry first = queue.get(i);
            Entry second = customTree.queue.get(i);
            if (!first.equals(second)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Implementation of the hashCode method for testing purposes;
     *
     * @return The object's hashCode
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (queue != null ? queue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        setValidCollection();
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < queue.size(); i++) {
            builder.append(queue.get(i).elementName);
            if (i < queue.size() - 1) builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    /**
     * This method returns a list iterator for the collection of items;
     *
     * @return A new SolutionListIterator;
     */
    @Override
    public ListIterator<String> listIterator() {
        return new SolutionListIterator(0);
    }

    /**
     * This method returns a list iterator for traversing a collection of nodes, starting from index;
     *
     * @param index - the starting index for traversing the collection.
     * @return A new SolutionListIterator;
     */
    @Override
    public ListIterator<String> listIterator(int index) {
        checkElementIndex(index);
        return new SolutionListIterator(index);
    }

    /**
     * Check the validity of the index
     *
     * @param index A node's index
     * @return true if the index is valid for our collection.
     */
    private boolean checkIndex(int index) {
        return index >= 0 && index < size();
    }

    /**
     * Throws an exception if the node's index is less than 0 or greater than the collection size
     *
     * @param index A node's index
     */
    private void checkElementIndex(int index) {
        if (!checkIndex(index)) throw new IndexOutOfBoundsException("List size: " + queue.size() + ", Index: " + index);
    }

    /**
     * This method returns a list iterator for the collection of items;
     *
     * @return A new SolutionListIterator;
     */
    @Override
    public Iterator<String> iterator() {
        return new SolutionIterator();
    }

    private class SolutionIterator implements Iterator<String> {
        volatile ArrayList<Entry<String>> list;
        volatile int index, lastReturned = -1;

        SolutionIterator() {
            setValidCollection();
            list = queue;
        }

        @Override
        public synchronized boolean hasNext() {
            return index != list.size();
        }

        @Override
        public synchronized String next() {
            int i = index;
            if (i >= size()) throw new NoSuchElementException();
            index = i + 1;
            return list.get(lastReturned = i).elementName;
        }

        @Override
        public synchronized void remove() {
            if (lastReturned < 0) throw new IllegalStateException();
            if (!hasNext()) throw new IndexOutOfBoundsException("List size: " + list.size() + ", Index: " + index);
            CustomTree.this.remove(list.get(lastReturned).elementName);
            index = lastReturned;
            lastReturned = -1;
            list = queue;
        }
    }

    private class SolutionListIterator extends SolutionIterator implements ListIterator<String> {

        SolutionListIterator(int index) {
            super();
            this.index = index;
        }

        @Override
        public synchronized boolean hasPrevious() {
            return index != 0;
        }

        @Override
        public synchronized String previous() {
            int i = index - 1;
            if (i < 0) throw new NoSuchElementException("List size: " + list.size() + ", Index: " + i);
            if (i >= list.size()) throw new IllegalStateException();
            index = i;
            return list.get(lastReturned = i).elementName;
        }

        @Override
        public synchronized int nextIndex() {
            return index;
        }

        @Override
        public synchronized int previousIndex() {
            return index - 1;
        }

        @Override
        public synchronized void set(String s) {
            if (lastReturned < 0) throw new IllegalStateException();
            for (Entry<String> entry : queue) if (entry.equals(list.get(lastReturned))) entry.elementName = s;
        }

        @Override
        public synchronized void add(String s) {
            CustomTree.this.add(s);
            list = queue;
        }
    }


    private static class Entry<T> implements Serializable {

        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren, newLineRootElement;
        Entry<T> parent, leftChild, rightChild;

        private Entry(String name) {
            elementName = name;
            newLineRootElement = false;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public void checkChildren() {
            if (this.leftChild != null) availableToAddLeftChildren = false;
            if (this.rightChild != null) availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return this.availableToAddRightChildren || this.availableToAddLeftChildren;
        }
    }
}
