//John Rosar
//COSC 2436
//Assignment 2

import java.util.Collection;
import java.util.Scanner;



public class JohnRosarList {


    interface MyList<E> extends java.util.Collection<E> {
        /**
         * Add a new element at the specified index in this list
         */
        public void add(int index, E e);

        /**
         * Return the element from this list at the specified index
         */
        public E get(int index);

        /**
         * Return the index of the first matching element in this list.
         * Return -1 if no match.
         */
        public int indexOf(Object e);

        /**
         * Return the index of the last matching element in this list
         * Return -1 if no match.
         */
        public int lastIndexOf(E e);

        /**
         * Remove the element at the specified position in this list
         * Shift any subsequent elements to the left.
         * Return the element that was removed from the list.
         */
        public E remove(int index);

        /**
         * Replace the element at the specified position in this list
         * with the specified element and returns the new set.
         */
        public E set(int index, E e);

        @Override
        /** Add a new element at the end of this list */
        public default boolean add(E e) {
            add(size(), e);
            return true;
        }

        @Override
        /** Return true if this list contains no elements */
        public default boolean isEmpty() {
            return size() == 0;
        }

        @Override
        /** Remove the first occurrence of the element e
         * from this list. Shift any subsequent elements to the left.
         * Return true if the element is removed. */
        public default boolean remove(Object e) {
            if (indexOf(e) >= 0) {
                remove(indexOf(e));
                return true;
            } else
                return false;
        }

        @Override
        public default boolean containsAll(Collection<?> c) {
            for (Object i : c) {
                if (!contains(i)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public default boolean addAll(Collection<? extends E> c) {
            for (Object i : c) {
                add((E) i);
            }
            return true;
        }

        @Override
        public default boolean removeAll(Collection<?> c) {
            boolean modded = false;
            for (Object i : c) {
                if (remove(i)) {
                    modded = true;
                }
            }
            return true;
        }

        @Override
        public default boolean retainAll(Collection<?> c) {
            boolean modded = false;
            for (int i = size() - 1; i >= 0; i--) {
                Object o = get(i);
                if (!c.contains(o)) {
                    remove(i);
                    modded = true;
                }
            }
            return modded;
        }

        @Override
        public default Object[] toArray() {
            Object[] arr = new Object[size()];
            for (int i = 0; i < size(); i++) {
                arr[i] = get(i);
            }
            return arr;
        }

        @Override
        public default <T> T[] toArray(T[] array) {
            T[] arr = (T[]) new String[array.length];
            for (int i = 0; i < array.length; i++) {
                arr[i] = (T) get(i);
            }
            return arr;
        }
    }

}


