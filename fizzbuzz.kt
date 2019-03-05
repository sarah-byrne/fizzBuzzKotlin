fun main(args : Array<String>) {
  fun fizzbuzz(x: Int): String {
    if (x % 3 == 0 && x % 5 == 0){
      return "fizzbuzz"
    } else if (x % 3 == 0) {
      return "fizz"
    } else if (x % 5 == 0) {
      return "buzz"
    } else {
      return x.toString()
    }
  }

  println("3: "+ fizzbuzz(3))
  println("5: "+ fizzbuzz(5))
  println("15: "+ fizzbuzz(15))
  println("23: "+ fizzbuzz(23))
}
