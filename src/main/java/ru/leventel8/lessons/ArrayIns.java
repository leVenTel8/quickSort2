package ru.leventel8.lessons;

class ArrayIns {

    private long[] theArray;            //Переменная приватного типа, объявление массива
    private int nElems;                 //Переменная приватного типа, объявление счетчика элементов массива

    /**
     * Конструктор при инициализации
     * принимает параметр max
     * @param max
     *      размер массива
     */
    public ArrayIns(int max){

        theArray = new long[max];
        nElems = 0;

    }

    /**
     * вставка в массив
     * @param value
     */
    public void insert(long value){

        theArray[nElems] = value;       // вставка value в ячейку nElems
        nElems++;                       // имнкримент nElems

    }// end insert()

    /**
     * вывод содержимого массива
     */
    public void display(){

        System.out.print("A=");
        for(int j=0; j<nElems; j++)             // перебор элементов массива в цикле
            System.out.print(theArray[j]+ " "); // вывод содержимого массива
        System.out.println("");

    }// end display()

    /**
     * быстрая сортировка
     * с высозов рекурсивного метода
     */
    public void quickSort(){

        recQuickSort(0, nElems-1);

    }//end quickSort()

    /**
     * быстрая сортировка
     * с выбором медианы
     * @param left, right
     */
    public void recQuickSort(int left, int right){

        int size = right-left+1;
        if(size <= 3)
            manualSort(left, right);                            // реализация алгоритма
        else{
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition-1);               // рекурсивный вызов левой стороны
            recQuickSort(partition+1, right);               // рекурсивный вызов правой стороны

        }

    }//end recQuickSort

    /**
     * выбор медианы
     * @param left, right
     * @return theArray[right-1]
     *  возвращение медианы
     */
    public long medianOf3(int left, int right){

        int center = (left+right)/2;                            // реализация алгоритма

        if(theArray[left] > theArray[center])
            swap(left, center);
        if(theArray[left] > theArray[right])
            swap(left, right);
        if(theArray[center] > theArray[right])
            swap(center, right);
        swap(center, right-1);
        return theArray[right-1];


    }//end medianOf3()

    /**
     * swap двух аргументов
     * @param dex1, dex2
     */
    public void swap(int dex1, int dex2){

        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;

    }//end swap()

    /**
     * разбиение массива
     * @param left, right, pivot
     * @return leftPtr
     * частичная сортировка
     */
    public int partitionIt(int left, int right, long pivot){

        int leftPtr = left;
        int rightPtr = right - 1;

        while(true){

            while(theArray[++leftPtr] < pivot);
            while(theArray[--rightPtr] > pivot);
            if(leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);

        }
        swap(leftPtr, right-1);
        return leftPtr;

    }//end partitionIt()

    /**
     * сортировка подмассивов
     * @return выход из массива
     */
    public void manualSort(int left, int right){

        int size = right-left+1;
        if(size <= 1)
            return;
        if(size == 2){

            if(theArray[left] > theArray[right])
                swap(left, right);
            return;

        }
        else{
            if(theArray[left]>theArray[right-1])
                swap(left, right-1);
            if(theArray[left]>theArray[right])
                swap(left, right);
            if(theArray[right-1]>theArray[right])
                swap(right-1, right);

        }

    }//end manualSort

    /**
     * метод берет первое значение массива
     */
    public long getFirst(){
        long first = theArray[0];
        return first;

    }//end getFirst()

}//end class ArrayIns
