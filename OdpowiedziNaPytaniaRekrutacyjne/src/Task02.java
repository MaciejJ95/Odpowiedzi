//Złożoność pamięciową oraz obliczeniową (przyjmując najgorszy scenariusz) przyjmuje się O(log n)
public class Task02 {
    public boolean search(int[] numbers, int x) {
        int lowerBracket = 0;
        int upperBracket = numbers.length - 1;

        while(lowerBracket <= upperBracket){
            int mid = (lowerBracket + upperBracket)/2;
            if(numbers[mid] == x){
                return true;
            }
            else if(x < numbers[mid]){
                lowerBracket = mid+1;
            }
            else{
                upperBracket = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] largeArray = new int[1000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = 1000-i;
        }
        Task02 task02 = new Task02();
        System.out.println(task02.search(largeArray, 501));
        System.out.println(task02.search(largeArray, 1));
        System.out.println(task02.search(largeArray,0));
        System.out.println(task02.search(largeArray,1000));
        System.out.println(task02.search(largeArray,1001));
    }
}