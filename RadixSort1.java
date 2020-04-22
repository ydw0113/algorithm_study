package algori;
public class RadixSort1{
static void AA(int n) {

if (n <= 1) return;

System.out.printf("%d ", n);

AA(n / 2);

}

static int BB(int n) {

System.out.printf("%d ", n);

if (n <= 1) return 1;

return n * BB(n / 2);

}

static int CC(int n) {

if (n < 1) return 1;

System.out.printf("%d ", n);

return n + CC(n - 1);

}

static class Node {

int value; Node next;

public Node(int value, Node next) {

this.value = value;

this.next = next;

}

public void print1() {

System.out.printf("%d ", value);

if (next != null) next.print1();

}

public void print2() {

System.out.printf("%d ", value);

if (next != null) next.print2();

System.out.printf("%d ", value);

}

}

static void DD() {

Node node = new Node(1, new Node(2, new Node(3, null)));

node.print1();

}

static void EE() {

Node node = new Node(1, new Node(2, new Node(3, null)));

node.print2();

}

static void FF(int[][] a, int r, int c) {

if (r >= a.length) return;

if (c >= a[r].length) return;

System.out.printf("%d ", a[r][c]);

FF(a, r + 1, c);

FF(a, r, c + 1);

}

static int GG(int[] a, int value, int start, int end) {

if (start > end) return -1;

int middle = (start + end) / 2;

System.out.printf("%d ", middle);

if (a[middle] < value) start = middle + 1;

else if (a[middle] > value) end = middle - 1;

else return middle;

return GG(a, value, start, end);

}

static void swap(int[] a, int i, int j) {

int temp = a[i];

a[i] = a[j];

a[j] = temp;

}

static void print(int[] a) {

for (int i = 0; i < a.length; ++i)

System.out.printf("%d ", a[i]);

System.out.println();

}

static void HH(int[] a) {

for (int i = a.length - 1; i > 1; --i) {

boolean 완료 = true;

for (int j = 0; j < i; ++j) {

if (a[j] > a[j + 1]) {

swap(a, j, j + 1);

완료 = false;

}

}

if (완료) break;

}

}

static void II(int[] a) {

for (int i = 1; i < a.length; ++i) {

int value = a[i];

int j;

for (j = i - 1; j > 0; --j)

if (a[j] > value)

a[j + 1] = a[j];

else break;

a[j] = value;

}

}

static void JJ(int[] a, int start, int end) {

if (start == end) return;

int middle = (start + end) / 2;

JJ(a, start, middle);

JJ(a, middle + 1, end);

merge(a, start, middle, end);

}

static void merge(int[] a, int start, int middle, int end) {

int length = end - start + 1;

int[] temp = new int[length]; // int배열을 생성할 때 자동으로 0 이 채워짐.

int i = 0, index1 = start, index2 = middle + 1;

while (index1 <= middle && index2 <= end) {

if (a[index1] < a[index2])

temp[i++] = a[index1++];

else temp[i++] = a[index2++];

}

while (index1 < middle) temp[i++] = a[index1++];

while (index2 < end) temp[i++] = a[index2++];

for (i = 0; i < temp.length; ++i)

a[start + i] = temp[i];

}

static int KK(int n) {

if (n <= 1) return 1;

return KK(n - 1) + KK(n - 2);

}

static int LL(int n) {

int sum = 0;

for (int i = 0; i < 100 - n; ++i)

sum += i;

return sum;

}

public static void main(String[] args) {

AA(9); System.out.println(); // (1) 출력?

System.out.println(BB(5)); // (2) 출력?

System.out.println(CC(3)); // (3) 출력?

DD(); System.out.println(); // (4) 출력?

EE(); System.out.println(); // (5) 출력?

int[][] f = {{1, 2}, {3, 4}};

FF(f, 0, 0); System.out.println(); // (6) 출력?

int[] g = {1, 2, 3, 4, 5};

GG(g, 2, 0, 4); // (7) 출력?

System.out.println();

int[] h = {2, 5, 3, 4, 1};

HH(h); print(h); // (8) 출력?

int[] i = {2, 5, 3, 4, 1};

II(i); print(i); // (9) 출력?

int[] j = {2, 5, 3, 4};

JJ(j, 0, 3); print(j); // (10) 출력?

System.out.println(KK(5)); // (11) 출력?

// (12) KK 메소드의 수행 시간?

// (13) LL 메소드의 수행 시간?

// (14) AA 메소드의 수행 시간?
}
}
// (15) DD 메소드의 수행 시간?