import java.util.Scanner;
public class Lab {

    public static void main(String[] args) {
        Vector[] array=new Vector[3];
        int[] ar = { 3, 5, 6, 7, 9};
        int n, i=0;
        boolean f=true;
        Scanner sc = new Scanner(System.in);
        System.out.println(&quot;Створюю масиви...&quot;);
        array[0]=new Vector();
        System.out.println(&quot;Яка ємність буде в масиві 2? &quot;);
        int capacity=sc.nextInt();
        array[1]=new Vector(capacity);
        array[2]=new Vector(ar);
        System.out.println(&quot;Створено!&quot;);
        System.out.println(&quot;Тепер треба заповнити. &quot;);
        while(f) {
            System.out.printf(&quot;Скільки елементів буде в масиві %d? &quot;, i+1);
            n = sc.nextInt();
            for(int j=0;j&lt;n;j++) {
                System.out.print(&quot;Введіть елемент: &quot;);
                int value=sc.nextInt();;
                array[i].add(value);
            }
            i++;
            if(i&gt;1) {
                f=false;
            }
        }
        System.out.println(&quot;Заповнили! Виводжу масиви на екран:&quot;);
        for(i=0;i&lt;3;i++) {
            System.out.printf(&quot;Масив %d:\t&quot;, i+1);
            System.out.println(array[i].toString());
        }
        System.out.println(&quot;Перевіримо розмір?&quot;);
        for(i=0;i&lt;3;i++) {
            System.out.printf(&quot;Масив %d:\t&quot;, i+1);
            System.out.println(array[i].size());
        }
        System.out.println(&quot;А може якийсь масив порожній?&quot;);
        for(i=0;i&lt;3;i++) {
            System.out.printf(&quot;Масив %d:\t&quot;, i+1);
            System.out.println(array[i].isEmpty());
        }
        System.out.println(&quot;Яка ємність масивів?&quot;);
        for(i=0;i&lt;3;i++) {
            System.out.printf(&quot;Масив %d:\t&quot;, i+1);
            System.out.println(array[i].capacity());
        }
        System.out.println(&quot;Візьмемо один елемент з масиву.&quot;);
        System.out.printf(&quot;1. Масив 1\t2. Масив 2\t3.Масив 3\n&quot;);
        n = sc.nextInt();
        System.out.print(&quot;Введіть позицію елементу: &quot;);
        int index = sc.nextInt();
        System.out.println(array[n-1].get(index));
        System.out.println(&quot;Видалимо один елемент з масиву. Виберіть з якого

        масиву будемо це робити:&quot;);

        System.out.printf(&quot;1. Масив 1\t2. Масив 2\t3.Масив 3\n&quot;);
        n = sc.nextInt();
        System.out.print(&quot;Введіть позицію елементу: &quot;);
        index = sc.nextInt();
        System.out.print(&quot;Тут раніше був такий елемент: &quot;);
        System.out.println(array[n-1].remove(index));

        System.out.println(&quot;Але його вже немає...&quot;);
        System.out.println(&quot;Перевіряємо:&quot;);
        System.out.println(array[n-1].toString());
        System.out.println(&quot;Перепишемо один елемент з масиву. Виберіть у якого

        масиву будемо це робити:&quot;);

        System.out.printf(&quot;1. Масив 1\t2. Масив 2\t3.Масив 3\n&quot;);
        n = sc.nextInt();
        System.out.print(&quot;Введіть позицію елементу та сам елемент: &quot;);
        index = sc.nextInt();
        int newValue = sc.nextInt();
        System.out.print(&quot;Тут раніше був такий елемент: &quot;);
        System.out.println(array[n-1].set(index, newValue));
        System.out.println(&quot;Перевіряємо:&quot;);
        System.out.println(array[n-1].toString());
        System.out.println(&quot;Добавимо в кінець масиву елемент. Виберіть до якого

        масиву будемо це робити:&quot;);

        System.out.printf(&quot;1. Масив 1\t2. Масив 2\t3.Масив 3\n&quot;);
        n = sc.nextInt();
        System.out.print(&quot;Введіть елемент: &quot;);
        int value = sc.nextInt();
        array[n-1].add(value);
        System.out.println(&quot;Перевіряємо:&quot;);
        System.out.println(array[n-1].toString());
        System.out.println(&quot;Добавимо в будь-яке місце масиву елемент. Виберіть

        до якого масиву будемо це робити:&quot;);

        System.out.printf(&quot;1. Масив 1\t2. Масив 2\t3.Масив 3\n&quot;);
        n = sc.nextInt();
        System.out.print(&quot;Введіть позицію елементу та сам елемент: &quot;);
        index = sc.nextInt();
        value = sc.nextInt();
        System.out.println();
        System.out.println(array[n-1].add(index,value));
        System.out.println(&quot;Перевіряємо:&quot;);
        System.out.println(array[n-1].toString());
        System.out.println(&quot;Добавимо масив ar в кінець масиву. Виберіть до якого

        масиву будемо це робити:&quot;);

        System.out.printf(&quot;1. Масив 1\t2. Масив 2\t3.Масив 3\n&quot;);
        n = sc.nextInt();
        array[n-1].addAll(ar);
        System.out.println(&quot;Перевіряємо:&quot;);
        System.out.println(array[n-1].toString());
        System.out.println(&quot;Добавимо масив ar в будь-яке місце масиву. Виберіть

        до якого масиву будемо це робити:&quot;);

        System.out.printf(&quot;1. Масив 1\t2. Масив 2\t3.Масив 3\n&quot;);
        n = sc.nextInt();
        System.out.print(&quot;Введіть позицію: &quot;);
        index = sc.nextInt();
        System.out.println(array[n-1].addAll(index,ar));
        System.out.println(&quot;Перевіряємо:&quot;);
        System.out.println(array[n-1].toString());
        System.out.println(&quot;Перевіремо чи однакові в нас масиви:&quot;);
        System.out.printf(&quot;1. Масив 1\t2. Масив 2\t3.Масив 3\n&quot;);
        System.out.print(&quot;Введіть номери масивів, які треба порівняти: &quot;);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(array[n1 - 1].equals(array[n2 - 1]));
        System.out.println(&quot;Тепер очищуємо масиви&quot;);
        for(i=0;i&lt;3;i++) {
            System.out.printf(&quot;Масив %d:\n&quot;, i+1);
            array[i].clear();
        }
    }

}
class Vector{
    private int[] vec;
    private int size;
    public Vector() {
        this.vec=new int[8];
        this.size=0;
    }
    public Vector(int capacity) {
        this.vec = new int[capacity];
        this.size = 0;
    }
    public Vector(int[] ar) {
        this.vec = new int[ar.length];
        this.size = ar.length;
        for (int i = 0; i &lt; ar.length; i++) {
            vec[i] = ar[i];
        }
    }
    public String toString() {
        String str = &quot;&quot;;
        for (int i = 0; i &lt; size - 1; i++) {
            str = str + vec[i] + &quot;, &quot;;
        }
        return &quot;[&quot; + str + vec[size - 1] + &quot;]&quot;;
    }
    public int size() {
        return size;
    }
    boolean isEmpty() {
        if(size==0) {
            return true;
        }
        else {
            return false;
        }
    }
    public int capacity() {
        return vec.length;
    }
    int get(int index) {
        if ((index &lt; vec.length) || (index &gt;= 0)) {
            return vec[index];
        } else {
            return -666;
        }
    }
    int remove(int index) {
        if ((index &gt;= size) || (index &lt; 0)) {
            return -666;
        }
        size--;
        int tmp = vec[index];

        for(int i=index;i&lt;=size-1;i++) {
            vec[i]=vec[i+1];
        }
        return tmp;
    }
    int set(int index, int newValue) {
        if ((index &gt;= size) &amp;&amp; (index &lt; 0)) {
            return -666;
        }
        int tmp = vec[index];
        vec[index] = newValue;
        return tmp;
    }
    void add(int value) {
        size++;
        vec[size-1]=value;
    }
    boolean add(int index, int value) {
        if ((index &gt; size) || (index &lt; 0)) {
            return false;
        }
else {
            size++;
            for(int i=index;i&lt;=size-1;i++) {
                vec[i+1]=vec[i];
            }
            vec[index] = value;
            return true;
        }
    }
    void addAll(int[] ar) {
        int sz=size;
        int sztmp=vec.length;
        size=size+ar.length;
        if(size&gt;vec.length) {
            int[] tmp = new int[vec.length];
            for(int i=0;i&lt;vec.length;i++) {
                tmp[i]=vec[i];
            }
            vec=new int[size+10];
            for(int i=0;i&lt;sztmp;i++) {
                vec[i]=tmp[i];
            }
        }
        for (int i = 0; i &lt; ar.length; i++) {
            vec[sz+i] = ar[i];
        }
    }
    boolean addAll(int index, int[] ar) {
        int sz=size, c1=0, c2=0;
        if ((index &gt; size) || (index &lt; 0)) {
            return false;
        }
else {
            size=size+ar.length;
            int[] tmp1 = new int[sz];
            int[] tmp2 = new int[sz];
            int j=0;
            for(int i=0;i&lt;index;i++) { //сохраняю часть до индекса
                tmp1[i]=vec[i];
                c1++;

            }
            for(int i=index;i&lt;sz;i++) { //сохраняю часть после индекса
                tmp2[i]=vec[i];
                c2++;
            }
            vec=new int[size+10];
            for(int i=index;i&lt;index+ar.length;i++) { //записываю массив ар
                vec[i]=ar[j];
                j++;
            }
            for(int i=0;i&lt;c1;i++) { //записываю первую часть обратно
                vec[i]=tmp1[i];
            }
            for(int i=index+ar.length;i&lt;index+ar.length+c2;i++) { //записываю

                вторую часть обратно

                vec[i]=tmp2[i-ar.length];
            }
            return true;
        }
    }
    public boolean equals(Vector other) {
        if (this == other) {
            return true;
        }
        else {
            return false;
        }
    }
    void clear() {
        size=0;
        System.out.println(&quot;Очищено&quot;);
    }
}