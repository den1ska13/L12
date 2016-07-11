import jdk.nashorn.internal.runtime.NumberToString;

import java.util.Arrays;
import java.util.Comparator;


public class ArrayWrapper {
    private Number[] array;
    private int arraycount = 0;
    public void add(Number o) {
        if (arraycount != array.length) {
            array[arraycount] = o;
            arraycount++;
        }
        else {
            try {
                for (int i = 0; i < arraycount - 1; i++) {
                    array[i] = array[i + 1];
                }
                array[arraycount - 1] = o;
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Введите размер массива не меньше 1");
            }
        }
    }
    public void print(){
        System.out.println(Arrays.toString(array));
        System.out.println(array.length);
    }


    public void remove(int index){
        int j = 0;
        int newl = array.length - 1;
        Number[] tmp = new Number[newl];
        for(int i =0; i < array.length; i++) {
            if (index != i) {
                tmp[j] = array[i];
                j++;
            }
        }
        array = tmp;

    }

    public void remove(Number o){
        int index = -1;
        for(int i =0; i < array.length; i++) {
            if (array[i] == o) {
               index = i;
            }
        }
        int j = 0;
        int newl = array.length - 1;
        Number[] tmp = new Number[newl];
        for(int i =0; i < array.length; i++) {
            if (index != i) {
                tmp[j] = array[i];
                j++;
            }
        }
        array = tmp;

    }

    public Number max(Comparator<Number> comparator) {
        try {
            Number m = array[0];


            for (int i = 0; i < array.length; i++) {
                if (comparator.compare(m, array[i]) < 0) {
                    m = array[i];
                }
            }
            return m;

        }
        catch(ArrayIndexOutOfBoundsException e1){
            System.out.println("Массив не задан");
        }
        finally {
            return null;
        }
    }

    public Number min(Comparator<Number> comparator) {
        try {
        Number m = array[0];
        for(int i =0; i < array.length; i++){
            if (comparator.compare(m,array[i])>0){
                m = array[i];
            }
        }
        return m;
        }
        catch(ArrayIndexOutOfBoundsException e1){
            System.out.println("Массив не задан");
        }
        finally {
            return null;
        }
    }
    public Number avg() {
        double a = 0;
        for(int i =0; i < array.length; i++) {
            a= a + array[i].intValue();
        }

        return a/array.length;
    }


    public ArrayWrapper(Number[] initArray) {
        this.array = initArray;
    }

    public void sort(Comparator<Number> comparator) {
        Number[] tmp = new Number[array.length];
        for(int i =0; i < array.length; i++) {
            tmp[i] = array[i];
        }

        for(int i =0; i < tmp.length; i++) {
            for(int j = 0; j < tmp.length - 1; j++) {
                if(comparator.compare(tmp[j], tmp[j+1]) > 0) {
                    Number tmpObj = tmp[j];
                    tmp[j] = tmp[j + 1];
                    tmp[j+1] = tmpObj;
                }
            }
        }
        array = tmp;
    }

}
