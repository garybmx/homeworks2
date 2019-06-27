public class CustomArray {

    private Integer[] data;
    private int size,capacity;

    public CustomArray(){
        size = 0;
        capacity = 100;
        data = new Integer[capacity];

    }

    void add(Integer element){
        if(size < capacity){
            data[size] = element;
            size++;
        }
        else {
            reallocate();
            data[size] = element;
            size++;
        }
    }

    void add(int index, Integer element){
        Integer[] tmpRight = new Integer[size + 1 ];
        System.arraycopy(data, index, tmpRight, index +1, size - index);
        data[index] = element;
        System.arraycopy(data, 0, tmpRight, 0, index+1);
        size++;
        data = tmpRight;
    }

    boolean remove(int index){
        Integer[] tmpRight = new Integer[size];
        System.arraycopy(data, index, tmpRight, index, size - index);
        System.arraycopy(tmpRight, index, data, index -1, size - index);
        size--;
        return true;
    }

    public int findIndexByValue(int value){
        int index = -1;
        int low = 0;
        int high = size-1;
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            if (value == data[mid]) {
                return mid;
            }
            else {
                if (value < data[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return index;
    }


    private void reallocate(){
        capacity *= 2;
        Integer[] tmp = new Integer[capacity];
        if (size >= 0) System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
    }

    void show(){
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    void set(int index, Integer value){
        data[index] = value;
    }

    Integer get(int index){
        return  data[index];
    }
    int size(){
        return size;
    }

    public void sortBubble(){
        int out, in;
        for (out = this.size - 1; out >= 1; out--) {
            for(in = 0; in < out; in++) {
                if (data[in] > data[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
    }

    private void change(int a, int b){
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    public void sortInsert(){
        int in, out;
        for(out = 1;out < this.size; out++){
            int temp = data[out];
            in = out;
            while(in > 0 && data[in-1] >=temp){
                data[in] = data[in-1];
                --in;
            }
            data[in] = temp;
        }
    }

    public void quickSort() {
        int startIndex = 0;
        int endIndex = size - 1;
        doSort(startIndex, endIndex);
    }

    private void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (data[i] <= data[cur])) {
                i++;
            }
            while (j > cur && (data[cur] <= data[j])) {
                j--;
            }
            if (i < j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur+1, end);
    }

}
