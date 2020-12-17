

import java.util.*


fun main(args: Array<String>) {
    takeInput()

}


fun takeInput() {
    val n: Int
    val sc = Scanner(System.`in`)
    print("Enter the number of elements you want to store: ")
    n = sc.nextInt()
    val array = IntArray(n)
    println("Enter the elements of the array: ")
    for (i in 0 until n) {
        array[i] = sc.nextInt()
    }

    println("Choose: \n 1 for get pair \n2 for max sum\n")
    val option: Int
    option = sc.nextInt()
    when (option) {
        1 -> getPair(array, array.size)
        2 -> {
            print("Please enter the k value ")
            val k: Int = sc.nextInt()
            maxSum(array, array.size, k)
        }
        else -> print("Please choose valid option")
    }
    //return array
}

fun getPair(array: IntArray, sum: Int) {
    val arrayPosition: MutableList<String?> = arrayListOf()
    var count = 0

    for (i in array.indices) {

        for (j in i + 1 until array.size) {
            if (array[i] + array[j] == sum) {
                count++
                val temp = "$i $j"
                arrayPosition.add(temp)
            }
        }
    }
    print(arrayPosition + " " + count)
}

fun maxSum(arr: IntArray, n: Int, k: Int) {

    if (n < k) {
        println("Not a valid k input must be greater than array size  ")

    }


    var res = 0
    for (i in 0 until k) res += arr[i]

    var curr_sum = res
    for (i in k until n) {
        curr_sum += arr[i] - arr[i - k]
        res = Math.max(res, curr_sum)
    }
    print(res)
}
