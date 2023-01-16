# AlgorithmStudy
알고리즘 풀이 백업 repo  

## memo
* List와 Array의 메모리 사용, 실행 시간 차이 알기 
* 단순히 contains만 확인하는 것은 hashSet 사용 
* math.min, max보다 if문이 빠르다 

## Algorithm
### 최대공약수, 최소공배수
```kotlin
/**
 * 최대공약수
 */
fun Int.gcd(other: Int): Int {
    var a = if (this > other) this else other
    var b = if (this > other) other else this

    // 유클리드 호제법 
    while(b != 0) {
        val r = a % b
        a = b
        b = r
    }

    return a
}

/**
 * 최소공배수 
 */
fun Int.lcm(other: Int) = (this * other) / this.gcd(other)
```

### DFS
DFS의 컨셉을 유지하여 문제에 맞는 여러가지 방법으로 구현할 수 있음
```kotlin
/**
 * 1부터 n까지 자연수 중에서 중복없이 r개를 고른 수열을 출력(순열)
 */
fun printPermutation(n: Int, r: Int) {
    val visit = BooleanArray(n)
    val arr = IntArray(r)

    fun dfs(n: Int, r: Int, depth: Int = 0) {
        // depth가 arr의 끝에 도달했다면 return 
        if (depth == r) {
            println(arr.contentToString)
            return
        }

        for (i in 0 until n) {
            // 이미 선택된 숫자가 아닌 경우  
            if (!visit[i]) {
                visit[i] = true     // 방문한 것으로 표시 
                arr[depth] = i + 1  // depth를 인덱스로 해서 지금 선택한 숫자를 저장  

                // 다음 인덱스로 이동해서 현재 과정 반복
                dfs(n, r, depth + 1)    

                // 과정이 다 끝나면 선택되지 않은 것으로 복구 
                visit[i] = false
            }
        }
    }

    dfs(n, r)
}
```

### 힙 정렬
시간복잡도: 모든 상황에서 nlog₂n

```kotlin
/**
 * 최소 Heap 정렬 
 */
fun IntArray.heapSort() {
    if (size < 2) return

    // 일단 먼저 전체를 최대 힙으로 만든다
    for (i in (lastIndex - 1) / 2 downTo 0) {
        heapify(i, size)
    }

    // 오름차순으로 정렬하기 
    for (i in lastIndex downTo 1) {
        // 0번째(root)에 있는 값은 언제나 최대 값이기 때문에
        // 0번째 값을 맨 뒤로 보내서 정렬시킨다
        swap(0, i)

        // 정렬된 뒷부분을 제외하고 나머지 서브트리를 최대 힙으로 다시 구성
        heapify(0, i)
    }
}

/**
 * 최대 Heap으로 만드는 과정 
 */
fun IntArray.heapify(index: Int, size: Int) {
    // 노드 index 구하기
    var parent = index          // 부모노드 index
    val left = index * 2 + 1    // 왼쪽 자식노드 index
    val right = index * 2 + 2   // 오른쪽 자식노드 index

    // 노드끼리 값 비교 
    if (left < size && this[left] > this[parent]) {
        parent = left
    }

    if (right < size && this[right] > this[parent]) {
        parent = right
    }

    // 파라미터로 받은 index와 현재 저장된 부모노드 index가 다르면 swap 실행
    // parent가 가르키는 index를 기준으로 다시 heapify 실행
    if (parent != index) {
        swap(parent, index)
        heapify(parent, size)
    }
}

fun IntArray.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}
```

### 병합 정렬
시간복잡도: 모든 상황에서 nlog₂n

```kotlin
fun IntArray.mergeSort(sorted: IntArray = IntArray(this.size), left: Int = 0, right: Int = this.lastIndex) {
    // left와 right가 같다는건 나눌 수 있는 최소 단위(1칸)까지 나눴다는 의미
    // 1칸은 정렬 할 필요가 없다
    if (left == right) return

    val mid = (left + right) / 2

    // 가운데를 기준으로 왼쪽과 오른쪽 부분 배열로 나누어 재귀호출
    mergeSort(sorted, left, mid)
    mergeSort(sorted, mid + 1, right)

    // 주어진 범위를 정렬
    merge(sorted, left, right, mid)
}

fun IntArray.merge(sorted: IntArray, left: Int, right: Int, mid: Int) {
    var lPivot = left
    var rPivot = mid + 1
    var index = left

    // 배열을 반으로 나눴을 때 왼쪽 부분의 맨 왼쪽과
    // 오른쪽 부분의 맨 왼쪽부터 차례대로 비교하여 sorted 배열에 삽입
    while (lPivot <= mid && rPivot <= right) {
        sorted[index++] = if (this[lPivot] <= this[rPivot]) {
            this[lPivot++]
        } else {
            this[rPivot++]
        }
    }

    // lPivot이 왼쪽 부분의 끝에 도달하지 못했다면
    // 나머지 숫자들을 sorted 배열에 차례대로 삽입
    // (부분정렬이 되어있는 상태이므로 그냥 차례대로 삽입한다)
    while (lPivot <= mid) {
        sorted[index++] = this[lPivot++]
    }

    // rPivot이 오른쪽 부분의 끝에 도달하지 못했다면
    // 나머지 숫자들을 sorted 배열에 차례대로 삽입
    // (부분정렬이 되어있는 상태이므로 그냥 차례대로 삽입한다)
    while (rPivot <= right) {
        sorted[index++] = this[rPivot++]
    }

    // 정렬한 숫자들을 원본 배열에 삽입 
    for (i in left..right) {
        this[i] = sorted[i]
    }
}
```